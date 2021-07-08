package com.edts.tdlib.bean.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public class ViewMessageTaskBean {

    private long id;

    private String subject;
    private String content;
    private int status;


    private List<MessageReceiverBean> users;
    private List<MessageReceiverBean> userGroup;
    private List<MessageReceiverBean> chatRoom;
    private List<MessageReceiverBean> chatRoomGroup;


    private MessageTypeBean messageTypeBean;
    private MessageFileBean messageFileBean;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "UTC")
    private Date createdDated;
    private String createdBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "UTC")
    private Date modifiedDate;
    private String modifiedBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public MessageTypeBean getMessageTypeBean() {
        return messageTypeBean;
    }

    public void setMessageTypeBean(MessageTypeBean messageTypeBean) {
        this.messageTypeBean = messageTypeBean;
    }

    public MessageFileBean getMessageFileBean() {
        return messageFileBean;
    }

    public void setMessageFileBean(MessageFileBean messageFileBean) {
        this.messageFileBean = messageFileBean;
    }

    public Date getCreatedDated() {
        return createdDated;
    }

    public void setCreatedDated(Date createdDated) {
        this.createdDated = createdDated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
