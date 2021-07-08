package com.edts.tdlib.bean.contact;

public class MemberAttributeBean {

    private String attributeValue;

    private long idRefContact;

    private String contactType;


    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
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
}
