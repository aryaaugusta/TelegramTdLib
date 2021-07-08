package com.edts.tdlib.bean.contact;

public class AddMemberUserGroupBean {

    private long id;
    private long idUsers[];

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long[] getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(long[] idUsers) {
        this.idUsers = idUsers;
    }
}
