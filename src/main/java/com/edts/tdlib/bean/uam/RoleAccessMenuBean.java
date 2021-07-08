package com.edts.tdlib.bean.uam;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleAccessMenuBean {

    @JsonProperty("create")
    private boolean canCreate;
    @JsonProperty("read")
    private boolean canRead;
    @JsonProperty("update")
    private boolean canUpdate;
    @JsonProperty("delete")
    private boolean canDelete;

    public RoleAccessMenuBean(boolean canCreate, boolean canRead, boolean canUpdate, boolean canDelete) {
        this.canCreate = canCreate;
        this.canRead = canRead;
        this.canUpdate = canUpdate;
        this.canDelete = canDelete;
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

    public void setCanRead(boolean canRead) {
        this.canRead = canRead;
    }

    public boolean isCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(boolean canUpdate) {
        this.canUpdate = canUpdate;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }
}
