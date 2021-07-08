package com.edts.tdlib.model.uam;

import com.edts.tdlib.base.BaseEntity;

import javax.persistence.*;

@Entity
public class AccessRightType extends BaseEntity {
    @Column(unique = true)
    private String code;
    private String label;
    private String url;
    //    @OneToMany(
//            mappedBy = "accessRightType",
//            fetch = FetchType.LAZY
//    )
//    private Set<AccessRight> accessRightSet;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "access_right_group_id")
    private AccessRightGroup accessRightGroup;
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int order) {
        this.position = order;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public Set<AccessRight> getAccessRightSet() {
//        return accessRightSet;
//    }
//
//    public void setAccessRightSet(Set<AccessRight> accessRightSet) {
//        this.accessRightSet = accessRightSet;
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public AccessRightGroup getAccessRightGroup() {
        return accessRightGroup;
    }

    public void setAccessRightGroup(AccessRightGroup accessRightGroup) {
        this.accessRightGroup = accessRightGroup;
    }
}
