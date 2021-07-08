package com.edts.tdlib.bean.contact;

import java.util.List;

public class ViewChatRoomGroupBean {
    private long id;
    private String name;
    private Integer countMember;

    List<ViewChatRoomGroupMemberBean> chatRoomGroupMemberBeans;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public List<ViewChatRoomGroupMemberBean> getChatRoomGroupMemberBeans() {
        return chatRoomGroupMemberBeans;
    }

    public void setChatRoomGroupMemberBeans(List<ViewChatRoomGroupMemberBean> chatRoomGroupMemberBeans) {
        this.chatRoomGroupMemberBeans = chatRoomGroupMemberBeans;
    }
}
