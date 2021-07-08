package com.edts.tdlib.bean.contact;

public class MemberPermissionBean extends ChatPermissionBean {

    private int telegramUserId;

    public int getTelegramUserId() {
        return telegramUserId;
    }

    public void setTelegramUserId(int telegramUserId) {
        this.telegramUserId = telegramUserId;
    }
}
