package com.edts.tdlib.bean.contact;

public class AttributeBean {

    private long id;
    private String name;
    private String dataType;
    private int userCount;

    public AttributeBean() {
    }

    public AttributeBean(String name, String dataType) {
        this.name = name;
        this.dataType = dataType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }
}
