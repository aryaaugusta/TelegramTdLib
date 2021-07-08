package com.edts.tdlib.bean.uam;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserListResponse implements Serializable {
    private List<RoleBean> roles = new ArrayList<>();
    private Page<UserBean> result;

    public UserListResponse(){

    }
    public UserListResponse(List<RoleBean> roles, Page<UserBean> users) {
        this.result=users;
        this.roles=roles;
    }

    public List<RoleBean> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleBean> roles) {
        this.roles = roles;
    }

    public Page<UserBean> getResult() {
        return result;
    }

    public void setResult(Page<UserBean> result) {
        this.result = result;
    }
}
