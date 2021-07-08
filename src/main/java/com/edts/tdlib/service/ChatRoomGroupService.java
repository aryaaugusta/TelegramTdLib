package com.edts.tdlib.service;

import com.edts.tdlib.bean.contact.ChatRoomGroupBean;
import com.edts.tdlib.bean.contact.ViewChatRoomGroupBean;
import com.edts.tdlib.constant.GeneralConstant;
import com.edts.tdlib.exception.HandledException;
import com.edts.tdlib.helper.ChatRoomExcelHelper;
import com.edts.tdlib.helper.ChatRoomGroupExcelHelper;
import com.edts.tdlib.mapper.CommonMapper;
import com.edts.tdlib.mapper.ContactMapper;
import com.edts.tdlib.model.contact.*;
import com.edts.tdlib.repository.ChatRoomGroupMemberRepo;
import com.edts.tdlib.repository.ChatRoomGroupRepo;
import com.edts.tdlib.repository.ChatRoomRepo;
import org.apache.commons.lang3.ArrayUtils;
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

@Service
public class ChatRoomGroupService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final ChatRoomRepo chatRoomRepo;
    private final ChatRoomGroupRepo chatRoomGroupRepo;
    private final CommonMapper commonMapper;
    private final ContactMapper contactMapper;
    private final ChatRoomGroupMemberRepo chatRoomGroupMemberRepo;
    private final ChatRoomGroupExcelHelper chatRoomGroupExcelHelper;

    public ChatRoomGroupService(ChatRoomRepo chatRoomRepo, ChatRoomGroupRepo chatRoomGroupRepo, CommonMapper commonMapper, ContactMapper contactMapper,
                                ChatRoomGroupMemberRepo chatRoomGroupMemberRepo, ChatRoomGroupExcelHelper chatRoomGroupExcelHelper) {
        this.chatRoomRepo = chatRoomRepo;
        this.chatRoomGroupRepo = chatRoomGroupRepo;
        this.commonMapper = commonMapper;
        this.contactMapper = contactMapper;
        this.chatRoomGroupMemberRepo = chatRoomGroupMemberRepo;
        this.chatRoomGroupExcelHelper = chatRoomGroupExcelHelper;
    }

    public void save(ChatRoomGroupBean chatRoomGroupBean) {
        ChatRoomGroup chatRoomGroup = new ChatRoomGroup();
        chatRoomGroup.setName(chatRoomGroupBean.getName());

        long[] inputChatRoom = chatRoomGroupBean.getAddChatRooms();
        Long[] inputBoxedChatRoom = ArrayUtils.toObject(inputChatRoom);
        List<Long> inputAsList = Arrays.asList(inputBoxedChatRoom);
        List<ChatRoomGroupMember> chatRoomGroupMembers = new ArrayList<>();

        inputAsList.stream().forEach(cr -> {
            ChatRoom chatRoom = chatRoomRepo.findById(cr).orElseThrow();
            ChatRoomGroupMember chatRoomGroupMember = new ChatRoomGroupMember(chatRoomGroup, chatRoom);
            chatRoomGroupMembers.add(chatRoomGroupMember);
        });
        chatRoomGroup.setChatRoomGroupMemberList(chatRoomGroupMembers);
        chatRoomGroup.setCountMember(chatRoomGroupMembers.size());

        chatRoomGroupRepo.save(chatRoomGroup);

    }

    public Page<ChatRoomGroupBean> list(String name, Pageable pageable) {
        Page<ChatRoomGroup> chatRoomGroupPage;
        if (name == null) {
            chatRoomGroupPage = chatRoomGroupRepo.findAll(pageable);
        } else {
            chatRoomGroupPage = chatRoomGroupRepo.findAllByName(name, pageable);
        }

        Page<ChatRoomGroupBean> chatRoomGroupBeanPage = commonMapper.mapEntityPageIntoDtoPage(chatRoomGroupPage, ChatRoomGroupBean.class);
        return chatRoomGroupBeanPage;
    }

    public ViewChatRoomGroupBean findById(long id) {
        ChatRoomGroup chatRoomGroup = chatRoomGroupRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        return contactMapper.toViewChatRoomGroupBean(chatRoomGroup);
    }

    public void edit(ChatRoomGroupBean chatRoomGroupBean) {
        ChatRoomGroup chatRoomGroup = chatRoomGroupRepo.findById(chatRoomGroupBean.getId()).orElseThrow(EntityNotFoundException::new);
        chatRoomGroup.setName(chatRoomGroupBean.getName());

        /**Delete member user group*/
        if (chatRoomGroupBean.getRemoveChatRooms().length > 0) {
            Long[] deleteMember = ArrayUtils.toObject(chatRoomGroupBean.getRemoveChatRooms());
            List<Long> deleteMemberAsList = Arrays.asList(deleteMember);
            List<ChatRoomGroupMember> chatRoomGroupMembersDelete = new ArrayList<>();
            deleteMemberAsList.parallelStream().forEach(dm -> {
                Optional<ChatRoomGroupMember> optionalChatRoomGroupMember = chatRoomGroupMemberRepo.findByIdAndChatRoomGroupId(dm, chatRoomGroup.getId());
                if (!optionalChatRoomGroupMember.isEmpty()) {
                    chatRoomGroupMembersDelete.add(optionalChatRoomGroupMember.get());
                }
            });
            chatRoomGroupMemberRepo.deleteAll(chatRoomGroupMembersDelete);
            chatRoomGroup.setCountMember(chatRoomGroup.getCountMember() - chatRoomGroupMembersDelete.size());
            chatRoomGroupRepo.save(chatRoomGroup);
        }

        if (chatRoomGroupBean.getAddChatRooms().length > 0) {
            Long[] addMember = ArrayUtils.toObject(chatRoomGroupBean.getAddChatRooms());
            List<Long> addMemberAsList = Arrays.asList(addMember);

            List<ChatRoomGroupMember> chatRoomGroupMembersAdd = new ArrayList<>();
            addMemberAsList.stream().forEach(ac -> {
                Optional<ChatRoomGroupMember> optionalChatRoomGroupMember = chatRoomGroupMemberRepo.findByIdAndChatRoomGroupId(ac, chatRoomGroup.getId());
                if (optionalChatRoomGroupMember.isEmpty()) {

                    ChatRoom chatRoom = chatRoomRepo.findById(ac).orElseThrow(EntityNotFoundException::new);

                    ChatRoomGroupMember chatRoomGroupMember = new ChatRoomGroupMember(chatRoomGroup, chatRoom);
                    chatRoomGroupMembersAdd.add(chatRoomGroupMember);
                }
            });
            chatRoomGroup.setChatRoomGroupMemberList(chatRoomGroupMembersAdd);
            chatRoomGroup.setCountMember(chatRoomGroup.getCountMember() + chatRoomGroupMembersAdd.size());
            chatRoomGroupRepo.save(chatRoomGroup);
        }

    }

    public void delete(long id) {
        ChatRoomGroup chatRoomGroup = chatRoomGroupRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        chatRoomGroup.setDeleted(true);
        chatRoomGroupRepo.save(chatRoomGroup);
    }


    public InputStream download(String name, Pageable pageable) {
        List<ChatRoomGroup> chatRoomGroups = new ArrayList<>();


        Page<ChatRoomGroup> chatRoomGroupPage;
        if (name == null) {
            chatRoomGroupPage = chatRoomGroupRepo.findAll(pageable);
        } else {
            chatRoomGroupPage = chatRoomGroupRepo.findAllByName(name, pageable);
        }


        chatRoomGroups = chatRoomGroupPage.getContent();

        ByteArrayInputStream in = ChatRoomGroupExcelHelper.chatroomsGroupToExcel(chatRoomGroups);
        return in;
    }

    public Map<String, Object> processDataUpload(MultipartFile file) throws IOException {
        return chatRoomGroupExcelHelper.excelToObject(file.getInputStream());
    }

    public void addChatroomBulk(MultipartFile file, String name) throws IOException {
        List<ChatRoomGroupMember> chatRoomGroupMemberList = chatRoomGroupExcelHelper.excelToObjectForSave(file.getInputStream());
        ChatRoomGroup chatRoomGroup = new ChatRoomGroup();
        chatRoomGroup.setName(name);
        List<ChatRoomGroupMember> chatRoomGroupMembers = new ArrayList<>();
        chatRoomGroupMemberList.stream().forEach(c -> {
            c.setChatRoomGroup(chatRoomGroup);
            chatRoomGroupMembers.add(c);
        });

        chatRoomGroup.setCountMember(chatRoomGroupMemberList.size());
        chatRoomGroup.setChatRoomGroupMemberList(chatRoomGroupMembers);
        chatRoomGroupRepo.save(chatRoomGroup);

    }
}
