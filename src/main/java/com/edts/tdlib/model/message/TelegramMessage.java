package com.edts.tdlib.model.message;

import com.edts.tdlib.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedNativeQuery(name = "recipientList",
query = "select tm.chat_id , case when tu.first_name is null then cr.name else concat(tu.first_name, tu.last_name) end as name," +
        " case when tm.message_delivered = 0 and tm.message_read = 0 then 'Sent' when tm.message_delivered = 1 and tm.message_read = 0 then 'Delivered' when tm.message_read = 1 and tm.message_read = 1 then 'Read' else 'N/a' end as status" +
        " from telegram_message tm left join telegram_user tu on tm.chat_id = tu.chat_id" +
        " left join chat_room cr on tm.chat_id = cr.chat_id where tm.message_task_id = :messageTaskId and batch = :batch and tm.message_id_success > 0", resultSetMapping = "recipient_list")
@SqlResultSetMapping(name = "recipient_list",
        classes = @ConstructorResult(
                targetClass = com.edts.tdlib.bean.MessageReportReceiverBean.class,
                columns = {
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "status", type = String.class)
                }
        ))
public class TelegramMessage extends BaseEntity {

    long messageId;
    long messageIdSuccess;
    long chatId;
    long senderUserId;
    String content;

    boolean messageRead;
    boolean messageDelivered;
    long messageTaskId;

    int batch;


    /***/
    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getMessageIdSuccess() {
        return messageIdSuccess;
    }

    public void setMessageIdSuccess(long messageIdSuccess) {
        this.messageIdSuccess = messageIdSuccess;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public long getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(long senderUserId) {
        this.senderUserId = senderUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isMessageRead() {
        return messageRead;
    }

    public void setMessageRead(boolean messageRead) {
        this.messageRead = messageRead;
    }

    public boolean isMessageDelivered() {
        return messageDelivered;
    }

    public void setMessageDelivered(boolean messageDelivered) {
        this.messageDelivered = messageDelivered;
    }

    public long getMessageTaskId() {
        return messageTaskId;
    }

    public void setMessageTaskId(long messageTaskId) {
        this.messageTaskId = messageTaskId;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }
}
