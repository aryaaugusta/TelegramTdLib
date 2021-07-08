package com.edts.tdlib.bean.message;

import org.keycloak.common.util.Time;

import java.util.Date;


public class MessageRecurringTaskBean {

    private long schedulerTaskId;
    private Date dateExecute;
    private String timeExecute;
    private String status;
    private long messageTaskId;
    private String content;
    private Integer batch;


    public MessageRecurringTaskBean(long schedulerTaskId, Date dateExecute, String timeExecute, String status, long messageTaskId, String content, Integer batch) {
        this.schedulerTaskId = schedulerTaskId;
        this.dateExecute = dateExecute;
        this.timeExecute = timeExecute;
        this.status = status;
        this.messageTaskId = messageTaskId;
        this.content = content;
        this.batch = batch;
    }


    public long getSchedulerTaskId() {
        return schedulerTaskId;
    }

    public void setSchedulerTaskId(long schedulerTaskId) {
        this.schedulerTaskId = schedulerTaskId;
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
}
