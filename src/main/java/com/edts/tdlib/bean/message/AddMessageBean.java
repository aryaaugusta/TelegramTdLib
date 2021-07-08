package com.edts.tdlib.bean.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public class AddMessageBean {

    private MessageTypeBean messageTypeBean;
    private String subject;
    private String content;
    private MessageFileBean messageFileBean;
    private List<MessageReceiverBean> users;
    private List<MessageReceiverBean> userGroup;
    private List<MessageReceiverBean> chatRoom;
    private List<MessageReceiverBean> chatRoomGroup;


    private String recurringType;
    private String recurringExecute;
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private Date recurringTimeExecute;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private Date recurringStartDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private Date recurringEndDate;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private Date onceOffTime;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private Date onceOffDate;

    private int status;

    private String createdBy;


    public MessageTypeBean getMessageTypeBean() {
        return messageTypeBean;
    }

    public void setMessageTypeBean(MessageTypeBean messageTypeBean) {
        this.messageTypeBean = messageTypeBean;
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

    public List<MessageReceiverBean> getUsers() {
        return users;
    }

    public void setUsers(List<MessageReceiverBean> users) {
        this.users = users;
    }

    public List<MessageReceiverBean> getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(List<MessageReceiverBean> userGroup) {
        this.userGroup = userGroup;
    }

    public List<MessageReceiverBean> getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(List<MessageReceiverBean> chatRoom) {
        this.chatRoom = chatRoom;
    }

    public List<MessageReceiverBean> getChatRoomGroup() {
        return chatRoomGroup;
    }

    public void setChatRoomGroup(List<MessageReceiverBean> chatRoomGroup) {
        this.chatRoomGroup = chatRoomGroup;
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

    public MessageFileBean getMessageFileBean() {
        return messageFileBean;
    }

    public void setMessageFileBean(MessageFileBean messageFileBean) {
        this.messageFileBean = messageFileBean;
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


}
