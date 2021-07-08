package com.edts.tdlib.model.contact;

import com.edts.tdlib.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class TelegramUserGroup extends BaseEntity {

    private String name;
    private String pathImage;
    private boolean enable = true;
    private int countMember;

    private boolean deleted;

    @OneToMany(mappedBy = "userGroup", cascade = CascadeType.ALL)
    private List<MemberTelegramUserGroup> teleUserGroupList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<MemberTelegramUserGroup> getTeleUserGroupList() {
        return teleUserGroupList;
    }

    public void setTeleUserGroupList(List<MemberTelegramUserGroup> teleUserGroupList) {
        this.teleUserGroupList = teleUserGroupList;
    }

    public int getCountMember() {
        return countMember;
    }

    public void setCountMember(int countMember) {
        this.countMember = countMember;
    }


    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
