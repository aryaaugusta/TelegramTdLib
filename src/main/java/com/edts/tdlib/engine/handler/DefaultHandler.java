package com.edts.tdlib.engine.handler;

import com.edts.tdlib.Client;
import com.edts.tdlib.TdApi;
import com.edts.tdlib.engine.GlobalVariable;
import com.edts.tdlib.engine.TdFunctions;

public class DefaultHandler implements Client.ResultHandler {
    @Override
    public void onResult(TdApi.Object object) {
        TdFunctions.print(object.toString());
        System.out.println(" ::: " +object.getConstructor());

    }
}
