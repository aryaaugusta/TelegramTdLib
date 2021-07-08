package com.edts.tdlib.bean.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public class EditMessageBean {

    private long id;
    private MessageTypeBean messageTypeBean;
    private String subject;
    private String content;
    private MessageFileBean messageFileBean;

    private List<MessageReceiverBean> users;
    private List<MessageReceiverBean> userGroup;
    private List<MessageReceiverBean> chatRoom;
    private List<MessageReceiverBean> chatRoomGroup;

    private List<MessageReceiverBean> deleteUsers;
    private List<MessageReceiverBean> deleteUserGroup;
    private List<MessageReceiverBean> deleteChatRoom;
    private List<MessageReceiverBean> deleteChatRoomGroup;


    private String recurringType;
    private String recurringExecute;
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+07:00")
    private Date recurringTimeExecute;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT+07:00")
    private Date recurringStartDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT+07:00")
    private Date recurringEndDate;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+07:00")
    private Date onceOffTime;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT+07:00")
    private Date onceOffDate;

    private int status;

    private String modifiedBy;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public MessageFileBean getMessageFileBean() {
        return messageFileBean;
    }

    public void setMessageFileBean(MessageFileBean messageFileBean) {
        this.messageFileBean = messageFileBean;
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

    public List<MessageReceiverBean> getDeleteUsers() {
        return deleteUsers;
    }

    public void setDeleteUsers(List<MessageReceiverBean> deleteUsers) {
        this.deleteUsers = deleteUsers;
    }

    public List<MessageReceiverBean> getDeleteUserGroup() {
        return deleteUserGroup;
    }

    public void setDeleteUserGroup(List<MessageReceiverBean> deleteUserGroup) {
        this.deleteUserGroup = deleteUserGroup;
    }

    public List<MessageReceiverBean> getDeleteChatRoom() {
        return deleteChatRoom;
    }

    public void setDeleteChatRoom(List<MessageReceiverBean> deleteChatRoom) {
        this.deleteChatRoom = deleteChatRoom;
    }

    public List<MessageReceiverBean> getDeleteChatRoomGroup() {
        return deleteChatRoomGroup;
    }

    public void setDeleteChatRoomGroup(List<MessageReceiverBean> deleteChatRoomGroup) {
        this.deleteChatRoomGroup = deleteChatRoomGroup;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
