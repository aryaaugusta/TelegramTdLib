package com.edts.tdlib.bean.contact;

import java.util.List;

public class HDTelegramUserGroupBean extends TelegramUserGroupBean {

    private List<TelegramUserMemberGroupBean> memberGroupBeanList;

    private long removeUser[];


    public List<TelegramUserMemberGroupBean> getMemberGroupBeanList() {
        return memberGroupBeanList;
    }

    public void setMemberGroupBeanList(List<TelegramUserMemberGroupBean> memberGroupBeanList) {
        this.memberGroupBeanList = memberGroupBeanList;
    }

    public long[] getRemoveUser() {
        return removeUser;
    }

    public void setRemoveUser(long[] removeUser) {
        this.removeUser = removeUser;
    }
}
