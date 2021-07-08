package com.edts.tdlib.bean;

public class TelegramMessageBean {

    private long chatId;
    private String message;
    private String fileURL;
    private String localPath;
    private String keyName;

    public TelegramMessageBean() {
    }

    public TelegramMessageBean(long chatId, String message, String keyName) {
        this.chatId = chatId;
        this.message = message;
        this.keyName = keyName;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }


}
