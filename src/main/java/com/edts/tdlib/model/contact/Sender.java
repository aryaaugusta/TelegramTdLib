package com.edts.tdlib.model.contact;

import com.edts.tdlib.base.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Sender extends BaseEntity {

    private String chatId;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }
}
