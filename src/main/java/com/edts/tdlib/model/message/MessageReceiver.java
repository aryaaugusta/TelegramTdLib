package com.edts.tdlib.model.message;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MessageReceiver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CreatedDate
    private Date createdDate = new Date();
    private long idReferenceReceiver;
    private String nameReceiver;
    private String type;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "message_task_id")
    private MessageTask messageTaskReceiver;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public long getIdReferenceReceiver() {
        return idReferenceReceiver;
    }

    public void setIdReferenceReceiver(long idReferenceReceiver) {
        this.idReferenceReceiver = idReferenceReceiver;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }

    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MessageTask getMessageTaskReceiver() {
        return messageTaskReceiver;
    }

    public void setMessageTaskReceiver(MessageTask messageTaskReceiver) {
        this.messageTaskReceiver = messageTaskReceiver;
    }
}
