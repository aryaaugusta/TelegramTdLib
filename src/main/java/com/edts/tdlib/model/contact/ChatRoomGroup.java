package com.edts.tdlib.model.contact;

import com.edts.tdlib.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ChatRoomGroup extends BaseEntity {

    private String name;

    private Integer countMember;

    private boolean deleted = false;

    @OneToMany(mappedBy = "chatRoomGroup", cascade = CascadeType.ALL)
    List<ChatRoomGroupMember> chatRoomGroupMemberList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountMember() {
        return countMember;
    }

    public void setCountMember(Integer countMember) {
        this.countMember = countMember;
    }

    public List<ChatRoomGroupMember> getChatRoomGroupMemberList() {
        return chatRoomGroupMemberList;
    }

    public void setChatRoomGroupMemberList(List<ChatRoomGroupMember> chatRoomGroupMemberList) {
        this.chatRoomGroupMemberList = chatRoomGroupMemberList;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
