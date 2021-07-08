package com.edts.tdlib.bean;

public class StatisticDataBean {

    private int sendCount;
    private int deliverCount;
    private int readCount;

    private int notDeliverCount;
    private int notReadCount;


    private double sendCountPercentage;
    private double deliverCountPercentage;
    private double readCountPercentage;
    private double engagementRatePercentage;

    private double notDeliverPercentage;
    private double notReadPercentage;


    public StatisticDataBean() {
    }


    public StatisticDataBean(int sendCount, int deliverCount, int readCount, int notDeliverCount, int notReadCount, double notDeliverPercentage, double notReadPercentage,
                             double sendCountPercentage, double deliverCountPercentage, double readCountPercentage, double engagementRatePercentage) {
        this.sendCount = sendCount;
        this.deliverCount = deliverCount;
        this.readCount = readCount;
        this.sendCountPercentage = sendCountPercentage;
        this.deliverCountPercentage = deliverCountPercentage;
        this.readCountPercentage = readCountPercentage;
        this.engagementRatePercentage = engagementRatePercentage;
        this.notDeliverCount = notDeliverCount;
        this.notReadCount = notReadCount;
        this.notDeliverPercentage = notDeliverPercentage;
        this.notReadPercentage = notReadPercentage;
    }


    public int getSendCount() {
        return sendCount;
    }

    public void setSendCount(int sendCount) {
        this.sendCount = sendCount;
    }

    public int getDeliverCount() {
        return deliverCount;
    }

    public void setDeliverCount(int deliverCount) {
        this.deliverCount = deliverCount;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getNotDeliverCount() {
        return notDeliverCount;
    }

    public void setNotDeliverCount(int notDeliverCount) {
        this.notDeliverCount = notDeliverCount;
    }

    public int getNotReadCount() {
        return notReadCount;
    }

    public void setNotReadCount(int notReadCount) {
        this.notReadCount = notReadCount;
    }

    public double getSendCountPercentage() {
        return sendCountPercentage;
    }

    public void setSendCountPercentage(double sendCountPercentage) {
        this.sendCountPercentage = sendCountPercentage;
    }

    public double getDeliverCountPercentage() {
        return deliverCountPercentage;
    }

    public void setDeliverCountPercentage(double deliverCountPercentage) {
        this.deliverCountPercentage = deliverCountPercentage;
    }

    public double getReadCountPercentage() {
        return readCountPercentage;
    }

    public void setReadCountPercentage(double readCountPercentage) {
        this.readCountPercentage = readCountPercentage;
    }

    public double getEngagementRatePercentage() {
        return engagementRatePercentage;
    }

    public void setEngagementRatePercentage(double engagementRatePercentage) {
        this.engagementRatePercentage = engagementRatePercentage;
    }

    public double getNotDeliverPercentage() {
        return notDeliverPercentage;
    }

    public void setNotDeliverPercentage(double notDeliverPercentage) {
        this.notDeliverPercentage = notDeliverPercentage;
    }

    public double getNotReadPercentage() {
        return notReadPercentage;
    }

    public void setNotReadPercentage(double notReadPercentage) {
        this.notReadPercentage = notReadPercentage;
    }
}
