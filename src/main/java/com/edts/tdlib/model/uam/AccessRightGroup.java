package com.edts.tdlib.model.uam;


import com.edts.tdlib.base.BaseEntity;

import javax.persistence.Entity;

@Entity
public class AccessRightGroup extends BaseEntity {
    private String name;
    private String code;
    private String icon;
    private boolean enabled;
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int order) {
        this.position = order;
    }

    //    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accessRightGroup")
//    private Set<AccessRightType> accessRightTypes;


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    public Set<AccessRightType> getAccessRightTypes() {
//        return accessRightTypes;
//    }
//
//    public void setAccessRightTypes(Set<AccessRightType> accessRightTypes) {
//        this.accessRightTypes = accessRightTypes;
//    }
}
