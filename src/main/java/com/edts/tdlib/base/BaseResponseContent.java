package com.edts.tdlib.base;

public class BaseResponseContent<T> {

    private T content;

    public BaseResponseContent(){

    }

    public BaseResponseContent(T content) {
        super();
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

}
