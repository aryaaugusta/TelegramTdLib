package com.edts.tdlib.bean.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ViewImmediateMessageBean extends ViewMessageTaskBean {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "UTC")
    private Date sendDate;

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}
