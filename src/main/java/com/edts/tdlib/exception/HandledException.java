package com.edts.tdlib.exception;

public class HandledException extends RuntimeException {

    private String code;

    public HandledException(String message) {
        super(message);
    }

    public HandledException(String code, String message) {
        super(message);
        this.setCode(code);
    }

    public HandledException(String code, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
