package com.edts.tdlib.model.message;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedNativeQuery(name = "findSchedulerTask",
        query = "select mts.id as schedulerTaskId, mts.date_execute as dateExecute, mts.time_execute as timeExecute, mts.status, mts.message_task_id as messageTaskId, mt.content, mts.batch from message_task_schedule mts inner join message_task mt on mt.id = mts.message_task_id where mt.recurring_type = :recurringType  and mts.date_execute <= :executeDate " +
                " and mts.status = 'QUEUE' and mt.status = 1", resultSetMapping = "scheduler_task_recurring")
@SqlResultSetMapping(name = "scheduler_task_recurring",
        classes = @ConstructorResult(
                targetClass = com.edts.tdlib.bean.message.MessageRecurringTaskBean.class,
                columns = {
                        @ColumnResult(name = "schedulerTaskId", type = Long.class),
                        @ColumnResult(name = "dateExecute", type = Date.class),
                        @ColumnResult(name = "timeExecute", type = String.class),
                        @ColumnResult(name = "status", type = String.class),
                        @ColumnResult(name = "messageTaskId", type = Long.class),
                        @ColumnResult(name = "content", type = String.class),
                        @ColumnResult(name = "batch", type = Integer.class)

                }
        ))
public class MessageTaskSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn
    private MessageTask messageTask;


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

    public MessageTask getMessageTask() {
        return messageTask;
    }

    public void setMessageTask(MessageTask messageTask) {
        this.messageTask = messageTask;
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
