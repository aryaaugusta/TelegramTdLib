package com.edts.tdlib.bean.contact;

public class ChatPermissionBean {

    private long chatId;

    private boolean canSendMessages;
    private boolean canSendMediaMessages;
    private boolean canSendPolls;
    private boolean canSendOtherMessages;
    private boolean canAddWebPagePreviews;
    private boolean canChangeInfo;
    private boolean canInviteUsers;
    private boolean canPinMessages;


    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }


    public boolean isCanSendMessages() {
        return canSendMessages;
    }

    public void setCanSendMessages(boolean canSendMessages) {
        this.canSendMessages = canSendMessages;
    }

    public boolean isCanSendMediaMessages() {
        return canSendMediaMessages;
    }

    public void setCanSendMediaMessages(boolean canSendMediaMessages) {
        this.canSendMediaMessages = canSendMediaMessages;
    }

    public boolean isCanSendPolls() {
        return canSendPolls;
    }

    public void setCanSendPolls(boolean canSendPolls) {
        this.canSendPolls = canSendPolls;
    }

    public boolean isCanSendOtherMessages() {
        return canSendOtherMessages;
    }

    public void setCanSendOtherMessages(boolean canSendOtherMessages) {
        this.canSendOtherMessages = canSendOtherMessages;
    }

    public boolean isCanAddWebPagePreviews() {
        return canAddWebPagePreviews;
    }

    public void setCanAddWebPagePreviews(boolean canAddWebPagePreviews) {
        this.canAddWebPagePreviews = canAddWebPagePreviews;
    }

    public boolean isCanChangeInfo() {
        return canChangeInfo;
    }

    public void setCanChangeInfo(boolean canChangeInfo) {
        this.canChangeInfo = canChangeInfo;
    }

    public boolean isCanInviteUsers() {
        return canInviteUsers;
    }

    public void setCanInviteUsers(boolean canInviteUsers) {
        this.canInviteUsers = canInviteUsers;
    }

    public boolean isCanPinMessages() {
        return canPinMessages;
    }

    public void setCanPinMessages(boolean canPinMessages) {
        this.canPinMessages = canPinMessages;
    }

}
