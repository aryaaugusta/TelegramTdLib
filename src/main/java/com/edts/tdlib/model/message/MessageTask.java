package com.edts.tdlib.model.message;

import com.edts.tdlib.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class MessageTask extends BaseEntity {

    @OneToOne
    @JoinColumn
    private MessageType messageType;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private MessageFile messageFile;
    private String subject;
    private String content;

    private String recurringType;
    private String recurringExecute;
    @Temporal(TemporalType.TIME)
    private Date recurringTimeExecute;

    @Temporal(TemporalType.DATE)
    private Date recurringStartDate;
    @Temporal(TemporalType.DATE)
    private Date recurringEndDate;

    @Temporal(TemporalType.TIME)
    private Date onceOffTime;
    @Temporal(TemporalType.DATE)
    private Date onceOffDate;


    private boolean deleted = false;

    @OneToMany(mappedBy = "messageTaskReceiver", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MessageReceiver> receiverList;

    @OneToMany(mappedBy = "messageTaskAttr", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MessageAttributes> attributesList;


    private int status;

    private String createdBy;
    private String modifiedBy;

    /**
     * ===========
     */
    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageFile getMessageFile() {
        return messageFile;
    }

    public void setMessageFile(MessageFile messageFile) {
        this.messageFile = messageFile;
    }

    public String getRecurringType() {
        return recurringType;
    }

    public void setRecurringType(String recurringType) {
        this.recurringType = recurringType;
    }

    public String getRecurringExecute() {
        return recurringExecute;
    }

    public void setRecurringExecute(String recurringExecute) {
        this.recurringExecute = recurringExecute;
    }

    public Date getRecurringTimeExecute() {
        return recurringTimeExecute;
    }

    public void setRecurringTimeExecute(Date recurringTimeExecute) {
        this.recurringTimeExecute = recurringTimeExecute;
    }

    public Date getRecurringStartDate() {
        return recurringStartDate;
    }

    public void setRecurringStartDate(Date recurringStartDate) {
        this.recurringStartDate = recurringStartDate;
    }

    public Date getRecurringEndDate() {
        return recurringEndDate;
    }

    public void setRecurringEndDate(Date recurringEndDate) {
        this.recurringEndDate = recurringEndDate;
    }

    public Date getOnceOffTime() {
        return onceOffTime;
    }

    public void setOnceOffTime(Date onceOffTime) {
        this.onceOffTime = onceOffTime;
    }

    public Date getOnceOffDate() {
        return onceOffDate;
    }

    public void setOnceOffDate(Date onceOffDate) {
        this.onceOffDate = onceOffDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<MessageReceiver> getReceiverList() {
        return receiverList;
    }

    public void setReceiverList(List<MessageReceiver> receiverList) {
        this.receiverList = receiverList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public List<MessageAttributes> getAttributesList() {
        return attributesList;
    }

    public void setAttributesList(List<MessageAttributes> attributesList) {
        this.attributesList = attributesList;
    }
}
