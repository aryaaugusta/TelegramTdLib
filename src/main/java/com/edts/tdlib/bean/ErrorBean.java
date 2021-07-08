package com.edts.tdlib.bean;

public class ErrorBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ErrorBean from(String message) {
        ErrorBean errorBean = new ErrorBean();
        errorBean.setMessage(message);
        return errorBean;
    }

    @Override
    public String toString() {
        return "ErrorBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
