package com.edts.tdlib.constant;

public class GeneralConstant {

    public static final String IMMEDIATE_CODE = "MT0001";
    public static final String ONCE_OFF_CODE = "MT0002";
    public static final String RECURRING_CODE = "MT0003";

    public static final String RECURRING_TYPE_DAILY = "DAILY";
    public static final String RECURRING_TYPE_WEEKLY = "WEEKLY";
    public static final String RECURRING_TYPE_MONTHLY = "MONTHLY";
    public static final String RECURRING_TYPE_ANNUALLY = "ANNUALLY";
    public static final String RECURRING_TYPE_ATTRIBUTE = "ATTRIBUTE";

    public static final String RECURRING_WEEKLY_SAT = "SAT";
    public static final String RECURRING_WEEKLY_SUN = "SUN";
    public static final String RECURRING_WEEKLY_MON = "MON";
    public static final String RECURRING_WEEKLY_TUE = "TUE";
    public static final String RECURRING_WEEKLY_WED = "WED";
    public static final String RECURRING_WEEKLY_THU = "THU";
    public static final String RECURRING_WEEKLY_FRI = "FRI";

    public static final String SUN = "1";
    public static final String MON = "2";
    public static final String TUE = "3";
    public static final String WED = "4";
    public static final String THU = "5";
    public static final String FRI = "6";
    public static final String SAT = "7";


    public static final String RECEIVER_TYPE_SINGLE_USER = "TU-1";
    public static final String RECEIVER_TYPE_MULTIPLE_USER = "TU-2";
    public static final String RECEIVER_TYPE_SINLGE_CHATROOM = "CT-1";
    public static final String RECEIVER_TYPE_MULTIPLE_CHATROOM = "CT-2";


    public static final String STATUS_QUEUE_MESSAGE_SCHEDULE = "QUEUE";
    public static final String STATUS_PROCESSED_MESSAGE_SCHEDULE = "PROCESSED";
    public static final String STATUS_PROCESSING_MESSAGE_SCHEDULE = "PROCESSING";


    public static final String GROUP_KEY_RECURRING = "RECURRING";
    public static final String GROUP_KEY_ONCE_OFF = "ONCE-OFF";
    public static final String GROUP_KEY_RECURRING_ATTRIBUTE = "REC-ATTRIBUTE";


    public static final String KEY_PARAM_EXECUTE_DATE = "EXECUTE-DATE";

    public static final String VALUE_PARAM_EXECUTE_DATE = "SYSDATE";


    public static final String ATTRIBUTE_CONTACT_TYPE_USER = "USER";
    public static final String ATTRIBUTE_CONTACT_TYPE_CHATROOM = "CHATROOM";

    public static final String ATTRIBUTE_DATA_TYPE_DATE = "DATE";
    public static final String ATTRIBUTE_DATA_TYPE_STRING = "STRING";

    public static final Integer MESSAGE_ATTRIBUTE_TYPE = 1;
    public static final Integer RECURRING_ATTRIBUTE_TYPE = 3;


    public static final String USER_TYPE_BOT = "BOT";
    public static final String USER_TYPE_REGULAR = "REGULAR";
    public static final String GROUP_KEY_EXPIRE = "EXPIRE";
    public static final String KEY_PARAM_CODE_PASS = "CODE-PASS";


    private GeneralConstant() {
    }

}
