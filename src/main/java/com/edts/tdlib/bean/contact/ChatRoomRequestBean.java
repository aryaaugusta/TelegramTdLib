package com.edts.tdlib.bean.contact;

public class ChatRoomRequestBean {

    private String name;
    private String description;
    private int[] userIds;

    public ChatRoomRequestBean(String name, String description, int[] userIds) {
        this.name = name;
        this.description = description;
        this.userIds = userIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int[] getUserIds() {
        return userIds;
    }

    public void setUserIds(int[] userIds) {
        this.userIds = userIds;
    }
}
