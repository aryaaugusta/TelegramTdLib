package com.edts.tdlib.bean;

public class AddMembersRequestBean {

    private long chatId;
    private int[] userIds;


    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public int[] getUserIds() {
        return userIds;
    }

    public void setUserIds(int[] userIds) {
        this.userIds = userIds;
    }


}
