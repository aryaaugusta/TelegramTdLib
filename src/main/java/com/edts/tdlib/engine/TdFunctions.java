package com.edts.tdlib.engine;

import com.edts.tdlib.Client;
import com.edts.tdlib.TdApi;
import com.edts.tdlib.engine.handler.DefaultHandler;
import com.edts.tdlib.engine.handler.UpdatesHandler;
import com.edts.tdlib.engine.handler.AuthorizationRequestHandler;
import com.edts.tdlib.engine.handler.UserContactHandler;
import com.edts.tdlib.helper.CoreHelper;
import com.edts.tdlib.model.TelegramAccount;
import com.edts.tdlib.repository.TelegramAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TdFunctions {

    private static volatile String currentPrompt = null;
    private static volatile boolean haveAuthorization = false;
    private static volatile boolean quiting = false;

    private static final Client.ResultHandler defaultHandler = new DefaultHandler();

    private static final Lock authorizationLock = new ReentrantLock();
    private static final Condition gotAuthorization = authorizationLock.newCondition();


    private static final NavigableSet<OrderedChat> mainChatList = new TreeSet<OrderedChat>();


    public static void print(String str) {
        if (currentPrompt != null) {
            System.out.println("");
        }
        System.out.println(str);
        if (currentPrompt != null) {
            System.out.print(currentPrompt);
        }
    }

    public static String promptString(String prompt) {
        System.out.print(prompt);
        currentPrompt = prompt;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentPrompt = null;
        return str;
    }

    public static void onAuthorizationStateUpdated(TdApi.AuthorizationState authorizationState) {
        if (authorizationState != null) {
            GlobalVariable.authorizationState = authorizationState;
        }
        switch (GlobalVariable.authorizationState.getConstructor()) {
            case TdApi.AuthorizationStateWaitTdlibParameters.CONSTRUCTOR:
                TelegramAccount telegramAccount = CoreHelper.getAccountEnable();
                TdApi.TdlibParameters parameters = new TdApi.TdlibParameters();
                parameters.databaseDirectory = telegramAccount.getDatabaseDirectory();
                //parameters.databaseDirectory = "tdlib";///
                //parameters.databaseDirectory = "/opt/telegram/db1/";///tdlib
                parameters.useMessageDatabase = true;
                parameters.useSecretChats = true;
                parameters.apiId = 94575;
                parameters.apiHash = "a3406de8d171bb422bb6ddf3bbd800e2";
                parameters.systemLanguageCode = "en";
                parameters.deviceModel = "Desktop";
                parameters.systemVersion = "Unknown";
                parameters.applicationVersion = "1.0";
                parameters.enableStorageOptimizer = true;
                //parameters.useTestDc = true;

                GlobalVariable.mainTelegram.client.send(new TdApi.SetTdlibParameters(parameters), new AuthorizationRequestHandler());
                break;
            case TdApi.AuthorizationStateWaitEncryptionKey.CONSTRUCTOR:
                GlobalVariable.mainTelegram.client.send(new TdApi.CheckDatabaseEncryptionKey(), new AuthorizationRequestHandler());
                break;
            case TdApi.AuthorizationStateWaitPhoneNumber.CONSTRUCTOR: {
                //String phoneNumber = promptString("Please enter phone number: ");
                TelegramAccount phone = CoreHelper.getAccountEnable();
                String phoneNumber = phone.getPhoneNumber();
                GlobalVariable.mainTelegram.client.send(new TdApi.SetAuthenticationPhoneNumber(phoneNumber, null), new AuthorizationRequestHandler());
                break;
            }
            case TdApi.AuthorizationStateWaitOtherDeviceConfirmation.CONSTRUCTOR: {
                String link = ((TdApi.AuthorizationStateWaitOtherDeviceConfirmation) authorizationState).link;
                System.out.println("Please confirm this login link on another device: " + link);
                break;
            }
            case TdApi.AuthorizationStateWaitCode.CONSTRUCTOR: {
                String code = promptString("Please enter authentication code: ");
                GlobalVariable.mainTelegram.client.send(new TdApi.CheckAuthenticationCode(code), new AuthorizationRequestHandler());
                break;
            }
            case TdApi.AuthorizationStateWaitRegistration.CONSTRUCTOR: {
                String firstName = promptString("Please enter your first name: ");
                String lastName = promptString("Please enter your last name: ");
                GlobalVariable.mainTelegram.client.send(new TdApi.RegisterUser(firstName, lastName), new AuthorizationRequestHandler());
                break;
            }
            case TdApi.AuthorizationStateWaitPassword.CONSTRUCTOR: {
                String password = promptString("Please enter password: ");
                GlobalVariable.mainTelegram.client.send(new TdApi.CheckAuthenticationPassword(password), new AuthorizationRequestHandler());
                break;
            }
            case TdApi.AuthorizationStateReady.CONSTRUCTOR:
                haveAuthorization = true;
                authorizationLock.lock();
                try {
                    gotAuthorization.signal();
                } finally {
                    authorizationLock.unlock();
                }
                break;
            case TdApi.AuthorizationStateLoggingOut.CONSTRUCTOR:
                haveAuthorization = false;
                print("Logging out");
                break;
            case TdApi.AuthorizationStateClosing.CONSTRUCTOR:
                haveAuthorization = false;
                print("Closing");
                break;
            case TdApi.AuthorizationStateClosed.CONSTRUCTOR:
                print("Closed");
                TdFunctions.print(" ::: " + CoreHelper.accountDisable);
                TdFunctions.print(" ::: " + CoreHelper.accountEnable);
                CoreHelper.disableAccount(CoreHelper.accountDisable);
                CoreHelper.enableAccount(CoreHelper.accountEnable);

                if (!quiting) {
                    GlobalVariable.mainTelegram.client = Client.create(new UpdatesHandler(), null, null); // recreate client after previous has closed
                }
                break;
            default:
                System.err.println("Unsupported authorization state:" + GlobalVariable.newLine + authorizationState);
        }
    }


    public static void setChatOrder(TdApi.Chat chat, long order) {
        synchronized (mainChatList) {
            synchronized (chat) {
                if (chat.chatList == null || chat.chatList.getConstructor() != TdApi.ChatListMain.CONSTRUCTOR) {
                    return;
                }

                if (chat.order != 0) {
                    boolean isRemoved = mainChatList.remove(new OrderedChat(chat.order, chat.id));
                    assert isRemoved;
                }

                chat.order = order;

                if (chat.order != 0) {
                    boolean isAdded = mainChatList.add(new OrderedChat(chat.order, chat.id));
                    assert isAdded;
                }
            }
        }
    }

    private static int toInt(String arg) {
        int result = 0;
        try {
            result = Integer.parseInt(arg);
        } catch (NumberFormatException ignored) {
        }
        return result;
    }

    private static long getChatId(String arg) {
        long chatId = 0;
        try {
            chatId = Long.parseLong(arg);
        } catch (NumberFormatException ignored) {
        }
        return chatId;
    }

    private static void getMainChatList(final int limit) {
        synchronized (mainChatList) {
            if (!GlobalVariable.mainTelegram.haveFullMainChatList && limit > mainChatList.size()) {
                // have enough chats in the chat list or chat list is too small
                long offsetOrder = Long.MAX_VALUE;
                long offsetChatId = 0;
                if (!mainChatList.isEmpty()) {
                    OrderedChat last = mainChatList.last();
                    offsetOrder = last.getOrder();
                    offsetChatId = last.getChatId();
                }
                GlobalVariable.mainTelegram.client.send(new TdApi.GetChats(new TdApi.ChatListMain(), offsetOrder, offsetChatId, limit - mainChatList.size()), new Client.ResultHandler() {
                    @Override
                    public void onResult(TdApi.Object object) {
                        switch (object.getConstructor()) {
                            case TdApi.Error.CONSTRUCTOR:
                                System.err.println("Receive an error for GetChats:" + GlobalVariable.mainTelegram.newLine + object);
                                break;
                            case TdApi.Chats.CONSTRUCTOR:
                                long[] chatIds = ((TdApi.Chats) object).chatIds;
                                if (chatIds.length == 0) {
                                    synchronized (mainChatList) {
                                        GlobalVariable.mainTelegram.haveFullMainChatList = true;
                                    }
                                }
                                // chats had already been received through updates, let's retry request
                                getMainChatList(limit);
                                break;
                            default:
                                System.err.println("Receive wrong response from TDLib:" + GlobalVariable.mainTelegram.newLine + object);
                        }
                    }
                });
                return;
            }

            // have enough chats in the chat list to answer request
            java.util.Iterator<OrderedChat> iter = mainChatList.iterator();
            System.out.println();
            System.out.println("First " + limit + " chat(s) out of " + mainChatList.size() + " known chat(s):");
            for (int i = 0; i < limit; i++) {
                long chatId = iter.next().getChatId();
                TdApi.Chat chat = GlobalVariable.mainTelegram.chats.get(chatId);
                synchronized (chat) {
                    System.out.println(chatId + ": " + chat.title);
                }
            }
            TdFunctions.print("");
        }
    }

    public static void getCommand() {
        String command = TdFunctions.promptString(GlobalVariable.mainTelegram.commandsLine);
        String[] commands = command.split(" ", 2);
        try {
            switch (commands[0]) {
                case "gcs": {
                    int limit = 20;
                    if (commands.length > 1) {
                        limit = toInt(commands[1]);
                    }
                    getMainChatList(limit);
                    break;
                }
                case "gc":
                    GlobalVariable.mainTelegram.client.send(new TdApi.GetChat(getChatId(commands[1])), defaultHandler);
                    break;
                case "me":
                    GlobalVariable.mainTelegram.client.send(new TdApi.GetMe(), defaultHandler);
                    break;
                case "sm": {
                    String[] args = commands[1].split(" ", 2);
                    sendMessage(getChatId(args[0]), args[1]);
                    break;
                }
                case "lo":
                    haveAuthorization = false;
                    GlobalVariable.mainTelegram.client.send(new TdApi.LogOut(), defaultHandler);
                    break;
                case "q":
                    quiting = true;
                    haveAuthorization = false;
                    GlobalVariable.mainTelegram.client.send(new TdApi.Close(), defaultHandler);
                    break;
                case "register":
                    String messageReplay = "Terima kasih.\n Nomor Telegram anda telah terdaftar ke sistem kami.";
                    TdApi.InlineKeyboardButton[] row = {new TdApi.InlineKeyboardButton("https://telegram.org?1", new TdApi.InlineKeyboardButtonTypeUrl()), new TdApi.InlineKeyboardButton("https://telegram.org?2", new TdApi.InlineKeyboardButtonTypeUrl()), new TdApi.InlineKeyboardButton("https://telegram.org?3", new TdApi.InlineKeyboardButtonTypeUrl())};

                    TdApi.ReplyMarkup replyMarkup = new TdApi.ReplyMarkupInlineKeyboard(new TdApi.InlineKeyboardButton[][]{row, row, row});
                    TdApi.InputMessageContent content = new TdApi.InputMessageText(new TdApi.FormattedText(messageReplay, null), false, true);
                    //GlobalVariable.mainTelegram.client.send(new TdApi.SendMessage(chatId, replayMessageId, null, replyMarkup, content), new UpdatesHandler());

                    //mainTelegram.client.send(new TdApi.SendMessage(telegramMessageBean.getChatId(), 0, null, replyMarkup, content), mainTelegram.defaultHandler);
                default:
                    System.err.println("Unsupported command: " + command);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            TdFunctions.print("Not enough arguments");
        }
    }

    static synchronized public void getUser(int userid) {
        GlobalVariable.mainTelegram.client.send(new TdApi.GetUser(userid), new UserContactHandler());
    }

    private static void sendMessage(long chatId, String message) {
        // initialize reply markup just for testing
        TdApi.InlineKeyboardButton[] row = {new TdApi.InlineKeyboardButton("https://telegram.org?1", new TdApi.InlineKeyboardButtonTypeUrl()), new TdApi.InlineKeyboardButton("https://telegram.org?2", new TdApi.InlineKeyboardButtonTypeUrl()), new TdApi.InlineKeyboardButton("https://telegram.org?3", new TdApi.InlineKeyboardButtonTypeUrl())};
        TdApi.ReplyMarkup replyMarkup = new TdApi.ReplyMarkupInlineKeyboard(new TdApi.InlineKeyboardButton[][]{row, row, row});

        TdApi.InputMessageContent content = new TdApi.InputMessageText(new TdApi.FormattedText(message, null), false, true);
        GlobalVariable.mainTelegram.client.send(new TdApi.SendMessage(chatId, 0, null, replyMarkup, content), defaultHandler);
    }
}
