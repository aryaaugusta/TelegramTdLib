package com.edts.tdlib.bean.uam;

import com.edts.tdlib.model.uam.AccessRight;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class Menu implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    private long id;
    private String code;
    private String label;
    private boolean enabled;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String url = "";
    private AccessRight accessRights;
    private int order;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AccessRight getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(AccessRight accessRights) {
        this.accessRights = accessRights;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


}
