package com.edts.tdlib.engine;

import com.edts.tdlib.Client;
import com.edts.tdlib.TdApi;
import com.edts.tdlib.engine.handler.DefaultHandler;
import com.edts.tdlib.engine.handler.UpdatesHandler;
import com.edts.tdlib.engine.handler.UserContactHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOError;
import java.io.IOException;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class MainTelegram implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger("MainRun");

    public static Client client = null;

    //public static TdApi.AuthorizationState authorizationState = null;
    public static volatile boolean haveAuthorization = false;
    private static volatile boolean quiting = false;

    public static final Client.ResultHandler defaultHandler = (Client.ResultHandler) new DefaultHandler();
    public static final Client.ResultHandler userContactHandler = (Client.ResultHandler) new UserContactHandler();

    public static final Lock authorizationLock = new ReentrantLock();
    public static final Condition gotAuthorization = authorizationLock.newCondition();


    public static final ConcurrentMap<Long, TdApi.Chat> chats = new ConcurrentHashMap<Long, TdApi.Chat>();
    private static final NavigableSet<OrderedChat> mainChatList = new TreeSet<OrderedChat>();
    public static boolean haveFullMainChatList = false;

    /* private static final ConcurrentMap<Integer, TdApi.UserFullInfo> usersFullInfo = new ConcurrentHashMap<Integer, TdApi.UserFullInfo>();
     private static final ConcurrentMap<Integer, TdApi.BasicGroupFullInfo> basicGroupsFullInfo = new ConcurrentHashMap<Integer, TdApi.BasicGroupFullInfo>();
     private static final ConcurrentMap<Integer, TdApi.SupergroupFullInfo> supergroupsFullInfo = new ConcurrentHashMap<Integer, TdApi.SupergroupFullInfo>();
 */
    public static final String newLine = System.getProperty("line.separator");
    public static final String commandsLine = "Enter command (gcs - GetChats, gc <chatId> - GetChat, me - GetMe, sm <chatId> <message> - SendMessage, lo - LogOut, q - Quit, register - Register): ";
    private static volatile String currentPrompt = null;


    private static java.lang.reflect.Field LIBRARIES = null;

  /*  @Autowired
    TelegramMessagesRepo telegramMessagesRepo;

    public TelegramMessages getOneMessage(String chatId){
        return telegramMessagesRepo.getOne(chatId);
    }

    public void updateMessageId(TelegramMessages telegramMessages){
        telegramMessagesRepo.save(telegramMessages);
    }*/


    @Override
    public void run(String... args) throws Exception {
        logger.info(" :::  === START MAIN TD LIB === :::");

        try {
           /* Field field = ClassLoader.class.getDeclaredField("loadedLibraryNames");
            field.setAccessible(true);
            if(field != null){
                Vector<String> libraries = (Vector<String>) LIBRARIES.get(ClassLoader.getSystemClassLoader());
                libraries.toArray(new String[] {});

                for(int i = 0; i < libraries.toArray(new String[] {}).length ; i++){
                    logger.info( "lib ===== ::: " + libraries.toArray(new String[] {})[i]);
                }
            }*/
            logger.info("JNI class path location : " + System.getProperty("java.library.path"));
            System.loadLibrary("tdjni");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }

        // disable TDLib log
        Client.execute(new TdApi.SetLogVerbosityLevel(0));
        if (Client.execute(new TdApi.SetLogStream(new TdApi.LogStreamFile("tdlib.log", 1 << 27))) instanceof TdApi.Error) {
            throw new IOError(new IOException("Write access to the current directory is required"));
        }

        // create client
        client = Client.create((Client.ResultHandler) new UpdatesHandler(), null, null);

        // test Client.execute
        defaultHandler.onResult((TdApi.Object) Client.execute(new TdApi.GetTextEntities("@telegram /test_command https://telegram.org telegram.me @gif @test")));

        // main loop
        while (!quiting) {
            // await authorization
            authorizationLock.lock();
            try {
                while (!haveAuthorization) {
                    gotAuthorization.await();
                }
            } finally {
                authorizationLock.unlock();
            }

            while (haveAuthorization) {
                TdFunctions.getCommand();
            }
        }

    }

}
