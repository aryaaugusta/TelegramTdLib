package com.edts.tdlib.bean.uam;

import java.io.Serializable;

public class RefreshTokenRequest implements Serializable {
    private String refresh_token;

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
