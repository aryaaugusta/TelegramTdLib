package com.edts.tdlib.model.contact;

import com.edts.tdlib.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ChatRoom extends BaseEntity {

    private int groupId;
    private String name;
    private int countMember;
    private boolean isActive;
    private long chatId;
    private int roomType;

    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ChatRoomMember> chatRoomMemberList;

    private boolean deleted;

    public ChatRoom() {
    }

    public ChatRoom(int groupId, String name, int countMember, boolean isActive, long chatId, int roomType) {
        this.groupId = groupId;
        this.name = name;
        this.countMember = countMember;
        this.isActive = isActive;
        this.chatId = chatId;
        this.roomType = roomType;
    }


    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountMember() {
        return countMember;
    }

    public void setCountMember(int countMember) {
        this.countMember = countMember;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public List<ChatRoomMember> getChatRoomMemberList() {
        return chatRoomMemberList;
    }

    public void setChatRoomMemberList(List<ChatRoomMember> chatRoomMemberList) {
        this.chatRoomMemberList = chatRoomMemberList;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }
}
