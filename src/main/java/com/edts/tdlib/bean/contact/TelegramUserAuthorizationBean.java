package com.edts.tdlib.bean.contact;

import com.edts.tdlib.bean.CommandGroupBean;

import java.util.Date;
import java.util.List;

public class TelegramUserAuthorizationBean extends TelegramUserBean {

    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;

    private List<TelegramUserGroupBean> telegramUserGroupsBean;
    private List<CommandGroupBean> commandGroupsBean;


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<TelegramUserGroupBean> getTelegramUserGroupsBean() {
        return telegramUserGroupsBean;
    }

    public void setTelegramUserGroupsBean(List<TelegramUserGroupBean> telegramUserGroupsBean) {
        this.telegramUserGroupsBean = telegramUserGroupsBean;
    }

    public List<CommandGroupBean> getCommandGroupsBean() {
        return commandGroupsBean;
    }

    public void setCommandGroupsBean(List<CommandGroupBean> commandGroupsBean) {
        this.commandGroupsBean = commandGroupsBean;
    }
}
