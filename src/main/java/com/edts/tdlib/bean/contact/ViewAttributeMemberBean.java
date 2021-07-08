package com.edts.tdlib.bean.contact;

public class ViewAttributeMemberBean {

    private long id;
    private long idRefContact;
    private String contactType;
    private String name;
    private String attributeValue;
    private long contactId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdRefContact() {
        return idRefContact;
    }

    public void setIdRefContact(long idRefContact) {
        this.idRefContact = idRefContact;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }
}
