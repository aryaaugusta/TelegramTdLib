package com.edts.tdlib.bean.message;

public class TransferMessageBean {

    private long messageTaskId;
    private int batch;


    public TransferMessageBean(long messageTaskId, int batch) {
        this.messageTaskId = messageTaskId;
        this.batch = batch;
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
