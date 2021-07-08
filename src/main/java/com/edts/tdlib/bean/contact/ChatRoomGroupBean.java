package com.edts.tdlib.bean.contact;

public class ChatRoomGroupBean {

    private long id;
    private String name;
    private Integer countMember;
    public long addChatRooms[];
    private long removeChatRooms[];

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

    public long[] getAddChatRooms() {
        return addChatRooms;
    }

    public void setAddChatRooms(long[] addChatRooms) {
        this.addChatRooms = addChatRooms;
    }

    public long[] getRemoveChatRooms() {
        return removeChatRooms;
    }

    public void setRemoveChatRooms(long[] removeChatRooms) {
        this.removeChatRooms = removeChatRooms;
    }
}
