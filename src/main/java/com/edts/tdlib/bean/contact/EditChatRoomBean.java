package com.edts.tdlib.bean.contact;

public class EditChatRoomBean {

    private long id;
    private String name;
    private int[] userIds;
    private int[] removeUserId;

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

    public int[] getUserIds() {
        return userIds;
    }

    public void setUserIds(int[] userIds) {
        this.userIds = userIds;
    }

    public int[] getRemoveUserId() {
        return removeUserId;
    }

    public void setRemoveUserId(int[] removeUserId) {
        this.removeUserId = removeUserId;
    }
}
