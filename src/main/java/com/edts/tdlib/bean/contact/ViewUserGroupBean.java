package com.edts.tdlib.bean.contact;

import java.util.List;

public class ViewUserGroupBean {

    private long id;
    private String name;
    private int countMember;

    List<MemberUseGroupBean> memberGroupBeanList;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountMember() {
        return countMember;
    }

    public void setCountMember(int countMember) {
        this.countMember = countMember;
    }

    public List<MemberUseGroupBean> getMemberGroupBeanList() {
        return memberGroupBeanList;
    }

    public void setMemberGroupBeanList(List<MemberUseGroupBean> memberGroupBeanList) {
        this.memberGroupBeanList = memberGroupBeanList;
    }
}
