package com.edts.tdlib.engine.handler;

import com.edts.tdlib.Client;
import com.edts.tdlib.TdApi;
import com.edts.tdlib.engine.TdFunctions;
import com.edts.tdlib.helper.CoreHelper;

public class ChatRoomHandler implements Client.ResultHandler {

    @Override
    public void onResult(TdApi.Object object) {

        TdFunctions.print("::: constructor ::: " + object.getConstructor());

        switch (object.getConstructor()) {
            case TdApi.CreateSupergroupChat.CONSTRUCTOR:
                TdApi.CreateSupergroupChat createSupergroupChat = (TdApi.CreateSupergroupChat) object;
                break;
            case TdApi.CreateNewBasicGroupChat.CONSTRUCTOR:
                TdApi.CreateNewBasicGroupChat createNewBasicGroupChat = (TdApi.CreateNewBasicGroupChat) object;
                break;
            case TdApi.BasicGroup.CONSTRUCTOR:
                TdFunctions.print(" Basic Group ::: " + object.toString());
                break;
            case TdApi.CreateBasicGroupChat.CONSTRUCTOR:
                TdFunctions.print(" CreateBasicGroupChat ::: " + object.toString());
                break;
            case TdApi.User.CONSTRUCTOR:
                TdApi.User user = (TdApi.User) object;
                CoreHelper.chatRoomMember.put(user.id, user);
                break;
            case TdApi.SetChatMemberStatus.CONSTRUCTOR:
                TdFunctions.print("SetChatMemberStatus ::: " + object.toString());
                break;
            case TdApi.GetSupergroupMembers.CONSTRUCTOR:
                TdApi.GetSupergroupMembers chatMembers = (TdApi.GetSupergroupMembers) object;
                break;

            case TdApi.Chat.CONSTRUCTOR:
                TdApi.Chat chat = (TdApi.Chat) object;
                CoreHelper.updateBasicGroup(chat);
                break;

        }

    }
}
