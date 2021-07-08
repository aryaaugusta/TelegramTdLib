package com.edts.tdlib.bean;

public class LoggerBean {
    private String projectName;
    private String errorClass;
    private String errorMessage;
    private String stackTraces;
    private String topic;
    private String topicMessage;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getErrorClass() {
        return errorClass;
    }

    public void setErrorClass(String errorClass) {
        this.errorClass = errorClass;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStackTraces() {
        return stackTraces;
    }

    public void setStackTraces(String stackTraces) {
        this.stackTraces = stackTraces;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopicMessage() {
        return topicMessage;
    }

    public void setTopicMessage(String topicMessage) {
        this.topicMessage = topicMessage;
    }

    @Override
    public String toString() {
        return "LoggerBean{" +
                "projectName='" + projectName + '\'' +
                ", errorClass='" + errorClass + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", stackTraces='" + stackTraces + '\'' +
                ", topic='" + topic + '\'' +
                ", topicMessage='" + topicMessage + '\'' +
                '}';
    }
}
