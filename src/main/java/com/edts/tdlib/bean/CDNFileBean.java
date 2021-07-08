package com.edts.tdlib.bean;

import com.google.common.base.MoreObjects;

public class CDNFileBean {

    private String fileId;
    private String url;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("fileId", fileId)
                .add("url", url)
                .toString();
    }

}
