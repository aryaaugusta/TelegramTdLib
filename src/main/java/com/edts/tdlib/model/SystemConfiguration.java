package com.edts.tdlib.model;

import com.edts.tdlib.base.BaseEntity;

import javax.persistence.Entity;

@Entity
public class SystemConfiguration extends BaseEntity {

    private String groupKey;
    private String keyParam;
    private String valueParam;


    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getKeyParam() {
        return keyParam;
    }

    public void setKeyParam(String keyParam) {
        this.keyParam = keyParam;
    }

    public String getValueParam() {
        return valueParam;
    }

    public void setValueParam(String valueParam) {
        this.valueParam = valueParam;
    }
}
