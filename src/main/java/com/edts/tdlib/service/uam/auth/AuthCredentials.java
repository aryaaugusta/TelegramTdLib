package com.edts.tdlib.service.uam.auth;

import java.io.Serializable;

public class AuthCredentials implements Serializable {
    private String type;
    private String value;
    private boolean temporary;

    public AuthCredentials(String type, String value, boolean temporary) {
        this.type = type;
        this.value = value;
        this.temporary = temporary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isTemporary() {
        return temporary;
    }

    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
    }

    @Override
    public String toString() {
        return "AuthCredentials{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", temporary=" + temporary +
                '}';
    }
}
