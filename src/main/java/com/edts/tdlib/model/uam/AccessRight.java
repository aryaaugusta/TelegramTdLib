package com.edts.tdlib.model.uam;

import com.edts.tdlib.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class AccessRight extends BaseEntity {
    @JsonProperty("create")
    private boolean canCreate;
    @JsonProperty("read")
    private boolean canRead;
    @JsonProperty("update")
    private boolean canUpdate;
    @JsonProperty("delete")
    private boolean canDelete;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "access_right_type_id")
    @JsonIgnore
    private AccessRightType accessRightType = new AccessRightType();
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "role_id")
    @JsonIgnore
    private Role role;

    public AccessRightType getAccessRightType() {
        return accessRightType;
    }

    public void setAccessRightType(AccessRightType accessRightType) {
        this.accessRightType = accessRightType;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isCanCreate() {
        return canCreate;
    }

    public void setCanCreate(boolean canCreate) {
        this.canCreate = canCreate;
    }

    public boolean isCanRead() {
        return canRead;
    }

    public void setCanRead(boolean read) {
        this.canRead = read;
    }

    public boolean isCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(boolean update) {
        this.canUpdate = update;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean delete) {
        this.canDelete = delete;
    }

    @Override
    public String toString() {
        return "AccessRight{" +
                "canCreate=" + canCreate +
                ", canRead=" + canRead +
                ", canUpdate=" + canUpdate +
                ", canDelete=" + canDelete +
                ", accessRightType=" + accessRightType +
                '}';
    }
}
