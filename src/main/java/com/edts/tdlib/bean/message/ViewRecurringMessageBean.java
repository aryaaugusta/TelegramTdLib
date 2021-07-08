package com.edts.tdlib.bean.message;

import com.edts.tdlib.bean.contact.AttributeBean;
import com.edts.tdlib.model.contact.Attribute;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ViewRecurringMessageBean extends ViewMessageTaskBean {

    private String recurringType;
    private String recurringExecute;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "UTC")
    private Date recurringTimeExecute;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "UTC")
    private Date recurringStartDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "UTC")
    private Date recurringEndDate;

    private AttributeBean attribute;


    public String getRecurringType() {
        return recurringType;
    }

    public void setRecurringType(String recurringType) {
        this.recurringType = recurringType;
    }

    public String getRecurringExecute() {
        return recurringExecute;
    }

    public void setRecurringExecute(String recurringExecute) {
        this.recurringExecute = recurringExecute;
    }

    public Date getRecurringTimeExecute() {
        return recurringTimeExecute;
    }

    public void setRecurringTimeExecute(Date recurringTimeExecute) {
        this.recurringTimeExecute = recurringTimeExecute;
    }

    public Date getRecurringStartDate() {
        return recurringStartDate;
    }

    public void setRecurringStartDate(Date recurringStartDate) {
        this.recurringStartDate = recurringStartDate;
    }

    public Date getRecurringEndDate() {
        return recurringEndDate;
    }

    public void setRecurringEndDate(Date recurringEndDate) {
        this.recurringEndDate = recurringEndDate;
    }

    public AttributeBean getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributeBean attribute) {
        this.attribute = attribute;
    }
}
