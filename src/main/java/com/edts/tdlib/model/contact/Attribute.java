package com.edts.tdlib.model.contact;

import com.edts.tdlib.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Attribute extends BaseEntity {


    private String name;
    private String dataType;
    private int userCount;
    private boolean deleted;

    @OneToMany(mappedBy = "attribute", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<MemberAttribute> memberAttributeList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }


    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<MemberAttribute> getMemberAttributeList() {
        return memberAttributeList;
    }

    public void setMemberAttributeList(List<MemberAttribute> memberAttributeList) {
        this.memberAttributeList = memberAttributeList;
    }
}
