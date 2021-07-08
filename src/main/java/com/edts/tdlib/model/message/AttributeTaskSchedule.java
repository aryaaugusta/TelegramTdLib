package com.edts.tdlib.model.message;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedNativeQuery(name = "findAttributeTask",
        query = " select ats.id as attributeTaskId, ats.date_execute as dateExecute, ats.time_execute as timeExecute, ats.status, ats.message_task_id as messageTaskId " +
                " ,mt.content, ats.batch , ats.id_ref_receiver as idRefReceiver, ats.receiver_type as receiverType  from attribute_task_schedule ats inner join message_task mt on ats.message_task_id = mt.id " +
                " where ats.date_execute <= :executeDate and ats.status = 'QUEUE' and mt.status = 1", resultSetMapping = "scheduler_attribute_recurring")
@SqlResultSetMapping(name = "scheduler_attribute_recurring",
        classes = @ConstructorResult(
                targetClass = com.edts.tdlib.bean.message.AttributeRecurringTaskBean.class,
                columns = {
                        @ColumnResult(name = "attributeTaskId", type = Long.class),
                        @ColumnResult(name = "dateExecute", type = Date.class),
                        @ColumnResult(name = "timeExecute", type = String.class),
                        @ColumnResult(name = "status", type = String.class),
                        @ColumnResult(name = "messageTaskId", type = Long.class),
                        @ColumnResult(name = "content", type = String.class),
                        @ColumnResult(name = "batch", type = Integer.class),
                        @ColumnResult(name = "idRefReceiver", type = Long.class),
                        @ColumnResult(name = "receiverType", type = String.class)
                }
        ))
public class AttributeTaskSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long messageTaskId;
    private Long idRefReceiver;
    private String receiverType;


    @Temporal(TemporalType.TIME)
    private Date timeExecute;

    @Temporal(TemporalType.DATE)
    private Date dateExecute;

    private String status;

    private int batch;


    private Date realStartExecuteDate;
    private Date realEndExecuteDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getMessageTaskId() {
        return messageTaskId;
    }

    public void setMessageTaskId(Long messageTaskId) {
        this.messageTaskId = messageTaskId;
    }

    public Long getIdRefReceiver() {
        return idRefReceiver;
    }

    public void setIdRefReceiver(Long idRefReceiver) {
        this.idRefReceiver = idRefReceiver;
    }

    public String getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }

    public Date getTimeExecute() {
        return timeExecute;
    }

    public void setTimeExecute(Date timeExecute) {
        this.timeExecute = timeExecute;
    }

    public Date getDateExecute() {
        return dateExecute;
    }

    public void setDateExecute(Date dateExecute) {
        this.dateExecute = dateExecute;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public Date getRealStartExecuteDate() {
        return realStartExecuteDate;
    }

    public void setRealStartExecuteDate(Date realStartExecuteDate) {
        this.realStartExecuteDate = realStartExecuteDate;
    }

    public Date getRealEndExecuteDate() {
        return realEndExecuteDate;
    }

    public void setRealEndExecuteDate(Date realEndExecuteDate) {
        this.realEndExecuteDate = realEndExecuteDate;
    }
}
