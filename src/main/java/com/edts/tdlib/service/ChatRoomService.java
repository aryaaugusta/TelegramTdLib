package com.edts.tdlib.service;

import com.edts.tdlib.TdApi;
import com.edts.tdlib.bean.AddMembersRequestBean;
import com.edts.tdlib.bean.contact.ChatRoomBean;
import com.edts.tdlib.bean.contact.ChatRoomRequestBean;
import com.edts.tdlib.bean.contact.ChatRoomUploadBean;
import com.edts.tdlib.bean.contact.EditChatRoomBean;
import com.edts.tdlib.constant.GeneralConstant;
import com.edts.tdlib.engine.GlobalVariable;
import com.edts.tdlib.engine.handler.ChatRoomHandler;
import com.edts.tdlib.engine.handler.UpdatesHandler;
import com.edts.tdlib.helper.ChatRoomExcelHelper;
import com.edts.tdlib.helper.CoreHelper;
import com.edts.tdlib.helper.TelegramUserExcelHelper;
import com.edts.tdlib.mapper.CommonMapper;
import com.edts.tdlib.mapper.ContactMapper;
import com.edts.tdlib.model.contact.ChatRoom;
import com.edts.tdlib.model.contact.ChatRoomMember;
import com.edts.tdlib.model.contact.TelegramUser;
import com.edts.tdlib.repository.ChatRoomMemberRepo;
import com.edts.tdlib.repository.ChatRoomRepo;
import com.edts.tdlib.repository.TelegramUserRepo;
import com.edts.tdlib.util.SecurityUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Service
public class ChatRoomService {

    private final Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ChatRoomRepo chatRoomRepo;
    private final CommonMapper commonMapper;
    private final TelegramUserRepo telegramUserRepo;
    private final ChatRoomExcelHelper chatRoomExcelHelper;
    private final ContactMapper contactMapper;
    private final ChatRoomMemberRepo chatRoomMemberRepo;


    public ChatRoomService(ChatRoomRepo chatRoomRepo, CommonMapper commonMapper, TelegramUserRepo telegramUserRepo,
                           ChatRoomExcelHelper chatRoomExcelHelper, ContactMapper contactMapper, ChatRoomMemberRepo chatRoomMemberRepo) {
        this.chatRoomRepo = chatRoomRepo;
        this.commonMapper = commonMapper;
        this.telegramUserRepo = telegramUserRepo;
        this.chatRoomExcelHelper = chatRoomExcelHelper;
        this.contactMapper = contactMapper;
        this.chatRoomMemberRepo = chatRoomMemberRepo;
    }


    public void addGroup(ChatRoomRequestBean chatRoomRequestBean) {
        CoreHelper.userBy.clear();
        CoreHelper.userBy.put(1, SecurityUtil.getEmail().get());
        CoreHelper.addGroup(chatRoomRequestBean);
    }

    public void addSuperGroup(ChatRoomRequestBean chatRoomRequestBean) {
        CoreHelper.userBy.clear();
        CoreHelper.userBy.put(1, SecurityUtil.getEmail().get());
        CoreHelper.addSuperGroup(chatRoomRequestBean);
    }

    public void addMembersGroup(AddMembersRequestBean addMembersRequestBean) {
        CoreHelper.addMembersGroup(addMembersRequestBean);
    }


    public Page<ChatRoomBean> getChatRooms(String name, Pageable pageable) {
        Page<ChatRoom> chatRoomPage;
        if (name == null) {
            chatRoomPage = chatRoomRepo.findAll(pageable);
        } else {
            chatRoomPage = chatRoomRepo.findAllByNameGroup(name, pageable);
        }

        Page<ChatRoomBean> chatRoomBeans = commonMapper.mapEntityPageIntoDtoPage(chatRoomPage, ChatRoomBean.class);
        return chatRoomBeans;
    }

    public void save(ChatRoom chatRoom, ConcurrentMap<Integer, TdApi.User> chatRoomMembers) {
        List<ChatRoomMember> members = new ArrayList<>();
        List<TdApi.User> users = new ArrayList<>(chatRoomMembers.values());
        /**if basic group flow*/
        if (chatRoomMembers.size() > 0) {
            users.parallelStream().forEach(cr -> {
                ChatRoomMember chatRoomMember = new ChatRoomMember();
                chatRoomMember.setChatRoom(chatRoom);
                chatRoomMember.setJoinDate(new Date());
                chatRoomMember.setUserTelegramId(String.valueOf(cr.id));
                chatRoomMember.setTelegramUser(telegramUserRepo.findOneByChatId(String.valueOf(cr.id)).orElseThrow());
                members.add(chatRoomMember);
            });
        }

        chatRoom.setChatRoomMemberList(members);
        chatRoomRepo.save(chatRoom);

        if (members != null && members.size() > 0 && chatRoom.getChatId() > 0) {
            users.stream().forEach(u -> {
                GlobalVariable.mainTelegram.client.send(
                        new TdApi.AddChatMember(chatRoom.getChatId(), u.id, 0), new ChatRoomHandler());
            });
            CoreHelper.chatRoomMember.clear();
        }

    }

    public void saveMemberSuperGroup(ConcurrentMap<Integer, TdApi.User> chatRoomMembers, long chatId) {
        List<TdApi.User> users = new ArrayList<>(chatRoomMembers.values());
        if (users.size() > 0) {
            users.stream().forEach(u -> {
                GlobalVariable.mainTelegram.client.send(
                        new TdApi.AddChatMember(chatId, u.id, 0), new ChatRoomHandler());
            });
            CoreHelper.chatRoomMember.clear();
        }
    }


    public Map<String, Object> processDataUpload(MultipartFile file) throws IOException {
        return chatRoomExcelHelper.excelToObject(file.getInputStream());
    }

    public void newChatRoomMemberBulk(MultipartFile file, String name) throws IOException {
        List<Integer> chatRoomUploadBeans = chatRoomExcelHelper.excelToObjectForSave(file.getInputStream());
        int members[] = chatRoomUploadBeans.stream().mapToInt(i -> i).toArray();
        ChatRoomRequestBean chatRoomRequestBean = new ChatRoomRequestBean(name, "", members);
        addSuperGroup(chatRoomRequestBean);
    }


    public ChatRoomBean findById(long id) {
        Optional<ChatRoom> optionalChatRoom = Optional.ofNullable(chatRoomRepo.findById(id).orElseThrow(EntityNotFoundException::new));
        ChatRoomBean chatRoomBean = contactMapper.toChatRoomBean(optionalChatRoom.get());
        return chatRoomBean;
    }

    public void editChatRoom(EditChatRoomBean editChatRoomBean) {
        CoreHelper.userBy.clear();
        CoreHelper.userBy.put(1, SecurityUtil.getEmail().get());

        Optional<ChatRoom> optionalChatRoom = Optional.ofNullable(chatRoomRepo.findById(editChatRoomBean.getId()).orElseThrow(EntityNotFoundException::new));

        int[] userIds = editChatRoomBean.getUserIds();
        int[] rmUserIds = editChatRoomBean.getRemoveUserId();

        List<Integer> addEditMember = Arrays.stream(userIds).boxed().collect(Collectors.toList());

        List<Integer> rmMember = Arrays.stream(rmUserIds).boxed().collect(Collectors.toList());


        rmMember.parallelStream().forEach(rm -> {
            if (rm > 0) {
                Optional<ChatRoomMember> optionalChatRoomMember = Optional.ofNullable(chatRoomMemberRepo.findOneByUserTelegramIdAndChatRoom(String.valueOf(rm), optionalChatRoom.get()).orElseThrow());
                chatRoomMemberRepo.delete(optionalChatRoomMember.get());

                TdApi.ChatMemberStatus statusLeft = new TdApi.ChatMemberStatusLeft();

                GlobalVariable.mainTelegram.client.send(new TdApi.SetChatMemberStatus(optionalChatRoom.get().getChatId(), rm, statusLeft), new UpdatesHandler());
            }
        });

        List<ChatRoomMember> chatRoomMembers = new ArrayList<>();
        addEditMember.parallelStream().forEach(ad -> {
            if (ad > 0) {
                Optional<ChatRoomMember> optionalChatRoomMember = chatRoomMemberRepo.findOneByUserTelegramIdAndChatRoom(String.valueOf(ad), optionalChatRoom.get());
                if (optionalChatRoomMember.isEmpty()) {
                    ChatRoomMember chatRoomMember = new ChatRoomMember();
                    chatRoomMember.setJoinDate(new Date());


                    chatRoomMember.setUserTelegramId(String.valueOf(ad));
                    chatRoomMember.setTelegramUser(telegramUserRepo.findByUserTelegramId(ad).orElseThrow());


                    chatRoomMember.setChatRoom(optionalChatRoom.get());
                    chatRoomMembers.add(chatRoomMember);

                    GlobalVariable.mainTelegram.client.send(new TdApi.AddChatMember(optionalChatRoom.get().getChatId(), ad, 0), new UpdatesHandler());
                }
            }
        });
        chatRoomMemberRepo.saveAll(chatRoomMembers);


    }

    public void delete(long id) {
        ChatRoom chatRoom = chatRoomRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        //TdApi.BasicGroup basicGroup = new TdApi.BasicGroup();

        chatRoom.setDeleted(true);
        chatRoomRepo.save(chatRoom);

    }

    public void addMemberFromPhone(int memberUserIds[], ChatRoom chatRoom) {
        if (memberUserIds.length > 0) {
            List<ChatRoomMember> chatRoomMembers = new ArrayList<>();
            Arrays.stream(memberUserIds).forEach(u -> {
                Optional<ChatRoomMember> optionalChatRoomMember = chatRoomMemberRepo.findOneByUserTelegramIdAndChatRoom(String.valueOf(u), chatRoom);
                if (optionalChatRoomMember.isEmpty()) {
                    ChatRoomMember chatRoomMember = new ChatRoomMember();
                    chatRoomMember.setChatRoom(chatRoom);
                    chatRoomMember.setJoinDate(new Date());
                    Optional<TelegramUser> optionalTelegramUser = telegramUserRepo.findOneByChatId(String.valueOf(u));
                    chatRoomMember.setTelegramUser(optionalTelegramUser.get());
                    chatRoomMember.setUserTelegramId(String.valueOf(u));
                    chatRoomMember.setRestrictedStatus(false);
                    chatRoomMembers.add(chatRoomMember);
                }
            });
            // chatRoomMemberRepo.saveAll(chatRoomMembers);
            chatRoom.setChatRoomMemberList(chatRoomMembers);
            chatRoom.setCountMember(chatRoom.getCountMember() + chatRoomMembers.size());
            chatRoomRepo.save(chatRoom);
        }
    }

    public void addMemberBasicGroupFromPhone(int memberUserIds[], ChatRoom chatRoom) {
        if (memberUserIds.length > 0) {
            List<ChatRoomMember> chatRoomMembers = new ArrayList<>();
            Arrays.stream(memberUserIds).forEach(u -> {
                Optional<ChatRoomMember> optionalChatRoomMember = chatRoomMemberRepo.findOneByUserTelegramIdAndChatRoom(String.valueOf(u), chatRoom);
                if (optionalChatRoomMember.isEmpty()) {
                    Optional<TelegramUser> optionalTelegramUser = telegramUserRepo.findOneByChatId(String.valueOf(u));
                    if (optionalTelegramUser.isPresent()) {
                        ChatRoomMember chatRoomMember = new ChatRoomMember();
                        chatRoomMember.setChatRoom(chatRoom);
                        chatRoomMember.setJoinDate(new Date());
                        chatRoomMember.setTelegramUser(optionalTelegramUser.get());
                        chatRoomMember.setUserTelegramId(String.valueOf(u));
                        chatRoomMember.setRestrictedStatus(false);
                        chatRoomMembers.add(chatRoomMember);
                    }

                }
            });
            // chatRoomMemberRepo.saveAll(chatRoomMembers);
            chatRoom.setChatRoomMemberList(chatRoomMembers);
            chatRoomRepo.save(chatRoom);
        }
    }

    public void getChatMembersTelegram(long groupId) {
        GlobalVariable.mainTelegram.client.send(new TdApi.GetSupergroupMembers((int) groupId, null, 0, 5), new UpdatesHandler());
    }

    public InputStream downloadChatroom(String name, Pageable pageable) {
        List<ChatRoom> chatRooms = new ArrayList<>();


        Page<ChatRoom> chatRoomPage;
        if (name == null) {
            chatRoomPage = chatRoomRepo.findAll(pageable);
        } else {
            chatRoomPage = chatRoomRepo.findAllByNameGroup(name, pageable);
        }


        chatRooms = chatRoomPage.getContent();

        ByteArrayInputStream in = ChatRoomExcelHelper.chatroomsToExcel(chatRooms);
        return in;
    }
}
