package com.edts.tdlib.engine;

import com.edts.tdlib.Client;
import com.edts.tdlib.TdApi;

import java.text.SimpleDateFormat;

public class GlobalVariable {
    final public static String TEXT_MESSAGE = "1";
    final public static String IMAGE_MESSAGE = "2";
    final public static String DOCUMENT_MESSAGE = "3";
    final public static String API_FUNCTION = "9";

    public static Client client = null;
    public static MainTelegram mainTelegram = null;
    //public static UserResponse userResponse = null;
    public static final String newLine = System.getProperty("line.separator");
    public static TdApi.AuthorizationState authorizationState = null;





    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

}
