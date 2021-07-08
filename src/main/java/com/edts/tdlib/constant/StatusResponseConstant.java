package com.edts.tdlib.constant;

public enum StatusResponseConstant {

    SUCCESS_STATUS_OK_CODE("00"),
    SUCCESS_STATUS_OK_DESC("Success"),

    SUCCESS_STATUS_ERROR_CODE("01"),
    SUCCESS_STATUS_ERROR_DESC("Success"),

    DATA_NOT_FOUND("Data not found");


    public final String label;

    StatusResponseConstant(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
