package com.edts.tdlib.service.uam.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties
public class AuthResponseBean implements Serializable {
    @Override
    public String toString() {
        return "AuthResponseBean{" +
                "access_token='" + access_token + '\'' +
                '}';
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    private String access_token;


}
