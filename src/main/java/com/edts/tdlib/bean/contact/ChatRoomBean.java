package com.edts.tdlib.bean.contact;

import java.util.List;

public class ChatRoomBean {

    private long id;
    private String name;
    private int countMember;
    private int groupId;
    private long chatId;

    private List<ChatRoomMemberBean> chatRoomMemberBeanList;

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

    public int getCountMember() {
        return countMember;
    }

    public void setCountMember(int countMember) {
        this.countMember = countMember;
    }

    public List<ChatRoomMemberBean> getChatRoomMemberBeanList() {
        return chatRoomMemberBeanList;
    }

    public void setChatRoomMemberBeanList(List<ChatRoomMemberBean> chatRoomMemberBeanList) {
        this.chatRoomMemberBeanList = chatRoomMemberBeanList;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }
}
