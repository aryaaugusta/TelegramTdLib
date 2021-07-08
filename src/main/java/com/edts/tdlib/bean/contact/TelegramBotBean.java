package com.edts.tdlib.bean.contact;

public class TelegramBotBean {

    private long id;
    private int userTelegramId;
    private String username = "";
    private String firstName = "";
    private String lastName = "";


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserTelegramId() {
        return userTelegramId;
    }

    public void setUserTelegramId(int userTelegramId) {
        this.userTelegramId = userTelegramId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
