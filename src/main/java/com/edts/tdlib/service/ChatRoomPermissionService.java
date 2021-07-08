package com.edts.tdlib.service;

import com.edts.tdlib.TdApi;
import com.edts.tdlib.bean.contact.ChatPermissionBean;
import com.edts.tdlib.bean.contact.MemberPermissionBean;
import com.edts.tdlib.engine.GlobalVariable;
import com.edts.tdlib.engine.handler.ChatRoomHandler;
import com.edts.tdlib.engine.handler.UpdatesHandler;
import com.edts.tdlib.mapper.ContactMapper;
import com.edts.tdlib.model.contact.ChatRoom;
import com.edts.tdlib.model.contact.ChatRoomMember;
import com.edts.tdlib.model.contact.ChatRoomMemberPermission;
import com.edts.tdlib.model.contact.ChatRoomPermission;
import com.edts.tdlib.repository.ChatRoomMemberPermissionRepo;
import com.edts.tdlib.repository.ChatRoomMemberRepo;
import com.edts.tdlib.repository.ChatRoomPermissionRepo;
import com.edts.tdlib.repository.ChatRoomRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ChatRoomPermissionService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ContactMapper contactMapper;
    private final ChatRoomMemberPermissionRepo chatRoomMemberPermissionRepo;
    private final ChatRoomPermissionRepo chatRoomPermissionRepo;
    private final ChatRoomMemberRepo chatRoomMemberRepo;
    private final ChatRoomRepo chatRoomRepo;

    public ChatRoomPermissionService(ContactMapper contactMapper, ChatRoomMemberPermissionRepo chatRoomMemberPermissionRepo, ChatRoomPermissionRepo chatRoomPermissionRepo,
                                     ChatRoomMemberRepo chatRoomMemberRepo, ChatRoomRepo chatRoomRepo) {
        this.contactMapper = contactMapper;
        this.chatRoomMemberPermissionRepo = chatRoomMemberPermissionRepo;
        this.chatRoomPermissionRepo = chatRoomPermissionRepo;
        this.chatRoomMemberRepo = chatRoomMemberRepo;
        this.chatRoomRepo = chatRoomRepo;
    }

    public void setMemberPermission(MemberPermissionBean memberPermission) {
        if (!memberPermission.isCanSendMessages()) {
            memberPermission.setCanSendMessages(false);
            memberPermission.setCanSendMediaMessages(false);
            memberPermission.setCanSendPolls(false);
            memberPermission.setCanSendOtherMessages(false);
            memberPermission.setCanAddWebPagePreviews(false);
        }

        TdApi.ChatPermissions chatPermissions = new TdApi.ChatPermissions(memberPermission.isCanSendMessages(), memberPermission.isCanSendMediaMessages(), memberPermission.isCanSendPolls(), memberPermission.isCanSendOtherMessages(),
                memberPermission.isCanAddWebPagePreviews(), memberPermission.isCanChangeInfo(), memberPermission.isCanInviteUsers(), false);

        TdApi.ChatMemberStatus chatMemberStatus = new TdApi.ChatMemberStatusRestricted(true, 0, chatPermissions);
        GlobalVariable.mainTelegram.client.send(new TdApi.SetChatMemberStatus(memberPermission.getChatId(), memberPermission.getTelegramUserId(), chatMemberStatus), new ChatRoomHandler());

        memberPermission.setCanPinMessages(false);
        ChatRoomMemberPermission chatRoomMemberPermission = contactMapper.toChatRoomMemberPermission(memberPermission);

        Optional<ChatRoomMemberPermission> optionalChatRoomMemberPermission = chatRoomMemberPermissionRepo.findByChatIdAndTelegramUserId(memberPermission.getChatId(), memberPermission.getTelegramUserId());
        optionalChatRoomMemberPermission.ifPresentOrElse(p -> {
            chatRoomMemberPermission.setId(p.getId());
            chatRoomMemberPermissionRepo.save(chatRoomMemberPermission);
        }, () -> {
            chatRoomMemberPermissionRepo.save(chatRoomMemberPermission);

            ChatRoom chatRoom = chatRoomRepo.findByChatId(memberPermission.getChatId()).orElseThrow();
            ChatRoomMember chatRoomMember = chatRoomMemberRepo.findOneByUserTelegramIdAndChatRoom(String.valueOf(memberPermission.getTelegramUserId()), chatRoom).orElseThrow();
            chatRoomMember.setRestrictedStatus(true);
            chatRoomMemberRepo.save(chatRoomMember);
        });

    }

    public void setMemberStatusMember(long chatId, int userId) {
        TdApi.ChatMemberStatus chatMemberStatus = new TdApi.ChatMemberStatusMember();
        GlobalVariable.mainTelegram.client.send(new TdApi.SetChatMemberStatus(chatId, userId, chatMemberStatus), new ChatRoomHandler());

        Optional<ChatRoomMemberPermission> optionalChatRoomMemberPermission = chatRoomMemberPermissionRepo.findByChatIdAndTelegramUserId(chatId, userId);
        if (optionalChatRoomMemberPermission.isPresent()) {
            chatRoomMemberPermissionRepo.delete(optionalChatRoomMemberPermission.get());

            ChatRoom chatRoom = chatRoomRepo.findByChatId(chatId).orElseThrow();
            ChatRoomMember chatRoomMember = chatRoomMemberRepo.findOneByUserTelegramIdAndChatRoom(String.valueOf(userId), chatRoom).orElseThrow();
            chatRoomMember.setRestrictedStatus(false);
            chatRoomMemberRepo.save(chatRoomMember);
        }

    }


    public Map<String, Object> findByChatIdAndUserTelegramId(long chatId, int userId) {
        Optional<ChatRoomMemberPermission> optionalChatRoomMemberPermission = Optional.ofNullable(chatRoomMemberPermissionRepo.findByChatIdAndTelegramUserId(chatId, userId).orElseThrow(EntityNotFoundException::new));


        MemberPermissionBean memberPermissionBean = contactMapper.toMemberPermissionBean(optionalChatRoomMemberPermission.get());

        Optional<ChatRoomPermission> optionalChatRoomPermission = Optional.ofNullable(chatRoomPermissionRepo.findByChatId(chatId).orElseThrow(EntityNotFoundException::new));
        ChatPermissionBean chatPermissionBean = contactMapper.toChatPermissionBean(optionalChatRoomPermission.get());

        Map<String, Object> mapResult = new HashMap<>();
        mapResult.put("chatRoomPermission", chatPermissionBean);
        mapResult.put("memberPermission", memberPermissionBean);

        return mapResult;
    }


    public void updateChatRoomPermissionToDb(long chatId, TdApi.ChatPermissions chatPermissions) {
        Optional<ChatRoomPermission> optionalChatRoomPermission = chatRoomPermissionRepo.findByChatId(chatId);
        ChatRoomPermission chatRoomPermission = contactMapper.toChatRoomPermission(chatPermissions);
        optionalChatRoomPermission.ifPresentOrElse(cr -> {
            chatRoomPermission.setId(cr.getId());
            chatRoomPermission.setChatId(cr.getChatId());
            chatRoomPermissionRepo.save(chatRoomPermission);
        }, () -> {
            chatRoomPermission.setChatId(chatId);
            chatRoomPermissionRepo.save(chatRoomPermission);
        });
    }

    public void updateChatRoomPermissionToTelegram(ChatPermissionBean chatPermissionBean) {
        TdApi.ChatPermissions chatPermissions = new TdApi.ChatPermissions(chatPermissionBean.isCanSendMessages(), chatPermissionBean.isCanSendMediaMessages(), chatPermissionBean.isCanSendPolls(), chatPermissionBean.isCanSendOtherMessages(),
                chatPermissionBean.isCanAddWebPagePreviews(), chatPermissionBean.isCanChangeInfo(), chatPermissionBean.isCanInviteUsers(), chatPermissionBean.isCanPinMessages());

        GlobalVariable.mainTelegram.client.send(new TdApi.SetChatPermissions(chatPermissionBean.getChatId(), chatPermissions), new UpdatesHandler());
    }


    public ChatPermissionBean findByChatId(long chatId) {
        Optional<ChatRoomPermission> optionalChatRoomPermission = Optional.ofNullable(chatRoomPermissionRepo.findByChatId(chatId).orElseThrow(EntityNotFoundException::new));
        return contactMapper.toChatPermissionBean(optionalChatRoomPermission.get());
    }


}
