package com.edts.tdlib.bean.contact;

public class ChatRoomMemberBean {

    private long id;
    private String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String userType;
    private String username;
    private boolean restrictedStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isRestrictedStatus() {
        return restrictedStatus;
    }

    public void setRestrictedStatus(boolean restrictedStatus) {
        this.restrictedStatus = restrictedStatus;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
