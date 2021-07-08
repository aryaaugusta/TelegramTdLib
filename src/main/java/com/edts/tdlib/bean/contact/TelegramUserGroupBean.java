package com.edts.tdlib.bean.contact;

import java.util.List;

public class TelegramUserGroupBean {

    private long id;
    private String groupName;
    private String filePath;
    private boolean enable;
    private int countMember;

    List<MemberUseGroupBean> memberUseGroupBeans;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getCountMember() {
        return countMember;
    }

    public void setCountMember(int countMember) {
        this.countMember = countMember;
    }

    public List<MemberUseGroupBean> getMemberUseGroupBeans() {
        return memberUseGroupBeans;
    }

    public void setMemberUseGroupBeans(List<MemberUseGroupBean> memberUseGroupBeans) {
        this.memberUseGroupBeans = memberUseGroupBeans;
    }
}
