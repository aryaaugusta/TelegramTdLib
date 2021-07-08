package com.edts.tdlib.model.message;

import com.edts.tdlib.base.BaseEntity;
import com.edts.tdlib.model.contact.Attribute;

import javax.persistence.*;

@Entity
public class MessageAttributes extends BaseEntity {

    @OneToOne
    @JoinColumn
    Attribute attribute;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "message_task_id")
    MessageTask messageTaskAttr;

    private int type;
    private String keyAttribute;


    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public MessageTask getMessageTaskAttr() {
        return messageTaskAttr;
    }

    public void setMessageTaskAttr(MessageTask messageTaskAttr) {
        this.messageTaskAttr = messageTaskAttr;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getKeyAttribute() {
        return keyAttribute;
    }

    public void setKeyAttribute(String keyAttribute) {
        this.keyAttribute = keyAttribute;
    }
}
