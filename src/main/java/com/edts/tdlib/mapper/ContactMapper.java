package com.edts.tdlib.mapper;

import com.edts.tdlib.TdApi;
import com.edts.tdlib.bean.contact.*;
import com.edts.tdlib.bean.message.*;
import com.edts.tdlib.constant.GeneralConstant;
import com.edts.tdlib.model.contact.*;
import com.edts.tdlib.model.message.MessageTask;
import com.edts.tdlib.repository.ChatRoomRepo;
import com.edts.tdlib.repository.TelegramUserRepo;
import com.edts.tdlib.util.GeneralUtil;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class ContactMapper {

    private final ModelMapper modelMapper = new ModelMapper();
    private final TelegramUserRepo telegramUserRepo;
    private final ChatRoomRepo chatRoomRepo;

    private static Logger logger = LoggerFactory.getLogger("CoreHelper");

    /*
     * Create new modelMapper
     * */
    public ModelMapper getMapper() {
        return modelMapper;
    }

    public ContactMapper(TelegramUserRepo telegramUserRepo, ChatRoomRepo chatRoomRepo) {
        this.telegramUserRepo = telegramUserRepo;
        this.chatRoomRepo = chatRoomRepo;
    }

    public TelegramUserBean toTelegramUserBean(TelegramUser telegramUser) {
        return modelMapper.map(telegramUser, TelegramUserBean.class);
    }

    public TelegramUserAuthorizationBean toTelegramUserAuthorizationBean(TelegramUserBean telegramUserBean, List<TelegramUserGroup> telegramUserGroups) {
        TelegramUserAuthorizationBean telegramUserAuthorizationBean = new TelegramUserAuthorizationBean();
        telegramUserAuthorizationBean.setId(telegramUserBean.getId());
        telegramUserAuthorizationBean.setPhoneNumber(telegramUserBean.getPhoneNumber());
        telegramUserAuthorizationBean.setChatId(telegramUserBean.getChatId());
        telegramUserAuthorizationBean.setFirstName(telegramUserBean.getFirstName());
        telegramUserAuthorizationBean.setLastName(telegramUserBean.getLastName());

        if (telegramUserGroups != null && telegramUserGroups.size() > 0) {
            List<TelegramUserGroupBean> telegramUserGroupBeans = new ArrayList<>();
            telegramUserGroups.parallelStream().forEach(g -> {
                TelegramUserGroupBean telegramUserGroupBean = new TelegramUserGroupBean();
                telegramUserGroupBean.setId(g.getId());
                telegramUserGroupBean.setGroupName(g.getName());
                telegramUserGroupBean.setEnable(g.isEnable());
                telegramUserGroupBeans.add(telegramUserGroupBean);
            });
            telegramUserAuthorizationBean.setTelegramUserGroupsBean(telegramUserGroupBeans);
        }

        return telegramUserAuthorizationBean;
    }

    public TelegramUserGroupBean toTelegramUSerGroupBean(TelegramUserGroup telegramUserGroup) {
        return modelMapper.map(telegramUserGroup, TelegramUserGroupBean.class);
    }

    public ChatRoomBean toChatRoomBean(ChatRoom chatRoom) {
        ChatRoomBean chatRoomBean = new ChatRoomBean();
        List<ChatRoomMemberBean> chatRoomMemberBeans = new ArrayList<>();
        chatRoomBean = modelMapper.map(chatRoom, ChatRoomBean.class);
        chatRoom.getChatRoomMemberList().parallelStream().forEach(cr -> {
            ChatRoomMemberBean chatRoomMemberBean = new ChatRoomMemberBean();
            chatRoomMemberBean.setId(cr.getId());
            chatRoomMemberBean.setFirstName(cr.getTelegramUser().getFirstName());
            chatRoomMemberBean.setLastName(cr.getTelegramUser().getLastName());
            chatRoomMemberBean.setPhoneNumber(cr.getTelegramUser().getPhoneNumber());
            chatRoomMemberBean.setContactId(String.valueOf(cr.getTelegramUser().getUserTelegramId()));
            chatRoomMemberBean.setRestrictedStatus(cr.isRestrictedStatus());
            chatRoomMemberBean.setUsername(cr.getTelegramUser().getUsername());

            switch (cr.getTelegramUser().getUserType()) {
                case GeneralConstant.USER_TYPE_BOT:
                    chatRoomMemberBean.setUserType(GeneralConstant.USER_TYPE_BOT);
                    break;
                default:
                    chatRoomMemberBean.setUserType("User");

            }


            chatRoomMemberBeans.add(chatRoomMemberBean);
        });

        chatRoomBean.setChatRoomMemberBeanList(chatRoomMemberBeans);
        return chatRoomBean;
    }

    public ViewUserGroupBean toViewUserGroupBean(TelegramUserGroup telegramUserGroup) {
        ViewUserGroupBean viewUserGroupBean = new ViewUserGroupBean();
        viewUserGroupBean = modelMapper.map(telegramUserGroup, ViewUserGroupBean.class);

        List<MemberUseGroupBean> memberUseGroupBeans = new ArrayList<>();
        telegramUserGroup.getTeleUserGroupList().stream().forEach(um -> {
            MemberUseGroupBean memberUseGroupBean = new MemberUseGroupBean();
            memberUseGroupBean.setChatId(um.getTelegramUser().getChatId());
            memberUseGroupBean.setIdUser(um.getTelegramUser().getId());
            memberUseGroupBean.setName(um.getTelegramUser().getFirstName() + " " + um.getTelegramUser().getLastName());
            memberUseGroupBean.setPhoneNumber(um.getTelegramUser().getPhoneNumber());
            memberUseGroupBeans.add(memberUseGroupBean);
        });
        viewUserGroupBean.setMemberGroupBeanList(memberUseGroupBeans);
        return viewUserGroupBean;
    }

    public ViewChatRoomGroupBean toViewChatRoomGroupBean(ChatRoomGroup chatRoomGroup) {
        ViewChatRoomGroupBean viewChatRoomGroupBean = new ViewChatRoomGroupBean();
        viewChatRoomGroupBean = modelMapper.map(chatRoomGroup, ViewChatRoomGroupBean.class);

        List<ViewChatRoomGroupMemberBean> chatRoomGroupMemberBeans = new ArrayList<>();
        chatRoomGroup.getChatRoomGroupMemberList().stream().forEach(cr -> {
            ViewChatRoomGroupMemberBean chatRoomGroupMemberBean = new ViewChatRoomGroupMemberBean();
            chatRoomGroupMemberBean.setChatRoomId(cr.getChatRoom().getId());
            chatRoomGroupMemberBean.setGroupId(cr.getChatRoom().getGroupId());
            chatRoomGroupMemberBean.setName(cr.getChatRoom().getName());
            chatRoomGroupMemberBean.setCountMember(cr.getChatRoom().getCountMember());
            chatRoomGroupMemberBean.setChatId(cr.getChatRoom().getChatId());
            chatRoomGroupMemberBeans.add(chatRoomGroupMemberBean);
        });
        viewChatRoomGroupBean.setChatRoomGroupMemberBeans(chatRoomGroupMemberBeans);
        return viewChatRoomGroupBean;
    }


    public ChatRoomMemberPermission toChatRoomMemberPermission(MemberPermissionBean memberPermissionBean) {
        return modelMapper.map(memberPermissionBean, ChatRoomMemberPermission.class);
    }

    public MemberPermissionBean toMemberPermissionBean(ChatRoomMemberPermission chatRoomMemberPermission) {
        return modelMapper.map(chatRoomMemberPermission, MemberPermissionBean.class);
    }

    public ChatRoomPermission toChatRoomPermission(TdApi.ChatPermissions chatPermissions) {
        ChatRoomPermission chatRoomPermission = new ChatRoomPermission();
        chatRoomPermission.setCanAddWebPagePreviews(chatPermissions.canAddWebPagePreviews);
        chatRoomPermission.setCanChangeInfo(chatPermissions.canChangeInfo);
        chatRoomPermission.setCanInviteUsers(chatPermissions.canInviteUsers);
        chatRoomPermission.setCanPinMessages(chatPermissions.canPinMessages);
        chatRoomPermission.setCanSendMediaMessages(chatPermissions.canSendMediaMessages);
        chatRoomPermission.setCanSendMessages(chatPermissions.canSendMessages);
        chatRoomPermission.setCanSendOtherMessages(chatPermissions.canSendOtherMessages);
        chatRoomPermission.setCanSendPolls(chatPermissions.canSendPolls);
        return chatRoomPermission;
    }

    public ChatPermissionBean toChatPermissionBean(ChatRoomPermission chatRoomPermission) {
        return modelMapper.map(chatRoomPermission, ChatPermissionBean.class);
    }


    public Attribute toAttribute(AddUpdateAttributeBean attributeBean) {
        Attribute attribute = modelMapper.map(attributeBean, Attribute.class);

        attribute.setUserCount(attribute.getUserCount() + attributeBean.getMemberAttributeBeans().size());
        return attribute;
    }

    public AttributeBean toAttributeBean(Attribute attribute) {
        return modelMapper.map(attribute, AttributeBean.class);
    }

    public ViewAttributeBean toViewAttributeBeaan(Attribute attribute) {
        ViewAttributeBean attributeBean = modelMapper.map(attribute, ViewAttributeBean.class);

        List<ViewAttributeMemberBean> memberBeanList = new ArrayList<>();
        attribute.getMemberAttributeList().stream().forEach(a -> {
            ViewAttributeMemberBean viewAttributeMemberBean = new ViewAttributeMemberBean();
            viewAttributeMemberBean.setId(a.getId());
            viewAttributeMemberBean.setContactType(a.getContactType());
            viewAttributeMemberBean.setIdRefContact(a.getIdRefContact());

            String attValue = null;
            switch (attribute.getDataType().toUpperCase(Locale.ROOT)) {
                case GeneralConstant.ATTRIBUTE_DATA_TYPE_DATE:
                    try {
                        Date attrDate = GeneralUtil.strToDate(a.getAttributeValue(), "dd-MM-yyyy");
                        attValue = GeneralUtil.dateToStr(attrDate, "yyyy-MM-dd");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    attValue = a.getAttributeValue();
                    break;

            }

            viewAttributeMemberBean.setAttributeValue(attValue);
            String name = null;
            long contactId = 0;
            switch (a.getContactType()) {
                case GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER:
                    TelegramUser telegramUser = telegramUserRepo.findById(a.getIdRefContact()).get();
                    name = telegramUser.getFirstName() + " " + telegramUser.getLastName();
                    contactId = telegramUser.getUserTelegramId();
                    break;
                case GeneralConstant.ATTRIBUTE_CONTACT_TYPE_CHATROOM:
                    ChatRoom chatRoom = chatRoomRepo.findById(a.getIdRefContact()).get();
                    name = chatRoom.getName();
                    contactId = chatRoom.getGroupId();
                    break;
                default:
                    logger.info("id ref tidak di temukan");

            }
            viewAttributeMemberBean.setName(name);
            viewAttributeMemberBean.setContactId(contactId);

            memberBeanList.add(viewAttributeMemberBean);
        });

        attributeBean.setMemberBeanList(memberBeanList);
        return attributeBean;
    }


    public TelegramUser toTelegramBot(TelegramBotBean telegramBotBean) {
        return modelMapper.map(telegramBotBean, TelegramUser.class);
    }


    public TelegramBotBean toTelegramBotBean(TelegramUser telegramUser) {
        return modelMapper.map(telegramUser, TelegramBotBean.class);
    }


    public ViewMessageTaskBean toReceiverView(MessageTask messageTask) {
        AtomicReference<MessageReceiverBean> user = new AtomicReference<>();
        List<MessageReceiverBean> users = new ArrayList<>();

        AtomicReference<MessageReceiverBean> userGroup = new AtomicReference<>();
        List<MessageReceiverBean> userGroups = new ArrayList<>();

        AtomicReference<MessageReceiverBean> chatRoom = new AtomicReference<>();
        List<MessageReceiverBean> chatRooms = new ArrayList<>();

        /**TO DO NEXT*/
        AtomicReference<MessageReceiverBean> chatRoomGroup = new AtomicReference<>();
        List<MessageReceiverBean> chatRoomGroups = new ArrayList<>();


        messageTask.getReceiverList().forEach(mr -> {
            if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_SINGLE_USER)) {
                user.set(new MessageReceiverBean(mr.getIdReferenceReceiver(), mr.getNameReceiver()));
                users.add(user.get());
            } else if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_MULTIPLE_USER)) {
                userGroup.set(new MessageReceiverBean(mr.getIdReferenceReceiver(), mr.getNameReceiver()));
                userGroups.add(userGroup.get());
            } else if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_SINLGE_CHATROOM)) {
                chatRoom.set(new MessageReceiverBean(mr.getIdReferenceReceiver(), mr.getNameReceiver()));
                chatRooms.add(chatRoom.get());
            } else if (mr.getType().equals(GeneralConstant.RECEIVER_TYPE_MULTIPLE_CHATROOM)) {
                chatRoomGroup.set(new MessageReceiverBean(mr.getIdReferenceReceiver(), mr.getNameReceiver()));
                chatRoomGroups.add(chatRoomGroup.get());
            }
        });

        ViewMessageTaskBean viewMessageTaskBean = new ViewMessageTaskBean();
        viewMessageTaskBean.setUsers(users);
        viewMessageTaskBean.setUserGroup(userGroups);
        viewMessageTaskBean.setChatRoom(chatRooms);
        viewMessageTaskBean.setChatRoomGroup(chatRoomGroups);
        return viewMessageTaskBean;
    }

    public ViewImmediateMessageBean toViewImmediateMessageBean(MessageTask messageTask, ViewMessageTaskBean viewMessageTaskBean) {
        ViewImmediateMessageBean viewImmediateMessageBean = new ViewImmediateMessageBean();
        viewImmediateMessageBean.setId(messageTask.getId());
        viewImmediateMessageBean.setSubject(messageTask.getSubject());
        viewImmediateMessageBean.setContent(messageTask.getContent());
        viewImmediateMessageBean.setStatus(messageTask.getStatus());
        viewImmediateMessageBean.setCreatedBy(messageTask.getCreatedBy());
        viewImmediateMessageBean.setModifiedBy(messageTask.getModifiedBy());
        viewImmediateMessageBean.setCreatedDated(messageTask.getCreatedDate());
        viewImmediateMessageBean.setModifiedDate(messageTask.getModifiedDate());
        viewImmediateMessageBean.setSendDate(messageTask.getCreatedDate());


        viewImmediateMessageBean.setUsers(viewMessageTaskBean.getUsers());
        viewImmediateMessageBean.setUserGroup(viewMessageTaskBean.getUserGroup());
        viewImmediateMessageBean.setChatRoom(viewMessageTaskBean.getChatRoom());
        viewImmediateMessageBean.setChatRoomGroup(viewMessageTaskBean.getChatRoomGroup());

        return viewImmediateMessageBean;
    }

    public ViewOnceOffMessgeBean toViewOnceOffMessgeBean(MessageTask messageTask, ViewMessageTaskBean viewMessageTaskBean) {
        ViewOnceOffMessgeBean viewOnceOffMessgeBean = new ViewOnceOffMessgeBean();

        viewOnceOffMessgeBean.setId(messageTask.getId());
        viewOnceOffMessgeBean.setSubject(messageTask.getSubject());
        viewOnceOffMessgeBean.setContent(messageTask.getContent());
        viewOnceOffMessgeBean.setStatus(messageTask.getStatus());
        viewOnceOffMessgeBean.setCreatedBy(messageTask.getCreatedBy());
        viewOnceOffMessgeBean.setModifiedBy(messageTask.getModifiedBy());
        viewOnceOffMessgeBean.setCreatedDated(messageTask.getCreatedDate());
        viewOnceOffMessgeBean.setModifiedDate(messageTask.getModifiedDate());
        viewOnceOffMessgeBean.setOnceOffDate(messageTask.getOnceOffDate());
        viewOnceOffMessgeBean.setOnceOffTime(messageTask.getOnceOffTime());


        viewOnceOffMessgeBean.setUsers(viewMessageTaskBean.getUsers());
        viewOnceOffMessgeBean.setUserGroup(viewMessageTaskBean.getUserGroup());
        viewOnceOffMessgeBean.setChatRoom(viewMessageTaskBean.getChatRoom());
        viewOnceOffMessgeBean.setChatRoomGroup(viewMessageTaskBean.getChatRoomGroup());

        return viewOnceOffMessgeBean;
    }

    public ViewRecurringMessageBean toViewRecurringMessageBean(MessageTask messageTask, ViewMessageTaskBean viewMessageTaskBean) {
        ViewRecurringMessageBean viewRecurringMessageBean = new ViewRecurringMessageBean();

        viewRecurringMessageBean.setId(messageTask.getId());
        viewRecurringMessageBean.setSubject(messageTask.getSubject());
        viewRecurringMessageBean.setContent(messageTask.getContent());
        viewRecurringMessageBean.setStatus(messageTask.getStatus());
        viewRecurringMessageBean.setCreatedBy(messageTask.getCreatedBy());
        viewRecurringMessageBean.setModifiedBy(messageTask.getModifiedBy());
        viewRecurringMessageBean.setCreatedDated(messageTask.getCreatedDate());
        viewRecurringMessageBean.setModifiedDate(messageTask.getModifiedDate());
        viewRecurringMessageBean.setRecurringType(messageTask.getRecurringType());
        viewRecurringMessageBean.setRecurringTimeExecute(messageTask.getRecurringTimeExecute());
        viewRecurringMessageBean.setRecurringStartDate(messageTask.getRecurringStartDate());
        viewRecurringMessageBean.setRecurringEndDate(messageTask.getRecurringEndDate());

        viewRecurringMessageBean.setUsers(viewMessageTaskBean.getUsers());
        viewRecurringMessageBean.setUserGroup(viewMessageTaskBean.getUserGroup());
        viewRecurringMessageBean.setChatRoom(viewMessageTaskBean.getChatRoom());
        viewRecurringMessageBean.setChatRoomGroup(viewMessageTaskBean.getChatRoomGroup());

        return viewRecurringMessageBean;
    }
}
