package com.edts.tdlib.bean.contact;

import com.edts.tdlib.bean.CommandGroupBean;

import java.util.List;

public class EditTelegramUserBean extends TelegramUserAuthorizationBean {

    private List<TelegramUserGroupBean> removeUserGroupBeans;
    private List<CommandGroupBean> removeCommandGroupsBean;

    public List<TelegramUserGroupBean> getRemoveUserGroupBeans() {
        return removeUserGroupBeans;
    }

    public void setRemoveUserGroupBeans(List<TelegramUserGroupBean> removeUserGroupBeans) {
        this.removeUserGroupBeans = removeUserGroupBeans;
    }

    public List<CommandGroupBean> getRemoveCommandGroupsBean() {
        return removeCommandGroupsBean;
    }

    public void setRemoveCommandGroupsBean(List<CommandGroupBean> removeCommandGroupsBean) {
        this.removeCommandGroupsBean = removeCommandGroupsBean;
    }
}
