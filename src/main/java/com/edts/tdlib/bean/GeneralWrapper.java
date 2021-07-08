package com.edts.tdlib.bean;

import com.edts.tdlib.util.CommonUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class GeneralWrapper<T> {
    private String status;
    private String message;
    private T data;
    private Date timestamp = new Date();
    private String signature;

    public GeneralWrapper<T> success() {
        this.status = "00";
        this.message = "Success";
        return this;
    }

    public GeneralWrapper<T> success(T t) {
        this.status = "00";
        this.message = "Success";
        if (CommonUtil.isArrayOrCollection(t)) {
            Map<String, Object> content = new HashMap<>();
            content.put("content", t);
            this.data = (T) content;
        } else {
            this.data = t;
        }
        return this;
    }

    public GeneralWrapper<T> success(T t, String signature) {
        this.status = "01";
        this.message = "Success";
        if (CommonUtil.isArrayOrCollection(t)) {
            Map<String, Object> content = new HashMap<>();
            content.put("content", t);
            this.data = (T) content;
        } else {
            this.data = t;
        }
        this.signature = signature;
        return this;
    }

    public GeneralWrapper<T> fail() {
        this.status = "02";
        this.message = "Fail";
        return this;
    }

    public GeneralWrapper<T> fail(Exception e) {
        this.status = "03";
        this.message = e.getMessage();
        return this;
    }

    public GeneralWrapper<T> fail(Exception e, String message) {
        this.status = "03";
        this.message = message;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "GeneralWrapper{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                ", signature='" + signature + '\'' +
                '}';
    }
}
