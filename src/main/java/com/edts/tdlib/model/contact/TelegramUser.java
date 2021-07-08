package com.edts.tdlib.model.contact;


import com.edts.tdlib.base.BaseEntity;

import javax.persistence.Entity;

@Entity
public class TelegramUser extends BaseEntity {

    private int userTelegramId;
    private String chatId;
    private String firstName;
    private String lastName;
    private String username;
    private String phoneNumber;
    private int status = 1;
    private boolean deleted = false;
    private int groupJoined;


    private String createdBy;
    private String modifiedBy;

    private String userType;

    public TelegramUser() {
    }

    public TelegramUser(int userTelegramId) {
        this.userTelegramId = userTelegramId;
    }


    public TelegramUser(int userTelegramId, String chatId, String firstName, String lastName, String username, String phoneNumber, String createdBy, String modifiedBy, String userType) {
        this.userTelegramId = userTelegramId;
        this.chatId = chatId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.userType = userType;
    }


    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getGroupJoined() {
        return groupJoined;
    }

    public void setGroupJoined(int groupJoined) {
        this.groupJoined = groupJoined;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public int getUserTelegramId() {
        return userTelegramId;
    }

    public void setUserTelegramId(int userTelegramId) {
        this.userTelegramId = userTelegramId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
