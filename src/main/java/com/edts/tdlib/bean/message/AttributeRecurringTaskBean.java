package com.edts.tdlib.bean.message;

import java.util.Date;

public class AttributeRecurringTaskBean {

    private long attributeTaskId;
    private Date dateExecute;
    private String timeExecute;
    private String status;
    private long messageTaskId;
    private String content;
    private Integer batch;
    private long idRefReceiver;
    private String receiverType;

    public AttributeRecurringTaskBean() {
    }


    public AttributeRecurringTaskBean(long attributeTaskId, Date dateExecute, String timeExecute, String status, long messageTaskId, String content, Integer batch, long idRefReceiver, String receiverType) {
        this.attributeTaskId = attributeTaskId;
        this.dateExecute = dateExecute;
        this.timeExecute = timeExecute;
        this.status = status;
        this.messageTaskId = messageTaskId;
        this.content = content;
        this.batch = batch;
        this.idRefReceiver = idRefReceiver;
        this.receiverType = receiverType;
    }

    public long getAttributeTaskId() {
        return attributeTaskId;
    }

    public void setAttributeTaskId(long attributeTaskId) {
        this.attributeTaskId = attributeTaskId;
    }

    public Date getDateExecute() {
        return dateExecute;
    }

    public void setDateExecute(Date dateExecute) {
        this.dateExecute = dateExecute;
    }

    public String getTimeExecute() {
        return timeExecute;
    }

    public void setTimeExecute(String timeExecute) {
        this.timeExecute = timeExecute;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getMessageTaskId() {
        return messageTaskId;
    }

    public void setMessageTaskId(long messageTaskId) {
        this.messageTaskId = messageTaskId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public long getIdRefReceiver() {
        return idRefReceiver;
    }

    public void setIdRefReceiver(long idRefReceiver) {
        this.idRefReceiver = idRefReceiver;
    }

    public String getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }
}
