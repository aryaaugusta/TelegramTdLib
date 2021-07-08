package com.edts.tdlib.model;

import com.edts.tdlib.base.BaseEntity;

import javax.persistence.Entity;

@Entity
public class TelegramAccount extends BaseEntity {

    private String phoneNumber;
    private boolean enable;
    private String databaseDirectory;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getDatabaseDirectory() {
        return databaseDirectory;
    }

    public void setDatabaseDirectory(String databaseDirectory) {
        this.databaseDirectory = databaseDirectory;
    }
}
