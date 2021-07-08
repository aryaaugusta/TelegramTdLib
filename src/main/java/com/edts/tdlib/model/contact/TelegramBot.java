package com.edts.tdlib.model.contact;

import com.edts.tdlib.base.BaseEntity;

import javax.persistence.Entity;

@Entity
public class TelegramBot extends BaseEntity {

    private int idBot;
    private String username;
    private String name;
    private boolean deleted;


    public int getIdBot() {
        return idBot;
    }

    public void setIdBot(int idBot) {
        this.idBot = idBot;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
