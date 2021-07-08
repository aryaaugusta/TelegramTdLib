package com.edts.tdlib.bean.contact;

import java.util.List;

public class ViewAttributeBean extends AttributeBean {

    List<ViewAttributeMemberBean> memberBeanList;

    public List<ViewAttributeMemberBean> getMemberBeanList() {
        return memberBeanList;
    }

    public void setMemberBeanList(List<ViewAttributeMemberBean> memberBeanList) {
        this.memberBeanList = memberBeanList;
    }
}
