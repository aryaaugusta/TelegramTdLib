package com.edts.tdlib.bean.contact;

import java.util.List;

public class AddUpdateAttributeBean extends AttributeBean {

    List<MemberAttributeBean> memberAttributeBeans;

    long removeMember[];

    public List<MemberAttributeBean> getMemberAttributeBeans() {
        return memberAttributeBeans;
    }

    public void setMemberAttributeBeans(List<MemberAttributeBean> memberAttributeBeans) {
        this.memberAttributeBeans = memberAttributeBeans;
    }

    public long[] getRemoveMember() {
        return removeMember;
    }

    public void setRemoveMember(long[] removeMember) {
        this.removeMember = removeMember;
    }
}
