package com.edts.tdlib.thread;


import com.edts.tdlib.TdApi;
import com.edts.tdlib.engine.GlobalVariable;
import com.edts.tdlib.engine.TdFunctions;
import com.edts.tdlib.engine.handler.UpdatesHandler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class CommandMessageThread {


    public void commandChat(int userId, long chatId, long replayMessageId, String text) {
        String[] commands = {text};
        try {
            switch (commands[0]) {

                case "register":

                    TdFunctions.getUser(userId);


                    String messageReplay = "Terima kasih.\nNomor Telegram anda telah terdaftar ke sistem kami.";
                    TdApi.InlineKeyboardButton[] row = {new TdApi.InlineKeyboardButton("https://telegram.org?1", new TdApi.InlineKeyboardButtonTypeUrl()), new TdApi.InlineKeyboardButton("https://telegram.org?2", new TdApi.InlineKeyboardButtonTypeUrl()), new TdApi.InlineKeyboardButton("https://telegram.org?3", new TdApi.InlineKeyboardButtonTypeUrl())};

                    TdApi.ReplyMarkup replyMarkup = new TdApi.ReplyMarkupInlineKeyboard(new TdApi.InlineKeyboardButton[][]{row, row, row});
                    TdApi.InputMessageContent content = new TdApi.InputMessageText(new TdApi.FormattedText(messageReplay, null), false, true);
                    GlobalVariable.mainTelegram.client.send(new TdApi.SendMessage(chatId, replayMessageId, null, replyMarkup, content), new UpdatesHandler());

                default:
                    System.err.println("Unsupported command: ");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            TdFunctions.print("Not enough arguments");
        }
    }


}
