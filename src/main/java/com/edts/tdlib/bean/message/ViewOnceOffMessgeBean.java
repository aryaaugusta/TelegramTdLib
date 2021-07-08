package com.edts.tdlib.bean.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ViewOnceOffMessgeBean extends ViewMessageTaskBean {

    @Temporal(TemporalType.TIME)
    private Date onceOffTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "UTC")
    private Date onceOffDate;


    public Date getOnceOffTime() {
        return onceOffTime;
    }

    public void setOnceOffTime(Date onceOffTime) {
        this.onceOffTime = onceOffTime;
    }

    public Date getOnceOffDate() {
        return onceOffDate;
    }

    public void setOnceOffDate(Date onceOffDate) {
        this.onceOffDate = onceOffDate;
    }
}
