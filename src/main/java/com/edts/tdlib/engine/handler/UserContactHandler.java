package com.edts.tdlib.engine.handler;

import com.edts.tdlib.Client;
import com.edts.tdlib.TdApi;
import com.edts.tdlib.engine.TdFunctions;
import com.edts.tdlib.helper.CoreHelper;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UserContactHandler implements Client.ResultHandler {


    @Override
    public void onResult(TdApi.Object object) {
        System.out.println(object.getConstructor() + " -->> ::: " + object.toString());
        switch (object.getConstructor()) {
            case TdApi.Users.CONSTRUCTOR:
                TdApi.Users us = (TdApi.Users) object;
                break;
            case TdApi.ImportedContacts.CONSTRUCTOR:
                TdApi.ImportedContacts importedContacts = (TdApi.ImportedContacts) object;
                int userIds[] = importedContacts.userIds;
                CoreHelper.addContact(userIds);
                break;
            case TdApi.User.CONSTRUCTOR:
                TdApi.User user = (TdApi.User) object;
                CoreHelper.chatRoomMember.put(user.id, user);
                CoreHelper.submitContact(user);// only first
                break;
            case TdApi.AddContact.CONSTRUCTOR:
                TdApi.Contact contact = (TdApi.Contact) object;
                TdFunctions.print(contact.toString());
                break;
        }


    }
}
