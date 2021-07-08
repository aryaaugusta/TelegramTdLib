package com.edts.tdlib.helper;

import com.edts.tdlib.TdApi;
import com.edts.tdlib.bean.AddMembersRequestBean;
import com.edts.tdlib.bean.ChatTypeBasicGroupBean;
import com.edts.tdlib.bean.ChatTypeBean;
import com.edts.tdlib.bean.contact.ChatRoomRequestBean;
import com.edts.tdlib.bean.contact.TelegramUserGroupBean;
import com.edts.tdlib.bean.message.TransferMessageBean;
import com.edts.tdlib.constant.GeneralConstant;
import com.edts.tdlib.engine.GlobalVariable;
import com.edts.tdlib.engine.TdFunctions;
import com.edts.tdlib.engine.handler.ChatRoomHandler;
import com.edts.tdlib.engine.handler.DefaultHandler;
import com.edts.tdlib.engine.handler.UpdatesHandler;
import com.edts.tdlib.model.TelegramAccount;
import com.edts.tdlib.model.contact.ChatRoom;
import com.edts.tdlib.model.contact.ChatRoomMember;
import com.edts.tdlib.model.contact.TelegramUser;
import com.edts.tdlib.model.message.TelegramMessage;
import com.edts.tdlib.repository.ChatRoomMemberRepo;
import com.edts.tdlib.repository.ChatRoomRepo;
import com.edts.tdlib.repository.TelegramMessageRepo;
import com.edts.tdlib.repository.TelegramUserRepo;
import com.edts.tdlib.service.*;
import com.edts.tdlib.thread.CommandMessageThread;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CoreHelper {

    private static Logger logger = LoggerFactory.getLogger("CoreHelper");
    private static final Gson gson = new Gson();

    public static final ConcurrentMap<Integer, TdApi.User> chatRoomMember = new ConcurrentHashMap<Integer, TdApi.User>();
    public static final ConcurrentMap<Integer, String> userBy = new ConcurrentHashMap<>();
    public static final ConcurrentMap<Long, TelegramUserGroupBean> userGroup = new ConcurrentHashMap<>();
    public static final ConcurrentMap<Long, TransferMessageBean> messageTransfer = new ConcurrentHashMap<>();
    public static final ConcurrentMap<Long, TdApi.Chat> chatsHelper = new ConcurrentHashMap<Long, TdApi.Chat>();
    public static String accountDisable = null;
    public static String accountEnable = null;


    private static TelegramUserRepo telegramUserRepo;
    private static ChatRoomRepo chatRoomRepo;
    private static ChatRoomService chatRoomService;
    private static TelegramUserGroupService telegramUserGroupService;
    private static TelegramMessageRepo telegramMessageRepo;
    private static MessageReportService messageReportService;
    private static TelegramAccountService telegramAccountService;
    private static ChatRoomPermissionService chatRoomPermissionService;
    private static CommandMessageThread commandMessageThread;
    private static ChatRoomMemberRepo chatRoomMemberRepo;

    public static void setTelegramMessageRepo(TelegramUserRepo telegramUserRepo, ChatRoomRepo chatRoomRepo,
                                              ChatRoomService chatRoomService, TelegramUserGroupService telegramUserGroupService,
                                              TelegramMessageRepo telegramMessageRepo, MessageReportService messageReportService,
                                              TelegramAccountService telegramAccountService, ChatRoomPermissionService chatRoomPermissionService,
                                              CommandMessageThread commandMessageThread, ChatRoomMemberRepo chatRoomMemberRepo) {
        CoreHelper.telegramUserRepo = telegramUserRepo;
        CoreHelper.chatRoomRepo = chatRoomRepo;
        CoreHelper.chatRoomService = chatRoomService;
        CoreHelper.telegramUserGroupService = telegramUserGroupService;
        CoreHelper.telegramMessageRepo = telegramMessageRepo;
        CoreHelper.messageReportService = messageReportService;
        CoreHelper.telegramAccountService = telegramAccountService;
        CoreHelper.chatRoomPermissionService = chatRoomPermissionService;
        CoreHelper.commandMessageThread = commandMessageThread;
        CoreHelper.chatRoomMemberRepo = chatRoomMemberRepo;
    }


    public CoreHelper() {

    }


    public static void addContact(int[] userIds) {
        for (int i = 0; i < userIds.length; i++) {
            logger.info("::: " + userIds[i]);
            TdFunctions.getUser(userIds[i]);
        }
    }

    public static synchronized void updateUser(TdApi.User user) {


    }

    public static synchronized void submitContact(TdApi.User user) {
        TdApi.UserType userType = user.type;

        TdFunctions.print("userType constructor  " + userType.getConstructor());

        String userTypeDB;

        switch (userType.getConstructor()) {
            case 1262387765:
                userTypeDB = GeneralConstant.USER_TYPE_BOT;
                break;
            default:
                userTypeDB = GeneralConstant.USER_TYPE_REGULAR;
                break;
        }

        Optional<TelegramUser> telegramUserByPhone = telegramUserRepo.findByPhoneNumber(user.phoneNumber);
        if (telegramUserByPhone.isPresent() && telegramUserByPhone.get().getChatId() == null) {
            TelegramUser userMember = telegramUserByPhone.get();
            userMember.setChatId(String.valueOf(user.id));
            userMember.setUserTelegramId(user.id);
            telegramUserRepo.save(userMember);
        } else {
            TdFunctions.print("submitContact :: " + user.toString());
            int userId = (int) user.id;
            List<String> userAction = new ArrayList<>(userBy.values());

            telegramUserRepo.findByUserTelegramId(userId).ifPresentOrElse(ut -> {
                ut.setFirstName(user.firstName);
                ut.setLastName(user.lastName);
                ut.setUsername(user.username);
                ut.setPhoneNumber(user.phoneNumber);
                ut.setModifiedBy(userAction.get(0).toString());
                ut.setUserType(userTypeDB);
                telegramUserRepo.save(ut);
                GlobalVariable.mainTelegram.client.send(new TdApi.CreatePrivateChat(user.id, true), new UpdatesHandler());
            }, () -> {
                String chatId = String.valueOf(user.id);
                String userBy = "dev2021@tms.id";

                if (userAction != null && userAction.size() > 0) {
                    userBy = userAction.get(0).toString();
                }
                logger.info("userby ::: " + userBy);
                TelegramUser telegramUser = telegramUserRepo.save(new TelegramUser(user.id, chatId, user.firstName,
                        user.lastName, user.username, user.phoneNumber, userBy, null, userTypeDB));

                List<TelegramUserGroupBean> telegramUserGroupBeans = new ArrayList<>(userGroup.values());
                telegramUserGroupService.addEditMemberFromAddUser(telegramUser, telegramUserGroupBeans, null);

                GlobalVariable.mainTelegram.client.send(new TdApi.CreatePrivateChat(user.id, true), new UpdatesHandler());


            });

        }
    }

    public static void getUserGroup(int[] userIds) {
        chatRoomMember.clear();
        for (int i = 0; i < userIds.length; i++) {
            logger.info("::: " + userIds[i]);
            TdFunctions.getUser(userIds[i]);
        }
    }

    public static void addGroup(ChatRoomRequestBean chatRoomRequestBean) {
        getUserGroup(chatRoomRequestBean.getUserIds());
        GlobalVariable.mainTelegram.client.send(
                new TdApi.CreateNewBasicGroupChat(chatRoomRequestBean.getUserIds(), chatRoomRequestBean.getName()), new ChatRoomHandler());
    }


    public static void addSuperGroup(ChatRoomRequestBean chatRoomRequestBean) {
        getUserGroup(chatRoomRequestBean.getUserIds());
        GlobalVariable.mainTelegram.client.send(
                new TdApi.CreateNewSupergroupChat(chatRoomRequestBean.getName(), false, chatRoomRequestBean.getDescription(), null), new ChatRoomHandler());

    }


    public static void submitAddBasicGroup(TdApi.BasicGroup basicGroup) {
        TdFunctions.print("::: " + basicGroup.id);
        chatRoomRepo.findByGroupId(basicGroup.id).ifPresentOrElse(
                bs -> {
                    if (basicGroup.memberCount > 0) {
                        bs.setCountMember(basicGroup.memberCount);
                        bs.setActive(true);
                        chatRoomRepo.save(bs);
                    } else {
                        chatRoomRepo.delete(bs);
                    }

                }, () -> {
                    chatRoomService.save(new ChatRoom(basicGroup.id, null, basicGroup.memberCount, true, 0, 1), chatRoomMember);
                }
        );
    }


    public static void submitAddSuperGroup(TdApi.Supergroup supergroup) {
        TdFunctions.print("::: " + supergroup.id);
        chatRoomRepo.findByGroupId(supergroup.id).ifPresentOrElse(
                bs -> {
                    bs.setCountMember(supergroup.memberCount);
                    bs.setActive(true);
                    chatRoomRepo.save(bs);
                }, () -> {
                    chatRoomService.save(new ChatRoom(supergroup.id, null, supergroup.memberCount, true, 0, 3), chatRoomMember);
                }
        );
    }

    public static void addMemberBasicGroupToDb(long groupId, TdApi.BasicGroupFullInfo basicGroupFullInfo) {
        TdApi.ChatMember[] chatMembers = basicGroupFullInfo.members;
        int var1 = chatMembers.length;
        int memberUserIds[] = new int[var1];

        for (int var0 = 0; var0 < var1; ++var0) {
            memberUserIds[var0] = chatMembers[var0].userId;
        }
        Optional<ChatRoom> optionalChatRoom = chatRoomRepo.findByGroupId((int) groupId);

        Optional<ChatRoomMember> optionalChatRoomMember = chatRoomMemberRepo.findByChatRoom(optionalChatRoom.get().getId());

        if (optionalChatRoomMember.isEmpty()) {
            chatRoomService.addMemberBasicGroupFromPhone(memberUserIds, optionalChatRoom.get());
            String chatId = "-" + groupId;
            TdApi.InputMessageContent content = new TdApi.InputMessageText(new TdApi.FormattedText("Terima kasih telah mendaftarkan IAP ke Chatroom ini. \nAkun ini adalah Nomor Telegram milik PT. Indomarco Adi Prima.", null), false, true);
            GlobalVariable.mainTelegram.client.send(new TdApi.SendMessage(Long.parseLong(chatId), 0, null, null, content), new DefaultHandler());

            GlobalVariable.mainTelegram.client.send(new TdApi.GetChat(Long.parseLong(chatId)), new ChatRoomHandler());
        }
    }

    public static void getBasicGroup(long groupId) {
        GlobalVariable.mainTelegram.client.send(new TdApi.GetBasicGroupFullInfo((int) groupId), new UpdatesHandler());
    }

    public static void getSupergroupFullInfo(long groupId) {
        GlobalVariable.mainTelegram.client.send(new TdApi.GetSupergroupFullInfo((int) groupId), new UpdatesHandler());
    }

    public static void getChatMembersTelegram(long groupId, int memberCount) {
        GlobalVariable.mainTelegram.client.send(new TdApi.GetSupergroupMembers((int) groupId, null, memberCount - 1, memberCount), new UpdatesHandler());
    }

    public static void updateSuperGroupFullInf(int superGroupId, TdApi.SupergroupFullInfo supergroupFullInfo) {
        Optional<ChatRoom> optionalChatRoom = chatRoomRepo.findByGroupId(superGroupId);
        if (optionalChatRoom.isPresent()) {
            ChatRoom chatRoom = optionalChatRoom.get();
            chatRoom.setCountMember(supergroupFullInfo.memberCount);
            chatRoomRepo.save(chatRoom);
        }

    }

    private static void setPermissionChatRoom(long chatId) {
        TdApi.ChatPermissions chatPermissions = new TdApi.ChatPermissions(true, true, true, true, true, true, true, true);
        GlobalVariable.mainTelegram.client.send(new TdApi.SetChatPermissions(chatId, chatPermissions), new UpdatesHandler());
    }


    public static void updateChatPermissionToDb(TdApi.Chat chat) {
        chatRoomPermissionService.updateChatRoomPermissionToDb(chat.id, chat.permissions);
    }

    public static void updateChatGroup(TdApi.Chat chat) {
        Gson gson = new Gson();
        TdApi.ChatType chatType = chat.type;
        chatType.toString();
        String chatTypeString = gson.toJson(chatType);

        ChatTypeBean chatTypeBean = gson.fromJson(chatTypeString, ChatTypeBean.class);

        TdApi.ChatPermissions chatPermissions = chat.permissions;


        chatRoomRepo.findByGroupId(chatTypeBean.getSupergroupId()).ifPresentOrElse(cr -> {
            cr.setName(chat.title);
            cr.setChatId(chat.id);
            chatRoomRepo.save(cr);
            chatRoomService.saveMemberSuperGroup(chatRoomMember, chat.id);
            chatRoomPermissionService.updateChatRoomPermissionToDb(chat.id, chatPermissions);
        }, () -> {
            TdFunctions.print("chat group not register");
        });


    }

    public static void updateBasicGroup(TdApi.Chat chat) {
        Gson gson = new Gson();
        TdApi.ChatType chatType = chat.type;
        chatType.toString();
        String chatTypeString = gson.toJson(chatType);

        ChatTypeBasicGroupBean chatTypeBean = gson.fromJson(chatTypeString, ChatTypeBasicGroupBean.class);

        TdApi.ChatPermissions chatPermissions = chat.permissions;


        chatRoomRepo.findByGroupId(chatTypeBean.getBasicGroupId()).ifPresentOrElse(cr -> {
            cr.setName(chat.title);
            cr.setChatId(chat.id);
            chatRoomRepo.save(cr);
            chatRoomService.saveMemberSuperGroup(chatRoomMember, chat.id);
            chatRoomPermissionService.updateChatRoomPermissionToDb(chat.id, chatPermissions);
        }, () -> {
            TdFunctions.print("chat group not register");
        });


    }

    public static void addMembersGroup(AddMembersRequestBean addMembersRequestBean) {
        for (int i = 0; i < addMembersRequestBean.getUserIds().length; i++) {
            TdFunctions.getUser(addMembersRequestBean.getUserIds()[i]);
            GlobalVariable.mainTelegram.client.send(
                    new TdApi.AddChatMember(addMembersRequestBean.getChatId(), addMembersRequestBean.getUserIds()[i], 0), new ChatRoomHandler());
        }
    }


    public static void updateReadMessage(long chatId, long messageId) {
        TdApi.Chat chat = chatsHelper.get(chatId);
        TelegramMessage telegramMessage = telegramMessageRepo.findByChatIdAndMessageIdSuccess(chatId, messageId).orElseThrow();


        List<TelegramMessage> telegramMessages = telegramMessageRepo.findAllByChatIdAndSenderUserId(telegramMessage.getChatId(), telegramMessage.getSenderUserId());
        TdFunctions.print("updateReadMessage size :::" + telegramMessages.size());
        if (telegramMessages.size() > 0) {

            telegramMessages.forEach(m -> {
                if (m.isMessageDelivered()) {
                    m.setMessageRead(true);
                    telegramMessageRepo.save(m);

                    messageReportService.updateReadMessage(m.getMessageTaskId(), m.getBatch());
                }

            });

        }

    }

    public static void updateSuccessMessage(TdApi.Message msg, long oldMessageId) {
        String chatId = String.valueOf(msg.chatId);
        TransferMessageBean transferMessageBean = messageTransfer.get(Long.parseLong(chatId));
        //synchronized (transferMessageBean) {
        TelegramMessage telegramMessage = telegramMessageRepo.findByChatIdAndMessageId(msg.chatId, oldMessageId).orElseThrow();
        telegramMessage.setMessageDelivered(true);
        telegramMessage.setMessageIdSuccess(msg.id);
        telegramMessageRepo.save(telegramMessage);

        messageReportService.updateDeliverMessage(telegramMessage.getMessageTaskId(), telegramMessage.getBatch(), msg.senderUserId);

        //}

    }

    public static synchronized void updateNewMessage(TdApi.Message msg) {
        String chatId = String.valueOf(msg.chatId);
        String textMessage = "";
        TdApi.MessageContent content = msg.content;


        if (content instanceof TdApi.MessageText) {
            TdApi.MessageText messageText = (TdApi.MessageText) content;
            textMessage = messageText.text.text;
        }

        if (content instanceof TdApi.MessagePhoto) {
            TdApi.MessagePhoto messagePhoto = (TdApi.MessagePhoto) content;
            textMessage = messagePhoto.caption.text;
        }

        if (content instanceof TdApi.MessageDocument) {
            TdApi.MessageDocument messageDocument = (TdApi.MessageDocument) content;
            textMessage = messageDocument.caption.text;
        }

        if (content instanceof TdApi.MessageChatAddMembers) {
            Optional<ChatRoom> optionalChatRoom = chatRoomRepo.findByChatId(msg.chatId);
            int memberUserIds[] = ((TdApi.MessageChatAddMembers) content).memberUserIds;
            if (optionalChatRoom.get().getRoomType() == 1) {
                chatRoomService.addMemberBasicGroupFromPhone(memberUserIds, optionalChatRoom.get());
            } else {
                chatRoomService.addMemberFromPhone(memberUserIds, optionalChatRoom.get());
            }

        }

        if (content instanceof TdApi.MessageChatDeleteMember) {
            Optional<ChatRoom> optionalChatRoom = chatRoomRepo.findByChatId(msg.chatId);
            int userId = ((TdApi.MessageChatDeleteMember) content).userId;
            Optional<ChatRoomMember> optionalChatRoomMember = chatRoomMemberRepo.findOneByUserTelegramIdAndChatRoom(String.valueOf(userId), optionalChatRoom.get());
            if (optionalChatRoomMember.isPresent()) {
                chatRoomMemberRepo.delete(optionalChatRoomMember.get());
            }
            ChatRoom chatRoom = optionalChatRoom.get();
            chatRoomRepo.save(chatRoom);


            getSupergroupFullInfo(optionalChatRoom.get().getGroupId());
        }


        TransferMessageBean transferMessageBean = messageTransfer.get(Long.parseLong(chatId));
        synchronized (transferMessageBean) {
            TelegramMessage telegramMessage = new TelegramMessage();
            telegramMessage.setChatId(Long.parseLong(chatId));
            telegramMessage.setMessageId(msg.id);
            telegramMessage.setSenderUserId(msg.senderUserId);
            telegramMessage.setContent(textMessage);
            telegramMessage.setMessageTaskId(transferMessageBean.getMessageTaskId());
            telegramMessage.setBatch(transferMessageBean.getBatch());
            telegramMessageRepo.save(telegramMessage);

        }

    }

    public static TelegramAccount getAccountEnable() {
        TelegramAccount telegramAccount = telegramAccountService.findByEnableEquals(true);
        return telegramAccount;
    }

    public static void disableAccount(String phoneNumber) {
        telegramAccountService.disableAccount(phoneNumber);
    }

    public static void enableAccount(String phoneNumber) {
        telegramAccountService.enableAccount(phoneNumber);
    }

    public static void commandChat(TdApi.Message message) {
        TdApi.MessageContent content = message.content;

        String text = "";

        if (content instanceof TdApi.MessageText) {
            TdApi.MessageText messageText = (TdApi.MessageText) content;
            text = messageText.text.text;
        }
        commandMessageThread.commandChat(message.senderUserId, message.chatId, message.id, text);
    }

}
