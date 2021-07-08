package com.edts.tdlib;

public class TdApi {
    public TdApi() {
    }

    public static class WriteGeneratedFilePart extends TdApi.Function {
        public long generationId;
        public int offset;
        public byte[] data;
        public static final int CONSTRUCTOR = -2062358189;

        public WriteGeneratedFilePart() {
        }

        public WriteGeneratedFilePart(long var1, int var3, byte[] var4) {
            this.generationId = var1;
            this.offset = var3;
            this.data = var4;
        }

        public int getConstructor() {
            return -2062358189;
        }
    }

    public static class ViewTrendingStickerSets extends TdApi.Function {
        public long[] stickerSetIds;
        public static final int CONSTRUCTOR = -952416520;

        public ViewTrendingStickerSets() {
        }

        public ViewTrendingStickerSets(long[] var1) {
            this.stickerSetIds = var1;
        }

        public int getConstructor() {
            return -952416520;
        }
    }

    public static class ViewMessages extends TdApi.Function {
        public long chatId;
        public long[] messageIds;
        public boolean forceRead;
        public static final int CONSTRUCTOR = -1925784915;

        public ViewMessages() {
        }

        public ViewMessages(long var1, long[] var3, boolean var4) {
            this.chatId = var1;
            this.messageIds = var3;
            this.forceRead = var4;
        }

        public int getConstructor() {
            return -1925784915;
        }
    }

    public static class ValidateOrderInfo extends TdApi.Function {
        public long chatId;
        public long messageId;
        public TdApi.OrderInfo orderInfo;
        public boolean allowSave;
        public static final int CONSTRUCTOR = 9480644;

        public ValidateOrderInfo() {
        }

        public ValidateOrderInfo(long var1, long var3, TdApi.OrderInfo var5, boolean var6) {
            this.chatId = var1;
            this.messageId = var3;
            this.orderInfo = var5;
            this.allowSave = var6;
        }

        public int getConstructor() {
            return 9480644;
        }
    }

    public static class UploadStickerFile extends TdApi.Function {
        public int userId;
        public TdApi.InputFile pngSticker;
        public static final int CONSTRUCTOR = 1134087551;

        public UploadStickerFile() {
        }

        public UploadStickerFile(int var1, TdApi.InputFile var2) {
            this.userId = var1;
            this.pngSticker = var2;
        }

        public int getConstructor() {
            return 1134087551;
        }
    }

    public static class UploadFile extends TdApi.Function {
        public TdApi.InputFile file;
        public TdApi.FileType fileType;
        public int priority;
        public static final int CONSTRUCTOR = -745597786;

        public UploadFile() {
        }

        public UploadFile(TdApi.InputFile var1, TdApi.FileType var2, int var3) {
            this.file = var1;
            this.fileType = var2;
            this.priority = var3;
        }

        public int getConstructor() {
            return -745597786;
        }
    }

    public static class UpgradeBasicGroupChatToSupergroupChat extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = 300488122;

        public UpgradeBasicGroupChatToSupergroupChat() {
        }

        public UpgradeBasicGroupChatToSupergroupChat(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return 300488122;
        }
    }

    public static class UnpinChatMessage extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = 277557690;

        public UnpinChatMessage() {
        }

        public UnpinChatMessage(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return 277557690;
        }
    }

    public static class UnblockUser extends TdApi.Function {
        public int userId;
        public static final int CONSTRUCTOR = -307286367;

        public UnblockUser() {
        }

        public UnblockUser(int var1) {
            this.userId = var1;
        }

        public int getConstructor() {
            return -307286367;
        }
    }

    public static class TransferChatOwnership extends TdApi.Function {
        public long chatId;
        public int userId;
        public String password;
        public static final int CONSTRUCTOR = -1925047127;

        public TransferChatOwnership() {
        }

        public TransferChatOwnership(long var1, int var3, String var4) {
            this.chatId = var1;
            this.userId = var3;
            this.password = var4;
        }

        public int getConstructor() {
            return -1925047127;
        }
    }

    public static class ToggleSupergroupSignMessages extends TdApi.Function {
        public int supergroupId;
        public boolean signMessages;
        public static final int CONSTRUCTOR = -558196581;

        public ToggleSupergroupSignMessages() {
        }

        public ToggleSupergroupSignMessages(int var1, boolean var2) {
            this.supergroupId = var1;
            this.signMessages = var2;
        }

        public int getConstructor() {
            return -558196581;
        }
    }

    public static class ToggleSupergroupIsAllHistoryAvailable extends TdApi.Function {
        public int supergroupId;
        public boolean isAllHistoryAvailable;
        public static final int CONSTRUCTOR = 1701526555;

        public ToggleSupergroupIsAllHistoryAvailable() {
        }

        public ToggleSupergroupIsAllHistoryAvailable(int var1, boolean var2) {
            this.supergroupId = var1;
            this.isAllHistoryAvailable = var2;
        }

        public int getConstructor() {
            return 1701526555;
        }
    }

    public static class ToggleChatIsPinned extends TdApi.Function {
        public long chatId;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -1166802621;

        public ToggleChatIsPinned() {
        }

        public ToggleChatIsPinned(long var1, boolean var3) {
            this.chatId = var1;
            this.isPinned = var3;
        }

        public int getConstructor() {
            return -1166802621;
        }
    }

    public static class ToggleChatIsMarkedAsUnread extends TdApi.Function {
        public long chatId;
        public boolean isMarkedAsUnread;
        public static final int CONSTRUCTOR = -986129697;

        public ToggleChatIsMarkedAsUnread() {
        }

        public ToggleChatIsMarkedAsUnread(long var1, boolean var3) {
            this.chatId = var1;
            this.isMarkedAsUnread = var3;
        }

        public int getConstructor() {
            return -986129697;
        }
    }

    public static class ToggleChatDefaultDisableNotification extends TdApi.Function {
        public long chatId;
        public boolean defaultDisableNotification;
        public static final int CONSTRUCTOR = 314794002;

        public ToggleChatDefaultDisableNotification() {
        }

        public ToggleChatDefaultDisableNotification(long var1, boolean var3) {
            this.chatId = var1;
            this.defaultDisableNotification = var3;
        }

        public int getConstructor() {
            return 314794002;
        }
    }

    public static class TestUseUpdate extends TdApi.Function {
        public static final int CONSTRUCTOR = 717094686;

        public TestUseUpdate() {
        }

        public int getConstructor() {
            return 717094686;
        }
    }

    public static class TestSquareInt extends TdApi.Function {
        public int x;
        public static final int CONSTRUCTOR = -60135024;

        public TestSquareInt() {
        }

        public TestSquareInt(int var1) {
            this.x = var1;
        }

        public int getConstructor() {
            return -60135024;
        }
    }

    public static class TestReturnError extends TdApi.Function {
        public TdApi.Error error;
        public static final int CONSTRUCTOR = 455179506;

        public TestReturnError() {
        }

        public TestReturnError(TdApi.Error var1) {
            this.error = var1;
        }

        public int getConstructor() {
            return 455179506;
        }
    }

    public static class TestProxy extends TdApi.Function {
        public String server;
        public int port;
        public TdApi.ProxyType type;
        public int dcId;
        public double timeout;
        public static final int CONSTRUCTOR = -1197366626;

        public TestProxy() {
        }

        public TestProxy(String var1, int var2, TdApi.ProxyType var3, int var4, double var5) {
            this.server = var1;
            this.port = var2;
            this.type = var3;
            this.dcId = var4;
            this.timeout = var5;
        }

        public int getConstructor() {
            return -1197366626;
        }
    }

    public static class TestNetwork extends TdApi.Function {
        public static final int CONSTRUCTOR = -1343998901;

        public TestNetwork() {
        }

        public int getConstructor() {
            return -1343998901;
        }
    }

    public static class TestGetDifference extends TdApi.Function {
        public static final int CONSTRUCTOR = 1747084069;

        public TestGetDifference() {
        }

        public int getConstructor() {
            return 1747084069;
        }
    }

    public static class TestCallVectorStringObject extends TdApi.Function {
        public TdApi.TestString[] x;
        public static final int CONSTRUCTOR = 1527666429;

        public TestCallVectorStringObject() {
        }

        public TestCallVectorStringObject(TdApi.TestString[] var1) {
            this.x = var1;
        }

        public int getConstructor() {
            return 1527666429;
        }
    }

    public static class TestCallVectorString extends TdApi.Function {
        public String[] x;
        public static final int CONSTRUCTOR = -408600900;

        public TestCallVectorString() {
        }

        public TestCallVectorString(String[] var1) {
            this.x = var1;
        }

        public int getConstructor() {
            return -408600900;
        }
    }

    public static class TestCallVectorIntObject extends TdApi.Function {
        public TdApi.TestInt[] x;
        public static final int CONSTRUCTOR = 1825428218;

        public TestCallVectorIntObject() {
        }

        public TestCallVectorIntObject(TdApi.TestInt[] var1) {
            this.x = var1;
        }

        public int getConstructor() {
            return 1825428218;
        }
    }

    public static class TestCallVectorInt extends TdApi.Function {
        public int[] x;
        public static final int CONSTRUCTOR = -2137277793;

        public TestCallVectorInt() {
        }

        public TestCallVectorInt(int[] var1) {
            this.x = var1;
        }

        public int getConstructor() {
            return -2137277793;
        }
    }

    public static class TestCallString extends TdApi.Function {
        public String x;
        public static final int CONSTRUCTOR = -1732818385;

        public TestCallString() {
        }

        public TestCallString(String var1) {
            this.x = var1;
        }

        public int getConstructor() {
            return -1732818385;
        }
    }

    public static class TestCallEmpty extends TdApi.Function {
        public static final int CONSTRUCTOR = -627291626;

        public TestCallEmpty() {
        }

        public int getConstructor() {
            return -627291626;
        }
    }

    public static class TestCallBytes extends TdApi.Function {
        public byte[] x;
        public static final int CONSTRUCTOR = -736011607;

        public TestCallBytes() {
        }

        public TestCallBytes(byte[] var1) {
            this.x = var1;
        }

        public int getConstructor() {
            return -736011607;
        }
    }

    public static class TerminateSession extends TdApi.Function {
        public long sessionId;
        public static final int CONSTRUCTOR = -407385812;

        public TerminateSession() {
        }

        public TerminateSession(long var1) {
            this.sessionId = var1;
        }

        public int getConstructor() {
            return -407385812;
        }
    }

    public static class TerminateAllOtherSessions extends TdApi.Function {
        public static final int CONSTRUCTOR = 1874485523;

        public TerminateAllOtherSessions() {
        }

        public int getConstructor() {
            return 1874485523;
        }
    }

    public static class SynchronizeLanguagePack extends TdApi.Function {
        public String languagePackId;
        public static final int CONSTRUCTOR = -2065307858;

        public SynchronizeLanguagePack() {
        }

        public SynchronizeLanguagePack(String var1) {
            this.languagePackId = var1;
        }

        public int getConstructor() {
            return -2065307858;
        }
    }

    public static class StopPoll extends TdApi.Function {
        public long chatId;
        public long messageId;
        public TdApi.ReplyMarkup replyMarkup;
        public static final int CONSTRUCTOR = 1659374253;

        public StopPoll() {
        }

        public StopPoll(long var1, long var3, TdApi.ReplyMarkup var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.replyMarkup = var5;
        }

        public int getConstructor() {
            return 1659374253;
        }
    }

    public static class SharePhoneNumber extends TdApi.Function {
        public int userId;
        public static final int CONSTRUCTOR = -370669878;

        public SharePhoneNumber() {
        }

        public SharePhoneNumber(int var1) {
            this.userId = var1;
        }

        public int getConstructor() {
            return -370669878;
        }
    }

    public static class SetUsername extends TdApi.Function {
        public String username;
        public static final int CONSTRUCTOR = 439901214;

        public SetUsername() {
        }

        public SetUsername(String var1) {
            this.username = var1;
        }

        public int getConstructor() {
            return 439901214;
        }
    }

    public static class SetUserPrivacySettingRules extends TdApi.Function {
        public TdApi.UserPrivacySetting setting;
        public TdApi.UserPrivacySettingRules rules;
        public static final int CONSTRUCTOR = -473812741;

        public SetUserPrivacySettingRules() {
        }

        public SetUserPrivacySettingRules(TdApi.UserPrivacySetting var1, TdApi.UserPrivacySettingRules var2) {
            this.setting = var1;
            this.rules = var2;
        }

        public int getConstructor() {
            return -473812741;
        }
    }

    public static class SetTdlibParameters extends TdApi.Function {
        public TdApi.TdlibParameters parameters;
        public static final int CONSTRUCTOR = -1912557997;

        public SetTdlibParameters() {
        }

        public SetTdlibParameters(TdApi.TdlibParameters var1) {
            this.parameters = var1;
        }

        public int getConstructor() {
            return -1912557997;
        }
    }

    public static class SetSupergroupUsername extends TdApi.Function {
        public int supergroupId;
        public String username;
        public static final int CONSTRUCTOR = -1428333122;

        public SetSupergroupUsername() {
        }

        public SetSupergroupUsername(int var1, String var2) {
            this.supergroupId = var1;
            this.username = var2;
        }

        public int getConstructor() {
            return -1428333122;
        }
    }

    public static class SetSupergroupStickerSet extends TdApi.Function {
        public int supergroupId;
        public long stickerSetId;
        public static final int CONSTRUCTOR = -295782298;

        public SetSupergroupStickerSet() {
        }

        public SetSupergroupStickerSet(int var1, long var2) {
            this.supergroupId = var1;
            this.stickerSetId = var2;
        }

        public int getConstructor() {
            return -295782298;
        }
    }

    public static class SetStickerPositionInSet extends TdApi.Function {
        public TdApi.InputFile sticker;
        public int position;
        public static final int CONSTRUCTOR = 2075281185;

        public SetStickerPositionInSet() {
        }

        public SetStickerPositionInSet(TdApi.InputFile var1, int var2) {
            this.sticker = var1;
            this.position = var2;
        }

        public int getConstructor() {
            return 2075281185;
        }
    }

    public static class SetScopeNotificationSettings extends TdApi.Function {
        public TdApi.NotificationSettingsScope scope;
        public TdApi.ScopeNotificationSettings notificationSettings;
        public static final int CONSTRUCTOR = -2049984966;

        public SetScopeNotificationSettings() {
        }

        public SetScopeNotificationSettings(TdApi.NotificationSettingsScope var1, TdApi.ScopeNotificationSettings var2) {
            this.scope = var1;
            this.notificationSettings = var2;
        }

        public int getConstructor() {
            return -2049984966;
        }
    }

    public static class SetRecoveryEmailAddress extends TdApi.Function {
        public String password;
        public String newRecoveryEmailAddress;
        public static final int CONSTRUCTOR = -1981836385;

        public SetRecoveryEmailAddress() {
        }

        public SetRecoveryEmailAddress(String var1, String var2) {
            this.password = var1;
            this.newRecoveryEmailAddress = var2;
        }

        public int getConstructor() {
            return -1981836385;
        }
    }

    public static class SetProfilePhoto extends TdApi.Function {
        public TdApi.InputFile photo;
        public static final int CONSTRUCTOR = 1594734550;

        public SetProfilePhoto() {
        }

        public SetProfilePhoto(TdApi.InputFile var1) {
            this.photo = var1;
        }

        public int getConstructor() {
            return 1594734550;
        }
    }

    public static class SetPollAnswer extends TdApi.Function {
        public long chatId;
        public long messageId;
        public int[] optionIds;
        public static final int CONSTRUCTOR = -1399388792;

        public SetPollAnswer() {
        }

        public SetPollAnswer(long var1, long var3, int[] var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.optionIds = var5;
        }

        public int getConstructor() {
            return -1399388792;
        }
    }

    public static class SetPinnedChats extends TdApi.Function {
        public TdApi.ChatList chatList;
        public long[] chatIds;
        public static final int CONSTRUCTOR = -695640000;

        public SetPinnedChats() {
        }

        public SetPinnedChats(TdApi.ChatList var1, long[] var2) {
            this.chatList = var1;
            this.chatIds = var2;
        }

        public int getConstructor() {
            return -695640000;
        }
    }

    public static class SetPassword extends TdApi.Function {
        public String oldPassword;
        public String newPassword;
        public String newHint;
        public boolean setRecoveryEmailAddress;
        public String newRecoveryEmailAddress;
        public static final int CONSTRUCTOR = -1193589027;

        public SetPassword() {
        }

        public SetPassword(String var1, String var2, String var3, boolean var4, String var5) {
            this.oldPassword = var1;
            this.newPassword = var2;
            this.newHint = var3;
            this.setRecoveryEmailAddress = var4;
            this.newRecoveryEmailAddress = var5;
        }

        public int getConstructor() {
            return -1193589027;
        }
    }

    public static class SetPassportElementErrors extends TdApi.Function {
        public int userId;
        public TdApi.InputPassportElementError[] errors;
        public static final int CONSTRUCTOR = 1455869875;

        public SetPassportElementErrors() {
        }

        public SetPassportElementErrors(int var1, TdApi.InputPassportElementError[] var2) {
            this.userId = var1;
            this.errors = var2;
        }

        public int getConstructor() {
            return 1455869875;
        }
    }

    public static class SetPassportElement extends TdApi.Function {
        public TdApi.InputPassportElement element;
        public String password;
        public static final int CONSTRUCTOR = 2068173212;

        public SetPassportElement() {
        }

        public SetPassportElement(TdApi.InputPassportElement var1, String var2) {
            this.element = var1;
            this.password = var2;
        }

        public int getConstructor() {
            return 2068173212;
        }
    }

    public static class SetOption extends TdApi.Function {
        public String name;
        public TdApi.OptionValue value;
        public static final int CONSTRUCTOR = 2114670322;

        public SetOption() {
        }

        public SetOption(String var1, TdApi.OptionValue var2) {
            this.name = var1;
            this.value = var2;
        }

        public int getConstructor() {
            return 2114670322;
        }
    }

    public static class SetNetworkType extends TdApi.Function {
        public TdApi.NetworkType type;
        public static final int CONSTRUCTOR = -701635234;

        public SetNetworkType() {
        }

        public SetNetworkType(TdApi.NetworkType var1) {
            this.type = var1;
        }

        public int getConstructor() {
            return -701635234;
        }
    }

    public static class SetName extends TdApi.Function {
        public String firstName;
        public String lastName;
        public static final int CONSTRUCTOR = 1711693584;

        public SetName() {
        }

        public SetName(String var1, String var2) {
            this.firstName = var1;
            this.lastName = var2;
        }

        public int getConstructor() {
            return 1711693584;
        }
    }

    public static class SetLogVerbosityLevel extends TdApi.Function {
        public int newVerbosityLevel;
        public static final int CONSTRUCTOR = -303429678;

        public SetLogVerbosityLevel() {
        }

        public SetLogVerbosityLevel(int var1) {
            this.newVerbosityLevel = var1;
        }

        public int getConstructor() {
            return -303429678;
        }
    }

    public static class SetLogTagVerbosityLevel extends TdApi.Function {
        public String tag;
        public int newVerbosityLevel;
        public static final int CONSTRUCTOR = -2095589738;

        public SetLogTagVerbosityLevel() {
        }

        public SetLogTagVerbosityLevel(String var1, int var2) {
            this.tag = var1;
            this.newVerbosityLevel = var2;
        }

        public int getConstructor() {
            return -2095589738;
        }
    }

    public static class SetLogStream extends TdApi.Function {
        public TdApi.LogStream logStream;
        public static final int CONSTRUCTOR = -1364199535;

        public SetLogStream() {
        }

        public SetLogStream(TdApi.LogStream var1) {
            this.logStream = var1;
        }

        public int getConstructor() {
            return -1364199535;
        }
    }

    public static class SetInlineGameScore extends TdApi.Function {
        public String inlineMessageId;
        public boolean editMessage;
        public int userId;
        public int score;
        public boolean force;
        public static final int CONSTRUCTOR = 758435487;

        public SetInlineGameScore() {
        }

        public SetInlineGameScore(String var1, boolean var2, int var3, int var4, boolean var5) {
            this.inlineMessageId = var1;
            this.editMessage = var2;
            this.userId = var3;
            this.score = var4;
            this.force = var5;
        }

        public int getConstructor() {
            return 758435487;
        }
    }

    public static class SetGameScore extends TdApi.Function {
        public long chatId;
        public long messageId;
        public boolean editMessage;
        public int userId;
        public int score;
        public boolean force;
        public static final int CONSTRUCTOR = -1768307069;

        public SetGameScore() {
        }

        public SetGameScore(long var1, long var3, boolean var5, int var6, int var7, boolean var8) {
            this.chatId = var1;
            this.messageId = var3;
            this.editMessage = var5;
            this.userId = var6;
            this.score = var7;
            this.force = var8;
        }

        public int getConstructor() {
            return -1768307069;
        }
    }

    public static class SetFileGenerationProgress extends TdApi.Function {
        public long generationId;
        public int expectedSize;
        public int localPrefixSize;
        public static final int CONSTRUCTOR = -540459953;

        public SetFileGenerationProgress() {
        }

        public SetFileGenerationProgress(long var1, int var3, int var4) {
            this.generationId = var1;
            this.expectedSize = var3;
            this.localPrefixSize = var4;
        }

        public int getConstructor() {
            return -540459953;
        }
    }

    public static class SetDatabaseEncryptionKey extends TdApi.Function {
        public byte[] newEncryptionKey;
        public static final int CONSTRUCTOR = -1204599371;

        public SetDatabaseEncryptionKey() {
        }

        public SetDatabaseEncryptionKey(byte[] var1) {
            this.newEncryptionKey = var1;
        }

        public int getConstructor() {
            return -1204599371;
        }
    }

    public static class SetCustomLanguagePackString extends TdApi.Function {
        public String languagePackId;
        public TdApi.LanguagePackString newString;
        public static final int CONSTRUCTOR = 1316365592;

        public SetCustomLanguagePackString() {
        }

        public SetCustomLanguagePackString(String var1, TdApi.LanguagePackString var2) {
            this.languagePackId = var1;
            this.newString = var2;
        }

        public int getConstructor() {
            return 1316365592;
        }
    }

    public static class SetCustomLanguagePack extends TdApi.Function {
        public TdApi.LanguagePackInfo info;
        public TdApi.LanguagePackString[] strings;
        public static final int CONSTRUCTOR = -296742819;

        public SetCustomLanguagePack() {
        }

        public SetCustomLanguagePack(TdApi.LanguagePackInfo var1, TdApi.LanguagePackString[] var2) {
            this.info = var1;
            this.strings = var2;
        }

        public int getConstructor() {
            return -296742819;
        }
    }

    public static class SetChatTitle extends TdApi.Function {
        public long chatId;
        public String title;
        public static final int CONSTRUCTOR = 164282047;

        public SetChatTitle() {
        }

        public SetChatTitle(long var1, String var3) {
            this.chatId = var1;
            this.title = var3;
        }

        public int getConstructor() {
            return 164282047;
        }
    }

    public static class SetChatSlowModeDelay extends TdApi.Function {
        public long chatId;
        public int slowModeDelay;
        public static final int CONSTRUCTOR = -540350914;

        public SetChatSlowModeDelay() {
        }

        public SetChatSlowModeDelay(long var1, int var3) {
            this.chatId = var1;
            this.slowModeDelay = var3;
        }

        public int getConstructor() {
            return -540350914;
        }
    }

    public static class SetChatPhoto extends TdApi.Function {
        public long chatId;
        public TdApi.InputFile photo;
        public static final int CONSTRUCTOR = 132244217;

        public SetChatPhoto() {
        }

        public SetChatPhoto(long var1, TdApi.InputFile var3) {
            this.chatId = var1;
            this.photo = var3;
        }

        public int getConstructor() {
            return 132244217;
        }
    }

    public static class SetChatPermissions extends TdApi.Function {
        public long chatId;
        public TdApi.ChatPermissions permissions;
        public static final int CONSTRUCTOR = 2138507006;

        public SetChatPermissions() {
        }

        public SetChatPermissions(long var1, TdApi.ChatPermissions var3) {
            this.chatId = var1;
            this.permissions = var3;
        }

        public int getConstructor() {
            return 2138507006;
        }
    }

    public static class SetChatNotificationSettings extends TdApi.Function {
        public long chatId;
        public TdApi.ChatNotificationSettings notificationSettings;
        public static final int CONSTRUCTOR = 777199614;

        public SetChatNotificationSettings() {
        }

        public SetChatNotificationSettings(long var1, TdApi.ChatNotificationSettings var3) {
            this.chatId = var1;
            this.notificationSettings = var3;
        }

        public int getConstructor() {
            return 777199614;
        }
    }

    public static class SetChatMemberStatus extends TdApi.Function {
        public long chatId;
        public int userId;
        public TdApi.ChatMemberStatus status;
        public static final int CONSTRUCTOR = -1754439241;

        public SetChatMemberStatus() {
        }

        public SetChatMemberStatus(long var1, int var3, TdApi.ChatMemberStatus var4) {
            this.chatId = var1;
            this.userId = var3;
            this.status = var4;
        }

        public int getConstructor() {
            return -1754439241;
        }
    }

    public static class SetChatLocation extends TdApi.Function {
        public long chatId;
        public TdApi.ChatLocation location;
        public static final int CONSTRUCTOR = -767091286;

        public SetChatLocation() {
        }

        public SetChatLocation(long var1, TdApi.ChatLocation var3) {
            this.chatId = var1;
            this.location = var3;
        }

        public int getConstructor() {
            return -767091286;
        }
    }

    public static class SetChatDraftMessage extends TdApi.Function {
        public long chatId;
        public TdApi.DraftMessage draftMessage;
        public static final int CONSTRUCTOR = -588175579;

        public SetChatDraftMessage() {
        }

        public SetChatDraftMessage(long var1, TdApi.DraftMessage var3) {
            this.chatId = var1;
            this.draftMessage = var3;
        }

        public int getConstructor() {
            return -588175579;
        }
    }

    public static class SetChatDiscussionGroup extends TdApi.Function {
        public long chatId;
        public long discussionChatId;
        public static final int CONSTRUCTOR = -918801736;

        public SetChatDiscussionGroup() {
        }

        public SetChatDiscussionGroup(long var1, long var3) {
            this.chatId = var1;
            this.discussionChatId = var3;
        }

        public int getConstructor() {
            return -918801736;
        }
    }

    public static class SetChatDescription extends TdApi.Function {
        public long chatId;
        public String description;
        public static final int CONSTRUCTOR = 1957213277;

        public SetChatDescription() {
        }

        public SetChatDescription(long var1, String var3) {
            this.chatId = var1;
            this.description = var3;
        }

        public int getConstructor() {
            return 1957213277;
        }
    }

    public static class SetChatClientData extends TdApi.Function {
        public long chatId;
        public String clientData;
        public static final int CONSTRUCTOR = -827119811;

        public SetChatClientData() {
        }

        public SetChatClientData(long var1, String var3) {
            this.chatId = var1;
            this.clientData = var3;
        }

        public int getConstructor() {
            return -827119811;
        }
    }

    public static class SetChatChatList extends TdApi.Function {
        public long chatId;
        public TdApi.ChatList chatList;
        public static final int CONSTRUCTOR = -1396517321;

        public SetChatChatList() {
        }

        public SetChatChatList(long var1, TdApi.ChatList var3) {
            this.chatId = var1;
            this.chatList = var3;
        }

        public int getConstructor() {
            return -1396517321;
        }
    }

    public static class SetBotUpdatesStatus extends TdApi.Function {
        public int pendingUpdateCount;
        public String errorMessage;
        public static final int CONSTRUCTOR = -1154926191;

        public SetBotUpdatesStatus() {
        }

        public SetBotUpdatesStatus(int var1, String var2) {
            this.pendingUpdateCount = var1;
            this.errorMessage = var2;
        }

        public int getConstructor() {
            return -1154926191;
        }
    }

    public static class SetBio extends TdApi.Function {
        public String bio;
        public static final int CONSTRUCTOR = -1619582124;

        public SetBio() {
        }

        public SetBio(String var1) {
            this.bio = var1;
        }

        public int getConstructor() {
            return -1619582124;
        }
    }

    public static class SetBackground extends TdApi.Function {
        public TdApi.InputBackground background;
        public TdApi.BackgroundType type;
        public boolean forDarkTheme;
        public static final int CONSTRUCTOR = -1035439225;

        public SetBackground() {
        }

        public SetBackground(TdApi.InputBackground var1, TdApi.BackgroundType var2, boolean var3) {
            this.background = var1;
            this.type = var2;
            this.forDarkTheme = var3;
        }

        public int getConstructor() {
            return -1035439225;
        }
    }

    public static class SetAutoDownloadSettings extends TdApi.Function {
        public TdApi.AutoDownloadSettings settings;
        public TdApi.NetworkType type;
        public static final int CONSTRUCTOR = -353671948;

        public SetAutoDownloadSettings() {
        }

        public SetAutoDownloadSettings(TdApi.AutoDownloadSettings var1, TdApi.NetworkType var2) {
            this.settings = var1;
            this.type = var2;
        }

        public int getConstructor() {
            return -353671948;
        }
    }

    public static class SetAuthenticationPhoneNumber extends TdApi.Function {
        public String phoneNumber;
        public TdApi.PhoneNumberAuthenticationSettings settings;
        public static final int CONSTRUCTOR = 868276259;

        public SetAuthenticationPhoneNumber() {
        }

        public SetAuthenticationPhoneNumber(String var1, TdApi.PhoneNumberAuthenticationSettings var2) {
            this.phoneNumber = var1;
            this.settings = var2;
        }

        public int getConstructor() {
            return 868276259;
        }
    }

    public static class SetAlarm extends TdApi.Function {
        public double seconds;
        public static final int CONSTRUCTOR = -873497067;

        public SetAlarm() {
        }

        public SetAlarm(double var1) {
            this.seconds = var1;
        }

        public int getConstructor() {
            return -873497067;
        }
    }

    public static class SetAccountTtl extends TdApi.Function {
        public TdApi.AccountTtl ttl;
        public static final int CONSTRUCTOR = 701389032;

        public SetAccountTtl() {
        }

        public SetAccountTtl(TdApi.AccountTtl var1) {
            this.ttl = var1;
        }

        public int getConstructor() {
            return 701389032;
        }
    }

    public static class SendPhoneNumberVerificationCode extends TdApi.Function {
        public String phoneNumber;
        public TdApi.PhoneNumberAuthenticationSettings settings;
        public static final int CONSTRUCTOR = 2081689035;

        public SendPhoneNumberVerificationCode() {
        }

        public SendPhoneNumberVerificationCode(String var1, TdApi.PhoneNumberAuthenticationSettings var2) {
            this.phoneNumber = var1;
            this.settings = var2;
        }

        public int getConstructor() {
            return 2081689035;
        }
    }

    public static class SendPhoneNumberConfirmationCode extends TdApi.Function {
        public String hash;
        public String phoneNumber;
        public TdApi.PhoneNumberAuthenticationSettings settings;
        public static final int CONSTRUCTOR = -1901171495;

        public SendPhoneNumberConfirmationCode() {
        }

        public SendPhoneNumberConfirmationCode(String var1, String var2, TdApi.PhoneNumberAuthenticationSettings var3) {
            this.hash = var1;
            this.phoneNumber = var2;
            this.settings = var3;
        }

        public int getConstructor() {
            return -1901171495;
        }
    }

    public static class SendPaymentForm extends TdApi.Function {
        public long chatId;
        public long messageId;
        public String orderInfoId;
        public String shippingOptionId;
        public TdApi.InputCredentials credentials;
        public static final int CONSTRUCTOR = 591581572;

        public SendPaymentForm() {
        }

        public SendPaymentForm(long var1, long var3, String var5, String var6, TdApi.InputCredentials var7) {
            this.chatId = var1;
            this.messageId = var3;
            this.orderInfoId = var5;
            this.shippingOptionId = var6;
            this.credentials = var7;
        }

        public int getConstructor() {
            return 591581572;
        }
    }

    public static class SendPassportAuthorizationForm extends TdApi.Function {
        public int autorizationFormId;
        public TdApi.PassportElementType[] types;
        public static final int CONSTRUCTOR = -602402218;

        public SendPassportAuthorizationForm() {
        }

        public SendPassportAuthorizationForm(int var1, TdApi.PassportElementType[] var2) {
            this.autorizationFormId = var1;
            this.types = var2;
        }

        public int getConstructor() {
            return -602402218;
        }
    }

    public static class SendMessageAlbum extends TdApi.Function {
        public long chatId;
        public long replyToMessageId;
        public TdApi.SendMessageOptions options;
        public TdApi.InputMessageContent[] inputMessageContents;
        public static final int CONSTRUCTOR = -818794592;

        public SendMessageAlbum() {
        }

        public SendMessageAlbum(long var1, long var3, TdApi.SendMessageOptions var5, TdApi.InputMessageContent[] var6) {
            this.chatId = var1;
            this.replyToMessageId = var3;
            this.options = var5;
            this.inputMessageContents = var6;
        }

        public int getConstructor() {
            return -818794592;
        }
    }

    public static class SendMessage extends TdApi.Function {
        public long chatId;
        public long replyToMessageId;
        public TdApi.SendMessageOptions options;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = -1314396596;

        public SendMessage() {
        }

        public SendMessage(long var1, long var3, TdApi.SendMessageOptions var5, TdApi.ReplyMarkup var6, TdApi.InputMessageContent var7) {

            this.chatId = var1;
            this.replyToMessageId = var3;
            this.options = var5;
            this.replyMarkup = var6;
            this.inputMessageContent = var7;
        }

        public int getConstructor() {
            return -1314396596;
        }
    }

    public static class SendInlineQueryResultMessage extends TdApi.Function {
        public long chatId;
        public long replyToMessageId;
        public TdApi.SendMessageOptions options;
        public long queryId;
        public String resultId;
        public boolean hideViaBot;
        public static final int CONSTRUCTOR = 729880339;

        public SendInlineQueryResultMessage() {
        }

        public SendInlineQueryResultMessage(long var1, long var3, TdApi.SendMessageOptions var5, long var6, String var8, boolean var9) {
            this.chatId = var1;
            this.replyToMessageId = var3;
            this.options = var5;
            this.queryId = var6;
            this.resultId = var8;
            this.hideViaBot = var9;
        }

        public int getConstructor() {
            return 729880339;
        }
    }

    public static class SendEmailAddressVerificationCode extends TdApi.Function {
        public String emailAddress;
        public static final int CONSTRUCTOR = -221621379;

        public SendEmailAddressVerificationCode() {
        }

        public SendEmailAddressVerificationCode(String var1) {
            this.emailAddress = var1;
        }

        public int getConstructor() {
            return -221621379;
        }
    }

    public static class SendCustomRequest extends TdApi.Function {
        public String method;
        public String parameters;
        public static final int CONSTRUCTOR = 285045153;

        public SendCustomRequest() {
        }

        public SendCustomRequest(String var1, String var2) {
            this.method = var1;
            this.parameters = var2;
        }

        public int getConstructor() {
            return 285045153;
        }
    }

    public static class SendChatSetTtlMessage extends TdApi.Function {
        public long chatId;
        public int ttl;
        public static final int CONSTRUCTOR = 1432535564;

        public SendChatSetTtlMessage() {
        }

        public SendChatSetTtlMessage(long var1, int var3) {
            this.chatId = var1;
            this.ttl = var3;
        }

        public int getConstructor() {
            return 1432535564;
        }
    }

    public static class SendChatScreenshotTakenNotification extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = 448399457;

        public SendChatScreenshotTakenNotification() {
        }

        public SendChatScreenshotTakenNotification(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return 448399457;
        }
    }

    public static class SendChatAction extends TdApi.Function {
        public long chatId;
        public TdApi.ChatAction action;
        public static final int CONSTRUCTOR = -841357536;

        public SendChatAction() {
        }

        public SendChatAction(long var1, TdApi.ChatAction var3) {
            this.chatId = var1;
            this.action = var3;
        }

        public int getConstructor() {
            return -841357536;
        }
    }

    public static class SendCallRating extends TdApi.Function {
        public int callId;
        public int rating;
        public String comment;
        public TdApi.CallProblem[] problems;
        public static final int CONSTRUCTOR = -1402719502;

        public SendCallRating() {
        }

        public SendCallRating(int var1, int var2, String var3, TdApi.CallProblem[] var4) {
            this.callId = var1;
            this.rating = var2;
            this.comment = var3;
            this.problems = var4;
        }

        public int getConstructor() {
            return -1402719502;
        }
    }

    public static class SendCallDebugInformation extends TdApi.Function {
        public int callId;
        public String debugInformation;
        public static final int CONSTRUCTOR = 2019243839;

        public SendCallDebugInformation() {
        }

        public SendCallDebugInformation(int var1, String var2) {
            this.callId = var1;
            this.debugInformation = var2;
        }

        public int getConstructor() {
            return 2019243839;
        }
    }

    public static class SendBotStartMessage extends TdApi.Function {
        public int botUserId;
        public long chatId;
        public String parameter;
        public static final int CONSTRUCTOR = 1112181339;

        public SendBotStartMessage() {
        }

        public SendBotStartMessage(int var1, long var2, String var4) {
            this.botUserId = var1;
            this.chatId = var2;
            this.parameter = var4;
        }

        public int getConstructor() {
            return 1112181339;
        }
    }

    public static class SearchStickers extends TdApi.Function {
        public String emoji;
        public int limit;
        public static final int CONSTRUCTOR = 1555771203;

        public SearchStickers() {
        }

        public SearchStickers(String var1, int var2) {
            this.emoji = var1;
            this.limit = var2;
        }

        public int getConstructor() {
            return 1555771203;
        }
    }

    public static class SearchStickerSets extends TdApi.Function {
        public String query;
        public static final int CONSTRUCTOR = -1082314629;

        public SearchStickerSets() {
        }

        public SearchStickerSets(String var1) {
            this.query = var1;
        }

        public int getConstructor() {
            return -1082314629;
        }
    }

    public static class SearchStickerSet extends TdApi.Function {
        public String name;
        public static final int CONSTRUCTOR = 1157930222;

        public SearchStickerSet() {
        }

        public SearchStickerSet(String var1) {
            this.name = var1;
        }

        public int getConstructor() {
            return 1157930222;
        }
    }

    public static class SearchSecretMessages extends TdApi.Function {
        public long chatId;
        public String query;
        public long fromSearchId;
        public int limit;
        public TdApi.SearchMessagesFilter filter;
        public static final int CONSTRUCTOR = -1670627915;

        public SearchSecretMessages() {
        }

        public SearchSecretMessages(long var1, String var3, long var4, int var6, TdApi.SearchMessagesFilter var7) {
            this.chatId = var1;
            this.query = var3;
            this.fromSearchId = var4;
            this.limit = var6;
            this.filter = var7;
        }

        public int getConstructor() {
            return -1670627915;
        }
    }

    public static class SearchPublicChats extends TdApi.Function {
        public String query;
        public static final int CONSTRUCTOR = 970385337;

        public SearchPublicChats() {
        }

        public SearchPublicChats(String var1) {
            this.query = var1;
        }

        public int getConstructor() {
            return 970385337;
        }
    }

    public static class SearchPublicChat extends TdApi.Function {
        public String username;
        public static final int CONSTRUCTOR = 857135533;

        public SearchPublicChat() {
        }

        public SearchPublicChat(String var1) {
            this.username = var1;
        }

        public int getConstructor() {
            return 857135533;
        }
    }

    public static class SearchMessages extends TdApi.Function {
        public TdApi.ChatList chatList;
        public String query;
        public int offsetDate;
        public long offsetChatId;
        public long offsetMessageId;
        public int limit;
        public static final int CONSTRUCTOR = -455843835;

        public SearchMessages() {
        }

        public SearchMessages(TdApi.ChatList var1, String var2, int var3, long var4, long var6, int var8) {
            this.chatList = var1;
            this.query = var2;
            this.offsetDate = var3;
            this.offsetChatId = var4;
            this.offsetMessageId = var6;
            this.limit = var8;
        }

        public int getConstructor() {
            return -455843835;
        }
    }

    public static class SearchInstalledStickerSets extends TdApi.Function {
        public boolean isMasks;
        public String query;
        public int limit;
        public static final int CONSTRUCTOR = 681171344;

        public SearchInstalledStickerSets() {
        }

        public SearchInstalledStickerSets(boolean var1, String var2, int var3) {
            this.isMasks = var1;
            this.query = var2;
            this.limit = var3;
        }

        public int getConstructor() {
            return 681171344;
        }
    }

    public static class SearchHashtags extends TdApi.Function {
        public String prefix;
        public int limit;
        public static final int CONSTRUCTOR = 1043637617;

        public SearchHashtags() {
        }

        public SearchHashtags(String var1, int var2) {
            this.prefix = var1;
            this.limit = var2;
        }

        public int getConstructor() {
            return 1043637617;
        }
    }

    public static class SearchEmojis extends TdApi.Function {
        public String text;
        public boolean exactMatch;
        public String inputLanguageCode;
        public static final int CONSTRUCTOR = 453292808;

        public SearchEmojis() {
        }

        public SearchEmojis(String var1, boolean var2, String var3) {
            this.text = var1;
            this.exactMatch = var2;
            this.inputLanguageCode = var3;
        }

        public int getConstructor() {
            return 453292808;
        }
    }

    public static class SearchContacts extends TdApi.Function {
        public String query;
        public int limit;
        public static final int CONSTRUCTOR = -1794690715;

        public SearchContacts() {
        }

        public SearchContacts(String var1, int var2) {
            this.query = var1;
            this.limit = var2;
        }

        public int getConstructor() {
            return -1794690715;
        }
    }

    public static class SearchChatsOnServer extends TdApi.Function {
        public String query;
        public int limit;
        public static final int CONSTRUCTOR = -1158402188;

        public SearchChatsOnServer() {
        }

        public SearchChatsOnServer(String var1, int var2) {
            this.query = var1;
            this.limit = var2;
        }

        public int getConstructor() {
            return -1158402188;
        }
    }

    public static class SearchChatsNearby extends TdApi.Function {
        public TdApi.Location location;
        public static final int CONSTRUCTOR = -196753377;

        public SearchChatsNearby() {
        }

        public SearchChatsNearby(TdApi.Location var1) {
            this.location = var1;
        }

        public int getConstructor() {
            return -196753377;
        }
    }

    public static class SearchChats extends TdApi.Function {
        public String query;
        public int limit;
        public static final int CONSTRUCTOR = -1879787060;

        public SearchChats() {
        }

        public SearchChats(String var1, int var2) {
            this.query = var1;
            this.limit = var2;
        }

        public int getConstructor() {
            return -1879787060;
        }
    }

    public static class SearchChatRecentLocationMessages extends TdApi.Function {
        public long chatId;
        public int limit;
        public static final int CONSTRUCTOR = 950238950;

        public SearchChatRecentLocationMessages() {
        }

        public SearchChatRecentLocationMessages(long var1, int var3) {
            this.chatId = var1;
            this.limit = var3;
        }

        public int getConstructor() {
            return 950238950;
        }
    }

    public static class SearchChatMessages extends TdApi.Function {
        public long chatId;
        public String query;
        public int senderUserId;
        public long fromMessageId;
        public int offset;
        public int limit;
        public TdApi.SearchMessagesFilter filter;
        public static final int CONSTRUCTOR = -1528846671;

        public SearchChatMessages() {
        }

        public SearchChatMessages(long var1, String var3, int var4, long var5, int var7, int var8, TdApi.SearchMessagesFilter var9) {
            this.chatId = var1;
            this.query = var3;
            this.senderUserId = var4;
            this.fromMessageId = var5;
            this.offset = var7;
            this.limit = var8;
            this.filter = var9;
        }

        public int getConstructor() {
            return -1528846671;
        }
    }

    public static class SearchChatMembers extends TdApi.Function {
        public long chatId;
        public String query;
        public int limit;
        public TdApi.ChatMembersFilter filter;
        public static final int CONSTRUCTOR = -445823291;

        public SearchChatMembers() {
        }

        public SearchChatMembers(long var1, String var3, int var4, TdApi.ChatMembersFilter var5) {
            this.chatId = var1;
            this.query = var3;
            this.limit = var4;
            this.filter = var5;
        }

        public int getConstructor() {
            return -445823291;
        }
    }

    public static class SearchCallMessages extends TdApi.Function {
        public long fromMessageId;
        public int limit;
        public boolean onlyMissed;
        public static final int CONSTRUCTOR = -1077230820;

        public SearchCallMessages() {
        }

        public SearchCallMessages(long var1, int var3, boolean var4) {
            this.fromMessageId = var1;
            this.limit = var3;
            this.onlyMissed = var4;
        }

        public int getConstructor() {
            return -1077230820;
        }
    }

    public static class SearchBackground extends TdApi.Function {
        public String name;
        public static final int CONSTRUCTOR = -2130996959;

        public SearchBackground() {
        }

        public SearchBackground(String var1) {
            this.name = var1;
        }

        public int getConstructor() {
            return -2130996959;
        }
    }

    public static class SaveApplicationLogEvent extends TdApi.Function {
        public String type;
        public long chatId;
        public TdApi.JsonValue data;
        public static final int CONSTRUCTOR = -811154930;

        public SaveApplicationLogEvent() {
        }

        public SaveApplicationLogEvent(String var1, long var2, TdApi.JsonValue var4) {
            this.type = var1;
            this.chatId = var2;
            this.data = var4;
        }

        public int getConstructor() {
            return -811154930;
        }
    }

    public static class ResetNetworkStatistics extends TdApi.Function {
        public static final int CONSTRUCTOR = 1646452102;

        public ResetNetworkStatistics() {
        }

        public int getConstructor() {
            return 1646452102;
        }
    }

    public static class ResetBackgrounds extends TdApi.Function {
        public static final int CONSTRUCTOR = 204852088;

        public ResetBackgrounds() {
        }

        public int getConstructor() {
            return 204852088;
        }
    }

    public static class ResetAllNotificationSettings extends TdApi.Function {
        public static final int CONSTRUCTOR = -174020359;

        public ResetAllNotificationSettings() {
        }

        public int getConstructor() {
            return -174020359;
        }
    }

    public static class ResendRecoveryEmailAddressCode extends TdApi.Function {
        public static final int CONSTRUCTOR = 433483548;

        public ResendRecoveryEmailAddressCode() {
        }

        public int getConstructor() {
            return 433483548;
        }
    }

    public static class ResendPhoneNumberVerificationCode extends TdApi.Function {
        public static final int CONSTRUCTOR = 1367629820;

        public ResendPhoneNumberVerificationCode() {
        }

        public int getConstructor() {
            return 1367629820;
        }
    }

    public static class ResendPhoneNumberConfirmationCode extends TdApi.Function {
        public static final int CONSTRUCTOR = 2069068522;

        public ResendPhoneNumberConfirmationCode() {
        }

        public int getConstructor() {
            return 2069068522;
        }
    }

    public static class ResendMessages extends TdApi.Function {
        public long chatId;
        public long[] messageIds;
        public static final int CONSTRUCTOR = -940655817;

        public ResendMessages() {
        }

        public ResendMessages(long var1, long[] var3) {
            this.chatId = var1;
            this.messageIds = var3;
        }

        public int getConstructor() {
            return -940655817;
        }
    }

    public static class ResendEmailAddressVerificationCode extends TdApi.Function {
        public static final int CONSTRUCTOR = -1872416732;

        public ResendEmailAddressVerificationCode() {
        }

        public int getConstructor() {
            return -1872416732;
        }
    }

    public static class ResendChangePhoneNumberCode extends TdApi.Function {
        public static final int CONSTRUCTOR = -786772060;

        public ResendChangePhoneNumberCode() {
        }

        public int getConstructor() {
            return -786772060;
        }
    }

    public static class ResendAuthenticationCode extends TdApi.Function {
        public static final int CONSTRUCTOR = -814377191;

        public ResendAuthenticationCode() {
        }

        public int getConstructor() {
            return -814377191;
        }
    }

    public static class RequestQrCodeAuthentication extends TdApi.Function {
        public int[] otherUserIds;
        public static final int CONSTRUCTOR = -104224560;

        public RequestQrCodeAuthentication() {
        }

        public RequestQrCodeAuthentication(int[] var1) {
            this.otherUserIds = var1;
        }

        public int getConstructor() {
            return -104224560;
        }
    }

    public static class RequestPasswordRecovery extends TdApi.Function {
        public static final int CONSTRUCTOR = -13777582;

        public RequestPasswordRecovery() {
        }

        public int getConstructor() {
            return -13777582;
        }
    }

    public static class RequestAuthenticationPasswordRecovery extends TdApi.Function {
        public static final int CONSTRUCTOR = 1393896118;

        public RequestAuthenticationPasswordRecovery() {
        }

        public int getConstructor() {
            return 1393896118;
        }
    }

    public static class ReportSupergroupSpam extends TdApi.Function {
        public int supergroupId;
        public int userId;
        public long[] messageIds;
        public static final int CONSTRUCTOR = -2125451498;

        public ReportSupergroupSpam() {
        }

        public ReportSupergroupSpam(int var1, int var2, long[] var3) {
            this.supergroupId = var1;
            this.userId = var2;
            this.messageIds = var3;
        }

        public int getConstructor() {
            return -2125451498;
        }
    }

    public static class ReportChat extends TdApi.Function {
        public long chatId;
        public TdApi.ChatReportReason reason;
        public long[] messageIds;
        public static final int CONSTRUCTOR = -312579772;

        public ReportChat() {
        }

        public ReportChat(long var1, TdApi.ChatReportReason var3, long[] var4) {
            this.chatId = var1;
            this.reason = var3;
            this.messageIds = var4;
        }

        public int getConstructor() {
            return -312579772;
        }
    }

    public static class ReorderInstalledStickerSets extends TdApi.Function {
        public boolean isMasks;
        public long[] stickerSetIds;
        public static final int CONSTRUCTOR = 1114537563;

        public ReorderInstalledStickerSets() {
        }

        public ReorderInstalledStickerSets(boolean var1, long[] var2) {
            this.isMasks = var1;
            this.stickerSetIds = var2;
        }

        public int getConstructor() {
            return 1114537563;
        }
    }

    public static class RemoveTopChat extends TdApi.Function {
        public TdApi.TopChatCategory category;
        public long chatId;
        public static final int CONSTRUCTOR = -1907876267;

        public RemoveTopChat() {
        }

        public RemoveTopChat(TdApi.TopChatCategory var1, long var2) {
            this.category = var1;
            this.chatId = var2;
        }

        public int getConstructor() {
            return -1907876267;
        }
    }

    public static class RemoveStickerFromSet extends TdApi.Function {
        public TdApi.InputFile sticker;
        public static final int CONSTRUCTOR = 1642196644;

        public RemoveStickerFromSet() {
        }

        public RemoveStickerFromSet(TdApi.InputFile var1) {
            this.sticker = var1;
        }

        public int getConstructor() {
            return 1642196644;
        }
    }

    public static class RemoveSavedAnimation extends TdApi.Function {
        public TdApi.InputFile animation;
        public static final int CONSTRUCTOR = -495605479;

        public RemoveSavedAnimation() {
        }

        public RemoveSavedAnimation(TdApi.InputFile var1) {
            this.animation = var1;
        }

        public int getConstructor() {
            return -495605479;
        }
    }

    public static class RemoveRecentlyFoundChat extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = 717340444;

        public RemoveRecentlyFoundChat() {
        }

        public RemoveRecentlyFoundChat(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return 717340444;
        }
    }

    public static class RemoveRecentSticker extends TdApi.Function {
        public boolean isAttached;
        public TdApi.InputFile sticker;
        public static final int CONSTRUCTOR = 1246577677;

        public RemoveRecentSticker() {
        }

        public RemoveRecentSticker(boolean var1, TdApi.InputFile var2) {
            this.isAttached = var1;
            this.sticker = var2;
        }

        public int getConstructor() {
            return 1246577677;
        }
    }

    public static class RemoveRecentHashtag extends TdApi.Function {
        public String hashtag;
        public static final int CONSTRUCTOR = -1013735260;

        public RemoveRecentHashtag() {
        }

        public RemoveRecentHashtag(String var1) {
            this.hashtag = var1;
        }

        public int getConstructor() {
            return -1013735260;
        }
    }

    public static class RemoveProxy extends TdApi.Function {
        public int proxyId;
        public static final int CONSTRUCTOR = 1369219847;

        public RemoveProxy() {
        }

        public RemoveProxy(int var1) {
            this.proxyId = var1;
        }

        public int getConstructor() {
            return 1369219847;
        }
    }

    public static class RemoveNotificationGroup extends TdApi.Function {
        public int notificationGroupId;
        public int maxNotificationId;
        public static final int CONSTRUCTOR = 1713005454;

        public RemoveNotificationGroup() {
        }

        public RemoveNotificationGroup(int var1, int var2) {
            this.notificationGroupId = var1;
            this.maxNotificationId = var2;
        }

        public int getConstructor() {
            return 1713005454;
        }
    }

    public static class RemoveNotification extends TdApi.Function {
        public int notificationGroupId;
        public int notificationId;
        public static final int CONSTRUCTOR = 862630734;

        public RemoveNotification() {
        }

        public RemoveNotification(int var1, int var2) {
            this.notificationGroupId = var1;
            this.notificationId = var2;
        }

        public int getConstructor() {
            return 862630734;
        }
    }

    public static class RemoveFavoriteSticker extends TdApi.Function {
        public TdApi.InputFile sticker;
        public static final int CONSTRUCTOR = 1152945264;

        public RemoveFavoriteSticker() {
        }

        public RemoveFavoriteSticker(TdApi.InputFile var1) {
            this.sticker = var1;
        }

        public int getConstructor() {
            return 1152945264;
        }
    }

    public static class RemoveContacts extends TdApi.Function {
        public int[] userIds;
        public static final int CONSTRUCTOR = -615510759;

        public RemoveContacts() {
        }

        public RemoveContacts(int[] var1) {
            this.userIds = var1;
        }

        public int getConstructor() {
            return -615510759;
        }
    }

    public static class RemoveChatActionBar extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = -1650968070;

        public RemoveChatActionBar() {
        }

        public RemoveChatActionBar(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return -1650968070;
        }
    }

    public static class RemoveBackground extends TdApi.Function {
        public long backgroundId;
        public static final int CONSTRUCTOR = -1484545642;

        public RemoveBackground() {
        }

        public RemoveBackground(long var1) {
            this.backgroundId = var1;
        }

        public int getConstructor() {
            return -1484545642;
        }
    }

    public static class RegisterUser extends TdApi.Function {
        public String firstName;
        public String lastName;
        public static final int CONSTRUCTOR = -109994467;

        public RegisterUser() {
        }

        public RegisterUser(String var1, String var2) {
            this.firstName = var1;
            this.lastName = var2;
        }

        public int getConstructor() {
            return -109994467;
        }
    }

    public static class RegisterDevice extends TdApi.Function {
        public TdApi.DeviceToken deviceToken;
        public int[] otherUserIds;
        public static final int CONSTRUCTOR = 1734127493;

        public RegisterDevice() {
        }

        public RegisterDevice(TdApi.DeviceToken var1, int[] var2) {
            this.deviceToken = var1;
            this.otherUserIds = var2;
        }

        public int getConstructor() {
            return 1734127493;
        }
    }

    public static class RecoverPassword extends TdApi.Function {
        public String recoveryCode;
        public static final int CONSTRUCTOR = 1660185903;

        public RecoverPassword() {
        }

        public RecoverPassword(String var1) {
            this.recoveryCode = var1;
        }

        public int getConstructor() {
            return 1660185903;
        }
    }

    public static class RecoverAuthenticationPassword extends TdApi.Function {
        public String recoveryCode;
        public static final int CONSTRUCTOR = 787436412;

        public RecoverAuthenticationPassword() {
        }

        public RecoverAuthenticationPassword(String var1) {
            this.recoveryCode = var1;
        }

        public int getConstructor() {
            return 787436412;
        }
    }

    public static class ReadFilePart extends TdApi.Function {
        public int fileId;
        public int offset;
        public int count;
        public static final int CONSTRUCTOR = -407749314;

        public ReadFilePart() {
        }

        public ReadFilePart(int var1, int var2, int var3) {
            this.fileId = var1;
            this.offset = var2;
            this.count = var3;
        }

        public int getConstructor() {
            return -407749314;
        }
    }

    public static class ReadAllChatMentions extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = 1357558453;

        public ReadAllChatMentions() {
        }

        public ReadAllChatMentions(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return 1357558453;
        }
    }

    public static class ProcessPushNotification extends TdApi.Function {
        public String payload;
        public static final int CONSTRUCTOR = 786679952;

        public ProcessPushNotification() {
        }

        public ProcessPushNotification(String var1) {
            this.payload = var1;
        }

        public int getConstructor() {
            return 786679952;
        }
    }

    public static class PingProxy extends TdApi.Function {
        public int proxyId;
        public static final int CONSTRUCTOR = -979681103;

        public PingProxy() {
        }

        public PingProxy(int var1) {
            this.proxyId = var1;
        }

        public int getConstructor() {
            return -979681103;
        }
    }

    public static class PinChatMessage extends TdApi.Function {
        public long chatId;
        public long messageId;
        public boolean disableNotification;
        public static final int CONSTRUCTOR = -554712351;

        public PinChatMessage() {
        }

        public PinChatMessage(long var1, long var3, boolean var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.disableNotification = var5;
        }

        public int getConstructor() {
            return -554712351;
        }
    }

    public static class ParseTextEntities extends TdApi.Function {
        public String text;
        public TdApi.TextParseMode parseMode;
        public static final int CONSTRUCTOR = -1709194593;

        public ParseTextEntities() {
        }

        public ParseTextEntities(String var1, TdApi.TextParseMode var2) {
            this.text = var1;
            this.parseMode = var2;
        }

        public int getConstructor() {
            return -1709194593;
        }
    }

    public static class OptimizeStorage extends TdApi.Function {
        public long size;
        public int ttl;
        public int count;
        public int immunityDelay;
        public TdApi.FileType[] fileTypes;
        public long[] chatIds;
        public long[] excludeChatIds;
        public int chatLimit;
        public static final int CONSTRUCTOR = 980397489;

        public OptimizeStorage() {
        }

        public OptimizeStorage(long var1, int var3, int var4, int var5, TdApi.FileType[] var6, long[] var7, long[] var8, int var9) {
            this.size = var1;
            this.ttl = var3;
            this.count = var4;
            this.immunityDelay = var5;
            this.fileTypes = var6;
            this.chatIds = var7;
            this.excludeChatIds = var8;
            this.chatLimit = var9;
        }

        public int getConstructor() {
            return 980397489;
        }
    }

    public static class OpenMessageContent extends TdApi.Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = -739088005;

        public OpenMessageContent() {
        }

        public OpenMessageContent(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        public int getConstructor() {
            return -739088005;
        }
    }

    public static class OpenChat extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = -323371509;

        public OpenChat() {
        }

        public OpenChat(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return -323371509;
        }
    }

    public static class LogOut extends TdApi.Function {
        public static final int CONSTRUCTOR = -1581923301;

        public LogOut() {
        }

        public int getConstructor() {
            return -1581923301;
        }
    }

    public static class LeaveChat extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = -1825080735;

        public LeaveChat() {
        }

        public LeaveChat(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return -1825080735;
        }
    }

    public static class JoinChatByInviteLink extends TdApi.Function {
        public String inviteLink;
        public static final int CONSTRUCTOR = -1049973882;

        public JoinChatByInviteLink() {
        }

        public JoinChatByInviteLink(String var1) {
            this.inviteLink = var1;
        }

        public int getConstructor() {
            return -1049973882;
        }
    }

    public static class JoinChat extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = 326769313;

        public JoinChat() {
        }

        public JoinChat(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return 326769313;
        }
    }

    public static class ImportContacts extends TdApi.Function {
        public TdApi.Contact[] contacts;
        public static final int CONSTRUCTOR = -215132767;

        public ImportContacts() {
        }

        public ImportContacts(TdApi.Contact[] var1) {
            this.contacts = var1;
        }

        public int getConstructor() {
            return -215132767;
        }
    }

    public static class GetWebPagePreview extends TdApi.Function {
        public TdApi.FormattedText text;
        public static final int CONSTRUCTOR = 573441580;

        public GetWebPagePreview() {
        }

        public GetWebPagePreview(TdApi.FormattedText var1) {
            this.text = var1;
        }

        public int getConstructor() {
            return 573441580;
        }
    }

    public static class GetWebPageInstantView extends TdApi.Function {
        public String url;
        public boolean forceFull;
        public static final int CONSTRUCTOR = -1962649975;

        public GetWebPageInstantView() {
        }

        public GetWebPageInstantView(String var1, boolean var2) {
            this.url = var1;
            this.forceFull = var2;
        }

        public int getConstructor() {
            return -1962649975;
        }
    }

    public static class GetUserProfilePhotos extends TdApi.Function {
        public int userId;
        public int offset;
        public int limit;
        public static final int CONSTRUCTOR = -2062927433;

        public GetUserProfilePhotos() {
        }

        public GetUserProfilePhotos(int var1, int var2, int var3) {
            this.userId = var1;
            this.offset = var2;
            this.limit = var3;
        }

        public int getConstructor() {
            return -2062927433;
        }
    }

    public static class GetUserPrivacySettingRules extends TdApi.Function {
        public TdApi.UserPrivacySetting setting;
        public static final int CONSTRUCTOR = -2077223311;

        public GetUserPrivacySettingRules() {
        }

        public GetUserPrivacySettingRules(TdApi.UserPrivacySetting var1) {
            this.setting = var1;
        }

        public int getConstructor() {
            return -2077223311;
        }
    }

    public static class GetUserFullInfo extends TdApi.Function {
        public int userId;
        public static final int CONSTRUCTOR = -655443263;

        public GetUserFullInfo() {
        }

        public GetUserFullInfo(int var1) {
            this.userId = var1;
        }

        public int getConstructor() {
            return -655443263;
        }
    }

    public static class GetUser extends TdApi.Function {
        public int userId;
        public static final int CONSTRUCTOR = -47586017;

        public GetUser() {
        }

        public GetUser(int var1) {
            this.userId = var1;
        }

        public int getConstructor() {
            return -47586017;
        }
    }

    public static class GetTrendingStickerSets extends TdApi.Function {
        public static final int CONSTRUCTOR = -1729129957;

        public GetTrendingStickerSets() {
        }

        public int getConstructor() {
            return -1729129957;
        }
    }

    public static class GetTopChats extends TdApi.Function {
        public TdApi.TopChatCategory category;
        public int limit;
        public static final int CONSTRUCTOR = -388410847;

        public GetTopChats() {
        }

        public GetTopChats(TdApi.TopChatCategory var1, int var2) {
            this.category = var1;
            this.limit = var2;
        }

        public int getConstructor() {
            return -388410847;
        }
    }

    public static class GetTextEntities extends TdApi.Function {
        public String text;
        public static final int CONSTRUCTOR = -341490693;

        public GetTextEntities() {
        }

        public GetTextEntities(String var1) {
            this.text = var1;
        }

        public int getConstructor() {
            return -341490693;
        }
    }

    public static class GetTemporaryPasswordState extends TdApi.Function {
        public static final int CONSTRUCTOR = -12670830;

        public GetTemporaryPasswordState() {
        }

        public int getConstructor() {
            return -12670830;
        }
    }

    public static class GetSupportUser extends TdApi.Function {
        public static final int CONSTRUCTOR = -1733497700;

        public GetSupportUser() {
        }

        public int getConstructor() {
            return -1733497700;
        }
    }

    public static class GetSupergroupMembers extends TdApi.Function {
        public int supergroupId;
        public TdApi.SupergroupMembersFilter filter;
        public int offset;
        public int limit;
        public static final int CONSTRUCTOR = 1427643098;

        public GetSupergroupMembers() {
        }

        public GetSupergroupMembers(int var1, TdApi.SupergroupMembersFilter var2, int var3, int var4) {
            this.supergroupId = var1;
            this.filter = var2;
            this.offset = var3;
            this.limit = var4;
        }

        public int getConstructor() {
            return 1427643098;
        }
    }

    public static class GetSupergroupFullInfo extends TdApi.Function {
        public int supergroupId;
        public static final int CONSTRUCTOR = -1150331262;

        public GetSupergroupFullInfo() {
        }

        public GetSupergroupFullInfo(int var1) {
            this.supergroupId = var1;
        }

        public int getConstructor() {
            return -1150331262;
        }
    }

    public static class GetSupergroup extends TdApi.Function {
        public int supergroupId;
        public static final int CONSTRUCTOR = -2063063706;

        public GetSupergroup() {
        }

        public GetSupergroup(int var1) {
            this.supergroupId = var1;
        }

        public int getConstructor() {
            return -2063063706;
        }
    }

    public static class GetSuitableDiscussionChats extends TdApi.Function {
        public static final int CONSTRUCTOR = 49044982;

        public GetSuitableDiscussionChats() {
        }

        public int getConstructor() {
            return 49044982;
        }
    }

    public static class GetStorageStatisticsFast extends TdApi.Function {
        public static final int CONSTRUCTOR = 61368066;

        public GetStorageStatisticsFast() {
        }

        public int getConstructor() {
            return 61368066;
        }
    }

    public static class GetStorageStatistics extends TdApi.Function {
        public int chatLimit;
        public static final int CONSTRUCTOR = -853193929;

        public GetStorageStatistics() {
        }

        public GetStorageStatistics(int var1) {
            this.chatLimit = var1;
        }

        public int getConstructor() {
            return -853193929;
        }
    }

    public static class GetStickers extends TdApi.Function {
        public String emoji;
        public int limit;
        public static final int CONSTRUCTOR = -1594919556;

        public GetStickers() {
        }

        public GetStickers(String var1, int var2) {
            this.emoji = var1;
            this.limit = var2;
        }

        public int getConstructor() {
            return -1594919556;
        }
    }

    public static class GetStickerSet extends TdApi.Function {
        public long setId;
        public static final int CONSTRUCTOR = 1052318659;

        public GetStickerSet() {
        }

        public GetStickerSet(long var1) {
            this.setId = var1;
        }

        public int getConstructor() {
            return 1052318659;
        }
    }

    public static class GetStickerEmojis extends TdApi.Function {
        public TdApi.InputFile sticker;
        public static final int CONSTRUCTOR = -1895508665;

        public GetStickerEmojis() {
        }

        public GetStickerEmojis(TdApi.InputFile var1) {
            this.sticker = var1;
        }

        public int getConstructor() {
            return -1895508665;
        }
    }

    public static class GetSecretChat extends TdApi.Function {
        public int secretChatId;
        public static final int CONSTRUCTOR = 40599169;

        public GetSecretChat() {
        }

        public GetSecretChat(int var1) {
            this.secretChatId = var1;
        }

        public int getConstructor() {
            return 40599169;
        }
    }

    public static class GetScopeNotificationSettings extends TdApi.Function {
        public TdApi.NotificationSettingsScope scope;
        public static final int CONSTRUCTOR = -995613361;

        public GetScopeNotificationSettings() {
        }

        public GetScopeNotificationSettings(TdApi.NotificationSettingsScope var1) {
            this.scope = var1;
        }

        public int getConstructor() {
            return -995613361;
        }
    }

    public static class GetSavedOrderInfo extends TdApi.Function {
        public static final int CONSTRUCTOR = -1152016675;

        public GetSavedOrderInfo() {
        }

        public int getConstructor() {
            return -1152016675;
        }
    }

    public static class GetSavedAnimations extends TdApi.Function {
        public static final int CONSTRUCTOR = 7051032;

        public GetSavedAnimations() {
        }

        public int getConstructor() {
            return 7051032;
        }
    }

    public static class GetRepliedMessage extends TdApi.Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = -641918531;

        public GetRepliedMessage() {
        }

        public GetRepliedMessage(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        public int getConstructor() {
            return -641918531;
        }
    }

    public static class GetRemoteFile extends TdApi.Function {
        public String remoteFileId;
        public TdApi.FileType fileType;
        public static final int CONSTRUCTOR = 2137204530;

        public GetRemoteFile() {
        }

        public GetRemoteFile(String var1, TdApi.FileType var2) {
            this.remoteFileId = var1;
            this.fileType = var2;
        }

        public int getConstructor() {
            return 2137204530;
        }
    }

    public static class GetRecoveryEmailAddress extends TdApi.Function {
        public String password;
        public static final int CONSTRUCTOR = -1594770947;

        public GetRecoveryEmailAddress() {
        }

        public GetRecoveryEmailAddress(String var1) {
            this.password = var1;
        }

        public int getConstructor() {
            return -1594770947;
        }
    }

    public static class GetRecentlyVisitedTMeUrls extends TdApi.Function {
        public String referrer;
        public static final int CONSTRUCTOR = 806754961;

        public GetRecentlyVisitedTMeUrls() {
        }

        public GetRecentlyVisitedTMeUrls(String var1) {
            this.referrer = var1;
        }

        public int getConstructor() {
            return 806754961;
        }
    }

    public static class GetRecentStickers extends TdApi.Function {
        public boolean isAttached;
        public static final int CONSTRUCTOR = -579622241;

        public GetRecentStickers() {
        }

        public GetRecentStickers(boolean var1) {
            this.isAttached = var1;
        }

        public int getConstructor() {
            return -579622241;
        }
    }

    public static class GetRecentInlineBots extends TdApi.Function {
        public static final int CONSTRUCTOR = 1437823548;

        public GetRecentInlineBots() {
        }

        public int getConstructor() {
            return 1437823548;
        }
    }

    public static class GetPushReceiverId extends TdApi.Function {
        public String payload;
        public static final int CONSTRUCTOR = -286505294;

        public GetPushReceiverId() {
        }

        public GetPushReceiverId(String var1) {
            this.payload = var1;
        }

        public int getConstructor() {
            return -286505294;
        }
    }

    public static class GetPublicMessageLink extends TdApi.Function {
        public long chatId;
        public long messageId;
        public boolean forAlbum;
        public static final int CONSTRUCTOR = -374642839;

        public GetPublicMessageLink() {
        }

        public GetPublicMessageLink(long var1, long var3, boolean var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.forAlbum = var5;
        }

        public int getConstructor() {
            return -374642839;
        }
    }

    public static class GetProxyLink extends TdApi.Function {
        public int proxyId;
        public static final int CONSTRUCTOR = -1285597664;

        public GetProxyLink() {
        }

        public GetProxyLink(int var1) {
            this.proxyId = var1;
        }

        public int getConstructor() {
            return -1285597664;
        }
    }

    public static class GetProxies extends TdApi.Function {
        public static final int CONSTRUCTOR = -95026381;

        public GetProxies() {
        }

        public int getConstructor() {
            return -95026381;
        }
    }

    public static class GetPreferredCountryLanguage extends TdApi.Function {
        public String countryCode;
        public static final int CONSTRUCTOR = -933049386;

        public GetPreferredCountryLanguage() {
        }

        public GetPreferredCountryLanguage(String var1) {
            this.countryCode = var1;
        }

        public int getConstructor() {
            return -933049386;
        }
    }

    public static class GetPollVoters extends TdApi.Function {
        public long chatId;
        public long messageId;
        public int optionId;
        public int offset;
        public int limit;
        public static final int CONSTRUCTOR = 2075288734;

        public GetPollVoters() {
        }

        public GetPollVoters(long var1, long var3, int var5, int var6, int var7) {
            this.chatId = var1;
            this.messageId = var3;
            this.optionId = var5;
            this.offset = var6;
            this.limit = var7;
        }

        public int getConstructor() {
            return 2075288734;
        }
    }

    public static class GetPaymentReceipt extends TdApi.Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = 1013758294;

        public GetPaymentReceipt() {
        }

        public GetPaymentReceipt(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        public int getConstructor() {
            return 1013758294;
        }
    }

    public static class GetPaymentForm extends TdApi.Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = -2146950882;

        public GetPaymentForm() {
        }

        public GetPaymentForm(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        public int getConstructor() {
            return -2146950882;
        }
    }

    public static class GetPasswordState extends TdApi.Function {
        public static final int CONSTRUCTOR = -174752904;

        public GetPasswordState() {
        }

        public int getConstructor() {
            return -174752904;
        }
    }

    public static class GetPassportElement extends TdApi.Function {
        public TdApi.PassportElementType type;
        public String password;
        public static final int CONSTRUCTOR = -1882398342;

        public GetPassportElement() {
        }

        public GetPassportElement(TdApi.PassportElementType var1, String var2) {
            this.type = var1;
            this.password = var2;
        }

        public int getConstructor() {
            return -1882398342;
        }
    }

    public static class GetPassportAuthorizationFormAvailableElements extends TdApi.Function {
        public int autorizationFormId;
        public String password;
        public static final int CONSTRUCTOR = 1738134754;

        public GetPassportAuthorizationFormAvailableElements() {
        }

        public GetPassportAuthorizationFormAvailableElements(int var1, String var2) {
            this.autorizationFormId = var1;
            this.password = var2;
        }

        public int getConstructor() {
            return 1738134754;
        }
    }

    public static class GetPassportAuthorizationForm extends TdApi.Function {
        public int botUserId;
        public String scope;
        public String publicKey;
        public String nonce;
        public static final int CONSTRUCTOR = -1468394095;

        public GetPassportAuthorizationForm() {
        }

        public GetPassportAuthorizationForm(int var1, String var2, String var3, String var4) {
            this.botUserId = var1;
            this.scope = var2;
            this.publicKey = var3;
            this.nonce = var4;
        }

        public int getConstructor() {
            return -1468394095;
        }
    }

    public static class GetOption extends TdApi.Function {
        public String name;
        public static final int CONSTRUCTOR = -1572495746;

        public GetOption() {
        }

        public GetOption(String var1) {
            this.name = var1;
        }

        public int getConstructor() {
            return -1572495746;
        }
    }

    public static class GetNetworkStatistics extends TdApi.Function {
        public boolean onlyCurrent;
        public static final int CONSTRUCTOR = -986228706;

        public GetNetworkStatistics() {
        }

        public GetNetworkStatistics(boolean var1) {
            this.onlyCurrent = var1;
        }

        public int getConstructor() {
            return -986228706;
        }
    }

    public static class GetMessages extends TdApi.Function {
        public long chatId;
        public long[] messageIds;
        public static final int CONSTRUCTOR = 425299338;

        public GetMessages() {
        }

        public GetMessages(long var1, long[] var3) {
            this.chatId = var1;
            this.messageIds = var3;
        }

        public int getConstructor() {
            return 425299338;
        }
    }

    public static class GetMessageLocally extends TdApi.Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = -603575444;

        public GetMessageLocally() {
        }

        public GetMessageLocally(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        public int getConstructor() {
            return -603575444;
        }
    }

    public static class GetMessageLinkInfo extends TdApi.Function {
        public String url;
        public static final int CONSTRUCTOR = -700533672;

        public GetMessageLinkInfo() {
        }

        public GetMessageLinkInfo(String var1) {
            this.url = var1;
        }

        public int getConstructor() {
            return -700533672;
        }
    }

    public static class GetMessageLink extends TdApi.Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = 1362732326;

        public GetMessageLink() {
        }

        public GetMessageLink(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        public int getConstructor() {
            return 1362732326;
        }
    }

    public static class GetMessage extends TdApi.Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = -1821196160;

        public GetMessage() {
        }

        public GetMessage(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        public int getConstructor() {
            return -1821196160;
        }
    }

    public static class GetMe extends TdApi.Function {
        public static final int CONSTRUCTOR = -191516033;

        public GetMe() {
        }

        public int getConstructor() {
            return -191516033;
        }
    }

    public static class GetMapThumbnailFile extends TdApi.Function {
        public TdApi.Location location;
        public int zoom;
        public int width;
        public int height;
        public int scale;
        public long chatId;
        public static final int CONSTRUCTOR = -152660070;

        public GetMapThumbnailFile() {
        }

        public GetMapThumbnailFile(TdApi.Location var1, int var2, int var3, int var4, int var5, long var6) {
            this.location = var1;
            this.zoom = var2;
            this.width = var3;
            this.height = var4;
            this.scale = var5;
            this.chatId = var6;
        }

        public int getConstructor() {
            return -152660070;
        }
    }

    public static class GetLoginUrlInfo extends TdApi.Function {
        public long chatId;
        public long messageId;
        public int buttonId;
        public static final int CONSTRUCTOR = -980042966;

        public GetLoginUrlInfo() {
        }

        public GetLoginUrlInfo(long var1, long var3, int var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.buttonId = var5;
        }

        public int getConstructor() {
            return -980042966;
        }
    }

    public static class GetLoginUrl extends TdApi.Function {
        public long chatId;
        public long messageId;
        public int buttonId;
        public boolean allowWriteAccess;
        public static final int CONSTRUCTOR = 694973925;

        public GetLoginUrl() {
        }

        public GetLoginUrl(long var1, long var3, int var5, boolean var6) {
            this.chatId = var1;
            this.messageId = var3;
            this.buttonId = var5;
            this.allowWriteAccess = var6;
        }

        public int getConstructor() {
            return 694973925;
        }
    }

    public static class GetLogVerbosityLevel extends TdApi.Function {
        public static final int CONSTRUCTOR = 594057956;

        public GetLogVerbosityLevel() {
        }

        public int getConstructor() {
            return 594057956;
        }
    }

    public static class GetLogTags extends TdApi.Function {
        public static final int CONSTRUCTOR = -254449190;

        public GetLogTags() {
        }

        public int getConstructor() {
            return -254449190;
        }
    }

    public static class GetLogTagVerbosityLevel extends TdApi.Function {
        public String tag;
        public static final int CONSTRUCTOR = 951004547;

        public GetLogTagVerbosityLevel() {
        }

        public GetLogTagVerbosityLevel(String var1) {
            this.tag = var1;
        }

        public int getConstructor() {
            return 951004547;
        }
    }

    public static class GetLogStream extends TdApi.Function {
        public static final int CONSTRUCTOR = 1167608667;

        public GetLogStream() {
        }

        public int getConstructor() {
            return 1167608667;
        }
    }

    public static class GetLocalizationTargetInfo extends TdApi.Function {
        public boolean onlyLocal;
        public static final int CONSTRUCTOR = 1849499526;

        public GetLocalizationTargetInfo() {
        }

        public GetLocalizationTargetInfo(boolean var1) {
            this.onlyLocal = var1;
        }

        public int getConstructor() {
            return 1849499526;
        }
    }

    public static class GetLanguagePackStrings extends TdApi.Function {
        public String languagePackId;
        public String[] keys;
        public static final int CONSTRUCTOR = 1246259088;

        public GetLanguagePackStrings() {
        }

        public GetLanguagePackStrings(String var1, String[] var2) {
            this.languagePackId = var1;
            this.keys = var2;
        }

        public int getConstructor() {
            return 1246259088;
        }
    }

    public static class GetLanguagePackString extends TdApi.Function {
        public String languagePackDatabasePath;
        public String localizationTarget;
        public String languagePackId;
        public String key;
        public static final int CONSTRUCTOR = 150789747;

        public GetLanguagePackString() {
        }

        public GetLanguagePackString(String var1, String var2, String var3, String var4) {
            this.languagePackDatabasePath = var1;
            this.localizationTarget = var2;
            this.languagePackId = var3;
            this.key = var4;
        }

        public int getConstructor() {
            return 150789747;
        }
    }

    public static class GetLanguagePackInfo extends TdApi.Function {
        public String languagePackId;
        public static final int CONSTRUCTOR = 2077809320;

        public GetLanguagePackInfo() {
        }

        public GetLanguagePackInfo(String var1) {
            this.languagePackId = var1;
        }

        public int getConstructor() {
            return 2077809320;
        }
    }

    public static class GetJsonValue extends TdApi.Function {
        public String json;
        public static final int CONSTRUCTOR = -1829086715;

        public GetJsonValue() {
        }

        public GetJsonValue(String var1) {
            this.json = var1;
        }

        public int getConstructor() {
            return -1829086715;
        }
    }

    public static class GetJsonString extends TdApi.Function {
        public TdApi.JsonValue jsonValue;
        public static final int CONSTRUCTOR = 663458849;

        public GetJsonString() {
        }

        public GetJsonString(TdApi.JsonValue var1) {
            this.jsonValue = var1;
        }

        public int getConstructor() {
            return 663458849;
        }
    }

    public static class GetInviteText extends TdApi.Function {
        public static final int CONSTRUCTOR = 794573512;

        public GetInviteText() {
        }

        public int getConstructor() {
            return 794573512;
        }
    }

    public static class GetInstalledStickerSets extends TdApi.Function {
        public boolean isMasks;
        public static final int CONSTRUCTOR = 1214523749;

        public GetInstalledStickerSets() {
        }

        public GetInstalledStickerSets(boolean var1) {
            this.isMasks = var1;
        }

        public int getConstructor() {
            return 1214523749;
        }
    }

    public static class GetInlineQueryResults extends TdApi.Function {
        public int botUserId;
        public long chatId;
        public TdApi.Location userLocation;
        public String query;
        public String offset;
        public static final int CONSTRUCTOR = -1182511172;

        public GetInlineQueryResults() {
        }

        public GetInlineQueryResults(int var1, long var2, TdApi.Location var4, String var5, String var6) {
            this.botUserId = var1;
            this.chatId = var2;
            this.userLocation = var4;
            this.query = var5;
            this.offset = var6;
        }

        public int getConstructor() {
            return -1182511172;
        }
    }

    public static class GetInlineGameHighScores extends TdApi.Function {
        public String inlineMessageId;
        public int userId;
        public static final int CONSTRUCTOR = -1833445800;

        public GetInlineGameHighScores() {
        }

        public GetInlineGameHighScores(String var1, int var2) {
            this.inlineMessageId = var1;
            this.userId = var2;
        }

        public int getConstructor() {
            return -1833445800;
        }
    }

    public static class GetInactiveSupergroupChats extends TdApi.Function {
        public static final int CONSTRUCTOR = -657720907;

        public GetInactiveSupergroupChats() {
        }

        public int getConstructor() {
            return -657720907;
        }
    }

    public static class GetImportedContactCount extends TdApi.Function {
        public static final int CONSTRUCTOR = -656336346;

        public GetImportedContactCount() {
        }

        public int getConstructor() {
            return -656336346;
        }
    }

    public static class GetGroupsInCommon extends TdApi.Function {
        public int userId;
        public long offsetChatId;
        public int limit;
        public static final int CONSTRUCTOR = -23238689;

        public GetGroupsInCommon() {
        }

        public GetGroupsInCommon(int var1, long var2, int var4) {
            this.userId = var1;
            this.offsetChatId = var2;
            this.limit = var4;
        }

        public int getConstructor() {
            return -23238689;
        }
    }

    public static class GetGameHighScores extends TdApi.Function {
        public long chatId;
        public long messageId;
        public int userId;
        public static final int CONSTRUCTOR = 1920923753;

        public GetGameHighScores() {
        }

        public GetGameHighScores(long var1, long var3, int var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.userId = var5;
        }

        public int getConstructor() {
            return 1920923753;
        }
    }

    public static class GetFileMimeType extends TdApi.Function {
        public String fileName;
        public static final int CONSTRUCTOR = -2073879671;

        public GetFileMimeType() {
        }

        public GetFileMimeType(String var1) {
            this.fileName = var1;
        }

        public int getConstructor() {
            return -2073879671;
        }
    }

    public static class GetFileExtension extends TdApi.Function {
        public String mimeType;
        public static final int CONSTRUCTOR = -106055372;

        public GetFileExtension() {
        }

        public GetFileExtension(String var1) {
            this.mimeType = var1;
        }

        public int getConstructor() {
            return -106055372;
        }
    }

    public static class GetFileDownloadedPrefixSize extends TdApi.Function {
        public int fileId;
        public int offset;
        public static final int CONSTRUCTOR = -1668864864;

        public GetFileDownloadedPrefixSize() {
        }

        public GetFileDownloadedPrefixSize(int var1, int var2) {
            this.fileId = var1;
            this.offset = var2;
        }

        public int getConstructor() {
            return -1668864864;
        }
    }

    public static class GetFile extends TdApi.Function {
        public int fileId;
        public static final int CONSTRUCTOR = 1553923406;

        public GetFile() {
        }

        public GetFile(int var1) {
            this.fileId = var1;
        }

        public int getConstructor() {
            return 1553923406;
        }
    }

    public static class GetFavoriteStickers extends TdApi.Function {
        public static final int CONSTRUCTOR = -338964672;

        public GetFavoriteStickers() {
        }

        public int getConstructor() {
            return -338964672;
        }
    }

    public static class GetEmojiSuggestionsUrl extends TdApi.Function {
        public String languageCode;
        public static final int CONSTRUCTOR = -1404101841;

        public GetEmojiSuggestionsUrl() {
        }

        public GetEmojiSuggestionsUrl(String var1) {
            this.languageCode = var1;
        }

        public int getConstructor() {
            return -1404101841;
        }
    }

    public static class GetDeepLinkInfo extends TdApi.Function {
        public String link;
        public static final int CONSTRUCTOR = 680673150;

        public GetDeepLinkInfo() {
        }

        public GetDeepLinkInfo(String var1) {
            this.link = var1;
        }

        public int getConstructor() {
            return 680673150;
        }
    }

    public static class GetDatabaseStatistics extends TdApi.Function {
        public static final int CONSTRUCTOR = -1942760263;

        public GetDatabaseStatistics() {
        }

        public int getConstructor() {
            return -1942760263;
        }
    }

    public static class GetCurrentState extends TdApi.Function {
        public static final int CONSTRUCTOR = -1191417719;

        public GetCurrentState() {
        }

        public int getConstructor() {
            return -1191417719;
        }
    }

    public static class GetCreatedPublicChats extends TdApi.Function {
        public TdApi.PublicChatType type;
        public static final int CONSTRUCTOR = 710354415;

        public GetCreatedPublicChats() {
        }

        public GetCreatedPublicChats(TdApi.PublicChatType var1) {
            this.type = var1;
        }

        public int getConstructor() {
            return 710354415;
        }
    }

    public static class GetCountryCode extends TdApi.Function {
        public static final int CONSTRUCTOR = 1540593906;

        public GetCountryCode() {
        }

        public int getConstructor() {
            return 1540593906;
        }
    }

    public static class GetContacts extends TdApi.Function {
        public static final int CONSTRUCTOR = -1417722768;

        public GetContacts() {
        }

        public int getConstructor() {
            return -1417722768;
        }
    }

    public static class GetConnectedWebsites extends TdApi.Function {
        public static final int CONSTRUCTOR = -170536110;

        public GetConnectedWebsites() {
        }

        public int getConstructor() {
            return -170536110;
        }
    }

    public static class GetChats extends TdApi.Function {
        public TdApi.ChatList chatList;
        public long offsetOrder;
        public long offsetChatId;
        public int limit;
        public static final int CONSTRUCTOR = 1847129537;

        public GetChats() {
        }

        public GetChats(TdApi.ChatList var1, long var2, long var4, int var6) {
            this.chatList = var1;
            this.offsetOrder = var2;
            this.offsetChatId = var4;
            this.limit = var6;
        }

        public int getConstructor() {
            return 1847129537;
        }
    }

    public static class GetChatStatisticsUrl extends TdApi.Function {
        public long chatId;
        public String parameters;
        public boolean isDark;
        public static final int CONSTRUCTOR = 1114621183;

        public GetChatStatisticsUrl() {
        }

        public GetChatStatisticsUrl(long var1, String var3, boolean var4) {
            this.chatId = var1;
            this.parameters = var3;
            this.isDark = var4;
        }

        public int getConstructor() {
            return 1114621183;
        }
    }

    public static class GetChatScheduledMessages extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = -549638149;

        public GetChatScheduledMessages() {
        }

        public GetChatScheduledMessages(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return -549638149;
        }
    }

    public static class GetChatPinnedMessage extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = 359865008;

        public GetChatPinnedMessage() {
        }

        public GetChatPinnedMessage(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return 359865008;
        }
    }

    public static class GetChatNotificationSettingsExceptions extends TdApi.Function {
        public TdApi.NotificationSettingsScope scope;
        public boolean compareSound;
        public static final int CONSTRUCTOR = 201199121;

        public GetChatNotificationSettingsExceptions() {
        }

        public GetChatNotificationSettingsExceptions(TdApi.NotificationSettingsScope var1, boolean var2) {
            this.scope = var1;
            this.compareSound = var2;
        }

        public int getConstructor() {
            return 201199121;
        }
    }

    public static class GetChatMessageCount extends TdApi.Function {
        public long chatId;
        public TdApi.SearchMessagesFilter filter;
        public boolean returnLocal;
        public static final int CONSTRUCTOR = 205435308;

        public GetChatMessageCount() {
        }

        public GetChatMessageCount(long var1, TdApi.SearchMessagesFilter var3, boolean var4) {
            this.chatId = var1;
            this.filter = var3;
            this.returnLocal = var4;
        }

        public int getConstructor() {
            return 205435308;
        }
    }

    public static class GetChatMessageByDate extends TdApi.Function {
        public long chatId;
        public int date;
        public static final int CONSTRUCTOR = 1062564150;

        public GetChatMessageByDate() {
        }

        public GetChatMessageByDate(long var1, int var3) {
            this.chatId = var1;
            this.date = var3;
        }

        public int getConstructor() {
            return 1062564150;
        }
    }

    public static class GetChatMember extends TdApi.Function {
        public long chatId;
        public int userId;
        public static final int CONSTRUCTOR = 677085892;

        public GetChatMember() {
        }

        public GetChatMember(long var1, int var3) {
            this.chatId = var1;
            this.userId = var3;
        }

        public int getConstructor() {
            return 677085892;
        }
    }

    public static class GetChatHistory extends TdApi.Function {
        public long chatId;
        public long fromMessageId;
        public int offset;
        public int limit;
        public boolean onlyLocal;
        public static final int CONSTRUCTOR = -799960451;

        public GetChatHistory() {
        }

        public GetChatHistory(long var1, long var3, int var5, int var6, boolean var7) {
            this.chatId = var1;
            this.fromMessageId = var3;
            this.offset = var5;
            this.limit = var6;
            this.onlyLocal = var7;
        }

        public int getConstructor() {
            return -799960451;
        }
    }

    public static class GetChatEventLog extends TdApi.Function {
        public long chatId;
        public String query;
        public long fromEventId;
        public int limit;
        public TdApi.ChatEventLogFilters filters;
        public int[] userIds;
        public static final int CONSTRUCTOR = 206900967;

        public GetChatEventLog() {
        }

        public GetChatEventLog(long var1, String var3, long var4, int var6, TdApi.ChatEventLogFilters var7, int[] var8) {
            this.chatId = var1;
            this.query = var3;
            this.fromEventId = var4;
            this.limit = var6;
            this.filters = var7;
            this.userIds = var8;
        }

        public int getConstructor() {
            return 206900967;
        }
    }

    public static class GetChatAdministrators extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = 1544468155;

        public GetChatAdministrators() {
        }

        public GetChatAdministrators(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return 1544468155;
        }
    }

    public static class GetChat extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = 1866601536;

        public GetChat() {
        }

        public GetChat(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return 1866601536;
        }
    }

    public static class GetCallbackQueryAnswer extends TdApi.Function {
        public long chatId;
        public long messageId;
        public TdApi.CallbackQueryPayload payload;
        public static final int CONSTRUCTOR = 116357727;

        public GetCallbackQueryAnswer() {
        }

        public GetCallbackQueryAnswer(long var1, long var3, TdApi.CallbackQueryPayload var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.payload = var5;
        }

        public int getConstructor() {
            return 116357727;
        }
    }

    public static class GetBlockedUsers extends TdApi.Function {
        public int offset;
        public int limit;
        public static final int CONSTRUCTOR = -742912777;

        public GetBlockedUsers() {
        }

        public GetBlockedUsers(int var1, int var2) {
            this.offset = var1;
            this.limit = var2;
        }

        public int getConstructor() {
            return -742912777;
        }
    }

    public static class GetBasicGroupFullInfo extends TdApi.Function {
        public int basicGroupId;
        public static final int CONSTRUCTOR = 1770517905;

        public GetBasicGroupFullInfo() {
        }

        public GetBasicGroupFullInfo(int var1) {
            this.basicGroupId = var1;
        }

        public int getConstructor() {
            return 1770517905;
        }
    }

    public static class GetBasicGroup extends TdApi.Function {
        public int basicGroupId;
        public static final int CONSTRUCTOR = 561775568;

        public GetBasicGroup() {
        }

        public GetBasicGroup(int var1) {
            this.basicGroupId = var1;
        }

        public int getConstructor() {
            return 561775568;
        }
    }

    public static class GetBackgrounds extends TdApi.Function {
        public boolean forDarkTheme;
        public static final int CONSTRUCTOR = 249072633;

        public GetBackgrounds() {
        }

        public GetBackgrounds(boolean var1) {
            this.forDarkTheme = var1;
        }

        public int getConstructor() {
            return 249072633;
        }
    }

    public static class GetBackgroundUrl extends TdApi.Function {
        public String name;
        public TdApi.BackgroundType type;
        public static final int CONSTRUCTOR = 733769682;

        public GetBackgroundUrl() {
        }

        public GetBackgroundUrl(String var1, TdApi.BackgroundType var2) {
            this.name = var1;
            this.type = var2;
        }

        public int getConstructor() {
            return 733769682;
        }
    }

    public static class GetAutoDownloadSettingsPresets extends TdApi.Function {
        public static final int CONSTRUCTOR = -1721088201;

        public GetAutoDownloadSettingsPresets() {
        }

        public int getConstructor() {
            return -1721088201;
        }
    }

    public static class GetAuthorizationState extends TdApi.Function {
        public static final int CONSTRUCTOR = 1949154877;

        public GetAuthorizationState() {
        }

        public int getConstructor() {
            return 1949154877;
        }
    }

    public static class GetAttachedStickerSets extends TdApi.Function {
        public int fileId;
        public static final int CONSTRUCTOR = 1302172429;

        public GetAttachedStickerSets() {
        }

        public GetAttachedStickerSets(int var1) {
            this.fileId = var1;
        }

        public int getConstructor() {
            return 1302172429;
        }
    }

    public static class GetArchivedStickerSets extends TdApi.Function {
        public boolean isMasks;
        public long offsetStickerSetId;
        public int limit;
        public static final int CONSTRUCTOR = 1996943238;

        public GetArchivedStickerSets() {
        }

        public GetArchivedStickerSets(boolean var1, long var2, int var4) {
            this.isMasks = var1;
            this.offsetStickerSetId = var2;
            this.limit = var4;
        }

        public int getConstructor() {
            return 1996943238;
        }
    }

    public static class GetApplicationConfig extends TdApi.Function {
        public static final int CONSTRUCTOR = -1823144318;

        public GetApplicationConfig() {
        }

        public int getConstructor() {
            return -1823144318;
        }
    }

    public static class GetAllPassportElements extends TdApi.Function {
        public String password;
        public static final int CONSTRUCTOR = -2038945045;

        public GetAllPassportElements() {
        }

        public GetAllPassportElements(String var1) {
            this.password = var1;
        }

        public int getConstructor() {
            return -2038945045;
        }
    }

    public static class GetActiveSessions extends TdApi.Function {
        public static final int CONSTRUCTOR = 1119710526;

        public GetActiveSessions() {
        }

        public int getConstructor() {
            return 1119710526;
        }
    }

    public static class GetActiveLiveLocationMessages extends TdApi.Function {
        public static final int CONSTRUCTOR = -1425459567;

        public GetActiveLiveLocationMessages() {
        }

        public int getConstructor() {
            return -1425459567;
        }
    }

    public static class GetAccountTtl extends TdApi.Function {
        public static final int CONSTRUCTOR = -443905161;

        public GetAccountTtl() {
        }

        public int getConstructor() {
            return -443905161;
        }
    }

    public static class GenerateChatInviteLink extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = 1945532500;

        public GenerateChatInviteLink() {
        }

        public GenerateChatInviteLink(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return 1945532500;
        }
    }

    public static class ForwardMessages extends TdApi.Function {
        public long chatId;
        public long fromChatId;
        public long[] messageIds;
        public TdApi.SendMessageOptions options;
        public boolean asAlbum;
        public boolean sendCopy;
        public boolean removeCaption;
        public static final int CONSTRUCTOR = -1633531094;

        public ForwardMessages() {
        }

        public ForwardMessages(long var1, long var3, long[] var5, TdApi.SendMessageOptions var6, boolean var7, boolean var8, boolean var9) {
            this.chatId = var1;
            this.fromChatId = var3;
            this.messageIds = var5;
            this.options = var6;
            this.asAlbum = var7;
            this.sendCopy = var8;
            this.removeCaption = var9;
        }

        public int getConstructor() {
            return -1633531094;
        }
    }

    public static class FinishFileGeneration extends TdApi.Function {
        public long generationId;
        public TdApi.Error error;
        public static final int CONSTRUCTOR = -1055060835;

        public FinishFileGeneration() {
        }

        public FinishFileGeneration(long var1, TdApi.Error var3) {
            this.generationId = var1;
            this.error = var3;
        }

        public int getConstructor() {
            return -1055060835;
        }
    }

    public static class EnableProxy extends TdApi.Function {
        public int proxyId;
        public static final int CONSTRUCTOR = 1494450838;

        public EnableProxy() {
        }

        public EnableProxy(int var1) {
            this.proxyId = var1;
        }

        public int getConstructor() {
            return 1494450838;
        }
    }

    public static class EditProxy extends TdApi.Function {
        public int proxyId;
        public String server;
        public int port;
        public boolean enable;
        public TdApi.ProxyType type;
        public static final int CONSTRUCTOR = -1605883821;

        public EditProxy() {
        }

        public EditProxy(int var1, String var2, int var3, boolean var4, TdApi.ProxyType var5) {
            this.proxyId = var1;
            this.server = var2;
            this.port = var3;
            this.enable = var4;
            this.type = var5;
        }

        public int getConstructor() {
            return -1605883821;
        }
    }

    public static class EditMessageText extends TdApi.Function {
        public long chatId;
        public long messageId;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 196272567;

        public EditMessageText() {
        }

        public EditMessageText(long var1, long var3, TdApi.ReplyMarkup var5, TdApi.InputMessageContent var6) {
            this.chatId = var1;
            this.messageId = var3;
            this.replyMarkup = var5;
            this.inputMessageContent = var6;
        }

        public int getConstructor() {
            return 196272567;
        }
    }

    public static class EditMessageSchedulingState extends TdApi.Function {
        public long chatId;
        public long messageId;
        public TdApi.MessageSchedulingState schedulingState;
        public static final int CONSTRUCTOR = -1372976192;

        public EditMessageSchedulingState() {
        }

        public EditMessageSchedulingState(long var1, long var3, TdApi.MessageSchedulingState var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.schedulingState = var5;
        }

        public int getConstructor() {
            return -1372976192;
        }
    }

    public static class EditMessageReplyMarkup extends TdApi.Function {
        public long chatId;
        public long messageId;
        public TdApi.ReplyMarkup replyMarkup;
        public static final int CONSTRUCTOR = 332127881;

        public EditMessageReplyMarkup() {
        }

        public EditMessageReplyMarkup(long var1, long var3, TdApi.ReplyMarkup var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.replyMarkup = var5;
        }

        public int getConstructor() {
            return 332127881;
        }
    }

    public static class EditMessageMedia extends TdApi.Function {
        public long chatId;
        public long messageId;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = -1152678125;

        public EditMessageMedia() {
        }

        public EditMessageMedia(long var1, long var3, TdApi.ReplyMarkup var5, TdApi.InputMessageContent var6) {
            this.chatId = var1;
            this.messageId = var3;
            this.replyMarkup = var5;
            this.inputMessageContent = var6;
        }

        public int getConstructor() {
            return -1152678125;
        }
    }

    public static class EditMessageLiveLocation extends TdApi.Function {
        public long chatId;
        public long messageId;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.Location location;
        public static final int CONSTRUCTOR = -1146772745;

        public EditMessageLiveLocation() {
        }

        public EditMessageLiveLocation(long var1, long var3, TdApi.ReplyMarkup var5, TdApi.Location var6) {
            this.chatId = var1;
            this.messageId = var3;
            this.replyMarkup = var5;
            this.location = var6;
        }

        public int getConstructor() {
            return -1146772745;
        }
    }

    public static class EditMessageCaption extends TdApi.Function {
        public long chatId;
        public long messageId;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.FormattedText caption;
        public static final int CONSTRUCTOR = 1154677038;

        public EditMessageCaption() {
        }

        public EditMessageCaption(long var1, long var3, TdApi.ReplyMarkup var5, TdApi.FormattedText var6) {
            this.chatId = var1;
            this.messageId = var3;
            this.replyMarkup = var5;
            this.caption = var6;
        }

        public int getConstructor() {
            return 1154677038;
        }
    }

    public static class EditInlineMessageText extends TdApi.Function {
        public String inlineMessageId;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = -855457307;

        public EditInlineMessageText() {
        }

        public EditInlineMessageText(String var1, TdApi.ReplyMarkup var2, TdApi.InputMessageContent var3) {
            this.inlineMessageId = var1;
            this.replyMarkup = var2;
            this.inputMessageContent = var3;
        }

        public int getConstructor() {
            return -855457307;
        }
    }

    public static class EditInlineMessageReplyMarkup extends TdApi.Function {
        public String inlineMessageId;
        public TdApi.ReplyMarkup replyMarkup;
        public static final int CONSTRUCTOR = -67565858;

        public EditInlineMessageReplyMarkup() {
        }

        public EditInlineMessageReplyMarkup(String var1, TdApi.ReplyMarkup var2) {
            this.inlineMessageId = var1;
            this.replyMarkup = var2;
        }

        public int getConstructor() {
            return -67565858;
        }
    }

    public static class EditInlineMessageMedia extends TdApi.Function {
        public String inlineMessageId;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 23553921;

        public EditInlineMessageMedia() {
        }

        public EditInlineMessageMedia(String var1, TdApi.ReplyMarkup var2, TdApi.InputMessageContent var3) {
            this.inlineMessageId = var1;
            this.replyMarkup = var2;
            this.inputMessageContent = var3;
        }

        public int getConstructor() {
            return 23553921;
        }
    }

    public static class EditInlineMessageLiveLocation extends TdApi.Function {
        public String inlineMessageId;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.Location location;
        public static final int CONSTRUCTOR = 655046316;

        public EditInlineMessageLiveLocation() {
        }

        public EditInlineMessageLiveLocation(String var1, TdApi.ReplyMarkup var2, TdApi.Location var3) {
            this.inlineMessageId = var1;
            this.replyMarkup = var2;
            this.location = var3;
        }

        public int getConstructor() {
            return 655046316;
        }
    }

    public static class EditInlineMessageCaption extends TdApi.Function {
        public String inlineMessageId;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.FormattedText caption;
        public static final int CONSTRUCTOR = -760985929;

        public EditInlineMessageCaption() {
        }

        public EditInlineMessageCaption(String var1, TdApi.ReplyMarkup var2, TdApi.FormattedText var3) {
            this.inlineMessageId = var1;
            this.replyMarkup = var2;
            this.caption = var3;
        }

        public int getConstructor() {
            return -760985929;
        }
    }

    public static class EditCustomLanguagePackInfo extends TdApi.Function {
        public TdApi.LanguagePackInfo info;
        public static final int CONSTRUCTOR = 1320751257;

        public EditCustomLanguagePackInfo() {
        }

        public EditCustomLanguagePackInfo(TdApi.LanguagePackInfo var1) {
            this.info = var1;
        }

        public int getConstructor() {
            return 1320751257;
        }
    }

    public static class DownloadFile extends TdApi.Function {
        public int fileId;
        public int priority;
        public int offset;
        public int limit;
        public boolean synchronous;
        public static final int CONSTRUCTOR = -1102026662;

        public DownloadFile() {
        }

        public DownloadFile(int var1, int var2, int var3, int var4, boolean var5) {
            this.fileId = var1;
            this.priority = var2;
            this.offset = var3;
            this.limit = var4;
            this.synchronous = var5;
        }

        public int getConstructor() {
            return -1102026662;
        }
    }

    public static class DisconnectWebsite extends TdApi.Function {
        public long websiteId;
        public static final int CONSTRUCTOR = -778767395;

        public DisconnectWebsite() {
        }

        public DisconnectWebsite(long var1) {
            this.websiteId = var1;
        }

        public int getConstructor() {
            return -778767395;
        }
    }

    public static class DisconnectAllWebsites extends TdApi.Function {
        public static final int CONSTRUCTOR = -1082985981;

        public DisconnectAllWebsites() {
        }

        public int getConstructor() {
            return -1082985981;
        }
    }

    public static class DiscardCall extends TdApi.Function {
        public int callId;
        public boolean isDisconnected;
        public int duration;
        public long connectionId;
        public static final int CONSTRUCTOR = -923187372;

        public DiscardCall() {
        }

        public DiscardCall(int var1, boolean var2, int var3, long var4) {
            this.callId = var1;
            this.isDisconnected = var2;
            this.duration = var3;
            this.connectionId = var4;
        }

        public int getConstructor() {
            return -923187372;
        }
    }

    public static class DisableProxy extends TdApi.Function {
        public static final int CONSTRUCTOR = -2100095102;

        public DisableProxy() {
        }

        public int getConstructor() {
            return -2100095102;
        }
    }

    public static class Destroy extends TdApi.Function {
        public static final int CONSTRUCTOR = 685331274;

        public Destroy() {
        }

        public int getConstructor() {
            return 685331274;
        }
    }

    public static class DeleteSupergroup extends TdApi.Function {
        public int supergroupId;
        public static final int CONSTRUCTOR = -1999855965;

        public DeleteSupergroup() {
        }

        public DeleteSupergroup(int var1) {
            this.supergroupId = var1;
        }

        public int getConstructor() {
            return -1999855965;
        }
    }

    public static class DeleteSavedOrderInfo extends TdApi.Function {
        public static final int CONSTRUCTOR = 1629058164;

        public DeleteSavedOrderInfo() {
        }

        public int getConstructor() {
            return 1629058164;
        }
    }

    public static class DeleteSavedCredentials extends TdApi.Function {
        public static final int CONSTRUCTOR = 826300114;

        public DeleteSavedCredentials() {
        }

        public int getConstructor() {
            return 826300114;
        }
    }

    public static class DeleteProfilePhoto extends TdApi.Function {
        public long profilePhotoId;
        public static final int CONSTRUCTOR = 1319794625;

        public DeleteProfilePhoto() {
        }

        public DeleteProfilePhoto(long var1) {
            this.profilePhotoId = var1;
        }

        public int getConstructor() {
            return 1319794625;
        }
    }

    public static class DeletePassportElement extends TdApi.Function {
        public TdApi.PassportElementType type;
        public static final int CONSTRUCTOR = -1719555468;

        public DeletePassportElement() {
        }

        public DeletePassportElement(TdApi.PassportElementType var1) {
            this.type = var1;
        }

        public int getConstructor() {
            return -1719555468;
        }
    }

    public static class DeleteMessages extends TdApi.Function {
        public long chatId;
        public long[] messageIds;
        public boolean revoke;
        public static final int CONSTRUCTOR = 1130090173;

        public DeleteMessages() {
        }

        public DeleteMessages(long var1, long[] var3, boolean var4) {
            this.chatId = var1;
            this.messageIds = var3;
            this.revoke = var4;
        }

        public int getConstructor() {
            return 1130090173;
        }
    }

    public static class DeleteLanguagePack extends TdApi.Function {
        public String languagePackId;
        public static final int CONSTRUCTOR = -2108761026;

        public DeleteLanguagePack() {
        }

        public DeleteLanguagePack(String var1) {
            this.languagePackId = var1;
        }

        public int getConstructor() {
            return -2108761026;
        }
    }

    public static class DeleteFile extends TdApi.Function {
        public int fileId;
        public static final int CONSTRUCTOR = 1807653676;

        public DeleteFile() {
        }

        public DeleteFile(int var1) {
            this.fileId = var1;
        }

        public int getConstructor() {
            return 1807653676;
        }
    }

    public static class DeleteChatReplyMarkup extends TdApi.Function {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = 100637531;

        public DeleteChatReplyMarkup() {
        }

        public DeleteChatReplyMarkup(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        public int getConstructor() {
            return 100637531;
        }
    }

    public static class DeleteChatMessagesFromUser extends TdApi.Function {
        public long chatId;
        public int userId;
        public static final int CONSTRUCTOR = -1599689199;

        public DeleteChatMessagesFromUser() {
        }

        public DeleteChatMessagesFromUser(long var1, int var3) {
            this.chatId = var1;
            this.userId = var3;
        }

        public int getConstructor() {
            return -1599689199;
        }
    }

    public static class DeleteChatHistory extends TdApi.Function {
        public long chatId;
        public boolean removeFromChatList;
        public boolean revoke;
        public static final int CONSTRUCTOR = -1472081761;

        public DeleteChatHistory() {
        }

        public DeleteChatHistory(long var1, boolean var3, boolean var4) {
            this.chatId = var1;
            this.removeFromChatList = var3;
            this.revoke = var4;
        }

        public int getConstructor() {
            return -1472081761;
        }
    }

    public static class DeleteAccount extends TdApi.Function {
        public String reason;
        public static final int CONSTRUCTOR = -1203056508;

        public DeleteAccount() {
        }

        public DeleteAccount(String var1) {
            this.reason = var1;
        }

        public int getConstructor() {
            return -1203056508;
        }
    }

    public static class CreateTemporaryPassword extends TdApi.Function {
        public String password;
        public int validFor;
        public static final int CONSTRUCTOR = -1626509434;

        public CreateTemporaryPassword() {
        }

        public CreateTemporaryPassword(String var1, int var2) {
            this.password = var1;
            this.validFor = var2;
        }

        public int getConstructor() {
            return -1626509434;
        }
    }

    public static class CreateSupergroupChat extends TdApi.Function {
        public int supergroupId;
        public boolean force;
        public static final int CONSTRUCTOR = 352742758;

        public CreateSupergroupChat() {
        }

        public CreateSupergroupChat(int var1, boolean var2) {
            this.supergroupId = var1;
            this.force = var2;
        }

        public int getConstructor() {
            return 352742758;
        }
    }

    public static class CreateSecretChat extends TdApi.Function {
        public int secretChatId;
        public static final int CONSTRUCTOR = 1930285615;

        public CreateSecretChat() {
        }

        public CreateSecretChat(int var1) {
            this.secretChatId = var1;
        }

        public int getConstructor() {
            return 1930285615;
        }
    }

    public static class CreatePrivateChat extends TdApi.Function {
        public int userId;
        public boolean force;
        public static final int CONSTRUCTOR = -1807530364;

        public CreatePrivateChat() {
        }

        public CreatePrivateChat(int var1, boolean var2) {
            this.userId = var1;
            this.force = var2;
        }

        public int getConstructor() {
            return -1807530364;
        }
    }

    public static class CreateNewSupergroupChat extends TdApi.Function {
        public String title;
        public boolean isChannel;
        public String description;
        public TdApi.ChatLocation location;
        public static final int CONSTRUCTOR = -8999251;

        public CreateNewSupergroupChat() {
        }

        public CreateNewSupergroupChat(String var1, boolean var2, String var3, TdApi.ChatLocation var4) {
            this.title = var1;
            this.isChannel = var2;
            this.description = var3;
            this.location = var4;
        }

        public int getConstructor() {
            return -8999251;
        }
    }

    public static class CreateNewStickerSet extends TdApi.Function {
        public int userId;
        public String title;
        public String name;
        public boolean isMasks;
        public TdApi.InputSticker[] stickers;
        public static final int CONSTRUCTOR = 205093058;

        public CreateNewStickerSet() {
        }

        public CreateNewStickerSet(int var1, String var2, String var3, boolean var4, TdApi.InputSticker[] var5) {
            this.userId = var1;
            this.title = var2;
            this.name = var3;
            this.isMasks = var4;
            this.stickers = var5;
        }

        public int getConstructor() {
            return 205093058;
        }
    }

    public static class CreateNewSecretChat extends TdApi.Function {
        public int userId;
        public static final int CONSTRUCTOR = 1689344881;

        public CreateNewSecretChat() {
        }

        public CreateNewSecretChat(int var1) {
            this.userId = var1;
        }

        public int getConstructor() {
            return 1689344881;
        }
    }

    public static class CreateNewBasicGroupChat extends TdApi.Function {
        public int[] userIds;
        public String title;
        public static final int CONSTRUCTOR = 1874532069;

        public CreateNewBasicGroupChat() {
        }

        public CreateNewBasicGroupChat(int[] var1, String var2) {
            this.userIds = var1;
            this.title = var2;
        }

        public int getConstructor() {
            return 1874532069;
        }
    }

    public static class CreateCall extends TdApi.Function {
        public int userId;
        public TdApi.CallProtocol protocol;
        public static final int CONSTRUCTOR = -1742408159;

        public CreateCall() {
        }

        public CreateCall(int var1, TdApi.CallProtocol var2) {
            this.userId = var1;
            this.protocol = var2;
        }

        public int getConstructor() {
            return -1742408159;
        }
    }

    public static class CreateBasicGroupChat extends TdApi.Function {
        public int basicGroupId;
        public boolean force;
        public static final int CONSTRUCTOR = 642492777;

        public CreateBasicGroupChat() {
        }

        public CreateBasicGroupChat(int var1, boolean var2) {
            this.basicGroupId = var1;
            this.force = var2;
        }

        public int getConstructor() {
            return 642492777;
        }
    }

    public static class ConfirmQrCodeAuthentication extends TdApi.Function {
        public String link;
        public static final int CONSTRUCTOR = -376199379;

        public ConfirmQrCodeAuthentication() {
        }

        public ConfirmQrCodeAuthentication(String var1) {
            this.link = var1;
        }

        public int getConstructor() {
            return -376199379;
        }
    }

    public static class CloseSecretChat extends TdApi.Function {
        public int secretChatId;
        public static final int CONSTRUCTOR = -471006133;

        public CloseSecretChat() {
        }

        public CloseSecretChat(int var1) {
            this.secretChatId = var1;
        }

        public int getConstructor() {
            return -471006133;
        }
    }

    public static class CloseChat extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = 39749353;

        public CloseChat() {
        }

        public CloseChat(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return 39749353;
        }
    }

    public static class Close extends TdApi.Function {
        public static final int CONSTRUCTOR = -1187782273;

        public Close() {
        }

        public int getConstructor() {
            return -1187782273;
        }
    }

    public static class ClearRecentlyFoundChats extends TdApi.Function {
        public static final int CONSTRUCTOR = -285582542;

        public ClearRecentlyFoundChats() {
        }

        public int getConstructor() {
            return -285582542;
        }
    }

    public static class ClearRecentStickers extends TdApi.Function {
        public boolean isAttached;
        public static final int CONSTRUCTOR = -321242684;

        public ClearRecentStickers() {
        }

        public ClearRecentStickers(boolean var1) {
            this.isAttached = var1;
        }

        public int getConstructor() {
            return -321242684;
        }
    }

    public static class ClearImportedContacts extends TdApi.Function {
        public static final int CONSTRUCTOR = 869503298;

        public ClearImportedContacts() {
        }

        public int getConstructor() {
            return 869503298;
        }
    }

    public static class ClearAllDraftMessages extends TdApi.Function {
        public boolean excludeSecretChats;
        public static final int CONSTRUCTOR = -46369573;

        public ClearAllDraftMessages() {
        }

        public ClearAllDraftMessages(boolean var1) {
            this.excludeSecretChats = var1;
        }

        public int getConstructor() {
            return -46369573;
        }
    }

    public static class CleanFileName extends TdApi.Function {
        public String fileName;
        public static final int CONSTRUCTOR = 967964667;

        public CleanFileName() {
        }

        public CleanFileName(String var1) {
            this.fileName = var1;
        }

        public int getConstructor() {
            return 967964667;
        }
    }

    public static class CheckRecoveryEmailAddressCode extends TdApi.Function {
        public String code;
        public static final int CONSTRUCTOR = -1997039589;

        public CheckRecoveryEmailAddressCode() {
        }

        public CheckRecoveryEmailAddressCode(String var1) {
            this.code = var1;
        }

        public int getConstructor() {
            return -1997039589;
        }
    }

    public static class CheckPhoneNumberVerificationCode extends TdApi.Function {
        public String code;
        public static final int CONSTRUCTOR = 1497462718;

        public CheckPhoneNumberVerificationCode() {
        }

        public CheckPhoneNumberVerificationCode(String var1) {
            this.code = var1;
        }

        public int getConstructor() {
            return 1497462718;
        }
    }

    public static class CheckPhoneNumberConfirmationCode extends TdApi.Function {
        public String code;
        public static final int CONSTRUCTOR = -1348060966;

        public CheckPhoneNumberConfirmationCode() {
        }

        public CheckPhoneNumberConfirmationCode(String var1) {
            this.code = var1;
        }

        public int getConstructor() {
            return -1348060966;
        }
    }

    public static class CheckEmailAddressVerificationCode extends TdApi.Function {
        public String code;
        public static final int CONSTRUCTOR = -426386685;

        public CheckEmailAddressVerificationCode() {
        }

        public CheckEmailAddressVerificationCode(String var1) {
            this.code = var1;
        }

        public int getConstructor() {
            return -426386685;
        }
    }

    public static class CheckDatabaseEncryptionKey extends TdApi.Function {
        public byte[] encryptionKey;
        public static final int CONSTRUCTOR = 1018769307;

        public CheckDatabaseEncryptionKey() {
        }

        public CheckDatabaseEncryptionKey(byte[] var1) {
            this.encryptionKey = var1;
        }

        public int getConstructor() {
            return 1018769307;
        }
    }

    public static class CheckCreatedPublicChatsLimit extends TdApi.Function {
        public TdApi.PublicChatType type;
        public static final int CONSTRUCTOR = -445546591;

        public CheckCreatedPublicChatsLimit() {
        }

        public CheckCreatedPublicChatsLimit(TdApi.PublicChatType var1) {
            this.type = var1;
        }

        public int getConstructor() {
            return -445546591;
        }
    }

    public static class CheckChatUsername extends TdApi.Function {
        public long chatId;
        public String username;
        public static final int CONSTRUCTOR = -119119344;

        public CheckChatUsername() {
        }

        public CheckChatUsername(long var1, String var3) {
            this.chatId = var1;
            this.username = var3;
        }

        public int getConstructor() {
            return -119119344;
        }
    }

    public static class CheckChatInviteLink extends TdApi.Function {
        public String inviteLink;
        public static final int CONSTRUCTOR = -496940997;

        public CheckChatInviteLink() {
        }

        public CheckChatInviteLink(String var1) {
            this.inviteLink = var1;
        }

        public int getConstructor() {
            return -496940997;
        }
    }

    public static class CheckChangePhoneNumberCode extends TdApi.Function {
        public String code;
        public static final int CONSTRUCTOR = -1720278429;

        public CheckChangePhoneNumberCode() {
        }

        public CheckChangePhoneNumberCode(String var1) {
            this.code = var1;
        }

        public int getConstructor() {
            return -1720278429;
        }
    }

    public static class CheckAuthenticationPassword extends TdApi.Function {
        public String password;
        public static final int CONSTRUCTOR = -2025698400;

        public CheckAuthenticationPassword() {
        }

        public CheckAuthenticationPassword(String var1) {
            this.password = var1;
        }

        public int getConstructor() {
            return -2025698400;
        }
    }

    public static class CheckAuthenticationCode extends TdApi.Function {
        public String code;
        public static final int CONSTRUCTOR = -302103382;

        public CheckAuthenticationCode() {
        }

        public CheckAuthenticationCode(String var1) {
            this.code = var1;
        }

        public int getConstructor() {
            return -302103382;
        }
    }

    public static class CheckAuthenticationBotToken extends TdApi.Function {
        public String token;
        public static final int CONSTRUCTOR = 639321206;

        public CheckAuthenticationBotToken() {
        }

        public CheckAuthenticationBotToken(String var1) {
            this.token = var1;
        }

        public int getConstructor() {
            return 639321206;
        }
    }

    public static class ChangeStickerSet extends TdApi.Function {
        public long setId;
        public boolean isInstalled;
        public boolean isArchived;
        public static final int CONSTRUCTOR = 449357293;

        public ChangeStickerSet() {
        }

        public ChangeStickerSet(long var1, boolean var3, boolean var4) {
            this.setId = var1;
            this.isInstalled = var3;
            this.isArchived = var4;
        }

        public int getConstructor() {
            return 449357293;
        }
    }

    public static class ChangePhoneNumber extends TdApi.Function {
        public String phoneNumber;
        public TdApi.PhoneNumberAuthenticationSettings settings;
        public static final int CONSTRUCTOR = -124666973;

        public ChangePhoneNumber() {
        }

        public ChangePhoneNumber(String var1, TdApi.PhoneNumberAuthenticationSettings var2) {
            this.phoneNumber = var1;
            this.settings = var2;
        }

        public int getConstructor() {
            return -124666973;
        }
    }

    public static class ChangeImportedContacts extends TdApi.Function {
        public TdApi.Contact[] contacts;
        public static final int CONSTRUCTOR = 1968207955;

        public ChangeImportedContacts() {
        }

        public ChangeImportedContacts(TdApi.Contact[] var1) {
            this.contacts = var1;
        }

        public int getConstructor() {
            return 1968207955;
        }
    }

    public static class CancelUploadFile extends TdApi.Function {
        public int fileId;
        public static final int CONSTRUCTOR = 1623539600;

        public CancelUploadFile() {
        }

        public CancelUploadFile(int var1) {
            this.fileId = var1;
        }

        public int getConstructor() {
            return 1623539600;
        }
    }

    public static class CancelDownloadFile extends TdApi.Function {
        public int fileId;
        public boolean onlyIfPending;
        public static final int CONSTRUCTOR = -1954524450;

        public CancelDownloadFile() {
        }

        public CancelDownloadFile(int var1, boolean var2) {
            this.fileId = var1;
            this.onlyIfPending = var2;
        }

        public int getConstructor() {
            return -1954524450;
        }
    }

    public static class CanTransferOwnership extends TdApi.Function {
        public static final int CONSTRUCTOR = 634602508;

        public CanTransferOwnership() {
        }

        public int getConstructor() {
            return 634602508;
        }
    }

    public static class BlockUser extends TdApi.Function {
        public int userId;
        public static final int CONSTRUCTOR = -1239315139;

        public BlockUser() {
        }

        public BlockUser(int var1) {
            this.userId = var1;
        }

        public int getConstructor() {
            return -1239315139;
        }
    }

    public static class AnswerShippingQuery extends TdApi.Function {
        public long shippingQueryId;
        public TdApi.ShippingOption[] shippingOptions;
        public String errorMessage;
        public static final int CONSTRUCTOR = -434601324;

        public AnswerShippingQuery() {
        }

        public AnswerShippingQuery(long var1, TdApi.ShippingOption[] var3, String var4) {
            this.shippingQueryId = var1;
            this.shippingOptions = var3;
            this.errorMessage = var4;
        }

        public int getConstructor() {
            return -434601324;
        }
    }

    public static class AnswerPreCheckoutQuery extends TdApi.Function {
        public long preCheckoutQueryId;
        public String errorMessage;
        public static final int CONSTRUCTOR = -1486789653;

        public AnswerPreCheckoutQuery() {
        }

        public AnswerPreCheckoutQuery(long var1, String var3) {
            this.preCheckoutQueryId = var1;
            this.errorMessage = var3;
        }

        public int getConstructor() {
            return -1486789653;
        }
    }

    public static class AnswerInlineQuery extends TdApi.Function {
        public long inlineQueryId;
        public boolean isPersonal;
        public TdApi.InputInlineQueryResult[] results;
        public int cacheTime;
        public String nextOffset;
        public String switchPmText;
        public String switchPmParameter;
        public static final int CONSTRUCTOR = 485879477;

        public AnswerInlineQuery() {
        }

        public AnswerInlineQuery(long var1, boolean var3, TdApi.InputInlineQueryResult[] var4, int var5, String var6, String var7, String var8) {
            this.inlineQueryId = var1;
            this.isPersonal = var3;
            this.results = var4;
            this.cacheTime = var5;
            this.nextOffset = var6;
            this.switchPmText = var7;
            this.switchPmParameter = var8;
        }

        public int getConstructor() {
            return 485879477;
        }
    }

    public static class AnswerCustomQuery extends TdApi.Function {
        public long customQueryId;
        public String data;
        public static final int CONSTRUCTOR = -1293603521;

        public AnswerCustomQuery() {
        }

        public AnswerCustomQuery(long var1, String var3) {
            this.customQueryId = var1;
            this.data = var3;
        }

        public int getConstructor() {
            return -1293603521;
        }
    }

    public static class AnswerCallbackQuery extends TdApi.Function {
        public long callbackQueryId;
        public String text;
        public boolean showAlert;
        public String url;
        public int cacheTime;
        public static final int CONSTRUCTOR = -1153028490;

        public AnswerCallbackQuery() {
        }

        public AnswerCallbackQuery(long var1, String var3, boolean var4, String var5, int var6) {
            this.callbackQueryId = var1;
            this.text = var3;
            this.showAlert = var4;
            this.url = var5;
            this.cacheTime = var6;
        }

        public int getConstructor() {
            return -1153028490;
        }
    }

    public static class AddStickerToSet extends TdApi.Function {
        public int userId;
        public String name;
        public TdApi.InputSticker sticker;
        public static final int CONSTRUCTOR = 1422402800;

        public AddStickerToSet() {
        }

        public AddStickerToSet(int var1, String var2, TdApi.InputSticker var3) {
            this.userId = var1;
            this.name = var2;
            this.sticker = var3;
        }

        public int getConstructor() {
            return 1422402800;
        }
    }

    public static class AddSavedAnimation extends TdApi.Function {
        public TdApi.InputFile animation;
        public static final int CONSTRUCTOR = -1538525088;

        public AddSavedAnimation() {
        }

        public AddSavedAnimation(TdApi.InputFile var1) {
            this.animation = var1;
        }

        public int getConstructor() {
            return -1538525088;
        }
    }

    public static class AddRecentlyFoundChat extends TdApi.Function {
        public long chatId;
        public static final int CONSTRUCTOR = -1746396787;

        public AddRecentlyFoundChat() {
        }

        public AddRecentlyFoundChat(long var1) {
            this.chatId = var1;
        }

        public int getConstructor() {
            return -1746396787;
        }
    }

    public static class AddRecentSticker extends TdApi.Function {
        public boolean isAttached;
        public TdApi.InputFile sticker;
        public static final int CONSTRUCTOR = -1478109026;

        public AddRecentSticker() {
        }

        public AddRecentSticker(boolean var1, TdApi.InputFile var2) {
            this.isAttached = var1;
            this.sticker = var2;
        }

        public int getConstructor() {
            return -1478109026;
        }
    }

    public static class AddProxy extends TdApi.Function {
        public String server;
        public int port;
        public boolean enable;
        public TdApi.ProxyType type;
        public static final int CONSTRUCTOR = 331529432;

        public AddProxy() {
        }

        public AddProxy(String var1, int var2, boolean var3, TdApi.ProxyType var4) {
            this.server = var1;
            this.port = var2;
            this.enable = var3;
            this.type = var4;
        }

        public int getConstructor() {
            return 331529432;
        }
    }

    public static class AddNetworkStatistics extends TdApi.Function {
        public TdApi.NetworkStatisticsEntry entry;
        public static final int CONSTRUCTOR = 1264825305;

        public AddNetworkStatistics() {
        }

        public AddNetworkStatistics(TdApi.NetworkStatisticsEntry var1) {
            this.entry = var1;
        }

        public int getConstructor() {
            return 1264825305;
        }
    }

    public static class AddLogMessage extends TdApi.Function {
        public int verbosityLevel;
        public String text;
        public static final int CONSTRUCTOR = 1597427692;

        public AddLogMessage() {
        }

        public AddLogMessage(int var1, String var2) {
            this.verbosityLevel = var1;
            this.text = var2;
        }

        public int getConstructor() {
            return 1597427692;
        }
    }

    public static class AddLocalMessage extends TdApi.Function {
        public long chatId;
        public int senderUserId;
        public long replyToMessageId;
        public boolean disableNotification;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = -348943149;

        public AddLocalMessage() {
        }

        public AddLocalMessage(long var1, int var3, long var4, boolean var6, TdApi.InputMessageContent var7) {
            this.chatId = var1;
            this.senderUserId = var3;
            this.replyToMessageId = var4;
            this.disableNotification = var6;
            this.inputMessageContent = var7;
        }

        public int getConstructor() {
            return -348943149;
        }
    }

    public static class AddFavoriteSticker extends TdApi.Function {
        public TdApi.InputFile sticker;
        public static final int CONSTRUCTOR = 324504799;

        public AddFavoriteSticker() {
        }

        public AddFavoriteSticker(TdApi.InputFile var1) {
            this.sticker = var1;
        }

        public int getConstructor() {
            return 324504799;
        }
    }

    public static class AddCustomServerLanguagePack extends TdApi.Function {
        public String languagePackId;
        public static final int CONSTRUCTOR = 4492771;

        public AddCustomServerLanguagePack() {
        }

        public AddCustomServerLanguagePack(String var1) {
            this.languagePackId = var1;
        }

        public int getConstructor() {
            return 4492771;
        }
    }

    public static class AddContact extends TdApi.Function {
        public TdApi.Contact contact;
        public boolean sharePhoneNumber;
        public static final int CONSTRUCTOR = 1869640000;

        public AddContact() {
        }

        public AddContact(TdApi.Contact var1, boolean var2) {
            this.contact = var1;
            this.sharePhoneNumber = var2;
        }

        public int getConstructor() {
            return 1869640000;
        }
    }

    public static class AddChatMembers extends TdApi.Function {
        public long chatId;
        public int[] userIds;
        public static final int CONSTRUCTOR = 1234094617;

        public AddChatMembers() {
        }

        public AddChatMembers(long var1, int[] var3) {
            this.chatId = var1;
            this.userIds = var3;
        }

        public int getConstructor() {
            return 1234094617;
        }
    }

    public static class AddChatMember extends TdApi.Function {
        public long chatId;
        public int userId;
        public int forwardLimit;
        public static final int CONSTRUCTOR = 1182817962;

        public AddChatMember() {
        }

        public AddChatMember(long var1, int var3, int var4) {
            this.chatId = var1;
            this.userId = var3;
            this.forwardLimit = var4;
        }

        public int getConstructor() {
            return 1182817962;
        }
    }

    public static class AcceptTermsOfService extends TdApi.Function {
        public String termsOfServiceId;
        public static final int CONSTRUCTOR = 2130576356;

        public AcceptTermsOfService() {
        }

        public AcceptTermsOfService(String var1) {
            this.termsOfServiceId = var1;
        }

        public int getConstructor() {
            return 2130576356;
        }
    }

    public static class AcceptCall extends TdApi.Function {
        public int callId;
        public TdApi.CallProtocol protocol;
        public static final int CONSTRUCTOR = -646618416;

        public AcceptCall() {
        }

        public AcceptCall(int var1, TdApi.CallProtocol var2) {
            this.callId = var1;
            this.protocol = var2;
        }

        public int getConstructor() {
            return -646618416;
        }
    }

    public static class WebPageInstantView extends TdApi.Object {
        public TdApi.PageBlock[] pageBlocks;
        public int version;
        public String url;
        public boolean isRtl;
        public boolean isFull;
        public static final int CONSTRUCTOR = 957287214;

        public WebPageInstantView() {
        }

        public WebPageInstantView(TdApi.PageBlock[] var1, int var2, String var3, boolean var4, boolean var5) {
            this.pageBlocks = var1;
            this.version = var2;
            this.url = var3;
            this.isRtl = var4;
            this.isFull = var5;
        }

        public int getConstructor() {
            return 957287214;
        }
    }

    public static class WebPage extends TdApi.Object {
        public String url;
        public String displayUrl;
        public String type;
        public String siteName;
        public String title;
        public String description;
        public TdApi.Photo photo;
        public String embedUrl;
        public String embedType;
        public int embedWidth;
        public int embedHeight;
        public int duration;
        public String author;
        public TdApi.Animation animation;
        public TdApi.Audio audio;
        public TdApi.Document document;
        public TdApi.Sticker sticker;
        public TdApi.Video video;
        public TdApi.VideoNote videoNote;
        public TdApi.VoiceNote voiceNote;
        public int instantViewVersion;
        public static final int CONSTRUCTOR = 1092898169;

        public WebPage() {
        }

        public WebPage(String var1, String var2, String var3, String var4, String var5, String var6, TdApi.Photo var7, String var8, String var9, int var10, int var11, int var12, String var13, TdApi.Animation var14, TdApi.Audio var15, TdApi.Document var16, TdApi.Sticker var17, TdApi.Video var18, TdApi.VideoNote var19, TdApi.VoiceNote var20, int var21) {
            this.url = var1;
            this.displayUrl = var2;
            this.type = var3;
            this.siteName = var4;
            this.title = var5;
            this.description = var6;
            this.photo = var7;
            this.embedUrl = var8;
            this.embedType = var9;
            this.embedWidth = var10;
            this.embedHeight = var11;
            this.duration = var12;
            this.author = var13;
            this.animation = var14;
            this.audio = var15;
            this.document = var16;
            this.sticker = var17;
            this.video = var18;
            this.videoNote = var19;
            this.voiceNote = var20;
            this.instantViewVersion = var21;
        }

        public int getConstructor() {
            return 1092898169;
        }
    }

    public static class VoiceNote extends TdApi.Object {
        public int duration;
        public byte[] waveform;
        public String mimeType;
        public TdApi.File voice;
        public static final int CONSTRUCTOR = -2066012058;

        public VoiceNote() {
        }

        public VoiceNote(int var1, byte[] var2, String var3, TdApi.File var4) {
            this.duration = var1;
            this.waveform = var2;
            this.mimeType = var3;
            this.voice = var4;
        }

        public int getConstructor() {
            return -2066012058;
        }
    }

    public static class VideoNote extends TdApi.Object {
        public int duration;
        public int length;
        public TdApi.Minithumbnail minithumbnail;
        public TdApi.PhotoSize thumbnail;
        public TdApi.File video;
        public static final int CONSTRUCTOR = -1080075672;

        public VideoNote() {
        }

        public VideoNote(int var1, int var2, TdApi.Minithumbnail var3, TdApi.PhotoSize var4, TdApi.File var5) {
            this.duration = var1;
            this.length = var2;
            this.minithumbnail = var3;
            this.thumbnail = var4;
            this.video = var5;
        }

        public int getConstructor() {
            return -1080075672;
        }
    }

    public static class Video extends TdApi.Object {
        public int duration;
        public int width;
        public int height;
        public String fileName;
        public String mimeType;
        public boolean hasStickers;
        public boolean supportsStreaming;
        public TdApi.Minithumbnail minithumbnail;
        public TdApi.PhotoSize thumbnail;
        public TdApi.File video;
        public static final int CONSTRUCTOR = -536898740;

        public Video() {
        }

        public Video(int var1, int var2, int var3, String var4, String var5, boolean var6, boolean var7, TdApi.Minithumbnail var8, TdApi.PhotoSize var9, TdApi.File var10) {
            this.duration = var1;
            this.width = var2;
            this.height = var3;
            this.fileName = var4;
            this.mimeType = var5;
            this.hasStickers = var6;
            this.supportsStreaming = var7;
            this.minithumbnail = var8;
            this.thumbnail = var9;
            this.video = var10;
        }

        public int getConstructor() {
            return -536898740;
        }
    }

    public static class Venue extends TdApi.Object {
        public TdApi.Location location;
        public String title;
        public String address;
        public String provider;
        public String id;
        public String type;
        public static final int CONSTRUCTOR = 1070406393;

        public Venue() {
        }

        public Venue(TdApi.Location var1, String var2, String var3, String var4, String var5, String var6) {
            this.location = var1;
            this.title = var2;
            this.address = var3;
            this.provider = var4;
            this.id = var5;
            this.type = var6;
        }

        public int getConstructor() {
            return 1070406393;
        }
    }

    public static class ValidatedOrderInfo extends TdApi.Object {
        public String orderInfoId;
        public TdApi.ShippingOption[] shippingOptions;
        public static final int CONSTRUCTOR = 1511451484;

        public ValidatedOrderInfo() {
        }

        public ValidatedOrderInfo(String var1, TdApi.ShippingOption[] var2) {
            this.orderInfoId = var1;
            this.shippingOptions = var2;
        }

        public int getConstructor() {
            return 1511451484;
        }
    }

    public static class Users extends TdApi.Object {
        public int totalCount;
        public int[] userIds;
        public static final int CONSTRUCTOR = 273760088;

        public Users() {
        }

        public Users(int var1, int[] var2) {
            this.totalCount = var1;
            this.userIds = var2;
        }

        public int getConstructor() {
            return 273760088;
        }
    }

    public static class UserTypeUnknown extends TdApi.UserType {
        public static final int CONSTRUCTOR = -724541123;

        public UserTypeUnknown() {
        }

        public int getConstructor() {
            return -724541123;
        }
    }

    public static class UserTypeBot extends TdApi.UserType {
        public boolean canJoinGroups;
        public boolean canReadAllGroupMessages;
        public boolean isInline;
        public String inlineQueryPlaceholder;
        public boolean needLocation;
        public static final int CONSTRUCTOR = 1262387765;

        public UserTypeBot() {
        }

        public UserTypeBot(boolean var1, boolean var2, boolean var3, String var4, boolean var5) {
            this.canJoinGroups = var1;
            this.canReadAllGroupMessages = var2;
            this.isInline = var3;
            this.inlineQueryPlaceholder = var4;
            this.needLocation = var5;
        }

        public int getConstructor() {
            return 1262387765;
        }
    }

    public static class UserTypeDeleted extends TdApi.UserType {
        public static final int CONSTRUCTOR = -1807729372;

        public UserTypeDeleted() {
        }

        public int getConstructor() {
            return -1807729372;
        }
    }

    public static class UserTypeRegular extends TdApi.UserType {
        public static final int CONSTRUCTOR = -598644325;

        public UserTypeRegular() {
        }

        public int getConstructor() {
            return -598644325;
        }
    }

    public abstract static class UserType extends TdApi.Object {
        public UserType() {
        }
    }

    public static class UserStatusLastMonth extends TdApi.UserStatus {
        public static final int CONSTRUCTOR = 2011940674;

        public UserStatusLastMonth() {
        }

        public int getConstructor() {
            return 2011940674;
        }
    }

    public static class UserStatusLastWeek extends TdApi.UserStatus {
        public static final int CONSTRUCTOR = 129960444;

        public UserStatusLastWeek() {
        }

        public int getConstructor() {
            return 129960444;
        }
    }

    public static class UserStatusRecently extends TdApi.UserStatus {
        public static final int CONSTRUCTOR = -496024847;

        public UserStatusRecently() {
        }

        public int getConstructor() {
            return -496024847;
        }
    }

    public static class UserStatusOffline extends TdApi.UserStatus {
        public int wasOnline;
        public static final int CONSTRUCTOR = -759984891;

        public UserStatusOffline() {
        }

        public UserStatusOffline(int var1) {
            this.wasOnline = var1;
        }

        public int getConstructor() {
            return -759984891;
        }
    }

    public static class UserStatusOnline extends TdApi.UserStatus {
        public int expires;
        public static final int CONSTRUCTOR = -1529460876;

        public UserStatusOnline() {
        }

        public UserStatusOnline(int var1) {
            this.expires = var1;
        }

        public int getConstructor() {
            return -1529460876;
        }
    }

    public static class UserStatusEmpty extends TdApi.UserStatus {
        public static final int CONSTRUCTOR = 164646985;

        public UserStatusEmpty() {
        }

        public int getConstructor() {
            return 164646985;
        }
    }

    public abstract static class UserStatus extends TdApi.Object {
        public UserStatus() {
        }
    }

    public static class UserProfilePhotos extends TdApi.Object {
        public int totalCount;
        public TdApi.UserProfilePhoto[] photos;
        public static final int CONSTRUCTOR = 1512709690;

        public UserProfilePhotos() {
        }

        public UserProfilePhotos(int var1, TdApi.UserProfilePhoto[] var2) {
            this.totalCount = var1;
            this.photos = var2;
        }

        public int getConstructor() {
            return 1512709690;
        }
    }

    public static class UserProfilePhoto extends TdApi.Object {
        public long id;
        public int addedDate;
        public TdApi.PhotoSize[] sizes;
        public static final int CONSTRUCTOR = -1882596466;

        public UserProfilePhoto() {
        }

        public UserProfilePhoto(long var1, int var3, TdApi.PhotoSize[] var4) {
            this.id = var1;
            this.addedDate = var3;
            this.sizes = var4;
        }

        public int getConstructor() {
            return -1882596466;
        }
    }

    public static class UserPrivacySettingRules extends TdApi.Object {
        public TdApi.UserPrivacySettingRule[] rules;
        public static final int CONSTRUCTOR = 322477541;

        public UserPrivacySettingRules() {
        }

        public UserPrivacySettingRules(TdApi.UserPrivacySettingRule[] var1) {
            this.rules = var1;
        }

        public int getConstructor() {
            return 322477541;
        }
    }

    public static class UserPrivacySettingRuleRestrictChatMembers extends TdApi.UserPrivacySettingRule {
        public long[] chatIds;
        public static final int CONSTRUCTOR = 392530897;

        public UserPrivacySettingRuleRestrictChatMembers() {
        }

        public UserPrivacySettingRuleRestrictChatMembers(long[] var1) {
            this.chatIds = var1;
        }

        public int getConstructor() {
            return 392530897;
        }
    }

    public static class UserPrivacySettingRuleRestrictUsers extends TdApi.UserPrivacySettingRule {
        public int[] userIds;
        public static final int CONSTRUCTOR = 2119951802;

        public UserPrivacySettingRuleRestrictUsers() {
        }

        public UserPrivacySettingRuleRestrictUsers(int[] var1) {
            this.userIds = var1;
        }

        public int getConstructor() {
            return 2119951802;
        }
    }

    public static class UserPrivacySettingRuleRestrictContacts extends TdApi.UserPrivacySettingRule {
        public static final int CONSTRUCTOR = 1008389378;

        public UserPrivacySettingRuleRestrictContacts() {
        }

        public int getConstructor() {
            return 1008389378;
        }
    }

    public static class UserPrivacySettingRuleRestrictAll extends TdApi.UserPrivacySettingRule {
        public static final int CONSTRUCTOR = -1406495408;

        public UserPrivacySettingRuleRestrictAll() {
        }

        public int getConstructor() {
            return -1406495408;
        }
    }

    public static class UserPrivacySettingRuleAllowChatMembers extends TdApi.UserPrivacySettingRule {
        public long[] chatIds;
        public static final int CONSTRUCTOR = -2048749863;

        public UserPrivacySettingRuleAllowChatMembers() {
        }

        public UserPrivacySettingRuleAllowChatMembers(long[] var1) {
            this.chatIds = var1;
        }

        public int getConstructor() {
            return -2048749863;
        }
    }

    public static class UserPrivacySettingRuleAllowUsers extends TdApi.UserPrivacySettingRule {
        public int[] userIds;
        public static final int CONSTRUCTOR = 427601278;

        public UserPrivacySettingRuleAllowUsers() {
        }

        public UserPrivacySettingRuleAllowUsers(int[] var1) {
            this.userIds = var1;
        }

        public int getConstructor() {
            return 427601278;
        }
    }

    public static class UserPrivacySettingRuleAllowContacts extends TdApi.UserPrivacySettingRule {
        public static final int CONSTRUCTOR = -1892733680;

        public UserPrivacySettingRuleAllowContacts() {
        }

        public int getConstructor() {
            return -1892733680;
        }
    }

    public static class UserPrivacySettingRuleAllowAll extends TdApi.UserPrivacySettingRule {
        public static final int CONSTRUCTOR = -1967186881;

        public UserPrivacySettingRuleAllowAll() {
        }

        public int getConstructor() {
            return -1967186881;
        }
    }

    public abstract static class UserPrivacySettingRule extends TdApi.Object {
        public UserPrivacySettingRule() {
        }
    }

    public static class UserPrivacySettingAllowFindingByPhoneNumber extends TdApi.UserPrivacySetting {
        public static final int CONSTRUCTOR = -1846645423;

        public UserPrivacySettingAllowFindingByPhoneNumber() {
        }

        public int getConstructor() {
            return -1846645423;
        }
    }

    public static class UserPrivacySettingAllowPeerToPeerCalls extends TdApi.UserPrivacySetting {
        public static final int CONSTRUCTOR = 352500032;

        public UserPrivacySettingAllowPeerToPeerCalls() {
        }

        public int getConstructor() {
            return 352500032;
        }
    }

    public static class UserPrivacySettingAllowCalls extends TdApi.UserPrivacySetting {
        public static final int CONSTRUCTOR = -906967291;

        public UserPrivacySettingAllowCalls() {
        }

        public int getConstructor() {
            return -906967291;
        }
    }

    public static class UserPrivacySettingAllowChatInvites extends TdApi.UserPrivacySetting {
        public static final int CONSTRUCTOR = 1271668007;

        public UserPrivacySettingAllowChatInvites() {
        }

        public int getConstructor() {
            return 1271668007;
        }
    }

    public static class UserPrivacySettingShowPhoneNumber extends TdApi.UserPrivacySetting {
        public static final int CONSTRUCTOR = -791567831;

        public UserPrivacySettingShowPhoneNumber() {
        }

        public int getConstructor() {
            return -791567831;
        }
    }

    public static class UserPrivacySettingShowLinkInForwardedMessages extends TdApi.UserPrivacySetting {
        public static final int CONSTRUCTOR = 592688870;

        public UserPrivacySettingShowLinkInForwardedMessages() {
        }

        public int getConstructor() {
            return 592688870;
        }
    }

    public static class UserPrivacySettingShowProfilePhoto extends TdApi.UserPrivacySetting {
        public static final int CONSTRUCTOR = 1408485877;

        public UserPrivacySettingShowProfilePhoto() {
        }

        public int getConstructor() {
            return 1408485877;
        }
    }

    public static class UserPrivacySettingShowStatus extends TdApi.UserPrivacySetting {
        public static final int CONSTRUCTOR = 1862829310;

        public UserPrivacySettingShowStatus() {
        }

        public int getConstructor() {
            return 1862829310;
        }
    }

    public abstract static class UserPrivacySetting extends TdApi.Object {
        public UserPrivacySetting() {
        }
    }

    public static class UserFullInfo extends TdApi.Object {
        public boolean isBlocked;
        public boolean canBeCalled;
        public boolean hasPrivateCalls;
        public boolean needPhoneNumberPrivacyException;
        public String bio;
        public String shareText;
        public int groupInCommonCount;
        public TdApi.BotInfo botInfo;
        public static final int CONSTRUCTOR = 333888500;

        public UserFullInfo() {
        }

        public UserFullInfo(boolean var1, boolean var2, boolean var3, boolean var4, String var5, String var6, int var7, TdApi.BotInfo var8) {
            this.isBlocked = var1;
            this.canBeCalled = var2;
            this.hasPrivateCalls = var3;
            this.needPhoneNumberPrivacyException = var4;
            this.bio = var5;
            this.shareText = var6;
            this.groupInCommonCount = var7;
            this.botInfo = var8;
        }

        public int getConstructor() {
            return 333888500;
        }
    }

    public static class User extends TdApi.Object {
        public int id;
        public String firstName;
        public String lastName;
        public String username;
        public String phoneNumber;
        public TdApi.UserStatus status;
        public TdApi.ProfilePhoto profilePhoto;
        public boolean isContact;
        public boolean isMutualContact;
        public boolean isVerified;
        public boolean isSupport;
        public String restrictionReason;
        public boolean isScam;
        public boolean haveAccess;
        public TdApi.UserType type;
        public String languageCode;
        public static final int CONSTRUCTOR = -824771497;

        public User() {
        }

        public User(int var1, String var2, String var3, String var4, String var5, TdApi.UserStatus var6, TdApi.ProfilePhoto var7, boolean var8, boolean var9, boolean var10, boolean var11, String var12, boolean var13, boolean var14, TdApi.UserType var15, String var16) {
            this.id = var1;
            this.firstName = var2;
            this.lastName = var3;
            this.username = var4;
            this.phoneNumber = var5;
            this.status = var6;
            this.profilePhoto = var7;
            this.isContact = var8;
            this.isMutualContact = var9;
            this.isVerified = var10;
            this.isSupport = var11;
            this.restrictionReason = var12;
            this.isScam = var13;
            this.haveAccess = var14;
            this.type = var15;
            this.languageCode = var16;
        }

        public int getConstructor() {
            return -824771497;
        }
    }

    public static class Updates extends TdApi.Object {
        public TdApi.Update[] updates;
        public static final int CONSTRUCTOR = 475842347;

        public Updates() {
        }

        public Updates(TdApi.Update[] var1) {
            this.updates = var1;
        }

        public int getConstructor() {
            return 475842347;
        }
    }

    public static class UpdatePollAnswer extends TdApi.Update {
        public long pollId;
        public int userId;
        public int[] optionIds;
        public static final int CONSTRUCTOR = 1606139344;

        public UpdatePollAnswer() {
        }

        public UpdatePollAnswer(long var1, int var3, int[] var4) {
            this.pollId = var1;
            this.userId = var3;
            this.optionIds = var4;
        }

        public int getConstructor() {
            return 1606139344;
        }
    }

    public static class UpdatePoll extends TdApi.Update {
        public TdApi.Poll poll;
        public static final int CONSTRUCTOR = -1771342902;

        public UpdatePoll() {
        }

        public UpdatePoll(TdApi.Poll var1) {
            this.poll = var1;
        }

        public int getConstructor() {
            return -1771342902;
        }
    }

    public static class UpdateNewCustomQuery extends TdApi.Update {
        public long id;
        public String data;
        public int timeout;
        public static final int CONSTRUCTOR = -687670874;

        public UpdateNewCustomQuery() {
        }

        public UpdateNewCustomQuery(long var1, String var3, int var4) {
            this.id = var1;
            this.data = var3;
            this.timeout = var4;
        }

        public int getConstructor() {
            return -687670874;
        }
    }

    public static class UpdateNewCustomEvent extends TdApi.Update {
        public String event;
        public static final int CONSTRUCTOR = 1994222092;

        public UpdateNewCustomEvent() {
        }

        public UpdateNewCustomEvent(String var1) {
            this.event = var1;
        }

        public int getConstructor() {
            return 1994222092;
        }
    }

    public static class UpdateNewPreCheckoutQuery extends TdApi.Update {
        public long id;
        public int senderUserId;
        public String currency;
        public long totalAmount;
        public byte[] invoicePayload;
        public String shippingOptionId;
        public TdApi.OrderInfo orderInfo;
        public static final int CONSTRUCTOR = 87964006;

        public UpdateNewPreCheckoutQuery() {
        }

        public UpdateNewPreCheckoutQuery(long var1, int var3, String var4, long var5, byte[] var7, String var8, TdApi.OrderInfo var9) {
            this.id = var1;
            this.senderUserId = var3;
            this.currency = var4;
            this.totalAmount = var5;
            this.invoicePayload = var7;
            this.shippingOptionId = var8;
            this.orderInfo = var9;
        }

        public int getConstructor() {
            return 87964006;
        }
    }

    public static class UpdateNewShippingQuery extends TdApi.Update {
        public long id;
        public int senderUserId;
        public String invoicePayload;
        public TdApi.Address shippingAddress;
        public static final int CONSTRUCTOR = -817474682;

        public UpdateNewShippingQuery() {
        }

        public UpdateNewShippingQuery(long var1, int var3, String var4, TdApi.Address var5) {
            this.id = var1;
            this.senderUserId = var3;
            this.invoicePayload = var4;
            this.shippingAddress = var5;
        }

        public int getConstructor() {
            return -817474682;
        }
    }

    public static class UpdateNewInlineCallbackQuery extends TdApi.Update {
        public long id;
        public int senderUserId;
        public String inlineMessageId;
        public long chatInstance;
        public TdApi.CallbackQueryPayload payload;
        public static final int CONSTRUCTOR = -1879154829;

        public UpdateNewInlineCallbackQuery() {
        }

        public UpdateNewInlineCallbackQuery(long var1, int var3, String var4, long var5, TdApi.CallbackQueryPayload var7) {
            this.id = var1;
            this.senderUserId = var3;
            this.inlineMessageId = var4;
            this.chatInstance = var5;
            this.payload = var7;
        }

        public int getConstructor() {
            return -1879154829;
        }
    }

    public static class UpdateNewCallbackQuery extends TdApi.Update {
        public long id;
        public int senderUserId;
        public long chatId;
        public long messageId;
        public long chatInstance;
        public TdApi.CallbackQueryPayload payload;
        public static final int CONSTRUCTOR = -2044226370;

        public UpdateNewCallbackQuery() {
        }

        public UpdateNewCallbackQuery(long var1, int var3, long var4, long var6, long var8, TdApi.CallbackQueryPayload var10) {
            this.id = var1;
            this.senderUserId = var3;
            this.chatId = var4;
            this.messageId = var6;
            this.chatInstance = var8;
            this.payload = var10;
        }

        public int getConstructor() {
            return -2044226370;
        }
    }

    public static class UpdateNewChosenInlineResult extends TdApi.Update {
        public int senderUserId;
        public TdApi.Location userLocation;
        public String query;
        public String resultId;
        public String inlineMessageId;
        public static final int CONSTRUCTOR = 527526965;

        public UpdateNewChosenInlineResult() {
        }

        public UpdateNewChosenInlineResult(int var1, TdApi.Location var2, String var3, String var4, String var5) {
            this.senderUserId = var1;
            this.userLocation = var2;
            this.query = var3;
            this.resultId = var4;
            this.inlineMessageId = var5;
        }

        public int getConstructor() {
            return 527526965;
        }
    }

    public static class UpdateNewInlineQuery extends TdApi.Update {
        public long id;
        public int senderUserId;
        public TdApi.Location userLocation;
        public String query;
        public String offset;
        public static final int CONSTRUCTOR = 2064730634;

        public UpdateNewInlineQuery() {
        }

        public UpdateNewInlineQuery(long var1, int var3, TdApi.Location var4, String var5, String var6) {
            this.id = var1;
            this.senderUserId = var3;
            this.userLocation = var4;
            this.query = var5;
            this.offset = var6;
        }

        public int getConstructor() {
            return 2064730634;
        }
    }

    public static class UpdateUsersNearby extends TdApi.Update {
        public TdApi.ChatNearby[] usersNearby;
        public static final int CONSTRUCTOR = -1517109163;

        public UpdateUsersNearby() {
        }

        public UpdateUsersNearby(TdApi.ChatNearby[] var1) {
            this.usersNearby = var1;
        }

        public int getConstructor() {
            return -1517109163;
        }
    }

    public static class UpdateTermsOfService extends TdApi.Update {
        public String termsOfServiceId;
        public TdApi.TermsOfService termsOfService;
        public static final int CONSTRUCTOR = -1304640162;

        public UpdateTermsOfService() {
        }

        public UpdateTermsOfService(String var1, TdApi.TermsOfService var2) {
            this.termsOfServiceId = var1;
            this.termsOfService = var2;
        }

        public int getConstructor() {
            return -1304640162;
        }
    }

    public static class UpdateConnectionState extends TdApi.Update {
        public TdApi.ConnectionState state;
        public static final int CONSTRUCTOR = 1469292078;

        public UpdateConnectionState() {
        }

        public UpdateConnectionState(TdApi.ConnectionState var1) {
            this.state = var1;
        }

        public int getConstructor() {
            return 1469292078;
        }
    }

    public static class UpdateLanguagePackStrings extends TdApi.Update {
        public String localizationTarget;
        public String languagePackId;
        public TdApi.LanguagePackString[] strings;
        public static final int CONSTRUCTOR = -1056319886;

        public UpdateLanguagePackStrings() {
        }

        public UpdateLanguagePackStrings(String var1, String var2, TdApi.LanguagePackString[] var3) {
            this.localizationTarget = var1;
            this.languagePackId = var2;
            this.strings = var3;
        }

        public int getConstructor() {
            return -1056319886;
        }
    }

    public static class UpdateSelectedBackground extends TdApi.Update {
        public boolean forDarkTheme;
        public TdApi.Background background;
        public static final int CONSTRUCTOR = -1715658659;

        public UpdateSelectedBackground() {
        }

        public UpdateSelectedBackground(boolean var1, TdApi.Background var2) {
            this.forDarkTheme = var1;
            this.background = var2;
        }

        public int getConstructor() {
            return -1715658659;
        }
    }

    public static class UpdateSavedAnimations extends TdApi.Update {
        public int[] animationIds;
        public static final int CONSTRUCTOR = 65563814;

        public UpdateSavedAnimations() {
        }

        public UpdateSavedAnimations(int[] var1) {
            this.animationIds = var1;
        }

        public int getConstructor() {
            return 65563814;
        }
    }

    public static class UpdateFavoriteStickers extends TdApi.Update {
        public int[] stickerIds;
        public static final int CONSTRUCTOR = 1662240999;

        public UpdateFavoriteStickers() {
        }

        public UpdateFavoriteStickers(int[] var1) {
            this.stickerIds = var1;
        }

        public int getConstructor() {
            return 1662240999;
        }
    }

    public static class UpdateRecentStickers extends TdApi.Update {
        public boolean isAttached;
        public int[] stickerIds;
        public static final int CONSTRUCTOR = 1906403540;

        public UpdateRecentStickers() {
        }

        public UpdateRecentStickers(boolean var1, int[] var2) {
            this.isAttached = var1;
            this.stickerIds = var2;
        }

        public int getConstructor() {
            return 1906403540;
        }
    }

    public static class UpdateTrendingStickerSets extends TdApi.Update {
        public TdApi.StickerSets stickerSets;
        public static final int CONSTRUCTOR = 450714593;

        public UpdateTrendingStickerSets() {
        }

        public UpdateTrendingStickerSets(TdApi.StickerSets var1) {
            this.stickerSets = var1;
        }

        public int getConstructor() {
            return 450714593;
        }
    }

    public static class UpdateInstalledStickerSets extends TdApi.Update {
        public boolean isMasks;
        public long[] stickerSetIds;
        public static final int CONSTRUCTOR = 1125575977;

        public UpdateInstalledStickerSets() {
        }

        public UpdateInstalledStickerSets(boolean var1, long[] var2) {
            this.isMasks = var1;
            this.stickerSetIds = var2;
        }

        public int getConstructor() {
            return 1125575977;
        }
    }

    public static class UpdateOption extends TdApi.Update {
        public String name;
        public TdApi.OptionValue value;
        public static final int CONSTRUCTOR = 900822020;

        public UpdateOption() {
        }

        public UpdateOption(String var1, TdApi.OptionValue var2) {
            this.name = var1;
            this.value = var2;
        }

        public int getConstructor() {
            return 900822020;
        }
    }

    public static class UpdateUnreadChatCount extends TdApi.Update {
        public TdApi.ChatList chatList;
        public int totalCount;
        public int unreadCount;
        public int unreadUnmutedCount;
        public int markedAsUnreadCount;
        public int markedAsUnreadUnmutedCount;
        public static final int CONSTRUCTOR = 1994494530;

        public UpdateUnreadChatCount() {
        }

        public UpdateUnreadChatCount(TdApi.ChatList var1, int var2, int var3, int var4, int var5, int var6) {
            this.chatList = var1;
            this.totalCount = var2;
            this.unreadCount = var3;
            this.unreadUnmutedCount = var4;
            this.markedAsUnreadCount = var5;
            this.markedAsUnreadUnmutedCount = var6;
        }

        public int getConstructor() {
            return 1994494530;
        }
    }

    public static class UpdateUnreadMessageCount extends TdApi.Update {
        public TdApi.ChatList chatList;
        public int unreadCount;
        public int unreadUnmutedCount;
        public static final int CONSTRUCTOR = 78987721;

        public UpdateUnreadMessageCount() {
        }

        public UpdateUnreadMessageCount(TdApi.ChatList var1, int var2, int var3) {
            this.chatList = var1;
            this.unreadCount = var2;
            this.unreadUnmutedCount = var3;
        }

        public int getConstructor() {
            return 78987721;
        }
    }

    public static class UpdateUserPrivacySettingRules extends TdApi.Update {
        public TdApi.UserPrivacySetting setting;
        public TdApi.UserPrivacySettingRules rules;
        public static final int CONSTRUCTOR = -912960778;

        public UpdateUserPrivacySettingRules() {
        }

        public UpdateUserPrivacySettingRules(TdApi.UserPrivacySetting var1, TdApi.UserPrivacySettingRules var2) {
            this.setting = var1;
            this.rules = var2;
        }

        public int getConstructor() {
            return -912960778;
        }
    }

    public static class UpdateCall extends TdApi.Update {
        public TdApi.Call call;
        public static final int CONSTRUCTOR = 1337184477;

        public UpdateCall() {
        }

        public UpdateCall(TdApi.Call var1) {
            this.call = var1;
        }

        public int getConstructor() {
            return 1337184477;
        }
    }

    public static class UpdateFileGenerationStop extends TdApi.Update {
        public long generationId;
        public static final int CONSTRUCTOR = -1894449685;

        public UpdateFileGenerationStop() {
        }

        public UpdateFileGenerationStop(long var1) {
            this.generationId = var1;
        }

        public int getConstructor() {
            return -1894449685;
        }
    }

    public static class UpdateFileGenerationStart extends TdApi.Update {
        public long generationId;
        public String originalPath;
        public String destinationPath;
        public String conversion;
        public static final int CONSTRUCTOR = 216817388;

        public UpdateFileGenerationStart() {
        }

        public UpdateFileGenerationStart(long var1, String var3, String var4, String var5) {
            this.generationId = var1;
            this.originalPath = var3;
            this.destinationPath = var4;
            this.conversion = var5;
        }

        public int getConstructor() {
            return 216817388;
        }
    }

    public static class UpdateFile extends TdApi.Update {
        public TdApi.File file;
        public static final int CONSTRUCTOR = 114132831;

        public UpdateFile() {
        }

        public UpdateFile(TdApi.File var1) {
            this.file = var1;
        }

        public int getConstructor() {
            return 114132831;
        }
    }

    public static class UpdateServiceNotification extends TdApi.Update {
        public String type;
        public TdApi.MessageContent content;
        public static final int CONSTRUCTOR = 1318622637;

        public UpdateServiceNotification() {
        }

        public UpdateServiceNotification(String var1, TdApi.MessageContent var2) {
            this.type = var1;
            this.content = var2;
        }

        public int getConstructor() {
            return 1318622637;
        }
    }

    public static class UpdateSupergroupFullInfo extends TdApi.Update {
        public int supergroupId;
        public TdApi.SupergroupFullInfo supergroupFullInfo;
        public static final int CONSTRUCTOR = 1288828758;

        public UpdateSupergroupFullInfo() {
        }

        public UpdateSupergroupFullInfo(int var1, TdApi.SupergroupFullInfo var2) {
            this.supergroupId = var1;
            this.supergroupFullInfo = var2;
        }

        public int getConstructor() {
            return 1288828758;
        }
    }

    public static class UpdateBasicGroupFullInfo extends TdApi.Update {
        public int basicGroupId;
        public TdApi.BasicGroupFullInfo basicGroupFullInfo;
        public static final int CONSTRUCTOR = 924030531;

        public UpdateBasicGroupFullInfo() {
        }

        public UpdateBasicGroupFullInfo(int var1, TdApi.BasicGroupFullInfo var2) {
            this.basicGroupId = var1;
            this.basicGroupFullInfo = var2;
        }

        public int getConstructor() {
            return 924030531;
        }
    }

    public static class UpdateUserFullInfo extends TdApi.Update {
        public int userId;
        public TdApi.UserFullInfo userFullInfo;
        public static final int CONSTRUCTOR = 222103874;

        public UpdateUserFullInfo() {
        }

        public UpdateUserFullInfo(int var1, TdApi.UserFullInfo var2) {
            this.userId = var1;
            this.userFullInfo = var2;
        }

        public int getConstructor() {
            return 222103874;
        }
    }

    public static class UpdateSecretChat extends TdApi.Update {
        public TdApi.SecretChat secretChat;
        public static final int CONSTRUCTOR = -1666903253;

        public UpdateSecretChat() {
        }

        public UpdateSecretChat(TdApi.SecretChat var1) {
            this.secretChat = var1;
        }

        public int getConstructor() {
            return -1666903253;
        }
    }

    public static class UpdateSupergroup extends TdApi.Update {
        public TdApi.Supergroup supergroup;
        public static final int CONSTRUCTOR = -76782300;

        public UpdateSupergroup() {
        }

        public UpdateSupergroup(TdApi.Supergroup var1) {
            this.supergroup = var1;
        }

        public int getConstructor() {
            return -76782300;
        }
    }

    public static class UpdateBasicGroup extends TdApi.Update {
        public TdApi.BasicGroup basicGroup;
        public static final int CONSTRUCTOR = -1003239581;

        public UpdateBasicGroup() {
        }

        public UpdateBasicGroup(TdApi.BasicGroup var1) {
            this.basicGroup = var1;
        }

        public int getConstructor() {
            return -1003239581;
        }
    }

    public static class UpdateUser extends TdApi.Update {
        public TdApi.User user;
        public static final int CONSTRUCTOR = 1183394041;

        public UpdateUser() {
        }

        public UpdateUser(TdApi.User var1) {
            this.user = var1;
        }

        public int getConstructor() {
            return 1183394041;
        }
    }

    public static class UpdateUserStatus extends TdApi.Update {
        public int userId;
        public TdApi.UserStatus status;
        public static final int CONSTRUCTOR = -1443545195;

        public UpdateUserStatus() {
        }

        public UpdateUserStatus(int var1, TdApi.UserStatus var2) {
            this.userId = var1;
            this.status = var2;
        }

        public int getConstructor() {
            return -1443545195;
        }
    }

    public static class UpdateUserChatAction extends TdApi.Update {
        public long chatId;
        public int userId;
        public TdApi.ChatAction action;
        public static final int CONSTRUCTOR = 1444133514;

        public UpdateUserChatAction() {
        }

        public UpdateUserChatAction(long var1, int var3, TdApi.ChatAction var4) {
            this.chatId = var1;
            this.userId = var3;
            this.action = var4;
        }

        public int getConstructor() {
            return 1444133514;
        }
    }

    public static class UpdateDeleteMessages extends TdApi.Update {
        public long chatId;
        public long[] messageIds;
        public boolean isPermanent;
        public boolean fromCache;
        public static final int CONSTRUCTOR = 1669252686;

        public UpdateDeleteMessages() {
        }

        public UpdateDeleteMessages(long var1, long[] var3, boolean var4, boolean var5) {
            this.chatId = var1;
            this.messageIds = var3;
            this.isPermanent = var4;
            this.fromCache = var5;
        }

        public int getConstructor() {
            return 1669252686;
        }
    }

    public static class UpdateHavePendingNotifications extends TdApi.Update {
        public boolean haveDelayedNotifications;
        public boolean haveUnreceivedNotifications;
        public static final int CONSTRUCTOR = 179233243;

        public UpdateHavePendingNotifications() {
        }

        public UpdateHavePendingNotifications(boolean var1, boolean var2) {
            this.haveDelayedNotifications = var1;
            this.haveUnreceivedNotifications = var2;
        }

        public int getConstructor() {
            return 179233243;
        }
    }

    public static class UpdateActiveNotifications extends TdApi.Update {
        public TdApi.NotificationGroup[] groups;
        public static final int CONSTRUCTOR = -1306672221;

        public UpdateActiveNotifications() {
        }

        public UpdateActiveNotifications(TdApi.NotificationGroup[] var1) {
            this.groups = var1;
        }

        public int getConstructor() {
            return -1306672221;
        }
    }

    public static class UpdateNotificationGroup extends TdApi.Update {
        public int notificationGroupId;
        public TdApi.NotificationGroupType type;
        public long chatId;
        public long notificationSettingsChatId;
        public boolean isSilent;
        public int totalCount;
        public TdApi.Notification[] addedNotifications;
        public int[] removedNotificationIds;
        public static final int CONSTRUCTOR = -2049005665;

        public UpdateNotificationGroup() {
        }

        public UpdateNotificationGroup(int var1, TdApi.NotificationGroupType var2, long var3, long var5, boolean var7, int var8, TdApi.Notification[] var9, int[] var10) {
            this.notificationGroupId = var1;
            this.type = var2;
            this.chatId = var3;
            this.notificationSettingsChatId = var5;
            this.isSilent = var7;
            this.totalCount = var8;
            this.addedNotifications = var9;
            this.removedNotificationIds = var10;
        }

        public int getConstructor() {
            return -2049005665;
        }
    }

    public static class UpdateNotification extends TdApi.Update {
        public int notificationGroupId;
        public TdApi.Notification notification;
        public static final int CONSTRUCTOR = -1897496876;

        public UpdateNotification() {
        }

        public UpdateNotification(int var1, TdApi.Notification var2) {
            this.notificationGroupId = var1;
            this.notification = var2;
        }

        public int getConstructor() {
            return -1897496876;
        }
    }

    public static class UpdateChatOnlineMemberCount extends TdApi.Update {
        public long chatId;
        public int onlineMemberCount;
        public static final int CONSTRUCTOR = 487369373;

        public UpdateChatOnlineMemberCount() {
        }

        public UpdateChatOnlineMemberCount(long var1, int var3) {
            this.chatId = var1;
            this.onlineMemberCount = var3;
        }

        public int getConstructor() {
            return 487369373;
        }
    }

    public static class UpdateChatDraftMessage extends TdApi.Update {
        public long chatId;
        public TdApi.DraftMessage draftMessage;
        public long order;
        public static final int CONSTRUCTOR = -1436617498;

        public UpdateChatDraftMessage() {
        }

        public UpdateChatDraftMessage(long var1, TdApi.DraftMessage var3, long var4) {
            this.chatId = var1;
            this.draftMessage = var3;
            this.order = var4;
        }

        public int getConstructor() {
            return -1436617498;
        }
    }

    public static class UpdateChatReplyMarkup extends TdApi.Update {
        public long chatId;
        public long replyMarkupMessageId;
        public static final int CONSTRUCTOR = 1309386144;

        public UpdateChatReplyMarkup() {
        }

        public UpdateChatReplyMarkup(long var1, long var3) {
            this.chatId = var1;
            this.replyMarkupMessageId = var3;
        }

        public int getConstructor() {
            return 1309386144;
        }
    }

    public static class UpdateChatPinnedMessage extends TdApi.Update {
        public long chatId;
        public long pinnedMessageId;
        public static final int CONSTRUCTOR = 802160507;

        public UpdateChatPinnedMessage() {
        }

        public UpdateChatPinnedMessage(long var1, long var3) {
            this.chatId = var1;
            this.pinnedMessageId = var3;
        }

        public int getConstructor() {
            return 802160507;
        }
    }

    public static class UpdateChatActionBar extends TdApi.Update {
        public long chatId;
        public TdApi.ChatActionBar actionBar;
        public static final int CONSTRUCTOR = -643671870;

        public UpdateChatActionBar() {
        }

        public UpdateChatActionBar(long var1, TdApi.ChatActionBar var3) {
            this.chatId = var1;
            this.actionBar = var3;
        }

        public int getConstructor() {
            return -643671870;
        }
    }

    public static class UpdateScopeNotificationSettings extends TdApi.Update {
        public TdApi.NotificationSettingsScope scope;
        public TdApi.ScopeNotificationSettings notificationSettings;
        public static final int CONSTRUCTOR = -1203975309;

        public UpdateScopeNotificationSettings() {
        }

        public UpdateScopeNotificationSettings(TdApi.NotificationSettingsScope var1, TdApi.ScopeNotificationSettings var2) {
            this.scope = var1;
            this.notificationSettings = var2;
        }

        public int getConstructor() {
            return -1203975309;
        }
    }

    public static class UpdateChatNotificationSettings extends TdApi.Update {
        public long chatId;
        public TdApi.ChatNotificationSettings notificationSettings;
        public static final int CONSTRUCTOR = -803163050;

        public UpdateChatNotificationSettings() {
        }

        public UpdateChatNotificationSettings(long var1, TdApi.ChatNotificationSettings var3) {
            this.chatId = var1;
            this.notificationSettings = var3;
        }

        public int getConstructor() {
            return -803163050;
        }
    }

    public static class UpdateChatUnreadMentionCount extends TdApi.Update {
        public long chatId;
        public int unreadMentionCount;
        public static final int CONSTRUCTOR = -2131461348;

        public UpdateChatUnreadMentionCount() {
        }

        public UpdateChatUnreadMentionCount(long var1, int var3) {
            this.chatId = var1;
            this.unreadMentionCount = var3;
        }

        public int getConstructor() {
            return -2131461348;
        }
    }

    public static class UpdateChatReadOutbox extends TdApi.Update {
        public long chatId;
        public long lastReadOutboxMessageId;
        public static final int CONSTRUCTOR = 708334213;

        public UpdateChatReadOutbox() {
        }

        public UpdateChatReadOutbox(long var1, long var3) {
            this.chatId = var1;
            this.lastReadOutboxMessageId = var3;
        }

        public int getConstructor() {
            return 708334213;
        }
    }

    public static class UpdateChatReadInbox extends TdApi.Update {
        public long chatId;
        public long lastReadInboxMessageId;
        public int unreadCount;
        public static final int CONSTRUCTOR = -797952281;

        public UpdateChatReadInbox() {
        }

        public UpdateChatReadInbox(long var1, long var3, int var5) {
            this.chatId = var1;
            this.lastReadInboxMessageId = var3;
            this.unreadCount = var5;
        }

        public int getConstructor() {
            return -797952281;
        }
    }

    public static class UpdateChatDefaultDisableNotification extends TdApi.Update {
        public long chatId;
        public boolean defaultDisableNotification;
        public static final int CONSTRUCTOR = 464087707;

        public UpdateChatDefaultDisableNotification() {
        }

        public UpdateChatDefaultDisableNotification(long var1, boolean var3) {
            this.chatId = var1;
            this.defaultDisableNotification = var3;
        }

        public int getConstructor() {
            return 464087707;
        }
    }

    public static class UpdateChatHasScheduledMessages extends TdApi.Update {
        public long chatId;
        public boolean hasScheduledMessages;
        public static final int CONSTRUCTOR = 2064958167;

        public UpdateChatHasScheduledMessages() {
        }

        public UpdateChatHasScheduledMessages(long var1, boolean var3) {
            this.chatId = var1;
            this.hasScheduledMessages = var3;
        }

        public int getConstructor() {
            return 2064958167;
        }
    }

    public static class UpdateChatIsSponsored extends TdApi.Update {
        public long chatId;
        public boolean isSponsored;
        public long order;
        public static final int CONSTRUCTOR = -1196180070;

        public UpdateChatIsSponsored() {
        }

        public UpdateChatIsSponsored(long var1, boolean var3, long var4) {
            this.chatId = var1;
            this.isSponsored = var3;
            this.order = var4;
        }

        public int getConstructor() {
            return -1196180070;
        }
    }

    public static class UpdateChatIsMarkedAsUnread extends TdApi.Update {
        public long chatId;
        public boolean isMarkedAsUnread;
        public static final int CONSTRUCTOR = 1468347188;

        public UpdateChatIsMarkedAsUnread() {
        }

        public UpdateChatIsMarkedAsUnread(long var1, boolean var3) {
            this.chatId = var1;
            this.isMarkedAsUnread = var3;
        }

        public int getConstructor() {
            return 1468347188;
        }
    }

    public static class UpdateChatIsPinned extends TdApi.Update {
        public long chatId;
        public boolean isPinned;
        public long order;
        public static final int CONSTRUCTOR = 488876260;

        public UpdateChatIsPinned() {
        }

        public UpdateChatIsPinned(long var1, boolean var3, long var4) {
            this.chatId = var1;
            this.isPinned = var3;
            this.order = var4;
        }

        public int getConstructor() {
            return 488876260;
        }
    }

    public static class UpdateChatOrder extends TdApi.Update {
        public long chatId;
        public long order;
        public static final int CONSTRUCTOR = -1601888026;

        public UpdateChatOrder() {
        }

        public UpdateChatOrder(long var1, long var3) {
            this.chatId = var1;
            this.order = var3;
        }

        public int getConstructor() {
            return -1601888026;
        }
    }

    public static class UpdateChatLastMessage extends TdApi.Update {
        public long chatId;
        public TdApi.Message lastMessage;
        public long order;
        public static final int CONSTRUCTOR = 580348828;

        public UpdateChatLastMessage() {
        }

        public UpdateChatLastMessage(long var1, TdApi.Message var3, long var4) {
            this.chatId = var1;
            this.lastMessage = var3;
            this.order = var4;
        }

        public int getConstructor() {
            return 580348828;
        }
    }

    public static class UpdateChatPermissions extends TdApi.Update {
        public long chatId;
        public TdApi.ChatPermissions permissions;
        public static final int CONSTRUCTOR = -1622010003;

        public UpdateChatPermissions() {
        }

        public UpdateChatPermissions(long var1, TdApi.ChatPermissions var3) {
            this.chatId = var1;
            this.permissions = var3;
        }

        public int getConstructor() {
            return -1622010003;
        }
    }

    public static class UpdateChatPhoto extends TdApi.Update {
        public long chatId;
        public TdApi.ChatPhoto photo;
        public static final int CONSTRUCTOR = -209353966;

        public UpdateChatPhoto() {
        }

        public UpdateChatPhoto(long var1, TdApi.ChatPhoto var3) {
            this.chatId = var1;
            this.photo = var3;
        }

        public int getConstructor() {
            return -209353966;
        }
    }

    public static class UpdateChatTitle extends TdApi.Update {
        public long chatId;
        public String title;
        public static final int CONSTRUCTOR = -175405660;

        public UpdateChatTitle() {
        }

        public UpdateChatTitle(long var1, String var3) {
            this.chatId = var1;
            this.title = var3;
        }

        public int getConstructor() {
            return -175405660;
        }
    }

    public static class UpdateChatChatList extends TdApi.Update {
        public long chatId;
        public TdApi.ChatList chatList;
        public static final int CONSTRUCTOR = -170455894;

        public UpdateChatChatList() {
        }

        public UpdateChatChatList(long var1, TdApi.ChatList var3) {
            this.chatId = var1;
            this.chatList = var3;
        }

        public int getConstructor() {
            return -170455894;
        }
    }

    public static class UpdateNewChat extends TdApi.Update {
        public TdApi.Chat chat;
        public static final int CONSTRUCTOR = 2075757773;

        public UpdateNewChat() {
        }

        public UpdateNewChat(TdApi.Chat var1) {
            this.chat = var1;
        }

        public int getConstructor() {
            return 2075757773;
        }
    }

    public static class UpdateMessageLiveLocationViewed extends TdApi.Update {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = -1308260971;

        public UpdateMessageLiveLocationViewed() {
        }

        public UpdateMessageLiveLocationViewed(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        public int getConstructor() {
            return -1308260971;
        }
    }

    public static class UpdateMessageMentionRead extends TdApi.Update {
        public long chatId;
        public long messageId;
        public int unreadMentionCount;
        public static final int CONSTRUCTOR = -252228282;

        public UpdateMessageMentionRead() {
        }

        public UpdateMessageMentionRead(long var1, long var3, int var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.unreadMentionCount = var5;
        }

        public int getConstructor() {
            return -252228282;
        }
    }

    public static class UpdateMessageContentOpened extends TdApi.Update {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = -1520523131;

        public UpdateMessageContentOpened() {
        }

        public UpdateMessageContentOpened(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        public int getConstructor() {
            return -1520523131;
        }
    }

    public static class UpdateMessageViews extends TdApi.Update {
        public long chatId;
        public long messageId;
        public int views;
        public static final int CONSTRUCTOR = -1854131125;

        public UpdateMessageViews() {
        }

        public UpdateMessageViews(long var1, long var3, int var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.views = var5;
        }

        public int getConstructor() {
            return -1854131125;
        }
    }

    public static class UpdateMessageEdited extends TdApi.Update {
        public long chatId;
        public long messageId;
        public int editDate;
        public TdApi.ReplyMarkup replyMarkup;
        public static final int CONSTRUCTOR = -559545626;

        public UpdateMessageEdited() {
        }

        public UpdateMessageEdited(long var1, long var3, int var5, TdApi.ReplyMarkup var6) {
            this.chatId = var1;
            this.messageId = var3;
            this.editDate = var5;
            this.replyMarkup = var6;
        }

        public int getConstructor() {
            return -559545626;
        }
    }

    public static class UpdateMessageContent extends TdApi.Update {
        public long chatId;
        public long messageId;
        public TdApi.MessageContent newContent;
        public static final int CONSTRUCTOR = 506903332;

        public UpdateMessageContent() {
        }

        public UpdateMessageContent(long var1, long var3, TdApi.MessageContent var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.newContent = var5;
        }

        public int getConstructor() {
            return 506903332;
        }
    }

    public static class UpdateMessageSendFailed extends TdApi.Update {
        public TdApi.Message message;
        public long oldMessageId;
        public int errorCode;
        public String errorMessage;
        public static final int CONSTRUCTOR = -1032335779;

        public UpdateMessageSendFailed() {
        }

        public UpdateMessageSendFailed(TdApi.Message var1, long var2, int var4, String var5) {
            this.message = var1;
            this.oldMessageId = var2;
            this.errorCode = var4;
            this.errorMessage = var5;
        }

        public int getConstructor() {
            return -1032335779;
        }
    }

    public static class UpdateMessageSendSucceeded extends TdApi.Update {
        public TdApi.Message message;
        public long oldMessageId;
        public static final int CONSTRUCTOR = 1815715197;

        public UpdateMessageSendSucceeded() {
        }

        public UpdateMessageSendSucceeded(TdApi.Message var1, long var2) {
            this.message = var1;
            this.oldMessageId = var2;
        }

        public int getConstructor() {
            return 1815715197;
        }
    }

    public static class UpdateMessageSendAcknowledged extends TdApi.Update {
        public long chatId;
        public long messageId;
        public static final int CONSTRUCTOR = 1302843961;

        public UpdateMessageSendAcknowledged() {
        }

        public UpdateMessageSendAcknowledged(long var1, long var3) {
            this.chatId = var1;
            this.messageId = var3;
        }

        public int getConstructor() {
            return 1302843961;
        }
    }

    public static class UpdateNewMessage extends TdApi.Update {
        public TdApi.Message message;
        public static final int CONSTRUCTOR = -563105266;

        public UpdateNewMessage() {
        }

        public UpdateNewMessage(TdApi.Message var1) {
            this.message = var1;
        }

        public int getConstructor() {
            return -563105266;
        }
    }

    public static class UpdateAuthorizationState extends TdApi.Update {
        public TdApi.AuthorizationState authorizationState;
        public static final int CONSTRUCTOR = 1622347490;

        public UpdateAuthorizationState() {
        }

        public UpdateAuthorizationState(TdApi.AuthorizationState var1) {
            this.authorizationState = var1;
        }

        public int getConstructor() {
            return 1622347490;
        }
    }

    public abstract static class Update extends TdApi.Object {
        public Update() {
        }
    }

    public static class TopChatCategoryForwardChats extends TdApi.TopChatCategory {
        public static final int CONSTRUCTOR = 1695922133;

        public TopChatCategoryForwardChats() {
        }

        public int getConstructor() {
            return 1695922133;
        }
    }

    public static class TopChatCategoryCalls extends TdApi.TopChatCategory {
        public static final int CONSTRUCTOR = 356208861;

        public TopChatCategoryCalls() {
        }

        public int getConstructor() {
            return 356208861;
        }
    }

    public static class TopChatCategoryInlineBots extends TdApi.TopChatCategory {
        public static final int CONSTRUCTOR = 377023356;

        public TopChatCategoryInlineBots() {
        }

        public int getConstructor() {
            return 377023356;
        }
    }

    public static class TopChatCategoryChannels extends TdApi.TopChatCategory {
        public static final int CONSTRUCTOR = -500825885;

        public TopChatCategoryChannels() {
        }

        public int getConstructor() {
            return -500825885;
        }
    }

    public static class TopChatCategoryGroups extends TdApi.TopChatCategory {
        public static final int CONSTRUCTOR = 1530056846;

        public TopChatCategoryGroups() {
        }

        public int getConstructor() {
            return 1530056846;
        }
    }

    public static class TopChatCategoryBots extends TdApi.TopChatCategory {
        public static final int CONSTRUCTOR = -1577129195;

        public TopChatCategoryBots() {
        }

        public int getConstructor() {
            return -1577129195;
        }
    }

    public static class TopChatCategoryUsers extends TdApi.TopChatCategory {
        public static final int CONSTRUCTOR = 1026706816;

        public TopChatCategoryUsers() {
        }

        public int getConstructor() {
            return 1026706816;
        }
    }

    public abstract static class TopChatCategory extends TdApi.Object {
        public TopChatCategory() {
        }
    }

    public static class TextParseModeHTML extends TdApi.TextParseMode {
        public static final int CONSTRUCTOR = 1660208627;

        public TextParseModeHTML() {
        }

        public int getConstructor() {
            return 1660208627;
        }
    }

    public static class TextParseModeMarkdown extends TdApi.TextParseMode {
        public int version;
        public static final int CONSTRUCTOR = 360073407;

        public TextParseModeMarkdown() {
        }

        public TextParseModeMarkdown(int var1) {
            this.version = var1;
        }

        public int getConstructor() {
            return 360073407;
        }
    }

    public abstract static class TextParseMode extends TdApi.Object {
        public TextParseMode() {
        }
    }

    public static class TextEntityTypeMentionName extends TdApi.TextEntityType {
        public int userId;
        public static final int CONSTRUCTOR = -791517091;

        public TextEntityTypeMentionName() {
        }

        public TextEntityTypeMentionName(int var1) {
            this.userId = var1;
        }

        public int getConstructor() {
            return -791517091;
        }
    }

    public static class TextEntityTypeTextUrl extends TdApi.TextEntityType {
        public String url;
        public static final int CONSTRUCTOR = 445719651;

        public TextEntityTypeTextUrl() {
        }

        public TextEntityTypeTextUrl(String var1) {
            this.url = var1;
        }

        public int getConstructor() {
            return 445719651;
        }
    }

    public static class TextEntityTypePreCode extends TdApi.TextEntityType {
        public String language;
        public static final int CONSTRUCTOR = -945325397;

        public TextEntityTypePreCode() {
        }

        public TextEntityTypePreCode(String var1) {
            this.language = var1;
        }

        public int getConstructor() {
            return -945325397;
        }
    }

    public static class TextEntityTypePre extends TdApi.TextEntityType {
        public static final int CONSTRUCTOR = 1648958606;

        public TextEntityTypePre() {
        }

        public int getConstructor() {
            return 1648958606;
        }
    }

    public static class TextEntityTypeCode extends TdApi.TextEntityType {
        public static final int CONSTRUCTOR = -974534326;

        public TextEntityTypeCode() {
        }

        public int getConstructor() {
            return -974534326;
        }
    }

    public static class TextEntityTypeStrikethrough extends TdApi.TextEntityType {
        public static final int CONSTRUCTOR = 961529082;

        public TextEntityTypeStrikethrough() {
        }

        public int getConstructor() {
            return 961529082;
        }
    }

    public static class TextEntityTypeUnderline extends TdApi.TextEntityType {
        public static final int CONSTRUCTOR = 792317842;

        public TextEntityTypeUnderline() {
        }

        public int getConstructor() {
            return 792317842;
        }
    }

    public static class TextEntityTypeItalic extends TdApi.TextEntityType {
        public static final int CONSTRUCTOR = -118253987;

        public TextEntityTypeItalic() {
        }

        public int getConstructor() {
            return -118253987;
        }
    }

    public static class TextEntityTypeBold extends TdApi.TextEntityType {
        public static final int CONSTRUCTOR = -1128210000;

        public TextEntityTypeBold() {
        }

        public int getConstructor() {
            return -1128210000;
        }
    }

    public static class TextEntityTypePhoneNumber extends TdApi.TextEntityType {
        public static final int CONSTRUCTOR = -1160140246;

        public TextEntityTypePhoneNumber() {
        }

        public int getConstructor() {
            return -1160140246;
        }
    }

    public static class TextEntityTypeEmailAddress extends TdApi.TextEntityType {
        public static final int CONSTRUCTOR = 1425545249;

        public TextEntityTypeEmailAddress() {
        }

        public int getConstructor() {
            return 1425545249;
        }
    }

    public static class TextEntityTypeUrl extends TdApi.TextEntityType {
        public static final int CONSTRUCTOR = -1312762756;

        public TextEntityTypeUrl() {
        }

        public int getConstructor() {
            return -1312762756;
        }
    }

    public static class TextEntityTypeBotCommand extends TdApi.TextEntityType {
        public static final int CONSTRUCTOR = -1150997581;

        public TextEntityTypeBotCommand() {
        }

        public int getConstructor() {
            return -1150997581;
        }
    }

    public static class TextEntityTypeCashtag extends TdApi.TextEntityType {
        public static final int CONSTRUCTOR = 1222915915;

        public TextEntityTypeCashtag() {
        }

        public int getConstructor() {
            return 1222915915;
        }
    }

    public static class TextEntityTypeHashtag extends TdApi.TextEntityType {
        public static final int CONSTRUCTOR = -1023958307;

        public TextEntityTypeHashtag() {
        }

        public int getConstructor() {
            return -1023958307;
        }
    }

    public static class TextEntityTypeMention extends TdApi.TextEntityType {
        public static final int CONSTRUCTOR = 934535013;

        public TextEntityTypeMention() {
        }

        public int getConstructor() {
            return 934535013;
        }
    }

    public abstract static class TextEntityType extends TdApi.Object {
        public TextEntityType() {
        }
    }

    public static class TextEntity extends TdApi.Object {
        public int offset;
        public int length;
        public TdApi.TextEntityType type;
        public static final int CONSTRUCTOR = -1951688280;

        public TextEntity() {
        }

        public TextEntity(int var1, int var2, TdApi.TextEntityType var3) {
            this.offset = var1;
            this.length = var2;
            this.type = var3;
        }

        public int getConstructor() {
            return -1951688280;
        }
    }

    public static class TextEntities extends TdApi.Object {
        public TdApi.TextEntity[] entities;
        public static final int CONSTRUCTOR = -933199172;

        public TextEntities() {
        }

        public TextEntities(TdApi.TextEntity[] var1) {
            this.entities = var1;
        }

        public int getConstructor() {
            return -933199172;
        }
    }

    public static class Text extends TdApi.Object {
        public String text;
        public static final int CONSTRUCTOR = 578181272;

        public Text() {
        }

        public Text(String var1) {
            this.text = var1;
        }

        public int getConstructor() {
            return 578181272;
        }
    }

    public static class TestVectorStringObject extends TdApi.Object {
        public TdApi.TestString[] value;
        public static final int CONSTRUCTOR = 80780537;

        public TestVectorStringObject() {
        }

        public TestVectorStringObject(TdApi.TestString[] var1) {
            this.value = var1;
        }

        public int getConstructor() {
            return 80780537;
        }
    }

    public static class TestVectorString extends TdApi.Object {
        public String[] value;
        public static final int CONSTRUCTOR = 79339995;

        public TestVectorString() {
        }

        public TestVectorString(String[] var1) {
            this.value = var1;
        }

        public int getConstructor() {
            return 79339995;
        }
    }

    public static class TestVectorIntObject extends TdApi.Object {
        public TdApi.TestInt[] value;
        public static final int CONSTRUCTOR = 125891546;

        public TestVectorIntObject() {
        }

        public TestVectorIntObject(TdApi.TestInt[] var1) {
            this.value = var1;
        }

        public int getConstructor() {
            return 125891546;
        }
    }

    public static class TestVectorInt extends TdApi.Object {
        public int[] value;
        public static final int CONSTRUCTOR = 593682027;

        public TestVectorInt() {
        }

        public TestVectorInt(int[] var1) {
            this.value = var1;
        }

        public int getConstructor() {
            return 593682027;
        }
    }

    public static class TestString extends TdApi.Object {
        public String value;
        public static final int CONSTRUCTOR = -27891572;

        public TestString() {
        }

        public TestString(String var1) {
            this.value = var1;
        }

        public int getConstructor() {
            return -27891572;
        }
    }

    public static class TestInt extends TdApi.Object {
        public int value;
        public static final int CONSTRUCTOR = -574804983;

        public TestInt() {
        }

        public TestInt(int var1) {
            this.value = var1;
        }

        public int getConstructor() {
            return -574804983;
        }
    }

    public static class TestBytes extends TdApi.Object {
        public byte[] value;
        public static final int CONSTRUCTOR = -1541225250;

        public TestBytes() {
        }

        public TestBytes(byte[] var1) {
            this.value = var1;
        }

        public int getConstructor() {
            return -1541225250;
        }
    }

    public static class TermsOfService extends TdApi.Object {
        public TdApi.FormattedText text;
        public int minUserAge;
        public boolean showPopup;
        public static final int CONSTRUCTOR = 739422597;

        public TermsOfService() {
        }

        public TermsOfService(TdApi.FormattedText var1, int var2, boolean var3) {
            this.text = var1;
            this.minUserAge = var2;
            this.showPopup = var3;
        }

        public int getConstructor() {
            return 739422597;
        }
    }

    public static class TemporaryPasswordState extends TdApi.Object {
        public boolean hasPassword;
        public int validFor;
        public static final int CONSTRUCTOR = 939837410;

        public TemporaryPasswordState() {
        }

        public TemporaryPasswordState(boolean var1, int var2) {
            this.hasPassword = var1;
            this.validFor = var2;
        }

        public int getConstructor() {
            return 939837410;
        }
    }

    public static class TdlibParameters extends TdApi.Object {
        public boolean useTestDc;
        public String databaseDirectory;
        public String filesDirectory;
        public boolean useFileDatabase;
        public boolean useChatInfoDatabase;
        public boolean useMessageDatabase;
        public boolean useSecretChats;
        public int apiId;
        public String apiHash;
        public String systemLanguageCode;
        public String deviceModel;
        public String systemVersion;
        public String applicationVersion;
        public boolean enableStorageOptimizer;
        public boolean ignoreFileNames;
        public static final int CONSTRUCTOR = -761520773;

        public TdlibParameters() {
        }

        public TdlibParameters(boolean var1, String var2, String var3, boolean var4, boolean var5, boolean var6, boolean var7, int var8, String var9, String var10, String var11, String var12, String var13, boolean var14, boolean var15) {
            this.useTestDc = var1;
            this.databaseDirectory = var2;
            this.filesDirectory = var3;
            this.useFileDatabase = var4;
            this.useChatInfoDatabase = var5;
            this.useMessageDatabase = var6;
            this.useSecretChats = var7;
            this.apiId = var8;
            this.apiHash = var9;
            this.systemLanguageCode = var10;
            this.deviceModel = var11;
            this.systemVersion = var12;
            this.applicationVersion = var13;
            this.enableStorageOptimizer = var14;
            this.ignoreFileNames = var15;
        }

        public int getConstructor() {
            return -761520773;
        }
    }

    public static class TMeUrls extends TdApi.Object {
        public TdApi.TMeUrl[] urls;
        public static final int CONSTRUCTOR = -1130595098;

        public TMeUrls() {
        }

        public TMeUrls(TdApi.TMeUrl[] var1) {
            this.urls = var1;
        }

        public int getConstructor() {
            return -1130595098;
        }
    }

    public static class TMeUrlTypeStickerSet extends TdApi.TMeUrlType {
        public long stickerSetId;
        public static final int CONSTRUCTOR = 1602473196;

        public TMeUrlTypeStickerSet() {
        }

        public TMeUrlTypeStickerSet(long var1) {
            this.stickerSetId = var1;
        }

        public int getConstructor() {
            return 1602473196;
        }
    }

    public static class TMeUrlTypeChatInvite extends TdApi.TMeUrlType {
        public TdApi.ChatInviteLinkInfo info;
        public static final int CONSTRUCTOR = 313907785;

        public TMeUrlTypeChatInvite() {
        }

        public TMeUrlTypeChatInvite(TdApi.ChatInviteLinkInfo var1) {
            this.info = var1;
        }

        public int getConstructor() {
            return 313907785;
        }
    }

    public static class TMeUrlTypeSupergroup extends TdApi.TMeUrlType {
        public long supergroupId;
        public static final int CONSTRUCTOR = -1353369944;

        public TMeUrlTypeSupergroup() {
        }

        public TMeUrlTypeSupergroup(long var1) {
            this.supergroupId = var1;
        }

        public int getConstructor() {
            return -1353369944;
        }
    }

    public static class TMeUrlTypeUser extends TdApi.TMeUrlType {
        public int userId;
        public static final int CONSTRUCTOR = -1198700130;

        public TMeUrlTypeUser() {
        }

        public TMeUrlTypeUser(int var1) {
            this.userId = var1;
        }

        public int getConstructor() {
            return -1198700130;
        }
    }

    public abstract static class TMeUrlType extends TdApi.Object {
        public TMeUrlType() {
        }
    }

    public static class TMeUrl extends TdApi.Object {
        public String url;
        public TdApi.TMeUrlType type;
        public static final int CONSTRUCTOR = -1140786622;

        public TMeUrl() {
        }

        public TMeUrl(String var1, TdApi.TMeUrlType var2) {
            this.url = var1;
            this.type = var2;
        }

        public int getConstructor() {
            return -1140786622;
        }
    }

    public static class SupergroupMembersFilterBots extends TdApi.SupergroupMembersFilter {
        public static final int CONSTRUCTOR = 492138918;

        public SupergroupMembersFilterBots() {
        }

        public int getConstructor() {
            return 492138918;
        }
    }

    public static class SupergroupMembersFilterBanned extends TdApi.SupergroupMembersFilter {
        public String query;
        public static final int CONSTRUCTOR = -1210621683;

        public SupergroupMembersFilterBanned() {
        }

        public SupergroupMembersFilterBanned(String var1) {
            this.query = var1;
        }

        public int getConstructor() {
            return -1210621683;
        }
    }

    public static class SupergroupMembersFilterRestricted extends TdApi.SupergroupMembersFilter {
        public String query;
        public static final int CONSTRUCTOR = -1107800034;

        public SupergroupMembersFilterRestricted() {
        }

        public SupergroupMembersFilterRestricted(String var1) {
            this.query = var1;
        }

        public int getConstructor() {
            return -1107800034;
        }
    }

    public static class SupergroupMembersFilterSearch extends TdApi.SupergroupMembersFilter {
        public String query;
        public static final int CONSTRUCTOR = -1696358469;

        public SupergroupMembersFilterSearch() {
        }

        public SupergroupMembersFilterSearch(String var1) {
            this.query = var1;
        }

        public int getConstructor() {
            return -1696358469;
        }
    }

    public static class SupergroupMembersFilterAdministrators extends TdApi.SupergroupMembersFilter {
        public static final int CONSTRUCTOR = -2097380265;

        public SupergroupMembersFilterAdministrators() {
        }

        public int getConstructor() {
            return -2097380265;
        }
    }

    public static class SupergroupMembersFilterContacts extends TdApi.SupergroupMembersFilter {
        public String query;
        public static final int CONSTRUCTOR = -1282910856;

        public SupergroupMembersFilterContacts() {
        }

        public SupergroupMembersFilterContacts(String var1) {
            this.query = var1;
        }

        public int getConstructor() {
            return -1282910856;
        }
    }

    public static class SupergroupMembersFilterRecent extends TdApi.SupergroupMembersFilter {
        public static final int CONSTRUCTOR = 1178199509;

        public SupergroupMembersFilterRecent() {
        }

        public int getConstructor() {
            return 1178199509;
        }
    }

    public abstract static class SupergroupMembersFilter extends TdApi.Object {
        public SupergroupMembersFilter() {
        }
    }

    public static class SupergroupFullInfo extends TdApi.Object {
        public String description;
        public int memberCount;
        public int administratorCount;
        public int restrictedCount;
        public int bannedCount;
        public long linkedChatId;
        public int slowModeDelay;
        public double slowModeDelayExpiresIn;
        public boolean canGetMembers;
        public boolean canSetUsername;
        public boolean canSetStickerSet;
        public boolean canSetLocation;
        public boolean canViewStatistics;
        public boolean isAllHistoryAvailable;
        public long stickerSetId;
        public TdApi.ChatLocation location;
        public String inviteLink;
        public int upgradedFromBasicGroupId;
        public long upgradedFromMaxMessageId;
        public static final int CONSTRUCTOR = -1562832718;

        public SupergroupFullInfo() {
        }

        public SupergroupFullInfo(String var1, int var2, int var3, int var4, int var5, long var6, int var8, double var9, boolean var11, boolean var12, boolean var13, boolean var14, boolean var15, boolean var16, long var17, TdApi.ChatLocation var19, String var20, int var21, long var22) {
            this.description = var1;
            this.memberCount = var2;
            this.administratorCount = var3;
            this.restrictedCount = var4;
            this.bannedCount = var5;
            this.linkedChatId = var6;
            this.slowModeDelay = var8;
            this.slowModeDelayExpiresIn = var9;
            this.canGetMembers = var11;
            this.canSetUsername = var12;
            this.canSetStickerSet = var13;
            this.canSetLocation = var14;
            this.canViewStatistics = var15;
            this.isAllHistoryAvailable = var16;
            this.stickerSetId = var17;
            this.location = var19;
            this.inviteLink = var20;
            this.upgradedFromBasicGroupId = var21;
            this.upgradedFromMaxMessageId = var22;
        }

        public int getConstructor() {
            return -1562832718;
        }
    }

    public static class Supergroup extends TdApi.Object {
        public int id;
        public String username;
        public int date;
        public TdApi.ChatMemberStatus status;
        public int memberCount;
        public boolean hasLinkedChat;
        public boolean hasLocation;
        public boolean signMessages;
        public boolean isSlowModeEnabled;
        public boolean isChannel;
        public boolean isVerified;
        public String restrictionReason;
        public boolean isScam;
        public static final int CONSTRUCTOR = -103091;

        public Supergroup() {
        }

        public Supergroup(int var1, String var2, int var3, TdApi.ChatMemberStatus var4, int var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10, boolean var11, String var12, boolean var13) {
            this.id = var1;
            this.username = var2;
            this.date = var3;
            this.status = var4;
            this.memberCount = var5;
            this.hasLinkedChat = var6;
            this.hasLocation = var7;
            this.signMessages = var8;
            this.isSlowModeEnabled = var9;
            this.isChannel = var10;
            this.isVerified = var11;
            this.restrictionReason = var12;
            this.isScam = var13;
        }

        public int getConstructor() {
            return -103091;
        }
    }

    public static class StorageStatisticsFast extends TdApi.Object {
        public long filesSize;
        public int fileCount;
        public long databaseSize;
        public long languagePackDatabaseSize;
        public long logSize;
        public static final int CONSTRUCTOR = -884922271;

        public StorageStatisticsFast() {
        }

        public StorageStatisticsFast(long var1, int var3, long var4, long var6, long var8) {
            this.filesSize = var1;
            this.fileCount = var3;
            this.databaseSize = var4;
            this.languagePackDatabaseSize = var6;
            this.logSize = var8;
        }

        public int getConstructor() {
            return -884922271;
        }
    }

    public static class StorageStatisticsByFileType extends TdApi.Object {
        public TdApi.FileType fileType;
        public long size;
        public int count;
        public static final int CONSTRUCTOR = 714012840;

        public StorageStatisticsByFileType() {
        }

        public StorageStatisticsByFileType(TdApi.FileType var1, long var2, int var4) {
            this.fileType = var1;
            this.size = var2;
            this.count = var4;
        }

        public int getConstructor() {
            return 714012840;
        }
    }

    public static class StorageStatisticsByChat extends TdApi.Object {
        public long chatId;
        public long size;
        public int count;
        public TdApi.StorageStatisticsByFileType[] byFileType;
        public static final int CONSTRUCTOR = 635434531;

        public StorageStatisticsByChat() {
        }

        public StorageStatisticsByChat(long var1, long var3, int var5, TdApi.StorageStatisticsByFileType[] var6) {
            this.chatId = var1;
            this.size = var3;
            this.count = var5;
            this.byFileType = var6;
        }

        public int getConstructor() {
            return 635434531;
        }
    }

    public static class StorageStatistics extends TdApi.Object {
        public long size;
        public int count;
        public TdApi.StorageStatisticsByChat[] byChat;
        public static final int CONSTRUCTOR = 217237013;

        public StorageStatistics() {
        }

        public StorageStatistics(long var1, int var3, TdApi.StorageStatisticsByChat[] var4) {
            this.size = var1;
            this.count = var3;
            this.byChat = var4;
        }

        public int getConstructor() {
            return 217237013;
        }
    }

    public static class Stickers extends TdApi.Object {
        public TdApi.Sticker[] stickers;
        public static final int CONSTRUCTOR = 1974859260;

        public Stickers() {
        }

        public Stickers(TdApi.Sticker[] var1) {
            this.stickers = var1;
        }

        public int getConstructor() {
            return 1974859260;
        }
    }

    public static class StickerSets extends TdApi.Object {
        public int totalCount;
        public TdApi.StickerSetInfo[] sets;
        public static final int CONSTRUCTOR = -1883828812;

        public StickerSets() {
        }

        public StickerSets(int var1, TdApi.StickerSetInfo[] var2) {
            this.totalCount = var1;
            this.sets = var2;
        }

        public int getConstructor() {
            return -1883828812;
        }
    }

    public static class StickerSetInfo extends TdApi.Object {
        public long id;
        public String title;
        public String name;
        public TdApi.PhotoSize thumbnail;
        public boolean isInstalled;
        public boolean isArchived;
        public boolean isOfficial;
        public boolean isAnimated;
        public boolean isMasks;
        public boolean isViewed;
        public int size;
        public TdApi.Sticker[] covers;
        public static final int CONSTRUCTOR = 228054782;

        public StickerSetInfo() {
        }

        public StickerSetInfo(long var1, String var3, String var4, TdApi.PhotoSize var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10, boolean var11, int var12, TdApi.Sticker[] var13) {
            this.id = var1;
            this.title = var3;
            this.name = var4;
            this.thumbnail = var5;
            this.isInstalled = var6;
            this.isArchived = var7;
            this.isOfficial = var8;
            this.isAnimated = var9;
            this.isMasks = var10;
            this.isViewed = var11;
            this.size = var12;
            this.covers = var13;
        }

        public int getConstructor() {
            return 228054782;
        }
    }

    public static class StickerSet extends TdApi.Object {
        public long id;
        public String title;
        public String name;
        public TdApi.PhotoSize thumbnail;
        public boolean isInstalled;
        public boolean isArchived;
        public boolean isOfficial;
        public boolean isAnimated;
        public boolean isMasks;
        public boolean isViewed;
        public TdApi.Sticker[] stickers;
        public TdApi.Emojis[] emojis;
        public static final int CONSTRUCTOR = 734588298;

        public StickerSet() {
        }

        public StickerSet(long var1, String var3, String var4, TdApi.PhotoSize var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10, boolean var11, TdApi.Sticker[] var12, TdApi.Emojis[] var13) {
            this.id = var1;
            this.title = var3;
            this.name = var4;
            this.thumbnail = var5;
            this.isInstalled = var6;
            this.isArchived = var7;
            this.isOfficial = var8;
            this.isAnimated = var9;
            this.isMasks = var10;
            this.isViewed = var11;
            this.stickers = var12;
            this.emojis = var13;
        }

        public int getConstructor() {
            return 734588298;
        }
    }

    public static class Sticker extends TdApi.Object {
        public long setId;
        public int width;
        public int height;
        public String emoji;
        public boolean isAnimated;
        public boolean isMask;
        public TdApi.MaskPosition maskPosition;
        public TdApi.PhotoSize thumbnail;
        public TdApi.File sticker;
        public static final int CONSTRUCTOR = -1835470627;

        public Sticker() {
        }

        public Sticker(long var1, int var3, int var4, String var5, boolean var6, boolean var7, TdApi.MaskPosition var8, TdApi.PhotoSize var9, TdApi.File var10) {
            this.setId = var1;
            this.width = var3;
            this.height = var4;
            this.emoji = var5;
            this.isAnimated = var6;
            this.isMask = var7;
            this.maskPosition = var8;
            this.thumbnail = var9;
            this.sticker = var10;
        }

        public int getConstructor() {
            return -1835470627;
        }
    }

    public static class ShippingOption extends TdApi.Object {
        public String id;
        public String title;
        public TdApi.LabeledPricePart[] priceParts;
        public static final int CONSTRUCTOR = 1425690001;

        public ShippingOption() {
        }

        public ShippingOption(String var1, String var2, TdApi.LabeledPricePart[] var3) {
            this.id = var1;
            this.title = var2;
            this.priceParts = var3;
        }

        public int getConstructor() {
            return 1425690001;
        }
    }

    public static class Sessions extends TdApi.Object {
        public TdApi.Session[] sessions;
        public static final int CONSTRUCTOR = -463118121;

        public Sessions() {
        }

        public Sessions(TdApi.Session[] var1) {
            this.sessions = var1;
        }

        public int getConstructor() {
            return -463118121;
        }
    }

    public static class Session extends TdApi.Object {
        public long id;
        public boolean isCurrent;
        public boolean isPasswordPending;
        public int apiId;
        public String applicationName;
        public String applicationVersion;
        public boolean isOfficialApplication;
        public String deviceModel;
        public String platform;
        public String systemVersion;
        public int logInDate;
        public int lastActiveDate;
        public String ip;
        public String country;
        public String region;
        public static final int CONSTRUCTOR = 1920553176;

        public Session() {
        }

        public Session(long var1, boolean var3, boolean var4, int var5, String var6, String var7, boolean var8, String var9, String var10, String var11, int var12, int var13, String var14, String var15, String var16) {
            this.id = var1;
            this.isCurrent = var3;
            this.isPasswordPending = var4;
            this.apiId = var5;
            this.applicationName = var6;
            this.applicationVersion = var7;
            this.isOfficialApplication = var8;
            this.deviceModel = var9;
            this.platform = var10;
            this.systemVersion = var11;
            this.logInDate = var12;
            this.lastActiveDate = var13;
            this.ip = var14;
            this.country = var15;
            this.region = var16;
        }

        public int getConstructor() {
            return 1920553176;
        }
    }

    public static class SendMessageOptions extends TdApi.Object {
        public boolean disableNotification;
        public boolean fromBackground;
        public TdApi.MessageSchedulingState schedulingState;
        public static final int CONSTRUCTOR = 669760254;

        public SendMessageOptions() {
        }

        public SendMessageOptions(boolean var1, boolean var2, TdApi.MessageSchedulingState var3) {
            this.disableNotification = var1;
            this.fromBackground = var2;
            this.schedulingState = var3;
        }

        public int getConstructor() {
            return 669760254;
        }
    }

    public static class SecretChatStateClosed extends TdApi.SecretChatState {
        public static final int CONSTRUCTOR = -1945106707;

        public SecretChatStateClosed() {
        }

        public int getConstructor() {
            return -1945106707;
        }
    }

    public static class SecretChatStateReady extends TdApi.SecretChatState {
        public static final int CONSTRUCTOR = -1611352087;

        public SecretChatStateReady() {
        }

        public int getConstructor() {
            return -1611352087;
        }
    }

    public static class SecretChatStatePending extends TdApi.SecretChatState {
        public static final int CONSTRUCTOR = -1637050756;

        public SecretChatStatePending() {
        }

        public int getConstructor() {
            return -1637050756;
        }
    }

    public abstract static class SecretChatState extends TdApi.Object {
        public SecretChatState() {
        }
    }

    public static class SecretChat extends TdApi.Object {
        public int id;
        public int userId;
        public TdApi.SecretChatState state;
        public boolean isOutbound;
        public int ttl;
        public byte[] keyHash;
        public int layer;
        public static final int CONSTRUCTOR = 1279231629;

        public SecretChat() {
        }

        public SecretChat(int var1, int var2, TdApi.SecretChatState var3, boolean var4, int var5, byte[] var6, int var7) {
            this.id = var1;
            this.userId = var2;
            this.state = var3;
            this.isOutbound = var4;
            this.ttl = var5;
            this.keyHash = var6;
            this.layer = var7;
        }

        public int getConstructor() {
            return 1279231629;
        }
    }

    public static class Seconds extends TdApi.Object {
        public double seconds;
        public static final int CONSTRUCTOR = 959899022;

        public Seconds() {
        }

        public Seconds(double var1) {
            this.seconds = var1;
        }

        public int getConstructor() {
            return 959899022;
        }
    }

    public static class SearchMessagesFilterUnreadMention extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = -95769149;

        public SearchMessagesFilterUnreadMention() {
        }

        public int getConstructor() {
            return -95769149;
        }
    }

    public static class SearchMessagesFilterMention extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = 2001258652;

        public SearchMessagesFilterMention() {
        }

        public int getConstructor() {
            return 2001258652;
        }
    }

    public static class SearchMessagesFilterVoiceAndVideoNote extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = 664174819;

        public SearchMessagesFilterVoiceAndVideoNote() {
        }

        public int getConstructor() {
            return 664174819;
        }
    }

    public static class SearchMessagesFilterVideoNote extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = 564323321;

        public SearchMessagesFilterVideoNote() {
        }

        public int getConstructor() {
            return 564323321;
        }
    }

    public static class SearchMessagesFilterMissedCall extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = 970663098;

        public SearchMessagesFilterMissedCall() {
        }

        public int getConstructor() {
            return 970663098;
        }
    }

    public static class SearchMessagesFilterCall extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = 1305231012;

        public SearchMessagesFilterCall() {
        }

        public int getConstructor() {
            return 1305231012;
        }
    }

    public static class SearchMessagesFilterChatPhoto extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = -1247751329;

        public SearchMessagesFilterChatPhoto() {
        }

        public int getConstructor() {
            return -1247751329;
        }
    }

    public static class SearchMessagesFilterUrl extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = -1828724341;

        public SearchMessagesFilterUrl() {
        }

        public int getConstructor() {
            return -1828724341;
        }
    }

    public static class SearchMessagesFilterPhotoAndVideo extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = 1352130963;

        public SearchMessagesFilterPhotoAndVideo() {
        }

        public int getConstructor() {
            return 1352130963;
        }
    }

    public static class SearchMessagesFilterVoiceNote extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = 1841439357;

        public SearchMessagesFilterVoiceNote() {
        }

        public int getConstructor() {
            return 1841439357;
        }
    }

    public static class SearchMessagesFilterVideo extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = 115538222;

        public SearchMessagesFilterVideo() {
        }

        public int getConstructor() {
            return 115538222;
        }
    }

    public static class SearchMessagesFilterPhoto extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = 925932293;

        public SearchMessagesFilterPhoto() {
        }

        public int getConstructor() {
            return 925932293;
        }
    }

    public static class SearchMessagesFilterDocument extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = 1526331215;

        public SearchMessagesFilterDocument() {
        }

        public int getConstructor() {
            return 1526331215;
        }
    }

    public static class SearchMessagesFilterAudio extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = 867505275;

        public SearchMessagesFilterAudio() {
        }

        public int getConstructor() {
            return 867505275;
        }
    }

    public static class SearchMessagesFilterAnimation extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = -155713339;

        public SearchMessagesFilterAnimation() {
        }

        public int getConstructor() {
            return -155713339;
        }
    }

    public static class SearchMessagesFilterEmpty extends TdApi.SearchMessagesFilter {
        public static final int CONSTRUCTOR = -869395657;

        public SearchMessagesFilterEmpty() {
        }

        public int getConstructor() {
            return -869395657;
        }
    }

    public abstract static class SearchMessagesFilter extends TdApi.Object {
        public SearchMessagesFilter() {
        }
    }

    public static class ScopeNotificationSettings extends TdApi.Object {
        public int muteFor;
        public String sound;
        public boolean showPreview;
        public boolean disablePinnedMessageNotifications;
        public boolean disableMentionNotifications;
        public static final int CONSTRUCTOR = -426103745;

        public ScopeNotificationSettings() {
        }

        public ScopeNotificationSettings(int var1, String var2, boolean var3, boolean var4, boolean var5) {
            this.muteFor = var1;
            this.sound = var2;
            this.showPreview = var3;
            this.disablePinnedMessageNotifications = var4;
            this.disableMentionNotifications = var5;
        }

        public int getConstructor() {
            return -426103745;
        }
    }

    public static class SavedCredentials extends TdApi.Object {
        public String id;
        public String title;
        public static final int CONSTRUCTOR = -370273060;

        public SavedCredentials() {
        }

        public SavedCredentials(String var1, String var2) {
            this.id = var1;
            this.title = var2;
        }

        public int getConstructor() {
            return -370273060;
        }
    }

    public static class RichTexts extends TdApi.RichText {
        public TdApi.RichText[] texts;
        public static final int CONSTRUCTOR = 1647457821;

        public RichTexts() {
        }

        public RichTexts(TdApi.RichText[] var1) {
            this.texts = var1;
        }

        public int getConstructor() {
            return 1647457821;
        }
    }

    public static class RichTextAnchor extends TdApi.RichText {
        public TdApi.RichText text;
        public String name;
        public static final int CONSTRUCTOR = 673137292;

        public RichTextAnchor() {
        }

        public RichTextAnchor(TdApi.RichText var1, String var2) {
            this.text = var1;
            this.name = var2;
        }

        public int getConstructor() {
            return 673137292;
        }
    }

    public static class RichTextIcon extends TdApi.RichText {
        public TdApi.Document document;
        public int width;
        public int height;
        public static final int CONSTRUCTOR = -1480316158;

        public RichTextIcon() {
        }

        public RichTextIcon(TdApi.Document var1, int var2, int var3) {
            this.document = var1;
            this.width = var2;
            this.height = var3;
        }

        public int getConstructor() {
            return -1480316158;
        }
    }

    public static class RichTextPhoneNumber extends TdApi.RichText {
        public TdApi.RichText text;
        public String phoneNumber;
        public static final int CONSTRUCTOR = 128521539;

        public RichTextPhoneNumber() {
        }

        public RichTextPhoneNumber(TdApi.RichText var1, String var2) {
            this.text = var1;
            this.phoneNumber = var2;
        }

        public int getConstructor() {
            return 128521539;
        }
    }

    public static class RichTextMarked extends TdApi.RichText {
        public TdApi.RichText text;
        public static final int CONSTRUCTOR = -1271999614;

        public RichTextMarked() {
        }

        public RichTextMarked(TdApi.RichText var1) {
            this.text = var1;
        }

        public int getConstructor() {
            return -1271999614;
        }
    }

    public static class RichTextSuperscript extends TdApi.RichText {
        public TdApi.RichText text;
        public static final int CONSTRUCTOR = -382241437;

        public RichTextSuperscript() {
        }

        public RichTextSuperscript(TdApi.RichText var1) {
            this.text = var1;
        }

        public int getConstructor() {
            return -382241437;
        }
    }

    public static class RichTextSubscript extends TdApi.RichText {
        public TdApi.RichText text;
        public static final int CONSTRUCTOR = -868197812;

        public RichTextSubscript() {
        }

        public RichTextSubscript(TdApi.RichText var1) {
            this.text = var1;
        }

        public int getConstructor() {
            return -868197812;
        }
    }

    public static class RichTextEmailAddress extends TdApi.RichText {
        public TdApi.RichText text;
        public String emailAddress;
        public static final int CONSTRUCTOR = 40018679;

        public RichTextEmailAddress() {
        }

        public RichTextEmailAddress(TdApi.RichText var1, String var2) {
            this.text = var1;
            this.emailAddress = var2;
        }

        public int getConstructor() {
            return 40018679;
        }
    }

    public static class RichTextUrl extends TdApi.RichText {
        public TdApi.RichText text;
        public String url;
        public boolean isCached;
        public static final int CONSTRUCTOR = 83939092;

        public RichTextUrl() {
        }

        public RichTextUrl(TdApi.RichText var1, String var2, boolean var3) {
            this.text = var1;
            this.url = var2;
            this.isCached = var3;
        }

        public int getConstructor() {
            return 83939092;
        }
    }

    public static class RichTextFixed extends TdApi.RichText {
        public TdApi.RichText text;
        public static final int CONSTRUCTOR = -1271496249;

        public RichTextFixed() {
        }

        public RichTextFixed(TdApi.RichText var1) {
            this.text = var1;
        }

        public int getConstructor() {
            return -1271496249;
        }
    }

    public static class RichTextStrikethrough extends TdApi.RichText {
        public TdApi.RichText text;
        public static final int CONSTRUCTOR = 723413585;

        public RichTextStrikethrough() {
        }

        public RichTextStrikethrough(TdApi.RichText var1) {
            this.text = var1;
        }

        public int getConstructor() {
            return 723413585;
        }
    }

    public static class RichTextUnderline extends TdApi.RichText {
        public TdApi.RichText text;
        public static final int CONSTRUCTOR = -536019572;

        public RichTextUnderline() {
        }

        public RichTextUnderline(TdApi.RichText var1) {
            this.text = var1;
        }

        public int getConstructor() {
            return -536019572;
        }
    }

    public static class RichTextItalic extends TdApi.RichText {
        public TdApi.RichText text;
        public static final int CONSTRUCTOR = 1853354047;

        public RichTextItalic() {
        }

        public RichTextItalic(TdApi.RichText var1) {
            this.text = var1;
        }

        public int getConstructor() {
            return 1853354047;
        }
    }

    public static class RichTextBold extends TdApi.RichText {
        public TdApi.RichText text;
        public static final int CONSTRUCTOR = 1670844268;

        public RichTextBold() {
        }

        public RichTextBold(TdApi.RichText var1) {
            this.text = var1;
        }

        public int getConstructor() {
            return 1670844268;
        }
    }

    public static class RichTextPlain extends TdApi.RichText {
        public String text;
        public static final int CONSTRUCTOR = 482617702;

        public RichTextPlain() {
        }

        public RichTextPlain(String var1) {
            this.text = var1;
        }

        public int getConstructor() {
            return 482617702;
        }
    }

    public abstract static class RichText extends TdApi.Object {
        public RichText() {
        }
    }

    public static class ReplyMarkupInlineKeyboard extends TdApi.ReplyMarkup {
        public TdApi.InlineKeyboardButton[][] rows;
        public static final int CONSTRUCTOR = -619317658;

        public ReplyMarkupInlineKeyboard() {
        }

        public ReplyMarkupInlineKeyboard(TdApi.InlineKeyboardButton[][] var1) {
            this.rows = var1;
        }

        public int getConstructor() {
            return -619317658;
        }
    }

    public static class ReplyMarkupShowKeyboard extends TdApi.ReplyMarkup {
        public TdApi.KeyboardButton[][] rows;
        public boolean resizeKeyboard;
        public boolean oneTime;
        public boolean isPersonal;
        public static final int CONSTRUCTOR = -992627133;

        public ReplyMarkupShowKeyboard() {
        }

        public ReplyMarkupShowKeyboard(TdApi.KeyboardButton[][] var1, boolean var2, boolean var3, boolean var4) {
            this.rows = var1;
            this.resizeKeyboard = var2;
            this.oneTime = var3;
            this.isPersonal = var4;
        }

        public int getConstructor() {
            return -992627133;
        }
    }

    public static class ReplyMarkupForceReply extends TdApi.ReplyMarkup {
        public boolean isPersonal;
        public static final int CONSTRUCTOR = 1039104593;

        public ReplyMarkupForceReply() {
        }

        public ReplyMarkupForceReply(boolean var1) {
            this.isPersonal = var1;
        }

        public int getConstructor() {
            return 1039104593;
        }
    }

    public static class ReplyMarkupRemoveKeyboard extends TdApi.ReplyMarkup {
        public boolean isPersonal;
        public static final int CONSTRUCTOR = -691252879;

        public ReplyMarkupRemoveKeyboard() {
        }

        public ReplyMarkupRemoveKeyboard(boolean var1) {
            this.isPersonal = var1;
        }

        public int getConstructor() {
            return -691252879;
        }
    }

    public abstract static class ReplyMarkup extends TdApi.Object {
        public ReplyMarkup() {
        }
    }

    public static class RemoteFile extends TdApi.Object {
        public String id;
        public String uniqueId;
        public boolean isUploadingActive;
        public boolean isUploadingCompleted;
        public int uploadedSize;
        public static final int CONSTRUCTOR = -1822143022;

        public RemoteFile() {
        }

        public RemoteFile(String var1, String var2, boolean var3, boolean var4, int var5) {
            this.id = var1;
            this.uniqueId = var2;
            this.isUploadingActive = var3;
            this.isUploadingCompleted = var4;
            this.uploadedSize = var5;
        }

        public int getConstructor() {
            return -1822143022;
        }
    }

    public static class RecoveryEmailAddress extends TdApi.Object {
        public String recoveryEmailAddress;
        public static final int CONSTRUCTOR = 1290526187;

        public RecoveryEmailAddress() {
        }

        public RecoveryEmailAddress(String var1) {
            this.recoveryEmailAddress = var1;
        }

        public int getConstructor() {
            return 1290526187;
        }
    }

    public static class PushReceiverId extends TdApi.Object {
        public long id;
        public static final int CONSTRUCTOR = 371056428;

        public PushReceiverId() {
        }

        public PushReceiverId(long var1) {
            this.id = var1;
        }

        public int getConstructor() {
            return 371056428;
        }
    }

    public static class PushMessageContentMediaAlbum extends TdApi.PushMessageContent {
        public int totalCount;
        public boolean hasPhotos;
        public boolean hasVideos;
        public static final int CONSTRUCTOR = -874278109;

        public PushMessageContentMediaAlbum() {
        }

        public PushMessageContentMediaAlbum(int var1, boolean var2, boolean var3) {
            this.totalCount = var1;
            this.hasPhotos = var2;
            this.hasVideos = var3;
        }

        public int getConstructor() {
            return -874278109;
        }
    }

    public static class PushMessageContentMessageForwards extends TdApi.PushMessageContent {
        public int totalCount;
        public static final int CONSTRUCTOR = -1913083876;

        public PushMessageContentMessageForwards() {
        }

        public PushMessageContentMessageForwards(int var1) {
            this.totalCount = var1;
        }

        public int getConstructor() {
            return -1913083876;
        }
    }

    public static class PushMessageContentChatJoinByLink extends TdApi.PushMessageContent {
        public static final int CONSTRUCTOR = 1553719113;

        public PushMessageContentChatJoinByLink() {
        }

        public int getConstructor() {
            return 1553719113;
        }
    }

    public static class PushMessageContentChatDeleteMember extends TdApi.PushMessageContent {
        public String memberName;
        public boolean isCurrentUser;
        public boolean isLeft;
        public static final int CONSTRUCTOR = 598714783;

        public PushMessageContentChatDeleteMember() {
        }

        public PushMessageContentChatDeleteMember(String var1, boolean var2, boolean var3) {
            this.memberName = var1;
            this.isCurrentUser = var2;
            this.isLeft = var3;
        }

        public int getConstructor() {
            return 598714783;
        }
    }

    public static class PushMessageContentChatChangeTitle extends TdApi.PushMessageContent {
        public String title;
        public static final int CONSTRUCTOR = -1964902749;

        public PushMessageContentChatChangeTitle() {
        }

        public PushMessageContentChatChangeTitle(String var1) {
            this.title = var1;
        }

        public int getConstructor() {
            return -1964902749;
        }
    }

    public static class PushMessageContentChatChangePhoto extends TdApi.PushMessageContent {
        public static final int CONSTRUCTOR = -1114222051;

        public PushMessageContentChatChangePhoto() {
        }

        public int getConstructor() {
            return -1114222051;
        }
    }

    public static class PushMessageContentChatAddMembers extends TdApi.PushMessageContent {
        public String memberName;
        public boolean isCurrentUser;
        public boolean isReturned;
        public static final int CONSTRUCTOR = -1087145158;

        public PushMessageContentChatAddMembers() {
        }

        public PushMessageContentChatAddMembers(String var1, boolean var2, boolean var3) {
            this.memberName = var1;
            this.isCurrentUser = var2;
            this.isReturned = var3;
        }

        public int getConstructor() {
            return -1087145158;
        }
    }

    public static class PushMessageContentBasicGroupChatCreate extends TdApi.PushMessageContent {
        public static final int CONSTRUCTOR = -2114855172;

        public PushMessageContentBasicGroupChatCreate() {
        }

        public int getConstructor() {
            return -2114855172;
        }
    }

    public static class PushMessageContentVoiceNote extends TdApi.PushMessageContent {
        public TdApi.VoiceNote voiceNote;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 88910987;

        public PushMessageContentVoiceNote() {
        }

        public PushMessageContentVoiceNote(TdApi.VoiceNote var1, boolean var2) {
            this.voiceNote = var1;
            this.isPinned = var2;
        }

        public int getConstructor() {
            return 88910987;
        }
    }

    public static class PushMessageContentVideoNote extends TdApi.PushMessageContent {
        public TdApi.VideoNote videoNote;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -1122764417;

        public PushMessageContentVideoNote() {
        }

        public PushMessageContentVideoNote(TdApi.VideoNote var1, boolean var2) {
            this.videoNote = var1;
            this.isPinned = var2;
        }

        public int getConstructor() {
            return -1122764417;
        }
    }

    public static class PushMessageContentVideo extends TdApi.PushMessageContent {
        public TdApi.Video video;
        public String caption;
        public boolean isSecret;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 310038831;

        public PushMessageContentVideo() {
        }

        public PushMessageContentVideo(TdApi.Video var1, String var2, boolean var3, boolean var4) {
            this.video = var1;
            this.caption = var2;
            this.isSecret = var3;
            this.isPinned = var4;
        }

        public int getConstructor() {
            return 310038831;
        }
    }

    public static class PushMessageContentText extends TdApi.PushMessageContent {
        public String text;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 274587305;

        public PushMessageContentText() {
        }

        public PushMessageContentText(String var1, boolean var2) {
            this.text = var1;
            this.isPinned = var2;
        }

        public int getConstructor() {
            return 274587305;
        }
    }

    public static class PushMessageContentSticker extends TdApi.PushMessageContent {
        public TdApi.Sticker sticker;
        public String emoji;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 1553513939;

        public PushMessageContentSticker() {
        }

        public PushMessageContentSticker(TdApi.Sticker var1, String var2, boolean var3) {
            this.sticker = var1;
            this.emoji = var2;
            this.isPinned = var3;
        }

        public int getConstructor() {
            return 1553513939;
        }
    }

    public static class PushMessageContentScreenshotTaken extends TdApi.PushMessageContent {
        public static final int CONSTRUCTOR = 214245369;

        public PushMessageContentScreenshotTaken() {
        }

        public int getConstructor() {
            return 214245369;
        }
    }

    public static class PushMessageContentPoll extends TdApi.PushMessageContent {
        public String question;
        public boolean isRegular;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -44403654;

        public PushMessageContentPoll() {
        }

        public PushMessageContentPoll(String var1, boolean var2, boolean var3) {
            this.question = var1;
            this.isRegular = var2;
            this.isPinned = var3;
        }

        public int getConstructor() {
            return -44403654;
        }
    }

    public static class PushMessageContentPhoto extends TdApi.PushMessageContent {
        public TdApi.Photo photo;
        public String caption;
        public boolean isSecret;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 140631122;

        public PushMessageContentPhoto() {
        }

        public PushMessageContentPhoto(TdApi.Photo var1, String var2, boolean var3, boolean var4) {
            this.photo = var1;
            this.caption = var2;
            this.isSecret = var3;
            this.isPinned = var4;
        }

        public int getConstructor() {
            return 140631122;
        }
    }

    public static class PushMessageContentLocation extends TdApi.PushMessageContent {
        public boolean isLive;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -1288005709;

        public PushMessageContentLocation() {
        }

        public PushMessageContentLocation(boolean var1, boolean var2) {
            this.isLive = var1;
            this.isPinned = var2;
        }

        public int getConstructor() {
            return -1288005709;
        }
    }

    public static class PushMessageContentInvoice extends TdApi.PushMessageContent {
        public String price;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -1731687492;

        public PushMessageContentInvoice() {
        }

        public PushMessageContentInvoice(String var1, boolean var2) {
            this.price = var1;
            this.isPinned = var2;
        }

        public int getConstructor() {
            return -1731687492;
        }
    }

    public static class PushMessageContentGameScore extends TdApi.PushMessageContent {
        public String title;
        public int score;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 901303688;

        public PushMessageContentGameScore() {
        }

        public PushMessageContentGameScore(String var1, int var2, boolean var3) {
            this.title = var1;
            this.score = var2;
            this.isPinned = var3;
        }

        public int getConstructor() {
            return 901303688;
        }
    }

    public static class PushMessageContentGame extends TdApi.PushMessageContent {
        public String title;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -515131109;

        public PushMessageContentGame() {
        }

        public PushMessageContentGame(String var1, boolean var2) {
            this.title = var1;
            this.isPinned = var2;
        }

        public int getConstructor() {
            return -515131109;
        }
    }

    public static class PushMessageContentDocument extends TdApi.PushMessageContent {
        public TdApi.Document document;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -458379775;

        public PushMessageContentDocument() {
        }

        public PushMessageContentDocument(TdApi.Document var1, boolean var2) {
            this.document = var1;
            this.isPinned = var2;
        }

        public int getConstructor() {
            return -458379775;
        }
    }

    public static class PushMessageContentContactRegistered extends TdApi.PushMessageContent {
        public static final int CONSTRUCTOR = -303962720;

        public PushMessageContentContactRegistered() {
        }

        public int getConstructor() {
            return -303962720;
        }
    }

    public static class PushMessageContentContact extends TdApi.PushMessageContent {
        public String name;
        public boolean isPinned;
        public static final int CONSTRUCTOR = -12219820;

        public PushMessageContentContact() {
        }

        public PushMessageContentContact(String var1, boolean var2) {
            this.name = var1;
            this.isPinned = var2;
        }

        public int getConstructor() {
            return -12219820;
        }
    }

    public static class PushMessageContentAudio extends TdApi.PushMessageContent {
        public TdApi.Audio audio;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 381581426;

        public PushMessageContentAudio() {
        }

        public PushMessageContentAudio(TdApi.Audio var1, boolean var2) {
            this.audio = var1;
            this.isPinned = var2;
        }

        public int getConstructor() {
            return 381581426;
        }
    }

    public static class PushMessageContentAnimation extends TdApi.PushMessageContent {
        public TdApi.Animation animation;
        public String caption;
        public boolean isPinned;
        public static final int CONSTRUCTOR = 1034215396;

        public PushMessageContentAnimation() {
        }

        public PushMessageContentAnimation(TdApi.Animation var1, String var2, boolean var3) {
            this.animation = var1;
            this.caption = var2;
            this.isPinned = var3;
        }

        public int getConstructor() {
            return 1034215396;
        }
    }

    public static class PushMessageContentHidden extends TdApi.PushMessageContent {
        public boolean isPinned;
        public static final int CONSTRUCTOR = -316950436;

        public PushMessageContentHidden() {
        }

        public PushMessageContentHidden(boolean var1) {
            this.isPinned = var1;
        }

        public int getConstructor() {
            return -316950436;
        }
    }

    public abstract static class PushMessageContent extends TdApi.Object {
        public PushMessageContent() {
        }
    }

    public static class PublicMessageLink extends TdApi.Object {
        public String link;
        public String html;
        public static final int CONSTRUCTOR = -679603433;

        public PublicMessageLink() {
        }

        public PublicMessageLink(String var1, String var2) {
            this.link = var1;
            this.html = var2;
        }

        public int getConstructor() {
            return -679603433;
        }
    }

    public static class PublicChatTypeIsLocationBased extends TdApi.PublicChatType {
        public static final int CONSTRUCTOR = 1183735952;

        public PublicChatTypeIsLocationBased() {
        }

        public int getConstructor() {
            return 1183735952;
        }
    }

    public static class PublicChatTypeHasUsername extends TdApi.PublicChatType {
        public static final int CONSTRUCTOR = 350789758;

        public PublicChatTypeHasUsername() {
        }

        public int getConstructor() {
            return 350789758;
        }
    }

    public abstract static class PublicChatType extends TdApi.Object {
        public PublicChatType() {
        }
    }

    public static class ProxyTypeMtproto extends TdApi.ProxyType {
        public String secret;
        public static final int CONSTRUCTOR = -1964826627;

        public ProxyTypeMtproto() {
        }

        public ProxyTypeMtproto(String var1) {
            this.secret = var1;
        }

        public int getConstructor() {
            return -1964826627;
        }
    }

    public static class ProxyTypeHttp extends TdApi.ProxyType {
        public String username;
        public String password;
        public boolean httpOnly;
        public static final int CONSTRUCTOR = -1547188361;

        public ProxyTypeHttp() {
        }

        public ProxyTypeHttp(String var1, String var2, boolean var3) {
            this.username = var1;
            this.password = var2;
            this.httpOnly = var3;
        }

        public int getConstructor() {
            return -1547188361;
        }
    }

    public static class ProxyTypeSocks5 extends TdApi.ProxyType {
        public String username;
        public String password;
        public static final int CONSTRUCTOR = -890027341;

        public ProxyTypeSocks5() {
        }

        public ProxyTypeSocks5(String var1, String var2) {
            this.username = var1;
            this.password = var2;
        }

        public int getConstructor() {
            return -890027341;
        }
    }

    public abstract static class ProxyType extends TdApi.Object {
        public ProxyType() {
        }
    }

    public static class Proxy extends TdApi.Object {
        public int id;
        public String server;
        public int port;
        public int lastUsedDate;
        public boolean isEnabled;
        public TdApi.ProxyType type;
        public static final int CONSTRUCTOR = 196049779;

        public Proxy() {
        }

        public Proxy(int var1, String var2, int var3, int var4, boolean var5, TdApi.ProxyType var6) {
            this.id = var1;
            this.server = var2;
            this.port = var3;
            this.lastUsedDate = var4;
            this.isEnabled = var5;
            this.type = var6;
        }

        public int getConstructor() {
            return 196049779;
        }
    }

    public static class Proxies extends TdApi.Object {
        public TdApi.Proxy[] proxies;
        public static final int CONSTRUCTOR = 1200447205;

        public Proxies() {
        }

        public Proxies(TdApi.Proxy[] var1) {
            this.proxies = var1;
        }

        public int getConstructor() {
            return 1200447205;
        }
    }

    public static class ProfilePhoto extends TdApi.Object {
        public long id;
        public TdApi.File small;
        public TdApi.File big;
        public static final int CONSTRUCTOR = 978085937;

        public ProfilePhoto() {
        }

        public ProfilePhoto(long var1, TdApi.File var3, TdApi.File var4) {
            this.id = var1;
            this.small = var3;
            this.big = var4;
        }

        public int getConstructor() {
            return 978085937;
        }
    }

    public static class PollTypeQuiz extends TdApi.PollType {
        public int correctOptionId;
        public static final int CONSTRUCTOR = -354461930;

        public PollTypeQuiz() {
        }

        public PollTypeQuiz(int var1) {
            this.correctOptionId = var1;
        }

        public int getConstructor() {
            return -354461930;
        }
    }

    public static class PollTypeRegular extends TdApi.PollType {
        public boolean allowMultipleAnswers;
        public static final int CONSTRUCTOR = 641265698;

        public PollTypeRegular() {
        }

        public PollTypeRegular(boolean var1) {
            this.allowMultipleAnswers = var1;
        }

        public int getConstructor() {
            return 641265698;
        }
    }

    public abstract static class PollType extends TdApi.Object {
        public PollType() {
        }
    }

    public static class PollOption extends TdApi.Object {
        public String text;
        public int voterCount;
        public int votePercentage;
        public boolean isChosen;
        public boolean isBeingChosen;
        public static final int CONSTRUCTOR = 1473893797;

        public PollOption() {
        }

        public PollOption(String var1, int var2, int var3, boolean var4, boolean var5) {
            this.text = var1;
            this.voterCount = var2;
            this.votePercentage = var3;
            this.isChosen = var4;
            this.isBeingChosen = var5;
        }

        public int getConstructor() {
            return 1473893797;
        }
    }

    public static class Poll extends TdApi.Object {
        public long id;
        public String question;
        public TdApi.PollOption[] options;
        public int totalVoterCount;
        public int[] recentVoterUserIds;
        public boolean isAnonymous;
        public TdApi.PollType type;
        public boolean isClosed;
        public static final int CONSTRUCTOR = -964385924;

        public Poll() {
        }

        public Poll(long var1, String var3, TdApi.PollOption[] var4, int var5, int[] var6, boolean var7, TdApi.PollType var8, boolean var9) {
            this.id = var1;
            this.question = var3;
            this.options = var4;
            this.totalVoterCount = var5;
            this.recentVoterUserIds = var6;
            this.isAnonymous = var7;
            this.type = var8;
            this.isClosed = var9;
        }

        public int getConstructor() {
            return -964385924;
        }
    }

    public static class PhotoSize extends TdApi.Object {
        public String type;
        public TdApi.File photo;
        public int width;
        public int height;
        public static final int CONSTRUCTOR = 421980227;

        public PhotoSize() {
        }

        public PhotoSize(String var1, TdApi.File var2, int var3, int var4) {
            this.type = var1;
            this.photo = var2;
            this.width = var3;
            this.height = var4;
        }

        public int getConstructor() {
            return 421980227;
        }
    }

    public static class Photo extends TdApi.Object {
        public boolean hasStickers;
        public TdApi.Minithumbnail minithumbnail;
        public TdApi.PhotoSize[] sizes;
        public static final int CONSTRUCTOR = -2022871583;

        public Photo() {
        }

        public Photo(boolean var1, TdApi.Minithumbnail var2, TdApi.PhotoSize[] var3) {
            this.hasStickers = var1;
            this.minithumbnail = var2;
            this.sizes = var3;
        }

        public int getConstructor() {
            return -2022871583;
        }
    }

    public static class PhoneNumberAuthenticationSettings extends TdApi.Object {
        public boolean allowFlashCall;
        public boolean isCurrentPhoneNumber;
        public boolean allowSmsRetrieverApi;
        public static final int CONSTRUCTOR = -859198743;

        public PhoneNumberAuthenticationSettings() {
        }

        public PhoneNumberAuthenticationSettings(boolean var1, boolean var2, boolean var3) {
            this.allowFlashCall = var1;
            this.isCurrentPhoneNumber = var2;
            this.allowSmsRetrieverApi = var3;
        }

        public int getConstructor() {
            return -859198743;
        }
    }

    public static class PersonalDocument extends TdApi.Object {
        public TdApi.DatedFile[] files;
        public TdApi.DatedFile[] translation;
        public static final int CONSTRUCTOR = -1011634661;

        public PersonalDocument() {
        }

        public PersonalDocument(TdApi.DatedFile[] var1, TdApi.DatedFile[] var2) {
            this.files = var1;
            this.translation = var2;
        }

        public int getConstructor() {
            return -1011634661;
        }
    }

    public static class PersonalDetails extends TdApi.Object {
        public String firstName;
        public String middleName;
        public String lastName;
        public String nativeFirstName;
        public String nativeMiddleName;
        public String nativeLastName;
        public TdApi.Date birthdate;
        public String gender;
        public String countryCode;
        public String residenceCountryCode;
        public static final int CONSTRUCTOR = -1061656137;

        public PersonalDetails() {
        }

        public PersonalDetails(String var1, String var2, String var3, String var4, String var5, String var6, TdApi.Date var7, String var8, String var9, String var10) {
            this.firstName = var1;
            this.middleName = var2;
            this.lastName = var3;
            this.nativeFirstName = var4;
            this.nativeMiddleName = var5;
            this.nativeLastName = var6;
            this.birthdate = var7;
            this.gender = var8;
            this.countryCode = var9;
            this.residenceCountryCode = var10;
        }

        public int getConstructor() {
            return -1061656137;
        }
    }

    public static class PaymentsProviderStripe extends TdApi.Object {
        public String publishableKey;
        public boolean needCountry;
        public boolean needPostalCode;
        public boolean needCardholderName;
        public static final int CONSTRUCTOR = 1090791032;

        public PaymentsProviderStripe() {
        }

        public PaymentsProviderStripe(String var1, boolean var2, boolean var3, boolean var4) {
            this.publishableKey = var1;
            this.needCountry = var2;
            this.needPostalCode = var3;
            this.needCardholderName = var4;
        }

        public int getConstructor() {
            return 1090791032;
        }
    }

    public static class PaymentResult extends TdApi.Object {
        public boolean success;
        public String verificationUrl;
        public static final int CONSTRUCTOR = -804263843;

        public PaymentResult() {
        }

        public PaymentResult(boolean var1, String var2) {
            this.success = var1;
            this.verificationUrl = var2;
        }

        public int getConstructor() {
            return -804263843;
        }
    }

    public static class PaymentReceipt extends TdApi.Object {
        public int date;
        public int paymentsProviderUserId;
        public TdApi.Invoice invoice;
        public TdApi.OrderInfo orderInfo;
        public TdApi.ShippingOption shippingOption;
        public String credentialsTitle;
        public static final int CONSTRUCTOR = -1171223545;

        public PaymentReceipt() {
        }

        public PaymentReceipt(int var1, int var2, TdApi.Invoice var3, TdApi.OrderInfo var4, TdApi.ShippingOption var5, String var6) {
            this.date = var1;
            this.paymentsProviderUserId = var2;
            this.invoice = var3;
            this.orderInfo = var4;
            this.shippingOption = var5;
            this.credentialsTitle = var6;
        }

        public int getConstructor() {
            return -1171223545;
        }
    }

    public static class PaymentForm extends TdApi.Object {
        public TdApi.Invoice invoice;
        public String url;
        public TdApi.PaymentsProviderStripe paymentsProvider;
        public TdApi.OrderInfo savedOrderInfo;
        public TdApi.SavedCredentials savedCredentials;
        public boolean canSaveCredentials;
        public boolean needPassword;
        public static final int CONSTRUCTOR = -200418230;

        public PaymentForm() {
        }

        public PaymentForm(TdApi.Invoice var1, String var2, TdApi.PaymentsProviderStripe var3, TdApi.OrderInfo var4, TdApi.SavedCredentials var5, boolean var6, boolean var7) {
            this.invoice = var1;
            this.url = var2;
            this.paymentsProvider = var3;
            this.savedOrderInfo = var4;
            this.savedCredentials = var5;
            this.canSaveCredentials = var6;
            this.needPassword = var7;
        }

        public int getConstructor() {
            return -200418230;
        }
    }

    public static class PasswordState extends TdApi.Object {
        public boolean hasPassword;
        public String passwordHint;
        public boolean hasRecoveryEmailAddress;
        public boolean hasPassportData;
        public TdApi.EmailAddressAuthenticationCodeInfo recoveryEmailAddressCodeInfo;
        public static final int CONSTRUCTOR = -1154797731;

        public PasswordState() {
        }

        public PasswordState(boolean var1, String var2, boolean var3, boolean var4, TdApi.EmailAddressAuthenticationCodeInfo var5) {
            this.hasPassword = var1;
            this.passwordHint = var2;
            this.hasRecoveryEmailAddress = var3;
            this.hasPassportData = var4;
            this.recoveryEmailAddressCodeInfo = var5;
        }

        public int getConstructor() {
            return -1154797731;
        }
    }

    public static class PassportSuitableElement extends TdApi.Object {
        public TdApi.PassportElementType type;
        public boolean isSelfieRequired;
        public boolean isTranslationRequired;
        public boolean isNativeNameRequired;
        public static final int CONSTRUCTOR = -789019876;

        public PassportSuitableElement() {
        }

        public PassportSuitableElement(TdApi.PassportElementType var1, boolean var2, boolean var3, boolean var4) {
            this.type = var1;
            this.isSelfieRequired = var2;
            this.isTranslationRequired = var3;
            this.isNativeNameRequired = var4;
        }

        public int getConstructor() {
            return -789019876;
        }
    }

    public static class PassportRequiredElement extends TdApi.Object {
        public TdApi.PassportSuitableElement[] suitableElements;
        public static final int CONSTRUCTOR = -1983641651;

        public PassportRequiredElement() {
        }

        public PassportRequiredElement(TdApi.PassportSuitableElement[] var1) {
            this.suitableElements = var1;
        }

        public int getConstructor() {
            return -1983641651;
        }
    }

    public static class PassportElementsWithErrors extends TdApi.Object {
        public TdApi.PassportElement[] elements;
        public TdApi.PassportElementError[] errors;
        public static final int CONSTRUCTOR = 1308923044;

        public PassportElementsWithErrors() {
        }

        public PassportElementsWithErrors(TdApi.PassportElement[] var1, TdApi.PassportElementError[] var2) {
            this.elements = var1;
            this.errors = var2;
        }

        public int getConstructor() {
            return 1308923044;
        }
    }

    public static class PassportElements extends TdApi.Object {
        public TdApi.PassportElement[] elements;
        public static final int CONSTRUCTOR = 1264617556;

        public PassportElements() {
        }

        public PassportElements(TdApi.PassportElement[] var1) {
            this.elements = var1;
        }

        public int getConstructor() {
            return 1264617556;
        }
    }

    public static class PassportElementTypeEmailAddress extends TdApi.PassportElementType {
        public static final int CONSTRUCTOR = -79321405;

        public PassportElementTypeEmailAddress() {
        }

        public int getConstructor() {
            return -79321405;
        }
    }

    public static class PassportElementTypePhoneNumber extends TdApi.PassportElementType {
        public static final int CONSTRUCTOR = -995361172;

        public PassportElementTypePhoneNumber() {
        }

        public int getConstructor() {
            return -995361172;
        }
    }

    public static class PassportElementTypeTemporaryRegistration extends TdApi.PassportElementType {
        public static final int CONSTRUCTOR = 1092498527;

        public PassportElementTypeTemporaryRegistration() {
        }

        public int getConstructor() {
            return 1092498527;
        }
    }

    public static class PassportElementTypePassportRegistration extends TdApi.PassportElementType {
        public static final int CONSTRUCTOR = -159478209;

        public PassportElementTypePassportRegistration() {
        }

        public int getConstructor() {
            return -159478209;
        }
    }

    public static class PassportElementTypeRentalAgreement extends TdApi.PassportElementType {
        public static final int CONSTRUCTOR = -2060583280;

        public PassportElementTypeRentalAgreement() {
        }

        public int getConstructor() {
            return -2060583280;
        }
    }

    public static class PassportElementTypeBankStatement extends TdApi.PassportElementType {
        public static final int CONSTRUCTOR = 574095667;

        public PassportElementTypeBankStatement() {
        }

        public int getConstructor() {
            return 574095667;
        }
    }

    public static class PassportElementTypeUtilityBill extends TdApi.PassportElementType {
        public static final int CONSTRUCTOR = 627084906;

        public PassportElementTypeUtilityBill() {
        }

        public int getConstructor() {
            return 627084906;
        }
    }

    public static class PassportElementTypeAddress extends TdApi.PassportElementType {
        public static final int CONSTRUCTOR = 496327874;

        public PassportElementTypeAddress() {
        }

        public int getConstructor() {
            return 496327874;
        }
    }

    public static class PassportElementTypeInternalPassport extends TdApi.PassportElementType {
        public static final int CONSTRUCTOR = -793781959;

        public PassportElementTypeInternalPassport() {
        }

        public int getConstructor() {
            return -793781959;
        }
    }

    public static class PassportElementTypeIdentityCard extends TdApi.PassportElementType {
        public static final int CONSTRUCTOR = -502356132;

        public PassportElementTypeIdentityCard() {
        }

        public int getConstructor() {
            return -502356132;
        }
    }

    public static class PassportElementTypeDriverLicense extends TdApi.PassportElementType {
        public static final int CONSTRUCTOR = 1827298379;

        public PassportElementTypeDriverLicense() {
        }

        public int getConstructor() {
            return 1827298379;
        }
    }

    public static class PassportElementTypePassport extends TdApi.PassportElementType {
        public static final int CONSTRUCTOR = -436360376;

        public PassportElementTypePassport() {
        }

        public int getConstructor() {
            return -436360376;
        }
    }

    public static class PassportElementTypePersonalDetails extends TdApi.PassportElementType {
        public static final int CONSTRUCTOR = -1032136365;

        public PassportElementTypePersonalDetails() {
        }

        public int getConstructor() {
            return -1032136365;
        }
    }

    public abstract static class PassportElementType extends TdApi.Object {
        public PassportElementType() {
        }
    }

    public static class PassportElementErrorSourceFiles extends TdApi.PassportElementErrorSource {
        public static final int CONSTRUCTOR = 1894164178;

        public PassportElementErrorSourceFiles() {
        }

        public int getConstructor() {
            return 1894164178;
        }
    }

    public static class PassportElementErrorSourceFile extends TdApi.PassportElementErrorSource {
        public int fileIndex;
        public static final int CONSTRUCTOR = 2020358960;

        public PassportElementErrorSourceFile() {
        }

        public PassportElementErrorSourceFile(int var1) {
            this.fileIndex = var1;
        }

        public int getConstructor() {
            return 2020358960;
        }
    }

    public static class PassportElementErrorSourceTranslationFiles extends TdApi.PassportElementErrorSource {
        public static final int CONSTRUCTOR = 581280796;

        public PassportElementErrorSourceTranslationFiles() {
        }

        public int getConstructor() {
            return 581280796;
        }
    }

    public static class PassportElementErrorSourceTranslationFile extends TdApi.PassportElementErrorSource {
        public int fileIndex;
        public static final int CONSTRUCTOR = -689621228;

        public PassportElementErrorSourceTranslationFile() {
        }

        public PassportElementErrorSourceTranslationFile(int var1) {
            this.fileIndex = var1;
        }

        public int getConstructor() {
            return -689621228;
        }
    }

    public static class PassportElementErrorSourceSelfie extends TdApi.PassportElementErrorSource {
        public static final int CONSTRUCTOR = -797043672;

        public PassportElementErrorSourceSelfie() {
        }

        public int getConstructor() {
            return -797043672;
        }
    }

    public static class PassportElementErrorSourceReverseSide extends TdApi.PassportElementErrorSource {
        public static final int CONSTRUCTOR = 1918630391;

        public PassportElementErrorSourceReverseSide() {
        }

        public int getConstructor() {
            return 1918630391;
        }
    }

    public static class PassportElementErrorSourceFrontSide extends TdApi.PassportElementErrorSource {
        public static final int CONSTRUCTOR = 1895658292;

        public PassportElementErrorSourceFrontSide() {
        }

        public int getConstructor() {
            return 1895658292;
        }
    }

    public static class PassportElementErrorSourceDataField extends TdApi.PassportElementErrorSource {
        public String fieldName;
        public static final int CONSTRUCTOR = -308650776;

        public PassportElementErrorSourceDataField() {
        }

        public PassportElementErrorSourceDataField(String var1) {
            this.fieldName = var1;
        }

        public int getConstructor() {
            return -308650776;
        }
    }

    public static class PassportElementErrorSourceUnspecified extends TdApi.PassportElementErrorSource {
        public static final int CONSTRUCTOR = -378320830;

        public PassportElementErrorSourceUnspecified() {
        }

        public int getConstructor() {
            return -378320830;
        }
    }

    public abstract static class PassportElementErrorSource extends TdApi.Object {
        public PassportElementErrorSource() {
        }
    }

    public static class PassportElementError extends TdApi.Object {
        public TdApi.PassportElementType type;
        public String message;
        public TdApi.PassportElementErrorSource source;
        public static final int CONSTRUCTOR = -1861902395;

        public PassportElementError() {
        }

        public PassportElementError(TdApi.PassportElementType var1, String var2, TdApi.PassportElementErrorSource var3) {
            this.type = var1;
            this.message = var2;
            this.source = var3;
        }

        public int getConstructor() {
            return -1861902395;
        }
    }

    public static class PassportElementEmailAddress extends TdApi.PassportElement {
        public String emailAddress;
        public static final int CONSTRUCTOR = -1528129531;

        public PassportElementEmailAddress() {
        }

        public PassportElementEmailAddress(String var1) {
            this.emailAddress = var1;
        }

        public int getConstructor() {
            return -1528129531;
        }
    }

    public static class PassportElementPhoneNumber extends TdApi.PassportElement {
        public String phoneNumber;
        public static final int CONSTRUCTOR = -1320118375;

        public PassportElementPhoneNumber() {
        }

        public PassportElementPhoneNumber(String var1) {
            this.phoneNumber = var1;
        }

        public int getConstructor() {
            return -1320118375;
        }
    }

    public static class PassportElementTemporaryRegistration extends TdApi.PassportElement {
        public TdApi.PersonalDocument temporaryRegistration;
        public static final int CONSTRUCTOR = 1237626864;

        public PassportElementTemporaryRegistration() {
        }

        public PassportElementTemporaryRegistration(TdApi.PersonalDocument var1) {
            this.temporaryRegistration = var1;
        }

        public int getConstructor() {
            return 1237626864;
        }
    }

    public static class PassportElementPassportRegistration extends TdApi.PassportElement {
        public TdApi.PersonalDocument passportRegistration;
        public static final int CONSTRUCTOR = 618323071;

        public PassportElementPassportRegistration() {
        }

        public PassportElementPassportRegistration(TdApi.PersonalDocument var1) {
            this.passportRegistration = var1;
        }

        public int getConstructor() {
            return 618323071;
        }
    }

    public static class PassportElementRentalAgreement extends TdApi.PassportElement {
        public TdApi.PersonalDocument rentalAgreement;
        public static final int CONSTRUCTOR = -290141400;

        public PassportElementRentalAgreement() {
        }

        public PassportElementRentalAgreement(TdApi.PersonalDocument var1) {
            this.rentalAgreement = var1;
        }

        public int getConstructor() {
            return -290141400;
        }
    }

    public static class PassportElementBankStatement extends TdApi.PassportElement {
        public TdApi.PersonalDocument bankStatement;
        public static final int CONSTRUCTOR = -366464408;

        public PassportElementBankStatement() {
        }

        public PassportElementBankStatement(TdApi.PersonalDocument var1) {
            this.bankStatement = var1;
        }

        public int getConstructor() {
            return -366464408;
        }
    }

    public static class PassportElementUtilityBill extends TdApi.PassportElement {
        public TdApi.PersonalDocument utilityBill;
        public static final int CONSTRUCTOR = -234611246;

        public PassportElementUtilityBill() {
        }

        public PassportElementUtilityBill(TdApi.PersonalDocument var1) {
            this.utilityBill = var1;
        }

        public int getConstructor() {
            return -234611246;
        }
    }

    public static class PassportElementAddress extends TdApi.PassportElement {
        public TdApi.Address address;
        public static final int CONSTRUCTOR = -782625232;

        public PassportElementAddress() {
        }

        public PassportElementAddress(TdApi.Address var1) {
            this.address = var1;
        }

        public int getConstructor() {
            return -782625232;
        }
    }

    public static class PassportElementInternalPassport extends TdApi.PassportElement {
        public TdApi.IdentityDocument internalPassport;
        public static final int CONSTRUCTOR = 36220295;

        public PassportElementInternalPassport() {
        }

        public PassportElementInternalPassport(TdApi.IdentityDocument var1) {
            this.internalPassport = var1;
        }

        public int getConstructor() {
            return 36220295;
        }
    }

    public static class PassportElementIdentityCard extends TdApi.PassportElement {
        public TdApi.IdentityDocument identityCard;
        public static final int CONSTRUCTOR = 2083775797;

        public PassportElementIdentityCard() {
        }

        public PassportElementIdentityCard(TdApi.IdentityDocument var1) {
            this.identityCard = var1;
        }

        public int getConstructor() {
            return 2083775797;
        }
    }

    public static class PassportElementDriverLicense extends TdApi.PassportElement {
        public TdApi.IdentityDocument driverLicense;
        public static final int CONSTRUCTOR = 1643580589;

        public PassportElementDriverLicense() {
        }

        public PassportElementDriverLicense(TdApi.IdentityDocument var1) {
            this.driverLicense = var1;
        }

        public int getConstructor() {
            return 1643580589;
        }
    }

    public static class PassportElementPassport extends TdApi.PassportElement {
        public TdApi.IdentityDocument passport;
        public static final int CONSTRUCTOR = -263985373;

        public PassportElementPassport() {
        }

        public PassportElementPassport(TdApi.IdentityDocument var1) {
            this.passport = var1;
        }

        public int getConstructor() {
            return -263985373;
        }
    }

    public static class PassportElementPersonalDetails extends TdApi.PassportElement {
        public TdApi.PersonalDetails personalDetails;
        public static final int CONSTRUCTOR = 1217724035;

        public PassportElementPersonalDetails() {
        }

        public PassportElementPersonalDetails(TdApi.PersonalDetails var1) {
            this.personalDetails = var1;
        }

        public int getConstructor() {
            return 1217724035;
        }
    }

    public abstract static class PassportElement extends TdApi.Object {
        public PassportElement() {
        }
    }

    public static class PassportAuthorizationForm extends TdApi.Object {
        public int id;
        public TdApi.PassportRequiredElement[] requiredElements;
        public String privacyPolicyUrl;
        public static final int CONSTRUCTOR = -1070673218;

        public PassportAuthorizationForm() {
        }

        public PassportAuthorizationForm(int var1, TdApi.PassportRequiredElement[] var2, String var3) {
            this.id = var1;
            this.requiredElements = var2;
            this.privacyPolicyUrl = var3;
        }

        public int getConstructor() {
            return -1070673218;
        }
    }

    public static class PageBlockVerticalAlignmentBottom extends TdApi.PageBlockVerticalAlignment {
        public static final int CONSTRUCTOR = 2092531158;

        public PageBlockVerticalAlignmentBottom() {
        }

        public int getConstructor() {
            return 2092531158;
        }
    }

    public static class PageBlockVerticalAlignmentMiddle extends TdApi.PageBlockVerticalAlignment {
        public static final int CONSTRUCTOR = -2123096587;

        public PageBlockVerticalAlignmentMiddle() {
        }

        public int getConstructor() {
            return -2123096587;
        }
    }

    public static class PageBlockVerticalAlignmentTop extends TdApi.PageBlockVerticalAlignment {
        public static final int CONSTRUCTOR = 195500454;

        public PageBlockVerticalAlignmentTop() {
        }

        public int getConstructor() {
            return 195500454;
        }
    }

    public abstract static class PageBlockVerticalAlignment extends TdApi.Object {
        public PageBlockVerticalAlignment() {
        }
    }

    public static class PageBlockTableCell extends TdApi.Object {
        public TdApi.RichText text;
        public boolean isHeader;
        public int colspan;
        public int rowspan;
        public TdApi.PageBlockHorizontalAlignment align;
        public TdApi.PageBlockVerticalAlignment valign;
        public static final int CONSTRUCTOR = 1417658214;

        public PageBlockTableCell() {
        }

        public PageBlockTableCell(TdApi.RichText var1, boolean var2, int var3, int var4, TdApi.PageBlockHorizontalAlignment var5, TdApi.PageBlockVerticalAlignment var6) {
            this.text = var1;
            this.isHeader = var2;
            this.colspan = var3;
            this.rowspan = var4;
            this.align = var5;
            this.valign = var6;
        }

        public int getConstructor() {
            return 1417658214;
        }
    }

    public static class PageBlockRelatedArticle extends TdApi.Object {
        public String url;
        public String title;
        public String description;
        public TdApi.Photo photo;
        public String author;
        public int publishDate;
        public static final int CONSTRUCTOR = 481199251;

        public PageBlockRelatedArticle() {
        }

        public PageBlockRelatedArticle(String var1, String var2, String var3, TdApi.Photo var4, String var5, int var6) {
            this.url = var1;
            this.title = var2;
            this.description = var3;
            this.photo = var4;
            this.author = var5;
            this.publishDate = var6;
        }

        public int getConstructor() {
            return 481199251;
        }
    }

    public static class PageBlockListItem extends TdApi.Object {
        public String label;
        public TdApi.PageBlock[] pageBlocks;
        public static final int CONSTRUCTOR = 323186259;

        public PageBlockListItem() {
        }

        public PageBlockListItem(String var1, TdApi.PageBlock[] var2) {
            this.label = var1;
            this.pageBlocks = var2;
        }

        public int getConstructor() {
            return 323186259;
        }
    }

    public static class PageBlockHorizontalAlignmentRight extends TdApi.PageBlockHorizontalAlignment {
        public static final int CONSTRUCTOR = 1371369214;

        public PageBlockHorizontalAlignmentRight() {
        }

        public int getConstructor() {
            return 1371369214;
        }
    }

    public static class PageBlockHorizontalAlignmentCenter extends TdApi.PageBlockHorizontalAlignment {
        public static final int CONSTRUCTOR = -1009203990;

        public PageBlockHorizontalAlignmentCenter() {
        }

        public int getConstructor() {
            return -1009203990;
        }
    }

    public static class PageBlockHorizontalAlignmentLeft extends TdApi.PageBlockHorizontalAlignment {
        public static final int CONSTRUCTOR = 848701417;

        public PageBlockHorizontalAlignmentLeft() {
        }

        public int getConstructor() {
            return 848701417;
        }
    }

    public abstract static class PageBlockHorizontalAlignment extends TdApi.Object {
        public PageBlockHorizontalAlignment() {
        }
    }

    public static class PageBlockCaption extends TdApi.Object {
        public TdApi.RichText text;
        public TdApi.RichText credit;
        public static final int CONSTRUCTOR = -1180064650;

        public PageBlockCaption() {
        }

        public PageBlockCaption(TdApi.RichText var1, TdApi.RichText var2) {
            this.text = var1;
            this.credit = var2;
        }

        public int getConstructor() {
            return -1180064650;
        }
    }

    public static class PageBlockMap extends TdApi.PageBlock {
        public TdApi.Location location;
        public int zoom;
        public int width;
        public int height;
        public TdApi.PageBlockCaption caption;
        public static final int CONSTRUCTOR = 1510961171;

        public PageBlockMap() {
        }

        public PageBlockMap(TdApi.Location var1, int var2, int var3, int var4, TdApi.PageBlockCaption var5) {
            this.location = var1;
            this.zoom = var2;
            this.width = var3;
            this.height = var4;
            this.caption = var5;
        }

        public int getConstructor() {
            return 1510961171;
        }
    }

    public static class PageBlockRelatedArticles extends TdApi.PageBlock {
        public TdApi.RichText header;
        public TdApi.PageBlockRelatedArticle[] articles;
        public static final int CONSTRUCTOR = -1807324374;

        public PageBlockRelatedArticles() {
        }

        public PageBlockRelatedArticles(TdApi.RichText var1, TdApi.PageBlockRelatedArticle[] var2) {
            this.header = var1;
            this.articles = var2;
        }

        public int getConstructor() {
            return -1807324374;
        }
    }

    public static class PageBlockDetails extends TdApi.PageBlock {
        public TdApi.RichText header;
        public TdApi.PageBlock[] pageBlocks;
        public boolean isOpen;
        public static final int CONSTRUCTOR = -1599869809;

        public PageBlockDetails() {
        }

        public PageBlockDetails(TdApi.RichText var1, TdApi.PageBlock[] var2, boolean var3) {
            this.header = var1;
            this.pageBlocks = var2;
            this.isOpen = var3;
        }

        public int getConstructor() {
            return -1599869809;
        }
    }

    public static class PageBlockTable extends TdApi.PageBlock {
        public TdApi.RichText caption;
        public TdApi.PageBlockTableCell[][] cells;
        public boolean isBordered;
        public boolean isStriped;
        public static final int CONSTRUCTOR = -942649288;

        public PageBlockTable() {
        }

        public PageBlockTable(TdApi.RichText var1, TdApi.PageBlockTableCell[][] var2, boolean var3, boolean var4) {
            this.caption = var1;
            this.cells = var2;
            this.isBordered = var3;
            this.isStriped = var4;
        }

        public int getConstructor() {
            return -942649288;
        }
    }

    public static class PageBlockChatLink extends TdApi.PageBlock {
        public String title;
        public TdApi.ChatPhoto photo;
        public String username;
        public static final int CONSTRUCTOR = 214606645;

        public PageBlockChatLink() {
        }

        public PageBlockChatLink(String var1, TdApi.ChatPhoto var2, String var3) {
            this.title = var1;
            this.photo = var2;
            this.username = var3;
        }

        public int getConstructor() {
            return 214606645;
        }
    }

    public static class PageBlockSlideshow extends TdApi.PageBlock {
        public TdApi.PageBlock[] pageBlocks;
        public TdApi.PageBlockCaption caption;
        public static final int CONSTRUCTOR = 539217375;

        public PageBlockSlideshow() {
        }

        public PageBlockSlideshow(TdApi.PageBlock[] var1, TdApi.PageBlockCaption var2) {
            this.pageBlocks = var1;
            this.caption = var2;
        }

        public int getConstructor() {
            return 539217375;
        }
    }

    public static class PageBlockCollage extends TdApi.PageBlock {
        public TdApi.PageBlock[] pageBlocks;
        public TdApi.PageBlockCaption caption;
        public static final int CONSTRUCTOR = 1163760110;

        public PageBlockCollage() {
        }

        public PageBlockCollage(TdApi.PageBlock[] var1, TdApi.PageBlockCaption var2) {
            this.pageBlocks = var1;
            this.caption = var2;
        }

        public int getConstructor() {
            return 1163760110;
        }
    }

    public static class PageBlockEmbeddedPost extends TdApi.PageBlock {
        public String url;
        public String author;
        public TdApi.Photo authorPhoto;
        public int date;
        public TdApi.PageBlock[] pageBlocks;
        public TdApi.PageBlockCaption caption;
        public static final int CONSTRUCTOR = 397600949;

        public PageBlockEmbeddedPost() {
        }

        public PageBlockEmbeddedPost(String var1, String var2, TdApi.Photo var3, int var4, TdApi.PageBlock[] var5, TdApi.PageBlockCaption var6) {
            this.url = var1;
            this.author = var2;
            this.authorPhoto = var3;
            this.date = var4;
            this.pageBlocks = var5;
            this.caption = var6;
        }

        public int getConstructor() {
            return 397600949;
        }
    }

    public static class PageBlockEmbedded extends TdApi.PageBlock {
        public String url;
        public String html;
        public TdApi.Photo posterPhoto;
        public int width;
        public int height;
        public TdApi.PageBlockCaption caption;
        public boolean isFullWidth;
        public boolean allowScrolling;
        public static final int CONSTRUCTOR = -1942577763;

        public PageBlockEmbedded() {
        }

        public PageBlockEmbedded(String var1, String var2, TdApi.Photo var3, int var4, int var5, TdApi.PageBlockCaption var6, boolean var7, boolean var8) {
            this.url = var1;
            this.html = var2;
            this.posterPhoto = var3;
            this.width = var4;
            this.height = var5;
            this.caption = var6;
            this.isFullWidth = var7;
            this.allowScrolling = var8;
        }

        public int getConstructor() {
            return -1942577763;
        }
    }

    public static class PageBlockCover extends TdApi.PageBlock {
        public TdApi.PageBlock cover;
        public static final int CONSTRUCTOR = 972174080;

        public PageBlockCover() {
        }

        public PageBlockCover(TdApi.PageBlock var1) {
            this.cover = var1;
        }

        public int getConstructor() {
            return 972174080;
        }
    }

    public static class PageBlockVoiceNote extends TdApi.PageBlock {
        public TdApi.VoiceNote voiceNote;
        public TdApi.PageBlockCaption caption;
        public static final int CONSTRUCTOR = 1823310463;

        public PageBlockVoiceNote() {
        }

        public PageBlockVoiceNote(TdApi.VoiceNote var1, TdApi.PageBlockCaption var2) {
            this.voiceNote = var1;
            this.caption = var2;
        }

        public int getConstructor() {
            return 1823310463;
        }
    }

    public static class PageBlockVideo extends TdApi.PageBlock {
        public TdApi.Video video;
        public TdApi.PageBlockCaption caption;
        public boolean needAutoplay;
        public boolean isLooped;
        public static final int CONSTRUCTOR = 510041394;

        public PageBlockVideo() {
        }

        public PageBlockVideo(TdApi.Video var1, TdApi.PageBlockCaption var2, boolean var3, boolean var4) {
            this.video = var1;
            this.caption = var2;
            this.needAutoplay = var3;
            this.isLooped = var4;
        }

        public int getConstructor() {
            return 510041394;
        }
    }

    public static class PageBlockPhoto extends TdApi.PageBlock {
        public TdApi.Photo photo;
        public TdApi.PageBlockCaption caption;
        public String url;
        public static final int CONSTRUCTOR = 417601156;

        public PageBlockPhoto() {
        }

        public PageBlockPhoto(TdApi.Photo var1, TdApi.PageBlockCaption var2, String var3) {
            this.photo = var1;
            this.caption = var2;
            this.url = var3;
        }

        public int getConstructor() {
            return 417601156;
        }
    }

    public static class PageBlockAudio extends TdApi.PageBlock {
        public TdApi.Audio audio;
        public TdApi.PageBlockCaption caption;
        public static final int CONSTRUCTOR = -63371245;

        public PageBlockAudio() {
        }

        public PageBlockAudio(TdApi.Audio var1, TdApi.PageBlockCaption var2) {
            this.audio = var1;
            this.caption = var2;
        }

        public int getConstructor() {
            return -63371245;
        }
    }

    public static class PageBlockAnimation extends TdApi.PageBlock {
        public TdApi.Animation animation;
        public TdApi.PageBlockCaption caption;
        public boolean needAutoplay;
        public static final int CONSTRUCTOR = 1355669513;

        public PageBlockAnimation() {
        }

        public PageBlockAnimation(TdApi.Animation var1, TdApi.PageBlockCaption var2, boolean var3) {
            this.animation = var1;
            this.caption = var2;
            this.needAutoplay = var3;
        }

        public int getConstructor() {
            return 1355669513;
        }
    }

    public static class PageBlockPullQuote extends TdApi.PageBlock {
        public TdApi.RichText text;
        public TdApi.RichText credit;
        public static final int CONSTRUCTOR = 490242317;

        public PageBlockPullQuote() {
        }

        public PageBlockPullQuote(TdApi.RichText var1, TdApi.RichText var2) {
            this.text = var1;
            this.credit = var2;
        }

        public int getConstructor() {
            return 490242317;
        }
    }

    public static class PageBlockBlockQuote extends TdApi.PageBlock {
        public TdApi.RichText text;
        public TdApi.RichText credit;
        public static final int CONSTRUCTOR = 1657834142;

        public PageBlockBlockQuote() {
        }

        public PageBlockBlockQuote(TdApi.RichText var1, TdApi.RichText var2) {
            this.text = var1;
            this.credit = var2;
        }

        public int getConstructor() {
            return 1657834142;
        }
    }

    public static class PageBlockList extends TdApi.PageBlock {
        public TdApi.PageBlockListItem[] items;
        public static final int CONSTRUCTOR = -1037074852;

        public PageBlockList() {
        }

        public PageBlockList(TdApi.PageBlockListItem[] var1) {
            this.items = var1;
        }

        public int getConstructor() {
            return -1037074852;
        }
    }

    public static class PageBlockAnchor extends TdApi.PageBlock {
        public String name;
        public static final int CONSTRUCTOR = -837994576;

        public PageBlockAnchor() {
        }

        public PageBlockAnchor(String var1) {
            this.name = var1;
        }

        public int getConstructor() {
            return -837994576;
        }
    }

    public static class PageBlockDivider extends TdApi.PageBlock {
        public static final int CONSTRUCTOR = -618614392;

        public PageBlockDivider() {
        }

        public int getConstructor() {
            return -618614392;
        }
    }

    public static class PageBlockFooter extends TdApi.PageBlock {
        public TdApi.RichText footer;
        public static final int CONSTRUCTOR = 886429480;

        public PageBlockFooter() {
        }

        public PageBlockFooter(TdApi.RichText var1) {
            this.footer = var1;
        }

        public int getConstructor() {
            return 886429480;
        }
    }

    public static class PageBlockPreformatted extends TdApi.PageBlock {
        public TdApi.RichText text;
        public String language;
        public static final int CONSTRUCTOR = -1066346178;

        public PageBlockPreformatted() {
        }

        public PageBlockPreformatted(TdApi.RichText var1, String var2) {
            this.text = var1;
            this.language = var2;
        }

        public int getConstructor() {
            return -1066346178;
        }
    }

    public static class PageBlockParagraph extends TdApi.PageBlock {
        public TdApi.RichText text;
        public static final int CONSTRUCTOR = 1182402406;

        public PageBlockParagraph() {
        }

        public PageBlockParagraph(TdApi.RichText var1) {
            this.text = var1;
        }

        public int getConstructor() {
            return 1182402406;
        }
    }

    public static class PageBlockKicker extends TdApi.PageBlock {
        public TdApi.RichText kicker;
        public static final int CONSTRUCTOR = 1361282635;

        public PageBlockKicker() {
        }

        public PageBlockKicker(TdApi.RichText var1) {
            this.kicker = var1;
        }

        public int getConstructor() {
            return 1361282635;
        }
    }

    public static class PageBlockSubheader extends TdApi.PageBlock {
        public TdApi.RichText subheader;
        public static final int CONSTRUCTOR = 1263956774;

        public PageBlockSubheader() {
        }

        public PageBlockSubheader(TdApi.RichText var1) {
            this.subheader = var1;
        }

        public int getConstructor() {
            return 1263956774;
        }
    }

    public static class PageBlockHeader extends TdApi.PageBlock {
        public TdApi.RichText header;
        public static final int CONSTRUCTOR = 1402854811;

        public PageBlockHeader() {
        }

        public PageBlockHeader(TdApi.RichText var1) {
            this.header = var1;
        }

        public int getConstructor() {
            return 1402854811;
        }
    }

    public static class PageBlockAuthorDate extends TdApi.PageBlock {
        public TdApi.RichText author;
        public int publishDate;
        public static final int CONSTRUCTOR = 1300231184;

        public PageBlockAuthorDate() {
        }

        public PageBlockAuthorDate(TdApi.RichText var1, int var2) {
            this.author = var1;
            this.publishDate = var2;
        }

        public int getConstructor() {
            return 1300231184;
        }
    }

    public static class PageBlockSubtitle extends TdApi.PageBlock {
        public TdApi.RichText subtitle;
        public static final int CONSTRUCTOR = 264524263;

        public PageBlockSubtitle() {
        }

        public PageBlockSubtitle(TdApi.RichText var1) {
            this.subtitle = var1;
        }

        public int getConstructor() {
            return 264524263;
        }
    }

    public static class PageBlockTitle extends TdApi.PageBlock {
        public TdApi.RichText title;
        public static final int CONSTRUCTOR = 1629664784;

        public PageBlockTitle() {
        }

        public PageBlockTitle(TdApi.RichText var1) {
            this.title = var1;
        }

        public int getConstructor() {
            return 1629664784;
        }
    }

    public abstract static class PageBlock extends TdApi.Object {
        public PageBlock() {
        }
    }

    public static class OrderInfo extends TdApi.Object {
        public String name;
        public String phoneNumber;
        public String emailAddress;
        public TdApi.Address shippingAddress;
        public static final int CONSTRUCTOR = 783997294;

        public OrderInfo() {
        }

        public OrderInfo(String var1, String var2, String var3, TdApi.Address var4) {
            this.name = var1;
            this.phoneNumber = var2;
            this.emailAddress = var3;
            this.shippingAddress = var4;
        }

        public int getConstructor() {
            return 783997294;
        }
    }

    public static class OptionValueString extends TdApi.OptionValue {
        public String value;
        public static final int CONSTRUCTOR = 756248212;

        public OptionValueString() {
        }

        public OptionValueString(String var1) {
            this.value = var1;
        }

        public int getConstructor() {
            return 756248212;
        }
    }

    public static class OptionValueInteger extends TdApi.OptionValue {
        public int value;
        public static final int CONSTRUCTOR = -1400911104;

        public OptionValueInteger() {
        }

        public OptionValueInteger(int var1) {
            this.value = var1;
        }

        public int getConstructor() {
            return -1400911104;
        }
    }

    public static class OptionValueEmpty extends TdApi.OptionValue {
        public static final int CONSTRUCTOR = 918955155;

        public OptionValueEmpty() {
        }

        public int getConstructor() {
            return 918955155;
        }
    }

    public static class OptionValueBoolean extends TdApi.OptionValue {
        public boolean value;
        public static final int CONSTRUCTOR = 63135518;

        public OptionValueBoolean() {
        }

        public OptionValueBoolean(boolean var1) {
            this.value = var1;
        }

        public int getConstructor() {
            return 63135518;
        }
    }

    public abstract static class OptionValue extends TdApi.Object {
        public OptionValue() {
        }
    }

    public static class Ok extends TdApi.Object {
        public static final int CONSTRUCTOR = -722616727;

        public Ok() {
        }

        public int getConstructor() {
            return -722616727;
        }
    }

    public static class NotificationTypeNewPushMessage extends TdApi.NotificationType {
        public long messageId;
        public int senderUserId;
        public TdApi.PushMessageContent content;
        public static final int CONSTRUCTOR = 1167232404;

        public NotificationTypeNewPushMessage() {
        }

        public NotificationTypeNewPushMessage(long var1, int var3, TdApi.PushMessageContent var4) {
            this.messageId = var1;
            this.senderUserId = var3;
            this.content = var4;
        }

        public int getConstructor() {
            return 1167232404;
        }
    }

    public static class NotificationTypeNewCall extends TdApi.NotificationType {
        public int callId;
        public static final int CONSTRUCTOR = 1712734585;

        public NotificationTypeNewCall() {
        }

        public NotificationTypeNewCall(int var1) {
            this.callId = var1;
        }

        public int getConstructor() {
            return 1712734585;
        }
    }

    public static class NotificationTypeNewSecretChat extends TdApi.NotificationType {
        public static final int CONSTRUCTOR = 1198638768;

        public NotificationTypeNewSecretChat() {
        }

        public int getConstructor() {
            return 1198638768;
        }
    }

    public static class NotificationTypeNewMessage extends TdApi.NotificationType {
        public TdApi.Message message;
        public static final int CONSTRUCTOR = 1885935159;

        public NotificationTypeNewMessage() {
        }

        public NotificationTypeNewMessage(TdApi.Message var1) {
            this.message = var1;
        }

        public int getConstructor() {
            return 1885935159;
        }
    }

    public abstract static class NotificationType extends TdApi.Object {
        public NotificationType() {
        }
    }

    public static class NotificationSettingsScopeChannelChats extends TdApi.NotificationSettingsScope {
        public static final int CONSTRUCTOR = 548013448;

        public NotificationSettingsScopeChannelChats() {
        }

        public int getConstructor() {
            return 548013448;
        }
    }

    public static class NotificationSettingsScopeGroupChats extends TdApi.NotificationSettingsScope {
        public static final int CONSTRUCTOR = 1212142067;

        public NotificationSettingsScopeGroupChats() {
        }

        public int getConstructor() {
            return 1212142067;
        }
    }

    public static class NotificationSettingsScopePrivateChats extends TdApi.NotificationSettingsScope {
        public static final int CONSTRUCTOR = 937446759;

        public NotificationSettingsScopePrivateChats() {
        }

        public int getConstructor() {
            return 937446759;
        }
    }

    public abstract static class NotificationSettingsScope extends TdApi.Object {
        public NotificationSettingsScope() {
        }
    }

    public static class NotificationGroupTypeCalls extends TdApi.NotificationGroupType {
        public static final int CONSTRUCTOR = 1379123538;

        public NotificationGroupTypeCalls() {
        }

        public int getConstructor() {
            return 1379123538;
        }
    }

    public static class NotificationGroupTypeSecretChat extends TdApi.NotificationGroupType {
        public static final int CONSTRUCTOR = 1390759476;

        public NotificationGroupTypeSecretChat() {
        }

        public int getConstructor() {
            return 1390759476;
        }
    }

    public static class NotificationGroupTypeMentions extends TdApi.NotificationGroupType {
        public static final int CONSTRUCTOR = -2050324051;

        public NotificationGroupTypeMentions() {
        }

        public int getConstructor() {
            return -2050324051;
        }
    }

    public static class NotificationGroupTypeMessages extends TdApi.NotificationGroupType {
        public static final int CONSTRUCTOR = -1702481123;

        public NotificationGroupTypeMessages() {
        }

        public int getConstructor() {
            return -1702481123;
        }
    }

    public abstract static class NotificationGroupType extends TdApi.Object {
        public NotificationGroupType() {
        }
    }

    public static class NotificationGroup extends TdApi.Object {
        public int id;
        public TdApi.NotificationGroupType type;
        public long chatId;
        public int totalCount;
        public TdApi.Notification[] notifications;
        public static final int CONSTRUCTOR = 780691541;

        public NotificationGroup() {
        }

        public NotificationGroup(int var1, TdApi.NotificationGroupType var2, long var3, int var5, TdApi.Notification[] var6) {
            this.id = var1;
            this.type = var2;
            this.chatId = var3;
            this.totalCount = var5;
            this.notifications = var6;
        }

        public int getConstructor() {
            return 780691541;
        }
    }

    public static class Notification extends TdApi.Object {
        public int id;
        public int date;
        public boolean isSilent;
        public TdApi.NotificationType type;
        public static final int CONSTRUCTOR = 788743120;

        public Notification() {
        }

        public Notification(int var1, int var2, boolean var3, TdApi.NotificationType var4) {
            this.id = var1;
            this.date = var2;
            this.isSilent = var3;
            this.type = var4;
        }

        public int getConstructor() {
            return 788743120;
        }
    }

    public static class NetworkTypeOther extends TdApi.NetworkType {
        public static final int CONSTRUCTOR = 1942128539;

        public NetworkTypeOther() {
        }

        public int getConstructor() {
            return 1942128539;
        }
    }

    public static class NetworkTypeWiFi extends TdApi.NetworkType {
        public static final int CONSTRUCTOR = -633872070;

        public NetworkTypeWiFi() {
        }

        public int getConstructor() {
            return -633872070;
        }
    }

    public static class NetworkTypeMobileRoaming extends TdApi.NetworkType {
        public static final int CONSTRUCTOR = -1435199760;

        public NetworkTypeMobileRoaming() {
        }

        public int getConstructor() {
            return -1435199760;
        }
    }

    public static class NetworkTypeMobile extends TdApi.NetworkType {
        public static final int CONSTRUCTOR = 819228239;

        public NetworkTypeMobile() {
        }

        public int getConstructor() {
            return 819228239;
        }
    }

    public static class NetworkTypeNone extends TdApi.NetworkType {
        public static final int CONSTRUCTOR = -1971691759;

        public NetworkTypeNone() {
        }

        public int getConstructor() {
            return -1971691759;
        }
    }

    public abstract static class NetworkType extends TdApi.Object {
        public NetworkType() {
        }
    }

    public static class NetworkStatisticsEntryCall extends TdApi.NetworkStatisticsEntry {
        public TdApi.NetworkType networkType;
        public long sentBytes;
        public long receivedBytes;
        public double duration;
        public static final int CONSTRUCTOR = 737000365;

        public NetworkStatisticsEntryCall() {
        }

        public NetworkStatisticsEntryCall(TdApi.NetworkType var1, long var2, long var4, double var6) {
            this.networkType = var1;
            this.sentBytes = var2;
            this.receivedBytes = var4;
            this.duration = var6;
        }

        public int getConstructor() {
            return 737000365;
        }
    }

    public static class NetworkStatisticsEntryFile extends TdApi.NetworkStatisticsEntry {
        public TdApi.FileType fileType;
        public TdApi.NetworkType networkType;
        public long sentBytes;
        public long receivedBytes;
        public static final int CONSTRUCTOR = 188452706;

        public NetworkStatisticsEntryFile() {
        }

        public NetworkStatisticsEntryFile(TdApi.FileType var1, TdApi.NetworkType var2, long var3, long var5) {
            this.fileType = var1;
            this.networkType = var2;
            this.sentBytes = var3;
            this.receivedBytes = var5;
        }

        public int getConstructor() {
            return 188452706;
        }
    }

    public abstract static class NetworkStatisticsEntry extends TdApi.Object {
        public NetworkStatisticsEntry() {
        }
    }

    public static class NetworkStatistics extends TdApi.Object {
        public int sinceDate;
        public TdApi.NetworkStatisticsEntry[] entries;
        public static final int CONSTRUCTOR = 1615554212;

        public NetworkStatistics() {
        }

        public NetworkStatistics(int var1, TdApi.NetworkStatisticsEntry[] var2) {
            this.sinceDate = var1;
            this.entries = var2;
        }

        public int getConstructor() {
            return 1615554212;
        }
    }

    public static class Minithumbnail extends TdApi.Object {
        public int width;
        public int height;
        public byte[] data;
        public static final int CONSTRUCTOR = -328540758;

        public Minithumbnail() {
        }

        public Minithumbnail(int var1, int var2, byte[] var3) {
            this.width = var1;
            this.height = var2;
            this.data = var3;
        }

        public int getConstructor() {
            return -328540758;
        }
    }

    public static class Messages extends TdApi.Object {
        public int totalCount;
        public TdApi.Message[] messages;
        public static final int CONSTRUCTOR = -16498159;

        public Messages() {
        }

        public Messages(int var1, TdApi.Message[] var2) {
            this.totalCount = var1;
            this.messages = var2;
        }

        public int getConstructor() {
            return -16498159;
        }
    }

    public static class MessageSendingStateFailed extends TdApi.MessageSendingState {
        public int errorCode;
        public String errorMessage;
        public boolean canRetry;
        public double retryAfter;
        public static final int CONSTRUCTOR = 2054476087;

        public MessageSendingStateFailed() {
        }

        public MessageSendingStateFailed(int var1, String var2, boolean var3, double var4) {
            this.errorCode = var1;
            this.errorMessage = var2;
            this.canRetry = var3;
            this.retryAfter = var4;
        }

        public int getConstructor() {
            return 2054476087;
        }
    }

    public static class MessageSendingStatePending extends TdApi.MessageSendingState {
        public static final int CONSTRUCTOR = -1381803582;

        public MessageSendingStatePending() {
        }

        public int getConstructor() {
            return -1381803582;
        }
    }

    public abstract static class MessageSendingState extends TdApi.Object {
        public MessageSendingState() {
        }
    }

    public static class MessageSchedulingStateSendWhenOnline extends TdApi.MessageSchedulingState {
        public static final int CONSTRUCTOR = 2092947464;

        public MessageSchedulingStateSendWhenOnline() {
        }

        public int getConstructor() {
            return 2092947464;
        }
    }

    public static class MessageSchedulingStateSendAtDate extends TdApi.MessageSchedulingState {
        public int sendDate;
        public static final int CONSTRUCTOR = -1485570073;

        public MessageSchedulingStateSendAtDate() {
        }

        public MessageSchedulingStateSendAtDate(int var1) {
            this.sendDate = var1;
        }

        public int getConstructor() {
            return -1485570073;
        }
    }

    public abstract static class MessageSchedulingState extends TdApi.Object {
        public MessageSchedulingState() {
        }
    }

    public static class MessageLinkInfo extends TdApi.Object {
        public boolean isPublic;
        public long chatId;
        public TdApi.Message message;
        public boolean forAlbum;
        public static final int CONSTRUCTOR = 657372995;

        public MessageLinkInfo() {
        }

        public MessageLinkInfo(boolean var1, long var2, TdApi.Message var4, boolean var5) {
            this.isPublic = var1;
            this.chatId = var2;
            this.message = var4;
            this.forAlbum = var5;
        }

        public int getConstructor() {
            return 657372995;
        }
    }

    public static class MessageForwardOriginChannel extends TdApi.MessageForwardOrigin {
        public long chatId;
        public long messageId;
        public String authorSignature;
        public static final int CONSTRUCTOR = 1490730723;

        public MessageForwardOriginChannel() {
        }

        public MessageForwardOriginChannel(long var1, long var3, String var5) {
            this.chatId = var1;
            this.messageId = var3;
            this.authorSignature = var5;
        }

        public int getConstructor() {
            return 1490730723;
        }
    }

    public static class MessageForwardOriginHiddenUser extends TdApi.MessageForwardOrigin {
        public String senderName;
        public static final int CONSTRUCTOR = -271257885;

        public MessageForwardOriginHiddenUser() {
        }

        public MessageForwardOriginHiddenUser(String var1) {
            this.senderName = var1;
        }

        public int getConstructor() {
            return -271257885;
        }
    }

    public static class MessageForwardOriginUser extends TdApi.MessageForwardOrigin {
        public int senderUserId;
        public static final int CONSTRUCTOR = 2781520;

        public MessageForwardOriginUser() {
        }

        public MessageForwardOriginUser(int var1) {
            this.senderUserId = var1;
        }

        public int getConstructor() {
            return 2781520;
        }
    }

    public abstract static class MessageForwardOrigin extends TdApi.Object {
        public MessageForwardOrigin() {
        }
    }

    public static class MessageForwardInfo extends TdApi.Object {
        public TdApi.MessageForwardOrigin origin;
        public int date;
        public long fromChatId;
        public long fromMessageId;
        public static final int CONSTRUCTOR = -1622371186;

        public MessageForwardInfo() {
        }

        public MessageForwardInfo(TdApi.MessageForwardOrigin var1, int var2, long var3, long var5) {
            this.origin = var1;
            this.date = var2;
            this.fromChatId = var3;
            this.fromMessageId = var5;
        }

        public int getConstructor() {
            return -1622371186;
        }
    }

    public static class MessageUnsupported extends TdApi.MessageContent {
        public static final int CONSTRUCTOR = -1816726139;

        public MessageUnsupported() {
        }

        public int getConstructor() {
            return -1816726139;
        }
    }

    public static class MessagePassportDataReceived extends TdApi.MessageContent {
        public TdApi.EncryptedPassportElement[] elements;
        public TdApi.EncryptedCredentials credentials;
        public static final int CONSTRUCTOR = -1367863624;

        public MessagePassportDataReceived() {
        }

        public MessagePassportDataReceived(TdApi.EncryptedPassportElement[] var1, TdApi.EncryptedCredentials var2) {
            this.elements = var1;
            this.credentials = var2;
        }

        public int getConstructor() {
            return -1367863624;
        }
    }

    public static class MessagePassportDataSent extends TdApi.MessageContent {
        public TdApi.PassportElementType[] types;
        public static final int CONSTRUCTOR = 1017405171;

        public MessagePassportDataSent() {
        }

        public MessagePassportDataSent(TdApi.PassportElementType[] var1) {
            this.types = var1;
        }

        public int getConstructor() {
            return 1017405171;
        }
    }

    public static class MessageWebsiteConnected extends TdApi.MessageContent {
        public String domainName;
        public static final int CONSTRUCTOR = -1074551800;

        public MessageWebsiteConnected() {
        }

        public MessageWebsiteConnected(String var1) {
            this.domainName = var1;
        }

        public int getConstructor() {
            return -1074551800;
        }
    }

    public static class MessageContactRegistered extends TdApi.MessageContent {
        public static final int CONSTRUCTOR = -1502020353;

        public MessageContactRegistered() {
        }

        public int getConstructor() {
            return -1502020353;
        }
    }

    public static class MessagePaymentSuccessfulBot extends TdApi.MessageContent {
        public long invoiceMessageId;
        public String currency;
        public long totalAmount;
        public byte[] invoicePayload;
        public String shippingOptionId;
        public TdApi.OrderInfo orderInfo;
        public String telegramPaymentChargeId;
        public String providerPaymentChargeId;
        public static final int CONSTRUCTOR = -412310696;

        public MessagePaymentSuccessfulBot() {
        }

        public MessagePaymentSuccessfulBot(long var1, String var3, long var4, byte[] var6, String var7, TdApi.OrderInfo var8, String var9, String var10) {
            this.invoiceMessageId = var1;
            this.currency = var3;
            this.totalAmount = var4;
            this.invoicePayload = var6;
            this.shippingOptionId = var7;
            this.orderInfo = var8;
            this.telegramPaymentChargeId = var9;
            this.providerPaymentChargeId = var10;
        }

        public int getConstructor() {
            return -412310696;
        }
    }

    public static class MessagePaymentSuccessful extends TdApi.MessageContent {
        public long invoiceMessageId;
        public String currency;
        public long totalAmount;
        public static final int CONSTRUCTOR = -595962993;

        public MessagePaymentSuccessful() {
        }

        public MessagePaymentSuccessful(long var1, String var3, long var4) {
            this.invoiceMessageId = var1;
            this.currency = var3;
            this.totalAmount = var4;
        }

        public int getConstructor() {
            return -595962993;
        }
    }

    public static class MessageGameScore extends TdApi.MessageContent {
        public long gameMessageId;
        public long gameId;
        public int score;
        public static final int CONSTRUCTOR = 1344904575;

        public MessageGameScore() {
        }

        public MessageGameScore(long var1, long var3, int var5) {
            this.gameMessageId = var1;
            this.gameId = var3;
            this.score = var5;
        }

        public int getConstructor() {
            return 1344904575;
        }
    }

    public static class MessageCustomServiceAction extends TdApi.MessageContent {
        public String text;
        public static final int CONSTRUCTOR = 1435879282;

        public MessageCustomServiceAction() {
        }

        public MessageCustomServiceAction(String var1) {
            this.text = var1;
        }

        public int getConstructor() {
            return 1435879282;
        }
    }

    public static class MessageChatSetTtl extends TdApi.MessageContent {
        public int ttl;
        public static final int CONSTRUCTOR = 1810060209;

        public MessageChatSetTtl() {
        }

        public MessageChatSetTtl(int var1) {
            this.ttl = var1;
        }

        public int getConstructor() {
            return 1810060209;
        }
    }

    public static class MessageScreenshotTaken extends TdApi.MessageContent {
        public static final int CONSTRUCTOR = -1564971605;

        public MessageScreenshotTaken() {
        }

        public int getConstructor() {
            return -1564971605;
        }
    }

    public static class MessagePinMessage extends TdApi.MessageContent {
        public long messageId;
        public static final int CONSTRUCTOR = 953503801;

        public MessagePinMessage() {
        }

        public MessagePinMessage(long var1) {
            this.messageId = var1;
        }

        public int getConstructor() {
            return 953503801;
        }
    }

    public static class MessageChatUpgradeFrom extends TdApi.MessageContent {
        public String title;
        public int basicGroupId;
        public static final int CONSTRUCTOR = 1642272558;

        public MessageChatUpgradeFrom() {
        }

        public MessageChatUpgradeFrom(String var1, int var2) {
            this.title = var1;
            this.basicGroupId = var2;
        }

        public int getConstructor() {
            return 1642272558;
        }
    }

    public static class MessageChatUpgradeTo extends TdApi.MessageContent {
        public int supergroupId;
        public static final int CONSTRUCTOR = 1957816681;

        public MessageChatUpgradeTo() {
        }

        public MessageChatUpgradeTo(int var1) {
            this.supergroupId = var1;
        }

        public int getConstructor() {
            return 1957816681;
        }
    }

    public static class MessageChatDeleteMember extends TdApi.MessageContent {
        public int userId;
        public static final int CONSTRUCTOR = 1164414043;

        public MessageChatDeleteMember() {
        }

        public MessageChatDeleteMember(int var1) {
            this.userId = var1;
        }

        public int getConstructor() {
            return 1164414043;
        }
    }

    public static class MessageChatJoinByLink extends TdApi.MessageContent {
        public static final int CONSTRUCTOR = 1846493311;

        public MessageChatJoinByLink() {
        }

        public int getConstructor() {
            return 1846493311;
        }
    }

    public static class MessageChatAddMembers extends TdApi.MessageContent {
        public int[] memberUserIds;
        public static final int CONSTRUCTOR = 401228326;

        public MessageChatAddMembers() {
        }

        public MessageChatAddMembers(int[] var1) {
            this.memberUserIds = var1;
        }

        public int getConstructor() {
            return 401228326;
        }
    }

    public static class MessageChatDeletePhoto extends TdApi.MessageContent {
        public static final int CONSTRUCTOR = -184374809;

        public MessageChatDeletePhoto() {
        }

        public int getConstructor() {
            return -184374809;
        }
    }

    public static class MessageChatChangePhoto extends TdApi.MessageContent {
        public TdApi.Photo photo;
        public static final int CONSTRUCTOR = 319630249;

        public MessageChatChangePhoto() {
        }

        public MessageChatChangePhoto(TdApi.Photo var1) {
            this.photo = var1;
        }

        public int getConstructor() {
            return 319630249;
        }
    }

    public static class MessageChatChangeTitle extends TdApi.MessageContent {
        public String title;
        public static final int CONSTRUCTOR = 748272449;

        public MessageChatChangeTitle() {
        }

        public MessageChatChangeTitle(String var1) {
            this.title = var1;
        }

        public int getConstructor() {
            return 748272449;
        }
    }

    public static class MessageSupergroupChatCreate extends TdApi.MessageContent {
        public String title;
        public static final int CONSTRUCTOR = -434325733;

        public MessageSupergroupChatCreate() {
        }

        public MessageSupergroupChatCreate(String var1) {
            this.title = var1;
        }

        public int getConstructor() {
            return -434325733;
        }
    }

    public static class MessageBasicGroupChatCreate extends TdApi.MessageContent {
        public String title;
        public int[] memberUserIds;
        public static final int CONSTRUCTOR = 1575377646;

        public MessageBasicGroupChatCreate() {
        }

        public MessageBasicGroupChatCreate(String var1, int[] var2) {
            this.title = var1;
            this.memberUserIds = var2;
        }

        public int getConstructor() {
            return 1575377646;
        }
    }

    public static class MessageCall extends TdApi.MessageContent {
        public TdApi.CallDiscardReason discardReason;
        public int duration;
        public static final int CONSTRUCTOR = 366512596;

        public MessageCall() {
        }

        public MessageCall(TdApi.CallDiscardReason var1, int var2) {
            this.discardReason = var1;
            this.duration = var2;
        }

        public int getConstructor() {
            return 366512596;
        }
    }

    public static class MessageInvoice extends TdApi.MessageContent {
        public String title;
        public String description;
        public TdApi.Photo photo;
        public String currency;
        public long totalAmount;
        public String startParameter;
        public boolean isTest;
        public boolean needShippingAddress;
        public long receiptMessageId;
        public static final int CONSTRUCTOR = -1916671476;

        public MessageInvoice() {
        }

        public MessageInvoice(String var1, String var2, TdApi.Photo var3, String var4, long var5, String var7, boolean var8, boolean var9, long var10) {
            this.title = var1;
            this.description = var2;
            this.photo = var3;
            this.currency = var4;
            this.totalAmount = var5;
            this.startParameter = var7;
            this.isTest = var8;
            this.needShippingAddress = var9;
            this.receiptMessageId = var10;
        }

        public int getConstructor() {
            return -1916671476;
        }
    }

    public static class MessagePoll extends TdApi.MessageContent {
        public TdApi.Poll poll;
        public static final int CONSTRUCTOR = -662130099;

        public MessagePoll() {
        }

        public MessagePoll(TdApi.Poll var1) {
            this.poll = var1;
        }

        public int getConstructor() {
            return -662130099;
        }
    }

    public static class MessageGame extends TdApi.MessageContent {
        public TdApi.Game game;
        public static final int CONSTRUCTOR = -69441162;

        public MessageGame() {
        }

        public MessageGame(TdApi.Game var1) {
            this.game = var1;
        }

        public int getConstructor() {
            return -69441162;
        }
    }

    public static class MessageContact extends TdApi.MessageContent {
        public TdApi.Contact contact;
        public static final int CONSTRUCTOR = -512684966;

        public MessageContact() {
        }

        public MessageContact(TdApi.Contact var1) {
            this.contact = var1;
        }

        public int getConstructor() {
            return -512684966;
        }
    }

    public static class MessageVenue extends TdApi.MessageContent {
        public TdApi.Venue venue;
        public static final int CONSTRUCTOR = -2146492043;

        public MessageVenue() {
        }

        public MessageVenue(TdApi.Venue var1) {
            this.venue = var1;
        }

        public int getConstructor() {
            return -2146492043;
        }
    }

    public static class MessageLocation extends TdApi.MessageContent {
        public TdApi.Location location;
        public int livePeriod;
        public int expiresIn;
        public static final int CONSTRUCTOR = -1301887786;

        public MessageLocation() {
        }

        public MessageLocation(TdApi.Location var1, int var2, int var3) {
            this.location = var1;
            this.livePeriod = var2;
            this.expiresIn = var3;
        }

        public int getConstructor() {
            return -1301887786;
        }
    }

    public static class MessageVoiceNote extends TdApi.MessageContent {
        public TdApi.VoiceNote voiceNote;
        public TdApi.FormattedText caption;
        public boolean isListened;
        public static final int CONSTRUCTOR = 527777781;

        public MessageVoiceNote() {
        }

        public MessageVoiceNote(TdApi.VoiceNote var1, TdApi.FormattedText var2, boolean var3) {
            this.voiceNote = var1;
            this.caption = var2;
            this.isListened = var3;
        }

        public int getConstructor() {
            return 527777781;
        }
    }

    public static class MessageVideoNote extends TdApi.MessageContent {
        public TdApi.VideoNote videoNote;
        public boolean isViewed;
        public boolean isSecret;
        public static final int CONSTRUCTOR = 963323014;

        public MessageVideoNote() {
        }

        public MessageVideoNote(TdApi.VideoNote var1, boolean var2, boolean var3) {
            this.videoNote = var1;
            this.isViewed = var2;
            this.isSecret = var3;
        }

        public int getConstructor() {
            return 963323014;
        }
    }

    public static class MessageExpiredVideo extends TdApi.MessageContent {
        public static final int CONSTRUCTOR = -1212209981;

        public MessageExpiredVideo() {
        }

        public int getConstructor() {
            return -1212209981;
        }
    }

    public static class MessageVideo extends TdApi.MessageContent {
        public TdApi.Video video;
        public TdApi.FormattedText caption;
        public boolean isSecret;
        public static final int CONSTRUCTOR = 2021281344;

        public MessageVideo() {
        }

        public MessageVideo(TdApi.Video var1, TdApi.FormattedText var2, boolean var3) {
            this.video = var1;
            this.caption = var2;
            this.isSecret = var3;
        }

        public int getConstructor() {
            return 2021281344;
        }
    }

    public static class MessageSticker extends TdApi.MessageContent {
        public TdApi.Sticker sticker;
        public static final int CONSTRUCTOR = 1779022878;

        public MessageSticker() {
        }

        public MessageSticker(TdApi.Sticker var1) {
            this.sticker = var1;
        }

        public int getConstructor() {
            return 1779022878;
        }
    }

    public static class MessageExpiredPhoto extends TdApi.MessageContent {
        public static final int CONSTRUCTOR = -1404641801;

        public MessageExpiredPhoto() {
        }

        public int getConstructor() {
            return -1404641801;
        }
    }

    public static class MessagePhoto extends TdApi.MessageContent {
        public TdApi.Photo photo;
        public TdApi.FormattedText caption;
        public boolean isSecret;
        public static final int CONSTRUCTOR = -1851395174;

        public MessagePhoto() {
        }

        public MessagePhoto(TdApi.Photo var1, TdApi.FormattedText var2, boolean var3) {
            this.photo = var1;
            this.caption = var2;
            this.isSecret = var3;
        }

        public int getConstructor() {
            return -1851395174;
        }
    }

    public static class MessageDocument extends TdApi.MessageContent {
        public TdApi.Document document;
        public TdApi.FormattedText caption;
        public static final int CONSTRUCTOR = 596945783;

        public MessageDocument() {
        }

        public MessageDocument(TdApi.Document var1, TdApi.FormattedText var2) {
            this.document = var1;
            this.caption = var2;
        }

        public int getConstructor() {
            return 596945783;
        }
    }

    public static class MessageAudio extends TdApi.MessageContent {
        public TdApi.Audio audio;
        public TdApi.FormattedText caption;
        public static final int CONSTRUCTOR = 276722716;

        public MessageAudio() {
        }

        public MessageAudio(TdApi.Audio var1, TdApi.FormattedText var2) {
            this.audio = var1;
            this.caption = var2;
        }

        public int getConstructor() {
            return 276722716;
        }
    }

    public static class MessageAnimation extends TdApi.MessageContent {
        public TdApi.Animation animation;
        public TdApi.FormattedText caption;
        public boolean isSecret;
        public static final int CONSTRUCTOR = 1306939396;

        public MessageAnimation() {
        }

        public MessageAnimation(TdApi.Animation var1, TdApi.FormattedText var2, boolean var3) {
            this.animation = var1;
            this.caption = var2;
            this.isSecret = var3;
        }

        public int getConstructor() {
            return 1306939396;
        }
    }

    public static class MessageText extends TdApi.MessageContent {
        public TdApi.FormattedText text;
        public TdApi.WebPage webPage;
        public static final int CONSTRUCTOR = 1989037971;

        public MessageText() {
        }

        public MessageText(TdApi.FormattedText var1, TdApi.WebPage var2) {
            this.text = var1;
            this.webPage = var2;
        }

        public int getConstructor() {
            return 1989037971;
        }
    }

    public abstract static class MessageContent extends TdApi.Object {
        public MessageContent() {
        }
    }

    public static class Message extends TdApi.Object {
        public long id;
        public int senderUserId;
        public long chatId;
        public TdApi.MessageSendingState sendingState;
        public TdApi.MessageSchedulingState schedulingState;
        public boolean isOutgoing;
        public boolean canBeEdited;
        public boolean canBeForwarded;
        public boolean canBeDeletedOnlyForSelf;
        public boolean canBeDeletedForAllUsers;
        public boolean isChannelPost;
        public boolean containsUnreadMention;
        public int date;
        public int editDate;
        public TdApi.MessageForwardInfo forwardInfo;
        public long replyToMessageId;
        public int ttl;
        public double ttlExpiresIn;
        public int viaBotUserId;
        public String authorSignature;
        public int views;
        public long mediaAlbumId;
        public String restrictionReason;
        public TdApi.MessageContent content;
        public TdApi.ReplyMarkup replyMarkup;
        public static final int CONSTRUCTOR = 1169109781;

        public Message() {
        }

        public Message(long var1, int var3, long var4, TdApi.MessageSendingState var6, TdApi.MessageSchedulingState var7, boolean var8, boolean var9, boolean var10, boolean var11, boolean var12, boolean var13, boolean var14, int var15, int var16, TdApi.MessageForwardInfo var17, long var18, int var20, double var21, int var23, String var24, int var25, long var26, String var28, TdApi.MessageContent var29, TdApi.ReplyMarkup var30) {
            this.id = var1;
            this.senderUserId = var3;
            this.chatId = var4;
            this.sendingState = var6;
            this.schedulingState = var7;
            this.isOutgoing = var8;
            this.canBeEdited = var9;
            this.canBeForwarded = var10;
            this.canBeDeletedOnlyForSelf = var11;
            this.canBeDeletedForAllUsers = var12;
            this.isChannelPost = var13;
            this.containsUnreadMention = var14;
            this.date = var15;
            this.editDate = var16;
            this.forwardInfo = var17;
            this.replyToMessageId = var18;
            this.ttl = var20;
            this.ttlExpiresIn = var21;
            this.viaBotUserId = var23;
            this.authorSignature = var24;
            this.views = var25;
            this.mediaAlbumId = var26;
            this.restrictionReason = var28;
            this.content = var29;
            this.replyMarkup = var30;
        }

        public int getConstructor() {
            return 1169109781;
        }
    }

    public static class MaskPosition extends TdApi.Object {
        public TdApi.MaskPoint point;
        public double xShift;
        public double yShift;
        public double scale;
        public static final int CONSTRUCTOR = -2097433026;

        public MaskPosition() {
        }

        public MaskPosition(TdApi.MaskPoint var1, double var2, double var4, double var6) {
            this.point = var1;
            this.xShift = var2;
            this.yShift = var4;
            this.scale = var6;
        }

        public int getConstructor() {
            return -2097433026;
        }
    }

    public static class MaskPointChin extends TdApi.MaskPoint {
        public static final int CONSTRUCTOR = 534995335;

        public MaskPointChin() {
        }

        public int getConstructor() {
            return 534995335;
        }
    }

    public static class MaskPointMouth extends TdApi.MaskPoint {
        public static final int CONSTRUCTOR = 411773406;

        public MaskPointMouth() {
        }

        public int getConstructor() {
            return 411773406;
        }
    }

    public static class MaskPointEyes extends TdApi.MaskPoint {
        public static final int CONSTRUCTOR = 1748310861;

        public MaskPointEyes() {
        }

        public int getConstructor() {
            return 1748310861;
        }
    }

    public static class MaskPointForehead extends TdApi.MaskPoint {
        public static final int CONSTRUCTOR = 1027512005;

        public MaskPointForehead() {
        }

        public int getConstructor() {
            return 1027512005;
        }
    }

    public abstract static class MaskPoint extends TdApi.Object {
        public MaskPoint() {
        }
    }

    public static class LoginUrlInfoRequestConfirmation extends TdApi.LoginUrlInfo {
        public String url;
        public String domain;
        public int botUserId;
        public boolean requestWriteAccess;
        public static final int CONSTRUCTOR = -1761898342;

        public LoginUrlInfoRequestConfirmation() {
        }

        public LoginUrlInfoRequestConfirmation(String var1, String var2, int var3, boolean var4) {
            this.url = var1;
            this.domain = var2;
            this.botUserId = var3;
            this.requestWriteAccess = var4;
        }

        public int getConstructor() {
            return -1761898342;
        }
    }

    public static class LoginUrlInfoOpen extends TdApi.LoginUrlInfo {
        public String url;
        public boolean skipConfirm;
        public static final int CONSTRUCTOR = -1079045420;

        public LoginUrlInfoOpen() {
        }

        public LoginUrlInfoOpen(String var1, boolean var2) {
            this.url = var1;
            this.skipConfirm = var2;
        }

        public int getConstructor() {
            return -1079045420;
        }
    }

    public abstract static class LoginUrlInfo extends TdApi.Object {
        public LoginUrlInfo() {
        }
    }

    public static class LogVerbosityLevel extends TdApi.Object {
        public int verbosityLevel;
        public static final int CONSTRUCTOR = 1734624234;

        public LogVerbosityLevel() {
        }

        public LogVerbosityLevel(int var1) {
            this.verbosityLevel = var1;
        }

        public int getConstructor() {
            return 1734624234;
        }
    }

    public static class LogTags extends TdApi.Object {
        public String[] tags;
        public static final int CONSTRUCTOR = -1604930601;

        public LogTags() {
        }

        public LogTags(String[] var1) {
            this.tags = var1;
        }

        public int getConstructor() {
            return -1604930601;
        }
    }

    public static class LogStreamEmpty extends TdApi.LogStream {
        public static final int CONSTRUCTOR = -499912244;

        public LogStreamEmpty() {
        }

        public int getConstructor() {
            return -499912244;
        }
    }

    public static class LogStreamFile extends TdApi.LogStream {
        public String path;
        public long maxFileSize;
        public static final int CONSTRUCTOR = -1880085930;

        public LogStreamFile() {
        }

        public LogStreamFile(String var1, long var2) {
            this.path = var1;
            this.maxFileSize = var2;
        }

        public int getConstructor() {
            return -1880085930;
        }
    }

    public static class LogStreamDefault extends TdApi.LogStream {
        public static final int CONSTRUCTOR = 1390581436;

        public LogStreamDefault() {
        }

        public int getConstructor() {
            return 1390581436;
        }
    }

    public abstract static class LogStream extends TdApi.Object {
        public LogStream() {
        }
    }

    public static class Location extends TdApi.Object {
        public double latitude;
        public double longitude;
        public static final int CONSTRUCTOR = 749028016;

        public Location() {
        }

        public Location(double var1, double var3) {
            this.latitude = var1;
            this.longitude = var3;
        }

        public int getConstructor() {
            return 749028016;
        }
    }

    public static class LocalizationTargetInfo extends TdApi.Object {
        public TdApi.LanguagePackInfo[] languagePacks;
        public static final int CONSTRUCTOR = -2048670809;

        public LocalizationTargetInfo() {
        }

        public LocalizationTargetInfo(TdApi.LanguagePackInfo[] var1) {
            this.languagePacks = var1;
        }

        public int getConstructor() {
            return -2048670809;
        }
    }

    public static class LocalFile extends TdApi.Object {
        public String path;
        public boolean canBeDownloaded;
        public boolean canBeDeleted;
        public boolean isDownloadingActive;
        public boolean isDownloadingCompleted;
        public int downloadOffset;
        public int downloadedPrefixSize;
        public int downloadedSize;
        public static final int CONSTRUCTOR = -1166400317;

        public LocalFile() {
        }

        public LocalFile(String var1, boolean var2, boolean var3, boolean var4, boolean var5, int var6, int var7, int var8) {
            this.path = var1;
            this.canBeDownloaded = var2;
            this.canBeDeleted = var3;
            this.isDownloadingActive = var4;
            this.isDownloadingCompleted = var5;
            this.downloadOffset = var6;
            this.downloadedPrefixSize = var7;
            this.downloadedSize = var8;
        }

        public int getConstructor() {
            return -1166400317;
        }
    }

    public static class LanguagePackStrings extends TdApi.Object {
        public TdApi.LanguagePackString[] strings;
        public static final int CONSTRUCTOR = 1172082922;

        public LanguagePackStrings() {
        }

        public LanguagePackStrings(TdApi.LanguagePackString[] var1) {
            this.strings = var1;
        }

        public int getConstructor() {
            return 1172082922;
        }
    }

    public static class LanguagePackStringValueDeleted extends TdApi.LanguagePackStringValue {
        public static final int CONSTRUCTOR = 1834792698;

        public LanguagePackStringValueDeleted() {
        }

        public int getConstructor() {
            return 1834792698;
        }
    }

    public static class LanguagePackStringValuePluralized extends TdApi.LanguagePackStringValue {
        public String zeroValue;
        public String oneValue;
        public String twoValue;
        public String fewValue;
        public String manyValue;
        public String otherValue;
        public static final int CONSTRUCTOR = 1906840261;

        public LanguagePackStringValuePluralized() {
        }

        public LanguagePackStringValuePluralized(String var1, String var2, String var3, String var4, String var5, String var6) {
            this.zeroValue = var1;
            this.oneValue = var2;
            this.twoValue = var3;
            this.fewValue = var4;
            this.manyValue = var5;
            this.otherValue = var6;
        }

        public int getConstructor() {
            return 1906840261;
        }
    }

    public static class LanguagePackStringValueOrdinary extends TdApi.LanguagePackStringValue {
        public String value;
        public static final int CONSTRUCTOR = -249256352;

        public LanguagePackStringValueOrdinary() {
        }

        public LanguagePackStringValueOrdinary(String var1) {
            this.value = var1;
        }

        public int getConstructor() {
            return -249256352;
        }
    }

    public abstract static class LanguagePackStringValue extends TdApi.Object {
        public LanguagePackStringValue() {
        }
    }

    public static class LanguagePackString extends TdApi.Object {
        public String key;
        public TdApi.LanguagePackStringValue value;
        public static final int CONSTRUCTOR = 1307632736;

        public LanguagePackString() {
        }

        public LanguagePackString(String var1, TdApi.LanguagePackStringValue var2) {
            this.key = var1;
            this.value = var2;
        }

        public int getConstructor() {
            return 1307632736;
        }
    }

    public static class LanguagePackInfo extends TdApi.Object {
        public String id;
        public String baseLanguagePackId;
        public String name;
        public String nativeName;
        public String pluralCode;
        public boolean isOfficial;
        public boolean isRtl;
        public boolean isBeta;
        public boolean isInstalled;
        public int totalStringCount;
        public int translatedStringCount;
        public int localStringCount;
        public String translationUrl;
        public static final int CONSTRUCTOR = 542199642;

        public LanguagePackInfo() {
        }

        public LanguagePackInfo(String var1, String var2, String var3, String var4, String var5, boolean var6, boolean var7, boolean var8, boolean var9, int var10, int var11, int var12, String var13) {
            this.id = var1;
            this.baseLanguagePackId = var2;
            this.name = var3;
            this.nativeName = var4;
            this.pluralCode = var5;
            this.isOfficial = var6;
            this.isRtl = var7;
            this.isBeta = var8;
            this.isInstalled = var9;
            this.totalStringCount = var10;
            this.translatedStringCount = var11;
            this.localStringCount = var12;
            this.translationUrl = var13;
        }

        public int getConstructor() {
            return 542199642;
        }
    }

    public static class LabeledPricePart extends TdApi.Object {
        public String label;
        public long amount;
        public static final int CONSTRUCTOR = 552789798;

        public LabeledPricePart() {
        }

        public LabeledPricePart(String var1, long var2) {
            this.label = var1;
            this.amount = var2;
        }

        public int getConstructor() {
            return 552789798;
        }
    }

    public static class KeyboardButtonTypeRequestPoll extends TdApi.KeyboardButtonType {
        public boolean forceRegular;
        public boolean forceQuiz;
        public static final int CONSTRUCTOR = 1902435512;

        public KeyboardButtonTypeRequestPoll() {
        }

        public KeyboardButtonTypeRequestPoll(boolean var1, boolean var2) {
            this.forceRegular = var1;
            this.forceQuiz = var2;
        }

        public int getConstructor() {
            return 1902435512;
        }
    }

    public static class KeyboardButtonTypeRequestLocation extends TdApi.KeyboardButtonType {
        public static final int CONSTRUCTOR = -125661955;

        public KeyboardButtonTypeRequestLocation() {
        }

        public int getConstructor() {
            return -125661955;
        }
    }

    public static class KeyboardButtonTypeRequestPhoneNumber extends TdApi.KeyboardButtonType {
        public static final int CONSTRUCTOR = -1529235527;

        public KeyboardButtonTypeRequestPhoneNumber() {
        }

        public int getConstructor() {
            return -1529235527;
        }
    }

    public static class KeyboardButtonTypeText extends TdApi.KeyboardButtonType {
        public static final int CONSTRUCTOR = -1773037256;

        public KeyboardButtonTypeText() {
        }

        public int getConstructor() {
            return -1773037256;
        }
    }

    public abstract static class KeyboardButtonType extends TdApi.Object {
        public KeyboardButtonType() {
        }
    }

    public static class KeyboardButton extends TdApi.Object {
        public String text;
        public TdApi.KeyboardButtonType type;
        public static final int CONSTRUCTOR = -2069836172;

        public KeyboardButton() {
        }

        public KeyboardButton(String var1, TdApi.KeyboardButtonType var2) {
            this.text = var1;
            this.type = var2;
        }

        public int getConstructor() {
            return -2069836172;
        }
    }

    public static class JsonValueObject extends TdApi.JsonValue {
        public TdApi.JsonObjectMember[] members;
        public static final int CONSTRUCTOR = 520252026;

        public JsonValueObject() {
        }

        public JsonValueObject(TdApi.JsonObjectMember[] var1) {
            this.members = var1;
        }

        public int getConstructor() {
            return 520252026;
        }
    }

    public static class JsonValueArray extends TdApi.JsonValue {
        public TdApi.JsonValue[] values;
        public static final int CONSTRUCTOR = -183913546;

        public JsonValueArray() {
        }

        public JsonValueArray(TdApi.JsonValue[] var1) {
            this.values = var1;
        }

        public int getConstructor() {
            return -183913546;
        }
    }

    public static class JsonValueString extends TdApi.JsonValue {
        public String value;
        public static final int CONSTRUCTOR = 1597947313;

        public JsonValueString() {
        }

        public JsonValueString(String var1) {
            this.value = var1;
        }

        public int getConstructor() {
            return 1597947313;
        }
    }

    public static class JsonValueNumber extends TdApi.JsonValue {
        public double value;
        public static final int CONSTRUCTOR = -1010822033;

        public JsonValueNumber() {
        }

        public JsonValueNumber(double var1) {
            this.value = var1;
        }

        public int getConstructor() {
            return -1010822033;
        }
    }

    public static class JsonValueBoolean extends TdApi.JsonValue {
        public boolean value;
        public static final int CONSTRUCTOR = -2142186576;

        public JsonValueBoolean() {
        }

        public JsonValueBoolean(boolean var1) {
            this.value = var1;
        }

        public int getConstructor() {
            return -2142186576;
        }
    }

    public static class JsonValueNull extends TdApi.JsonValue {
        public static final int CONSTRUCTOR = -92872499;

        public JsonValueNull() {
        }

        public int getConstructor() {
            return -92872499;
        }
    }

    public abstract static class JsonValue extends TdApi.Object {
        public JsonValue() {
        }
    }

    public static class JsonObjectMember extends TdApi.Object {
        public String key;
        public TdApi.JsonValue value;
        public static final int CONSTRUCTOR = -1803309418;

        public JsonObjectMember() {
        }

        public JsonObjectMember(String var1, TdApi.JsonValue var2) {
            this.key = var1;
            this.value = var2;
        }

        public int getConstructor() {
            return -1803309418;
        }
    }

    public static class Invoice extends TdApi.Object {
        public String currency;
        public TdApi.LabeledPricePart[] priceParts;
        public boolean isTest;
        public boolean needName;
        public boolean needPhoneNumber;
        public boolean needEmailAddress;
        public boolean needShippingAddress;
        public boolean sendPhoneNumberToProvider;
        public boolean sendEmailAddressToProvider;
        public boolean isFlexible;
        public static final int CONSTRUCTOR = -368451690;

        public Invoice() {
        }

        public Invoice(String var1, TdApi.LabeledPricePart[] var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10) {
            this.currency = var1;
            this.priceParts = var2;
            this.isTest = var3;
            this.needName = var4;
            this.needPhoneNumber = var5;
            this.needEmailAddress = var6;
            this.needShippingAddress = var7;
            this.sendPhoneNumberToProvider = var8;
            this.sendEmailAddressToProvider = var9;
            this.isFlexible = var10;
        }

        public int getConstructor() {
            return -368451690;
        }
    }

    public static class InputThumbnail extends TdApi.Object {
        public TdApi.InputFile thumbnail;
        public int width;
        public int height;
        public static final int CONSTRUCTOR = 1582387236;

        public InputThumbnail() {
        }

        public InputThumbnail(TdApi.InputFile var1, int var2, int var3) {
            this.thumbnail = var1;
            this.width = var2;
            this.height = var3;
        }

        public int getConstructor() {
            return 1582387236;
        }
    }

    public static class InputSticker extends TdApi.Object {
        public TdApi.InputFile pngSticker;
        public String emojis;
        public TdApi.MaskPosition maskPosition;
        public static final int CONSTRUCTOR = -1998602205;

        public InputSticker() {
        }

        public InputSticker(TdApi.InputFile var1, String var2, TdApi.MaskPosition var3) {
            this.pngSticker = var1;
            this.emojis = var2;
            this.maskPosition = var3;
        }

        public int getConstructor() {
            return -1998602205;
        }
    }

    public static class InputPersonalDocument extends TdApi.Object {
        public TdApi.InputFile[] files;
        public TdApi.InputFile[] translation;
        public static final int CONSTRUCTOR = 1676966826;

        public InputPersonalDocument() {
        }

        public InputPersonalDocument(TdApi.InputFile[] var1, TdApi.InputFile[] var2) {
            this.files = var1;
            this.translation = var2;
        }

        public int getConstructor() {
            return 1676966826;
        }
    }

    public static class InputPassportElementErrorSourceFiles extends TdApi.InputPassportElementErrorSource {
        public byte[][] fileHashes;
        public static final int CONSTRUCTOR = -2008541640;

        public InputPassportElementErrorSourceFiles() {
        }

        public InputPassportElementErrorSourceFiles(byte[][] var1) {
            this.fileHashes = var1;
        }

        public int getConstructor() {
            return -2008541640;
        }
    }

    public static class InputPassportElementErrorSourceFile extends TdApi.InputPassportElementErrorSource {
        public byte[] fileHash;
        public static final int CONSTRUCTOR = -298492469;

        public InputPassportElementErrorSourceFile() {
        }

        public InputPassportElementErrorSourceFile(byte[] var1) {
            this.fileHash = var1;
        }

        public int getConstructor() {
            return -298492469;
        }
    }

    public static class InputPassportElementErrorSourceTranslationFiles extends TdApi.InputPassportElementErrorSource {
        public byte[][] fileHashes;
        public static final int CONSTRUCTOR = -527254048;

        public InputPassportElementErrorSourceTranslationFiles() {
        }

        public InputPassportElementErrorSourceTranslationFiles(byte[][] var1) {
            this.fileHashes = var1;
        }

        public int getConstructor() {
            return -527254048;
        }
    }

    public static class InputPassportElementErrorSourceTranslationFile extends TdApi.InputPassportElementErrorSource {
        public byte[] fileHash;
        public static final int CONSTRUCTOR = 505842299;

        public InputPassportElementErrorSourceTranslationFile() {
        }

        public InputPassportElementErrorSourceTranslationFile(byte[] var1) {
            this.fileHash = var1;
        }

        public int getConstructor() {
            return 505842299;
        }
    }

    public static class InputPassportElementErrorSourceSelfie extends TdApi.InputPassportElementErrorSource {
        public byte[] fileHash;
        public static final int CONSTRUCTOR = -773575528;

        public InputPassportElementErrorSourceSelfie() {
        }

        public InputPassportElementErrorSourceSelfie(byte[] var1) {
            this.fileHash = var1;
        }

        public int getConstructor() {
            return -773575528;
        }
    }

    public static class InputPassportElementErrorSourceReverseSide extends TdApi.InputPassportElementErrorSource {
        public byte[] fileHash;
        public static final int CONSTRUCTOR = 413072891;

        public InputPassportElementErrorSourceReverseSide() {
        }

        public InputPassportElementErrorSourceReverseSide(byte[] var1) {
            this.fileHash = var1;
        }

        public int getConstructor() {
            return 413072891;
        }
    }

    public static class InputPassportElementErrorSourceFrontSide extends TdApi.InputPassportElementErrorSource {
        public byte[] fileHash;
        public static final int CONSTRUCTOR = 588023741;

        public InputPassportElementErrorSourceFrontSide() {
        }

        public InputPassportElementErrorSourceFrontSide(byte[] var1) {
            this.fileHash = var1;
        }

        public int getConstructor() {
            return 588023741;
        }
    }

    public static class InputPassportElementErrorSourceDataField extends TdApi.InputPassportElementErrorSource {
        public String fieldName;
        public byte[] dataHash;
        public static final int CONSTRUCTOR = -426795002;

        public InputPassportElementErrorSourceDataField() {
        }

        public InputPassportElementErrorSourceDataField(String var1, byte[] var2) {
            this.fieldName = var1;
            this.dataHash = var2;
        }

        public int getConstructor() {
            return -426795002;
        }
    }

    public static class InputPassportElementErrorSourceUnspecified extends TdApi.InputPassportElementErrorSource {
        public byte[] elementHash;
        public static final int CONSTRUCTOR = 267230319;

        public InputPassportElementErrorSourceUnspecified() {
        }

        public InputPassportElementErrorSourceUnspecified(byte[] var1) {
            this.elementHash = var1;
        }

        public int getConstructor() {
            return 267230319;
        }
    }

    public abstract static class InputPassportElementErrorSource extends TdApi.Object {
        public InputPassportElementErrorSource() {
        }
    }

    public static class InputPassportElementError extends TdApi.Object {
        public TdApi.PassportElementType type;
        public String message;
        public TdApi.InputPassportElementErrorSource source;
        public static final int CONSTRUCTOR = 285756898;

        public InputPassportElementError() {
        }

        public InputPassportElementError(TdApi.PassportElementType var1, String var2, TdApi.InputPassportElementErrorSource var3) {
            this.type = var1;
            this.message = var2;
            this.source = var3;
        }

        public int getConstructor() {
            return 285756898;
        }
    }

    public static class InputPassportElementEmailAddress extends TdApi.InputPassportElement {
        public String emailAddress;
        public static final int CONSTRUCTOR = -248605659;

        public InputPassportElementEmailAddress() {
        }

        public InputPassportElementEmailAddress(String var1) {
            this.emailAddress = var1;
        }

        public int getConstructor() {
            return -248605659;
        }
    }

    public static class InputPassportElementPhoneNumber extends TdApi.InputPassportElement {
        public String phoneNumber;
        public static final int CONSTRUCTOR = 1319357497;

        public InputPassportElementPhoneNumber() {
        }

        public InputPassportElementPhoneNumber(String var1) {
            this.phoneNumber = var1;
        }

        public int getConstructor() {
            return 1319357497;
        }
    }

    public static class InputPassportElementTemporaryRegistration extends TdApi.InputPassportElement {
        public TdApi.InputPersonalDocument temporaryRegistration;
        public static final int CONSTRUCTOR = -1913238047;

        public InputPassportElementTemporaryRegistration() {
        }

        public InputPassportElementTemporaryRegistration(TdApi.InputPersonalDocument var1) {
            this.temporaryRegistration = var1;
        }

        public int getConstructor() {
            return -1913238047;
        }
    }

    public static class InputPassportElementPassportRegistration extends TdApi.InputPassportElement {
        public TdApi.InputPersonalDocument passportRegistration;
        public static final int CONSTRUCTOR = 1314562128;

        public InputPassportElementPassportRegistration() {
        }

        public InputPassportElementPassportRegistration(TdApi.InputPersonalDocument var1) {
            this.passportRegistration = var1;
        }

        public int getConstructor() {
            return 1314562128;
        }
    }

    public static class InputPassportElementRentalAgreement extends TdApi.InputPassportElement {
        public TdApi.InputPersonalDocument rentalAgreement;
        public static final int CONSTRUCTOR = 1736154155;

        public InputPassportElementRentalAgreement() {
        }

        public InputPassportElementRentalAgreement(TdApi.InputPersonalDocument var1) {
            this.rentalAgreement = var1;
        }

        public int getConstructor() {
            return 1736154155;
        }
    }

    public static class InputPassportElementBankStatement extends TdApi.InputPassportElement {
        public TdApi.InputPersonalDocument bankStatement;
        public static final int CONSTRUCTOR = -26585208;

        public InputPassportElementBankStatement() {
        }

        public InputPassportElementBankStatement(TdApi.InputPersonalDocument var1) {
            this.bankStatement = var1;
        }

        public int getConstructor() {
            return -26585208;
        }
    }

    public static class InputPassportElementUtilityBill extends TdApi.InputPassportElement {
        public TdApi.InputPersonalDocument utilityBill;
        public static final int CONSTRUCTOR = 1389203841;

        public InputPassportElementUtilityBill() {
        }

        public InputPassportElementUtilityBill(TdApi.InputPersonalDocument var1) {
            this.utilityBill = var1;
        }

        public int getConstructor() {
            return 1389203841;
        }
    }

    public static class InputPassportElementAddress extends TdApi.InputPassportElement {
        public TdApi.Address address;
        public static final int CONSTRUCTOR = 461630480;

        public InputPassportElementAddress() {
        }

        public InputPassportElementAddress(TdApi.Address var1) {
            this.address = var1;
        }

        public int getConstructor() {
            return 461630480;
        }
    }

    public static class InputPassportElementInternalPassport extends TdApi.InputPassportElement {
        public TdApi.InputIdentityDocument internalPassport;
        public static final int CONSTRUCTOR = 715360043;

        public InputPassportElementInternalPassport() {
        }

        public InputPassportElementInternalPassport(TdApi.InputIdentityDocument var1) {
            this.internalPassport = var1;
        }

        public int getConstructor() {
            return 715360043;
        }
    }

    public static class InputPassportElementIdentityCard extends TdApi.InputPassportElement {
        public TdApi.InputIdentityDocument identityCard;
        public static final int CONSTRUCTOR = -9963390;

        public InputPassportElementIdentityCard() {
        }

        public InputPassportElementIdentityCard(TdApi.InputIdentityDocument var1) {
            this.identityCard = var1;
        }

        public int getConstructor() {
            return -9963390;
        }
    }

    public static class InputPassportElementDriverLicense extends TdApi.InputPassportElement {
        public TdApi.InputIdentityDocument driverLicense;
        public static final int CONSTRUCTOR = 304813264;

        public InputPassportElementDriverLicense() {
        }

        public InputPassportElementDriverLicense(TdApi.InputIdentityDocument var1) {
            this.driverLicense = var1;
        }

        public int getConstructor() {
            return 304813264;
        }
    }

    public static class InputPassportElementPassport extends TdApi.InputPassportElement {
        public TdApi.InputIdentityDocument passport;
        public static final int CONSTRUCTOR = -497011356;

        public InputPassportElementPassport() {
        }

        public InputPassportElementPassport(TdApi.InputIdentityDocument var1) {
            this.passport = var1;
        }

        public int getConstructor() {
            return -497011356;
        }
    }

    public static class InputPassportElementPersonalDetails extends TdApi.InputPassportElement {
        public TdApi.PersonalDetails personalDetails;
        public static final int CONSTRUCTOR = 164791359;

        public InputPassportElementPersonalDetails() {
        }

        public InputPassportElementPersonalDetails(TdApi.PersonalDetails var1) {
            this.personalDetails = var1;
        }

        public int getConstructor() {
            return 164791359;
        }
    }

    public abstract static class InputPassportElement extends TdApi.Object {
        public InputPassportElement() {
        }
    }

    public static class InputMessageForwarded extends TdApi.InputMessageContent {
        public long fromChatId;
        public long messageId;
        public boolean inGameShare;
        public boolean sendCopy;
        public boolean removeCaption;
        public static final int CONSTRUCTOR = 1503132333;

        public InputMessageForwarded() {
        }

        public InputMessageForwarded(long var1, long var3, boolean var5, boolean var6, boolean var7) {
            this.fromChatId = var1;
            this.messageId = var3;
            this.inGameShare = var5;
            this.sendCopy = var6;
            this.removeCaption = var7;
        }

        public int getConstructor() {
            return 1503132333;
        }
    }

    public static class InputMessagePoll extends TdApi.InputMessageContent {
        public String question;
        public String[] options;
        public boolean isAnonymous;
        public TdApi.PollType type;
        public boolean isClosed;
        public static final int CONSTRUCTOR = 743307780;

        public InputMessagePoll() {
        }

        public InputMessagePoll(String var1, String[] var2, boolean var3, TdApi.PollType var4, boolean var5) {
            this.question = var1;
            this.options = var2;
            this.isAnonymous = var3;
            this.type = var4;
            this.isClosed = var5;
        }

        public int getConstructor() {
            return 743307780;
        }
    }

    public static class InputMessageInvoice extends TdApi.InputMessageContent {
        public TdApi.Invoice invoice;
        public String title;
        public String description;
        public String photoUrl;
        public int photoSize;
        public int photoWidth;
        public int photoHeight;
        public byte[] payload;
        public String providerToken;
        public String providerData;
        public String startParameter;
        public static final int CONSTRUCTOR = 1038812175;

        public InputMessageInvoice() {
        }

        public InputMessageInvoice(TdApi.Invoice var1, String var2, String var3, String var4, int var5, int var6, int var7, byte[] var8, String var9, String var10, String var11) {
            this.invoice = var1;
            this.title = var2;
            this.description = var3;
            this.photoUrl = var4;
            this.photoSize = var5;
            this.photoWidth = var6;
            this.photoHeight = var7;
            this.payload = var8;
            this.providerToken = var9;
            this.providerData = var10;
            this.startParameter = var11;
        }

        public int getConstructor() {
            return 1038812175;
        }
    }

    public static class InputMessageGame extends TdApi.InputMessageContent {
        public int botUserId;
        public String gameShortName;
        public static final int CONSTRUCTOR = -1728000914;

        public InputMessageGame() {
        }

        public InputMessageGame(int var1, String var2) {
            this.botUserId = var1;
            this.gameShortName = var2;
        }

        public int getConstructor() {
            return -1728000914;
        }
    }

    public static class InputMessageContact extends TdApi.InputMessageContent {
        public TdApi.Contact contact;
        public static final int CONSTRUCTOR = -982446849;

        public InputMessageContact() {
        }

        public InputMessageContact(TdApi.Contact var1) {
            this.contact = var1;
        }

        public int getConstructor() {
            return -982446849;
        }
    }

    public static class InputMessageVenue extends TdApi.InputMessageContent {
        public TdApi.Venue venue;
        public static final int CONSTRUCTOR = 1447926269;

        public InputMessageVenue() {
        }

        public InputMessageVenue(TdApi.Venue var1) {
            this.venue = var1;
        }

        public int getConstructor() {
            return 1447926269;
        }
    }

    public static class InputMessageLocation extends TdApi.InputMessageContent {
        public TdApi.Location location;
        public int livePeriod;
        public static final int CONSTRUCTOR = -1624179655;

        public InputMessageLocation() {
        }

        public InputMessageLocation(TdApi.Location var1, int var2) {
            this.location = var1;
            this.livePeriod = var2;
        }

        public int getConstructor() {
            return -1624179655;
        }
    }

    public static class InputMessageVoiceNote extends TdApi.InputMessageContent {
        public TdApi.InputFile voiceNote;
        public int duration;
        public byte[] waveform;
        public TdApi.FormattedText caption;
        public static final int CONSTRUCTOR = 2136519657;

        public InputMessageVoiceNote() {
        }

        public InputMessageVoiceNote(TdApi.InputFile var1, int var2, byte[] var3, TdApi.FormattedText var4) {
            this.voiceNote = var1;
            this.duration = var2;
            this.waveform = var3;
            this.caption = var4;
        }

        public int getConstructor() {
            return 2136519657;
        }
    }

    public static class InputMessageVideoNote extends TdApi.InputMessageContent {
        public TdApi.InputFile videoNote;
        public TdApi.InputThumbnail thumbnail;
        public int duration;
        public int length;
        public static final int CONSTRUCTOR = 279108859;

        public InputMessageVideoNote() {
        }

        public InputMessageVideoNote(TdApi.InputFile var1, TdApi.InputThumbnail var2, int var3, int var4) {
            this.videoNote = var1;
            this.thumbnail = var2;
            this.duration = var3;
            this.length = var4;
        }

        public int getConstructor() {
            return 279108859;
        }
    }

    public static class InputMessageVideo extends TdApi.InputMessageContent {
        public TdApi.InputFile video;
        public TdApi.InputThumbnail thumbnail;
        public int[] addedStickerFileIds;
        public int duration;
        public int width;
        public int height;
        public boolean supportsStreaming;
        public TdApi.FormattedText caption;
        public int ttl;
        public static final int CONSTRUCTOR = -2108486755;

        public InputMessageVideo() {
        }

        public InputMessageVideo(TdApi.InputFile var1, TdApi.InputThumbnail var2, int[] var3, int var4, int var5, int var6, boolean var7, TdApi.FormattedText var8, int var9) {
            this.video = var1;
            this.thumbnail = var2;
            this.addedStickerFileIds = var3;
            this.duration = var4;
            this.width = var5;
            this.height = var6;
            this.supportsStreaming = var7;
            this.caption = var8;
            this.ttl = var9;
        }

        public int getConstructor() {
            return -2108486755;
        }
    }

    public static class InputMessageSticker extends TdApi.InputMessageContent {
        public TdApi.InputFile sticker;
        public TdApi.InputThumbnail thumbnail;
        public int width;
        public int height;
        public static final int CONSTRUCTOR = 740776325;

        public InputMessageSticker() {
        }

        public InputMessageSticker(TdApi.InputFile var1, TdApi.InputThumbnail var2, int var3, int var4) {
            this.sticker = var1;
            this.thumbnail = var2;
            this.width = var3;
            this.height = var4;
        }

        public int getConstructor() {
            return 740776325;
        }
    }

    public static class InputMessagePhoto extends TdApi.InputMessageContent {
        public TdApi.InputFile photo;
        public TdApi.InputThumbnail thumbnail;
        public int[] addedStickerFileIds;
        public int width;
        public int height;
        public TdApi.FormattedText caption;
        public int ttl;
        public static final int CONSTRUCTOR = 1648801584;

        public InputMessagePhoto() {
        }

        public InputMessagePhoto(TdApi.InputFile var1, TdApi.InputThumbnail var2, int[] var3, int var4, int var5, TdApi.FormattedText var6, int var7) {
            this.photo = var1;
            this.thumbnail = var2;
            this.addedStickerFileIds = var3;
            this.width = var4;
            this.height = var5;
            this.caption = var6;
            this.ttl = var7;
        }

        public int getConstructor() {
            return 1648801584;
        }
    }

    public static class InputMessageDocument extends TdApi.InputMessageContent {
        public TdApi.InputFile document;
        public TdApi.InputThumbnail thumbnail;
        public TdApi.FormattedText caption;
        public static final int CONSTRUCTOR = 937970604;

        public InputMessageDocument() {
        }

        public InputMessageDocument(TdApi.InputFile var1, TdApi.InputThumbnail var2, TdApi.FormattedText var3) {
            this.document = var1;
            this.thumbnail = var2;
            this.caption = var3;
        }

        public int getConstructor() {
            return 937970604;
        }
    }

    public static class InputMessageAudio extends TdApi.InputMessageContent {
        public TdApi.InputFile audio;
        public TdApi.InputThumbnail albumCoverThumbnail;
        public int duration;
        public String title;
        public String performer;
        public TdApi.FormattedText caption;
        public static final int CONSTRUCTOR = -626786126;

        public InputMessageAudio() {
        }

        public InputMessageAudio(TdApi.InputFile var1, TdApi.InputThumbnail var2, int var3, String var4, String var5, TdApi.FormattedText var6) {
            this.audio = var1;
            this.albumCoverThumbnail = var2;
            this.duration = var3;
            this.title = var4;
            this.performer = var5;
            this.caption = var6;
        }

        public int getConstructor() {
            return -626786126;
        }
    }

    public static class InputMessageAnimation extends TdApi.InputMessageContent {
        public TdApi.InputFile animation;
        public TdApi.InputThumbnail thumbnail;
        public int duration;
        public int width;
        public int height;
        public TdApi.FormattedText caption;
        public static final int CONSTRUCTOR = 926542724;

        public InputMessageAnimation() {
        }

        public InputMessageAnimation(TdApi.InputFile var1, TdApi.InputThumbnail var2, int var3, int var4, int var5, TdApi.FormattedText var6) {
            this.animation = var1;
            this.thumbnail = var2;
            this.duration = var3;
            this.width = var4;
            this.height = var5;
            this.caption = var6;
        }

        public int getConstructor() {
            return 926542724;
        }
    }

    public static class InputMessageText extends TdApi.InputMessageContent {
        public TdApi.FormattedText text;
        public boolean disableWebPagePreview;
        public boolean clearDraft;
        public static final int CONSTRUCTOR = 247050392;

        public InputMessageText() {
        }

        public InputMessageText(TdApi.FormattedText var1, boolean var2, boolean var3) {
            this.text = var1;
            this.disableWebPagePreview = var2;
            this.clearDraft = var3;
        }

        public int getConstructor() {
            return 247050392;
        }
    }

    public abstract static class InputMessageContent extends TdApi.Object {
        public InputMessageContent() {
        }
    }

    public static class InputInlineQueryResultVoiceNote extends TdApi.InputInlineQueryResult {
        public String id;
        public String title;
        public String voiceNoteUrl;
        public int voiceNoteDuration;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = -1790072503;

        public InputInlineQueryResultVoiceNote() {
        }

        public InputInlineQueryResultVoiceNote(String var1, String var2, String var3, int var4, TdApi.ReplyMarkup var5, TdApi.InputMessageContent var6) {
            this.id = var1;
            this.title = var2;
            this.voiceNoteUrl = var3;
            this.voiceNoteDuration = var4;
            this.replyMarkup = var5;
            this.inputMessageContent = var6;
        }

        public int getConstructor() {
            return -1790072503;
        }
    }

    public static class InputInlineQueryResultVideo extends TdApi.InputInlineQueryResult {
        public String id;
        public String title;
        public String description;
        public String thumbnailUrl;
        public String videoUrl;
        public String mimeType;
        public int videoWidth;
        public int videoHeight;
        public int videoDuration;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 1724073191;

        public InputInlineQueryResultVideo() {
        }

        public InputInlineQueryResultVideo(String var1, String var2, String var3, String var4, String var5, String var6, int var7, int var8, int var9, TdApi.ReplyMarkup var10, TdApi.InputMessageContent var11) {
            this.id = var1;
            this.title = var2;
            this.description = var3;
            this.thumbnailUrl = var4;
            this.videoUrl = var5;
            this.mimeType = var6;
            this.videoWidth = var7;
            this.videoHeight = var8;
            this.videoDuration = var9;
            this.replyMarkup = var10;
            this.inputMessageContent = var11;
        }

        public int getConstructor() {
            return 1724073191;
        }
    }

    public static class InputInlineQueryResultVenue extends TdApi.InputInlineQueryResult {
        public String id;
        public TdApi.Venue venue;
        public String thumbnailUrl;
        public int thumbnailWidth;
        public int thumbnailHeight;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 541704509;

        public InputInlineQueryResultVenue() {
        }

        public InputInlineQueryResultVenue(String var1, TdApi.Venue var2, String var3, int var4, int var5, TdApi.ReplyMarkup var6, TdApi.InputMessageContent var7) {
            this.id = var1;
            this.venue = var2;
            this.thumbnailUrl = var3;
            this.thumbnailWidth = var4;
            this.thumbnailHeight = var5;
            this.replyMarkup = var6;
            this.inputMessageContent = var7;
        }

        public int getConstructor() {
            return 541704509;
        }
    }

    public static class InputInlineQueryResultSticker extends TdApi.InputInlineQueryResult {
        public String id;
        public String thumbnailUrl;
        public String stickerUrl;
        public int stickerWidth;
        public int stickerHeight;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 274007129;

        public InputInlineQueryResultSticker() {
        }

        public InputInlineQueryResultSticker(String var1, String var2, String var3, int var4, int var5, TdApi.ReplyMarkup var6, TdApi.InputMessageContent var7) {
            this.id = var1;
            this.thumbnailUrl = var2;
            this.stickerUrl = var3;
            this.stickerWidth = var4;
            this.stickerHeight = var5;
            this.replyMarkup = var6;
            this.inputMessageContent = var7;
        }

        public int getConstructor() {
            return 274007129;
        }
    }

    public static class InputInlineQueryResultPhoto extends TdApi.InputInlineQueryResult {
        public String id;
        public String title;
        public String description;
        public String thumbnailUrl;
        public String photoUrl;
        public int photoWidth;
        public int photoHeight;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = -1123338721;

        public InputInlineQueryResultPhoto() {
        }

        public InputInlineQueryResultPhoto(String var1, String var2, String var3, String var4, String var5, int var6, int var7, TdApi.ReplyMarkup var8, TdApi.InputMessageContent var9) {
            this.id = var1;
            this.title = var2;
            this.description = var3;
            this.thumbnailUrl = var4;
            this.photoUrl = var5;
            this.photoWidth = var6;
            this.photoHeight = var7;
            this.replyMarkup = var8;
            this.inputMessageContent = var9;
        }

        public int getConstructor() {
            return -1123338721;
        }
    }

    public static class InputInlineQueryResultLocation extends TdApi.InputInlineQueryResult {
        public String id;
        public TdApi.Location location;
        public int livePeriod;
        public String title;
        public String thumbnailUrl;
        public int thumbnailWidth;
        public int thumbnailHeight;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = -1887650218;

        public InputInlineQueryResultLocation() {
        }

        public InputInlineQueryResultLocation(String var1, TdApi.Location var2, int var3, String var4, String var5, int var6, int var7, TdApi.ReplyMarkup var8, TdApi.InputMessageContent var9) {
            this.id = var1;
            this.location = var2;
            this.livePeriod = var3;
            this.title = var4;
            this.thumbnailUrl = var5;
            this.thumbnailWidth = var6;
            this.thumbnailHeight = var7;
            this.replyMarkup = var8;
            this.inputMessageContent = var9;
        }

        public int getConstructor() {
            return -1887650218;
        }
    }

    public static class InputInlineQueryResultGame extends TdApi.InputInlineQueryResult {
        public String id;
        public String gameShortName;
        public TdApi.ReplyMarkup replyMarkup;
        public static final int CONSTRUCTOR = 966074327;

        public InputInlineQueryResultGame() {
        }

        public InputInlineQueryResultGame(String var1, String var2, TdApi.ReplyMarkup var3) {
            this.id = var1;
            this.gameShortName = var2;
            this.replyMarkup = var3;
        }

        public int getConstructor() {
            return 966074327;
        }
    }

    public static class InputInlineQueryResultDocument extends TdApi.InputInlineQueryResult {
        public String id;
        public String title;
        public String description;
        public String documentUrl;
        public String mimeType;
        public String thumbnailUrl;
        public int thumbnailWidth;
        public int thumbnailHeight;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 578801869;

        public InputInlineQueryResultDocument() {
        }

        public InputInlineQueryResultDocument(String var1, String var2, String var3, String var4, String var5, String var6, int var7, int var8, TdApi.ReplyMarkup var9, TdApi.InputMessageContent var10) {
            this.id = var1;
            this.title = var2;
            this.description = var3;
            this.documentUrl = var4;
            this.mimeType = var5;
            this.thumbnailUrl = var6;
            this.thumbnailWidth = var7;
            this.thumbnailHeight = var8;
            this.replyMarkup = var9;
            this.inputMessageContent = var10;
        }

        public int getConstructor() {
            return 578801869;
        }
    }

    public static class InputInlineQueryResultContact extends TdApi.InputInlineQueryResult {
        public String id;
        public TdApi.Contact contact;
        public String thumbnailUrl;
        public int thumbnailWidth;
        public int thumbnailHeight;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 1846064594;

        public InputInlineQueryResultContact() {
        }

        public InputInlineQueryResultContact(String var1, TdApi.Contact var2, String var3, int var4, int var5, TdApi.ReplyMarkup var6, TdApi.InputMessageContent var7) {
            this.id = var1;
            this.contact = var2;
            this.thumbnailUrl = var3;
            this.thumbnailWidth = var4;
            this.thumbnailHeight = var5;
            this.replyMarkup = var6;
            this.inputMessageContent = var7;
        }

        public int getConstructor() {
            return 1846064594;
        }
    }

    public static class InputInlineQueryResultAudio extends TdApi.InputInlineQueryResult {
        public String id;
        public String title;
        public String performer;
        public String audioUrl;
        public int audioDuration;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 1260139988;

        public InputInlineQueryResultAudio() {
        }

        public InputInlineQueryResultAudio(String var1, String var2, String var3, String var4, int var5, TdApi.ReplyMarkup var6, TdApi.InputMessageContent var7) {
            this.id = var1;
            this.title = var2;
            this.performer = var3;
            this.audioUrl = var4;
            this.audioDuration = var5;
            this.replyMarkup = var6;
            this.inputMessageContent = var7;
        }

        public int getConstructor() {
            return 1260139988;
        }
    }

    public static class InputInlineQueryResultArticle extends TdApi.InputInlineQueryResult {
        public String id;
        public String url;
        public boolean hideUrl;
        public String title;
        public String description;
        public String thumbnailUrl;
        public int thumbnailWidth;
        public int thumbnailHeight;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = 1973670156;

        public InputInlineQueryResultArticle() {
        }

        public InputInlineQueryResultArticle(String var1, String var2, boolean var3, String var4, String var5, String var6, int var7, int var8, TdApi.ReplyMarkup var9, TdApi.InputMessageContent var10) {
            this.id = var1;
            this.url = var2;
            this.hideUrl = var3;
            this.title = var4;
            this.description = var5;
            this.thumbnailUrl = var6;
            this.thumbnailWidth = var7;
            this.thumbnailHeight = var8;
            this.replyMarkup = var9;
            this.inputMessageContent = var10;
        }

        public int getConstructor() {
            return 1973670156;
        }
    }

    public static class InputInlineQueryResultAnimatedMpeg4 extends TdApi.InputInlineQueryResult {
        public String id;
        public String title;
        public String thumbnailUrl;
        public String mpeg4Url;
        public int mpeg4Duration;
        public int mpeg4Width;
        public int mpeg4Height;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = -1629529888;

        public InputInlineQueryResultAnimatedMpeg4() {
        }

        public InputInlineQueryResultAnimatedMpeg4(String var1, String var2, String var3, String var4, int var5, int var6, int var7, TdApi.ReplyMarkup var8, TdApi.InputMessageContent var9) {
            this.id = var1;
            this.title = var2;
            this.thumbnailUrl = var3;
            this.mpeg4Url = var4;
            this.mpeg4Duration = var5;
            this.mpeg4Width = var6;
            this.mpeg4Height = var7;
            this.replyMarkup = var8;
            this.inputMessageContent = var9;
        }

        public int getConstructor() {
            return -1629529888;
        }
    }

    public static class InputInlineQueryResultAnimatedGif extends TdApi.InputInlineQueryResult {
        public String id;
        public String title;
        public String thumbnailUrl;
        public String gifUrl;
        public int gifDuration;
        public int gifWidth;
        public int gifHeight;
        public TdApi.ReplyMarkup replyMarkup;
        public TdApi.InputMessageContent inputMessageContent;
        public static final int CONSTRUCTOR = -891474894;

        public InputInlineQueryResultAnimatedGif() {
        }

        public InputInlineQueryResultAnimatedGif(String var1, String var2, String var3, String var4, int var5, int var6, int var7, TdApi.ReplyMarkup var8, TdApi.InputMessageContent var9) {
            this.id = var1;
            this.title = var2;
            this.thumbnailUrl = var3;
            this.gifUrl = var4;
            this.gifDuration = var5;
            this.gifWidth = var6;
            this.gifHeight = var7;
            this.replyMarkup = var8;
            this.inputMessageContent = var9;
        }

        public int getConstructor() {
            return -891474894;
        }
    }

    public abstract static class InputInlineQueryResult extends TdApi.Object {
        public InputInlineQueryResult() {
        }
    }

    public static class InputIdentityDocument extends TdApi.Object {
        public String number;
        public TdApi.Date expiryDate;
        public TdApi.InputFile frontSide;
        public TdApi.InputFile reverseSide;
        public TdApi.InputFile selfie;
        public TdApi.InputFile[] translation;
        public static final int CONSTRUCTOR = -381776063;

        public InputIdentityDocument() {
        }

        public InputIdentityDocument(String var1, TdApi.Date var2, TdApi.InputFile var3, TdApi.InputFile var4, TdApi.InputFile var5, TdApi.InputFile[] var6) {
            this.number = var1;
            this.expiryDate = var2;
            this.frontSide = var3;
            this.reverseSide = var4;
            this.selfie = var5;
            this.translation = var6;
        }

        public int getConstructor() {
            return -381776063;
        }
    }

    public static class InputFileGenerated extends TdApi.InputFile {
        public String originalPath;
        public String conversion;
        public int expectedSize;
        public static final int CONSTRUCTOR = -1781351885;

        public InputFileGenerated() {
        }

        public InputFileGenerated(String var1, String var2, int var3) {
            this.originalPath = var1;
            this.conversion = var2;
            this.expectedSize = var3;
        }

        public int getConstructor() {
            return -1781351885;
        }
    }

    public static class InputFileLocal extends TdApi.InputFile {
        public String path;
        public static final int CONSTRUCTOR = 2056030919;

        public InputFileLocal() {
        }

        public InputFileLocal(String var1) {
            this.path = var1;
        }

        public int getConstructor() {
            return 2056030919;
        }
    }

    public static class InputFileRemote extends TdApi.InputFile {
        public String id;
        public static final int CONSTRUCTOR = -107574466;

        public InputFileRemote() {
        }

        public InputFileRemote(String var1) {
            this.id = var1;
        }

        public int getConstructor() {
            return -107574466;
        }
    }

    public static class InputFileId extends TdApi.InputFile {
        public int id;
        public static final int CONSTRUCTOR = 1788906253;

        public InputFileId() {
        }

        public InputFileId(int var1) {
            this.id = var1;
        }

        public int getConstructor() {
            return 1788906253;
        }
    }

    public abstract static class InputFile extends TdApi.Object {
        public InputFile() {
        }
    }

    public static class InputCredentialsApplePay extends TdApi.InputCredentials {
        public String data;
        public static final int CONSTRUCTOR = -1246570799;

        public InputCredentialsApplePay() {
        }

        public InputCredentialsApplePay(String var1) {
            this.data = var1;
        }

        public int getConstructor() {
            return -1246570799;
        }
    }

    public static class InputCredentialsAndroidPay extends TdApi.InputCredentials {
        public String data;
        public static final int CONSTRUCTOR = 1979566832;

        public InputCredentialsAndroidPay() {
        }

        public InputCredentialsAndroidPay(String var1) {
            this.data = var1;
        }

        public int getConstructor() {
            return 1979566832;
        }
    }

    public static class InputCredentialsNew extends TdApi.InputCredentials {
        public String data;
        public boolean allowSave;
        public static final int CONSTRUCTOR = -829689558;

        public InputCredentialsNew() {
        }

        public InputCredentialsNew(String var1, boolean var2) {
            this.data = var1;
            this.allowSave = var2;
        }

        public int getConstructor() {
            return -829689558;
        }
    }

    public static class InputCredentialsSaved extends TdApi.InputCredentials {
        public String savedCredentialsId;
        public static final int CONSTRUCTOR = -2034385364;

        public InputCredentialsSaved() {
        }

        public InputCredentialsSaved(String var1) {
            this.savedCredentialsId = var1;
        }

        public int getConstructor() {
            return -2034385364;
        }
    }

    public abstract static class InputCredentials extends TdApi.Object {
        public InputCredentials() {
        }
    }

    public static class InputBackgroundRemote extends TdApi.InputBackground {
        public long backgroundId;
        public static final int CONSTRUCTOR = -274976231;

        public InputBackgroundRemote() {
        }

        public InputBackgroundRemote(long var1) {
            this.backgroundId = var1;
        }

        public int getConstructor() {
            return -274976231;
        }
    }

    public static class InputBackgroundLocal extends TdApi.InputBackground {
        public TdApi.InputFile background;
        public static final int CONSTRUCTOR = -1747094364;

        public InputBackgroundLocal() {
        }

        public InputBackgroundLocal(TdApi.InputFile var1) {
            this.background = var1;
        }

        public int getConstructor() {
            return -1747094364;
        }
    }

    public abstract static class InputBackground extends TdApi.Object {
        public InputBackground() {
        }
    }

    public static class InlineQueryResults extends TdApi.Object {
        public long inlineQueryId;
        public String nextOffset;
        public TdApi.InlineQueryResult[] results;
        public String switchPmText;
        public String switchPmParameter;
        public static final int CONSTRUCTOR = 1000709656;

        public InlineQueryResults() {
        }

        public InlineQueryResults(long var1, String var3, TdApi.InlineQueryResult[] var4, String var5, String var6) {
            this.inlineQueryId = var1;
            this.nextOffset = var3;
            this.results = var4;
            this.switchPmText = var5;
            this.switchPmParameter = var6;
        }

        public int getConstructor() {
            return 1000709656;
        }
    }

    public static class InlineQueryResultVoiceNote extends TdApi.InlineQueryResult {
        public String id;
        public TdApi.VoiceNote voiceNote;
        public String title;
        public static final int CONSTRUCTOR = -1897393105;

        public InlineQueryResultVoiceNote() {
        }

        public InlineQueryResultVoiceNote(String var1, TdApi.VoiceNote var2, String var3) {
            this.id = var1;
            this.voiceNote = var2;
            this.title = var3;
        }

        public int getConstructor() {
            return -1897393105;
        }
    }

    public static class InlineQueryResultVideo extends TdApi.InlineQueryResult {
        public String id;
        public TdApi.Video video;
        public String title;
        public String description;
        public static final int CONSTRUCTOR = -1373158683;

        public InlineQueryResultVideo() {
        }

        public InlineQueryResultVideo(String var1, TdApi.Video var2, String var3, String var4) {
            this.id = var1;
            this.video = var2;
            this.title = var3;
            this.description = var4;
        }

        public int getConstructor() {
            return -1373158683;
        }
    }

    public static class InlineQueryResultSticker extends TdApi.InlineQueryResult {
        public String id;
        public TdApi.Sticker sticker;
        public static final int CONSTRUCTOR = -1848224245;

        public InlineQueryResultSticker() {
        }

        public InlineQueryResultSticker(String var1, TdApi.Sticker var2) {
            this.id = var1;
            this.sticker = var2;
        }

        public int getConstructor() {
            return -1848224245;
        }
    }

    public static class InlineQueryResultPhoto extends TdApi.InlineQueryResult {
        public String id;
        public TdApi.Photo photo;
        public String title;
        public String description;
        public static final int CONSTRUCTOR = 1848319440;

        public InlineQueryResultPhoto() {
        }

        public InlineQueryResultPhoto(String var1, TdApi.Photo var2, String var3, String var4) {
            this.id = var1;
            this.photo = var2;
            this.title = var3;
            this.description = var4;
        }

        public int getConstructor() {
            return 1848319440;
        }
    }

    public static class InlineQueryResultDocument extends TdApi.InlineQueryResult {
        public String id;
        public TdApi.Document document;
        public String title;
        public String description;
        public static final int CONSTRUCTOR = -1491268539;

        public InlineQueryResultDocument() {
        }

        public InlineQueryResultDocument(String var1, TdApi.Document var2, String var3, String var4) {
            this.id = var1;
            this.document = var2;
            this.title = var3;
            this.description = var4;
        }

        public int getConstructor() {
            return -1491268539;
        }
    }

    public static class InlineQueryResultAudio extends TdApi.InlineQueryResult {
        public String id;
        public TdApi.Audio audio;
        public static final int CONSTRUCTOR = 842650360;

        public InlineQueryResultAudio() {
        }

        public InlineQueryResultAudio(String var1, TdApi.Audio var2) {
            this.id = var1;
            this.audio = var2;
        }

        public int getConstructor() {
            return 842650360;
        }
    }

    public static class InlineQueryResultAnimation extends TdApi.InlineQueryResult {
        public String id;
        public TdApi.Animation animation;
        public String title;
        public static final int CONSTRUCTOR = 2009984267;

        public InlineQueryResultAnimation() {
        }

        public InlineQueryResultAnimation(String var1, TdApi.Animation var2, String var3) {
            this.id = var1;
            this.animation = var2;
            this.title = var3;
        }

        public int getConstructor() {
            return 2009984267;
        }
    }

    public static class InlineQueryResultGame extends TdApi.InlineQueryResult {
        public String id;
        public TdApi.Game game;
        public static final int CONSTRUCTOR = 1706916987;

        public InlineQueryResultGame() {
        }

        public InlineQueryResultGame(String var1, TdApi.Game var2) {
            this.id = var1;
            this.game = var2;
        }

        public int getConstructor() {
            return 1706916987;
        }
    }

    public static class InlineQueryResultVenue extends TdApi.InlineQueryResult {
        public String id;
        public TdApi.Venue venue;
        public TdApi.PhotoSize thumbnail;
        public static final int CONSTRUCTOR = -1592932211;

        public InlineQueryResultVenue() {
        }

        public InlineQueryResultVenue(String var1, TdApi.Venue var2, TdApi.PhotoSize var3) {
            this.id = var1;
            this.venue = var2;
            this.thumbnail = var3;
        }

        public int getConstructor() {
            return -1592932211;
        }
    }

    public static class InlineQueryResultLocation extends TdApi.InlineQueryResult {
        public String id;
        public TdApi.Location location;
        public String title;
        public TdApi.PhotoSize thumbnail;
        public static final int CONSTRUCTOR = -158305341;

        public InlineQueryResultLocation() {
        }

        public InlineQueryResultLocation(String var1, TdApi.Location var2, String var3, TdApi.PhotoSize var4) {
            this.id = var1;
            this.location = var2;
            this.title = var3;
            this.thumbnail = var4;
        }

        public int getConstructor() {
            return -158305341;
        }
    }

    public static class InlineQueryResultContact extends TdApi.InlineQueryResult {
        public String id;
        public TdApi.Contact contact;
        public TdApi.PhotoSize thumbnail;
        public static final int CONSTRUCTOR = 410081985;

        public InlineQueryResultContact() {
        }

        public InlineQueryResultContact(String var1, TdApi.Contact var2, TdApi.PhotoSize var3) {
            this.id = var1;
            this.contact = var2;
            this.thumbnail = var3;
        }

        public int getConstructor() {
            return 410081985;
        }
    }

    public static class InlineQueryResultArticle extends TdApi.InlineQueryResult {
        public String id;
        public String url;
        public boolean hideUrl;
        public String title;
        public String description;
        public TdApi.PhotoSize thumbnail;
        public static final int CONSTRUCTOR = -518366710;

        public InlineQueryResultArticle() {
        }

        public InlineQueryResultArticle(String var1, String var2, boolean var3, String var4, String var5, TdApi.PhotoSize var6) {
            this.id = var1;
            this.url = var2;
            this.hideUrl = var3;
            this.title = var4;
            this.description = var5;
            this.thumbnail = var6;
        }

        public int getConstructor() {
            return -518366710;
        }
    }

    public abstract static class InlineQueryResult extends TdApi.Object {
        public InlineQueryResult() {
        }
    }

    public static class InlineKeyboardButtonTypeBuy extends TdApi.InlineKeyboardButtonType {
        public static final int CONSTRUCTOR = 1360739440;

        public InlineKeyboardButtonTypeBuy() {
        }

        public int getConstructor() {
            return 1360739440;
        }
    }

    public static class InlineKeyboardButtonTypeSwitchInline extends TdApi.InlineKeyboardButtonType {
        public String query;
        public boolean inCurrentChat;
        public static final int CONSTRUCTOR = -2035563307;

        public InlineKeyboardButtonTypeSwitchInline() {
        }

        public InlineKeyboardButtonTypeSwitchInline(String var1, boolean var2) {
            this.query = var1;
            this.inCurrentChat = var2;
        }

        public int getConstructor() {
            return -2035563307;
        }
    }

    public static class InlineKeyboardButtonTypeCallbackGame extends TdApi.InlineKeyboardButtonType {
        public static final int CONSTRUCTOR = -383429528;

        public InlineKeyboardButtonTypeCallbackGame() {
        }

        public int getConstructor() {
            return -383429528;
        }
    }

    public static class InlineKeyboardButtonTypeCallback extends TdApi.InlineKeyboardButtonType {
        public byte[] data;
        public static final int CONSTRUCTOR = -1127515139;

        public InlineKeyboardButtonTypeCallback() {
        }

        public InlineKeyboardButtonTypeCallback(byte[] var1) {
            this.data = var1;
        }

        public int getConstructor() {
            return -1127515139;
        }
    }

    public static class InlineKeyboardButtonTypeLoginUrl extends TdApi.InlineKeyboardButtonType {
        public String url;
        public int id;
        public String forwardText;
        public static final int CONSTRUCTOR = 281435539;

        public InlineKeyboardButtonTypeLoginUrl() {
        }

        public InlineKeyboardButtonTypeLoginUrl(String var1, int var2, String var3) {
            this.url = var1;
            this.id = var2;
            this.forwardText = var3;
        }

        public int getConstructor() {
            return 281435539;
        }
    }

    public static class InlineKeyboardButtonTypeUrl extends TdApi.InlineKeyboardButtonType {
        public String url;
        public static final int CONSTRUCTOR = 1130741420;

        public InlineKeyboardButtonTypeUrl() {
        }

        public InlineKeyboardButtonTypeUrl(String var1) {
            this.url = var1;
        }

        public int getConstructor() {
            return 1130741420;
        }
    }

    public abstract static class InlineKeyboardButtonType extends TdApi.Object {
        public InlineKeyboardButtonType() {
        }
    }

    public static class InlineKeyboardButton extends TdApi.Object {
        public String text;
        public TdApi.InlineKeyboardButtonType type;
        public static final int CONSTRUCTOR = -372105704;

        public InlineKeyboardButton() {
        }

        public InlineKeyboardButton(String var1, TdApi.InlineKeyboardButtonType var2) {
            this.text = var1;
            this.type = var2;
        }

        public int getConstructor() {
            return -372105704;
        }
    }

    public static class ImportedContacts extends TdApi.Object {
        public int[] userIds;
        public int[] importerCount;
        public static final int CONSTRUCTOR = -741685354;

        public ImportedContacts() {
        }

        public ImportedContacts(int[] var1, int[] var2) {
            this.userIds = var1;
            this.importerCount = var2;
        }

        public int getConstructor() {
            return -741685354;
        }
    }

    public static class IdentityDocument extends TdApi.Object {
        public String number;
        public TdApi.Date expiryDate;
        public TdApi.DatedFile frontSide;
        public TdApi.DatedFile reverseSide;
        public TdApi.DatedFile selfie;
        public TdApi.DatedFile[] translation;
        public static final int CONSTRUCTOR = 445952972;

        public IdentityDocument() {
        }

        public IdentityDocument(String var1, TdApi.Date var2, TdApi.DatedFile var3, TdApi.DatedFile var4, TdApi.DatedFile var5, TdApi.DatedFile[] var6) {
            this.number = var1;
            this.expiryDate = var2;
            this.frontSide = var3;
            this.reverseSide = var4;
            this.selfie = var5;
            this.translation = var6;
        }

        public int getConstructor() {
            return 445952972;
        }
    }

    public static class HttpUrl extends TdApi.Object {
        public String url;
        public static final int CONSTRUCTOR = -2018019930;

        public HttpUrl() {
        }

        public HttpUrl(String var1) {
            this.url = var1;
        }

        public int getConstructor() {
            return -2018019930;
        }
    }

    public static class Hashtags extends TdApi.Object {
        public String[] hashtags;
        public static final int CONSTRUCTOR = 676798885;

        public Hashtags() {
        }

        public Hashtags(String[] var1) {
            this.hashtags = var1;
        }

        public int getConstructor() {
            return 676798885;
        }
    }

    public static class GameHighScores extends TdApi.Object {
        public TdApi.GameHighScore[] scores;
        public static final int CONSTRUCTOR = -725770727;

        public GameHighScores() {
        }

        public GameHighScores(TdApi.GameHighScore[] var1) {
            this.scores = var1;
        }

        public int getConstructor() {
            return -725770727;
        }
    }

    public static class GameHighScore extends TdApi.Object {
        public int position;
        public int userId;
        public int score;
        public static final int CONSTRUCTOR = -30778358;

        public GameHighScore() {
        }

        public GameHighScore(int var1, int var2, int var3) {
            this.position = var1;
            this.userId = var2;
            this.score = var3;
        }

        public int getConstructor() {
            return -30778358;
        }
    }

    public static class Game extends TdApi.Object {
        public long id;
        public String shortName;
        public String title;
        public TdApi.FormattedText text;
        public String description;
        public TdApi.Photo photo;
        public TdApi.Animation animation;
        public static final int CONSTRUCTOR = -1565597752;

        public Game() {
        }

        public Game(long var1, String var3, String var4, TdApi.FormattedText var5, String var6, TdApi.Photo var7, TdApi.Animation var8) {
            this.id = var1;
            this.shortName = var3;
            this.title = var4;
            this.text = var5;
            this.description = var6;
            this.photo = var7;
            this.animation = var8;
        }

        public int getConstructor() {
            return -1565597752;
        }
    }

    public static class FoundMessages extends TdApi.Object {
        public TdApi.Message[] messages;
        public long nextFromSearchId;
        public static final int CONSTRUCTOR = 2135623881;

        public FoundMessages() {
        }

        public FoundMessages(TdApi.Message[] var1, long var2) {
            this.messages = var1;
            this.nextFromSearchId = var2;
        }

        public int getConstructor() {
            return 2135623881;
        }
    }

    public static class FormattedText extends TdApi.Object {
        public String text;
        public TdApi.TextEntity[] entities;
        public static final int CONSTRUCTOR = -252624564;

        public FormattedText() {
        }

        public FormattedText(String var1, TdApi.TextEntity[] var2) {
            this.text = var1;
            this.entities = var2;
        }

        public int getConstructor() {
            return -252624564;
        }
    }

    public static class FileTypeWallpaper extends TdApi.FileType {
        public static final int CONSTRUCTOR = 1854930076;

        public FileTypeWallpaper() {
        }

        public int getConstructor() {
            return 1854930076;
        }
    }

    public static class FileTypeVoiceNote extends TdApi.FileType {
        public static final int CONSTRUCTOR = -588681661;

        public FileTypeVoiceNote() {
        }

        public int getConstructor() {
            return -588681661;
        }
    }

    public static class FileTypeVideoNote extends TdApi.FileType {
        public static final int CONSTRUCTOR = -518412385;

        public FileTypeVideoNote() {
        }

        public int getConstructor() {
            return -518412385;
        }
    }

    public static class FileTypeVideo extends TdApi.FileType {
        public static final int CONSTRUCTOR = 1430816539;

        public FileTypeVideo() {
        }

        public int getConstructor() {
            return 1430816539;
        }
    }

    public static class FileTypeUnknown extends TdApi.FileType {
        public static final int CONSTRUCTOR = -2011566768;

        public FileTypeUnknown() {
        }

        public int getConstructor() {
            return -2011566768;
        }
    }

    public static class FileTypeThumbnail extends TdApi.FileType {
        public static final int CONSTRUCTOR = -12443298;

        public FileTypeThumbnail() {
        }

        public int getConstructor() {
            return -12443298;
        }
    }

    public static class FileTypeSticker extends TdApi.FileType {
        public static final int CONSTRUCTOR = 475233385;

        public FileTypeSticker() {
        }

        public int getConstructor() {
            return 475233385;
        }
    }

    public static class FileTypeSecure extends TdApi.FileType {
        public static final int CONSTRUCTOR = -1419133146;

        public FileTypeSecure() {
        }

        public int getConstructor() {
            return -1419133146;
        }
    }

    public static class FileTypeSecretThumbnail extends TdApi.FileType {
        public static final int CONSTRUCTOR = -1401326026;

        public FileTypeSecretThumbnail() {
        }

        public int getConstructor() {
            return -1401326026;
        }
    }

    public static class FileTypeSecret extends TdApi.FileType {
        public static final int CONSTRUCTOR = -1871899401;

        public FileTypeSecret() {
        }

        public int getConstructor() {
            return -1871899401;
        }
    }

    public static class FileTypeProfilePhoto extends TdApi.FileType {
        public static final int CONSTRUCTOR = 1795089315;

        public FileTypeProfilePhoto() {
        }

        public int getConstructor() {
            return 1795089315;
        }
    }

    public static class FileTypePhoto extends TdApi.FileType {
        public static final int CONSTRUCTOR = -1718914651;

        public FileTypePhoto() {
        }

        public int getConstructor() {
            return -1718914651;
        }
    }

    public static class FileTypeDocument extends TdApi.FileType {
        public static final int CONSTRUCTOR = -564722929;

        public FileTypeDocument() {
        }

        public int getConstructor() {
            return -564722929;
        }
    }

    public static class FileTypeAudio extends TdApi.FileType {
        public static final int CONSTRUCTOR = -709112160;

        public FileTypeAudio() {
        }

        public int getConstructor() {
            return -709112160;
        }
    }

    public static class FileTypeAnimation extends TdApi.FileType {
        public static final int CONSTRUCTOR = -290816582;

        public FileTypeAnimation() {
        }

        public int getConstructor() {
            return -290816582;
        }
    }

    public static class FileTypeNone extends TdApi.FileType {
        public static final int CONSTRUCTOR = 2003009189;

        public FileTypeNone() {
        }

        public int getConstructor() {
            return 2003009189;
        }
    }

    public abstract static class FileType extends TdApi.Object {
        public FileType() {
        }
    }

    public static class FilePart extends TdApi.Object {
        public byte[] data;
        public static final int CONSTRUCTOR = 911821878;

        public FilePart() {
        }

        public FilePart(byte[] var1) {
            this.data = var1;
        }

        public int getConstructor() {
            return 911821878;
        }
    }

    public static class File extends TdApi.Object {
        public int id;
        public int size;
        public int expectedSize;
        public TdApi.LocalFile local;
        public TdApi.RemoteFile remote;
        public static final int CONSTRUCTOR = 766337656;

        public File() {
        }

        public File(int var1, int var2, int var3, TdApi.LocalFile var4, TdApi.RemoteFile var5) {
            this.id = var1;
            this.size = var2;
            this.expectedSize = var3;
            this.local = var4;
            this.remote = var5;
        }

        public int getConstructor() {
            return 766337656;
        }
    }

    public static class Error extends TdApi.Object {
        public int code;
        public String message;
        public static final int CONSTRUCTOR = -1679978726;

        public Error() {
        }

        public Error(int var1, String var2) {
            this.code = var1;
            this.message = var2;
        }

        public int getConstructor() {
            return -1679978726;
        }
    }

    public static class EncryptedPassportElement extends TdApi.Object {
        public TdApi.PassportElementType type;
        public byte[] data;
        public TdApi.DatedFile frontSide;
        public TdApi.DatedFile reverseSide;
        public TdApi.DatedFile selfie;
        public TdApi.DatedFile[] translation;
        public TdApi.DatedFile[] files;
        public String value;
        public String hash;
        public static final int CONSTRUCTOR = 2002386193;

        public EncryptedPassportElement() {
        }

        public EncryptedPassportElement(TdApi.PassportElementType var1, byte[] var2, TdApi.DatedFile var3, TdApi.DatedFile var4, TdApi.DatedFile var5, TdApi.DatedFile[] var6, TdApi.DatedFile[] var7, String var8, String var9) {
            this.type = var1;
            this.data = var2;
            this.frontSide = var3;
            this.reverseSide = var4;
            this.selfie = var5;
            this.translation = var6;
            this.files = var7;
            this.value = var8;
            this.hash = var9;
        }

        public int getConstructor() {
            return 2002386193;
        }
    }

    public static class EncryptedCredentials extends TdApi.Object {
        public byte[] data;
        public byte[] hash;
        public byte[] secret;
        public static final int CONSTRUCTOR = 1331106766;

        public EncryptedCredentials() {
        }

        public EncryptedCredentials(byte[] var1, byte[] var2, byte[] var3) {
            this.data = var1;
            this.hash = var2;
            this.secret = var3;
        }

        public int getConstructor() {
            return 1331106766;
        }
    }

    public static class Emojis extends TdApi.Object {
        public String[] emojis;
        public static final int CONSTRUCTOR = 950339552;

        public Emojis() {
        }

        public Emojis(String[] var1) {
            this.emojis = var1;
        }

        public int getConstructor() {
            return 950339552;
        }
    }

    public static class EmailAddressAuthenticationCodeInfo extends TdApi.Object {
        public String emailAddressPattern;
        public int length;
        public static final int CONSTRUCTOR = 1151066659;

        public EmailAddressAuthenticationCodeInfo() {
        }

        public EmailAddressAuthenticationCodeInfo(String var1, int var2) {
            this.emailAddressPattern = var1;
            this.length = var2;
        }

        public int getConstructor() {
            return 1151066659;
        }
    }

    public static class DraftMessage extends TdApi.Object {
        public long replyToMessageId;
        public TdApi.InputMessageContent inputMessageText;
        public static final int CONSTRUCTOR = 1902914742;

        public DraftMessage() {
        }

        public DraftMessage(long var1, TdApi.InputMessageContent var3) {
            this.replyToMessageId = var1;
            this.inputMessageText = var3;
        }

        public int getConstructor() {
            return 1902914742;
        }
    }

    public static class Document extends TdApi.Object {
        public String fileName;
        public String mimeType;
        public TdApi.Minithumbnail minithumbnail;
        public TdApi.PhotoSize thumbnail;
        public TdApi.File document;
        public static final int CONSTRUCTOR = 21881988;

        public Document() {
        }

        public Document(String var1, String var2, TdApi.Minithumbnail var3, TdApi.PhotoSize var4, TdApi.File var5) {
            this.fileName = var1;
            this.mimeType = var2;
            this.minithumbnail = var3;
            this.thumbnail = var4;
            this.document = var5;
        }

        public int getConstructor() {
            return 21881988;
        }
    }

    public static class DeviceTokenTizenPush extends TdApi.DeviceToken {
        public String regId;
        public static final int CONSTRUCTOR = -1359947213;

        public DeviceTokenTizenPush() {
        }

        public DeviceTokenTizenPush(String var1) {
            this.regId = var1;
        }

        public int getConstructor() {
            return -1359947213;
        }
    }

    public static class DeviceTokenBlackBerryPush extends TdApi.DeviceToken {
        public String token;
        public static final int CONSTRUCTOR = 1559167234;

        public DeviceTokenBlackBerryPush() {
        }

        public DeviceTokenBlackBerryPush(String var1) {
            this.token = var1;
        }

        public int getConstructor() {
            return 1559167234;
        }
    }

    public static class DeviceTokenUbuntuPush extends TdApi.DeviceToken {
        public String token;
        public static final int CONSTRUCTOR = 1782320422;

        public DeviceTokenUbuntuPush() {
        }

        public DeviceTokenUbuntuPush(String var1) {
            this.token = var1;
        }

        public int getConstructor() {
            return 1782320422;
        }
    }

    public static class DeviceTokenSimplePush extends TdApi.DeviceToken {
        public String endpoint;
        public static final int CONSTRUCTOR = 49584736;

        public DeviceTokenSimplePush() {
        }

        public DeviceTokenSimplePush(String var1) {
            this.endpoint = var1;
        }

        public int getConstructor() {
            return 49584736;
        }
    }

    public static class DeviceTokenWebPush extends TdApi.DeviceToken {
        public String endpoint;
        public String p256dhBase64url;
        public String authBase64url;
        public static final int CONSTRUCTOR = -1694507273;

        public DeviceTokenWebPush() {
        }

        public DeviceTokenWebPush(String var1, String var2, String var3) {
            this.endpoint = var1;
            this.p256dhBase64url = var2;
            this.authBase64url = var3;
        }

        public int getConstructor() {
            return -1694507273;
        }
    }

    public static class DeviceTokenMicrosoftPushVoIP extends TdApi.DeviceToken {
        public String channelUri;
        public static final int CONSTRUCTOR = -785603759;

        public DeviceTokenMicrosoftPushVoIP() {
        }

        public DeviceTokenMicrosoftPushVoIP(String var1) {
            this.channelUri = var1;
        }

        public int getConstructor() {
            return -785603759;
        }
    }

    public static class DeviceTokenMicrosoftPush extends TdApi.DeviceToken {
        public String channelUri;
        public static final int CONSTRUCTOR = 1224269900;

        public DeviceTokenMicrosoftPush() {
        }

        public DeviceTokenMicrosoftPush(String var1) {
            this.channelUri = var1;
        }

        public int getConstructor() {
            return 1224269900;
        }
    }

    public static class DeviceTokenWindowsPush extends TdApi.DeviceToken {
        public String accessToken;
        public static final int CONSTRUCTOR = -1410514289;

        public DeviceTokenWindowsPush() {
        }

        public DeviceTokenWindowsPush(String var1) {
            this.accessToken = var1;
        }

        public int getConstructor() {
            return -1410514289;
        }
    }

    public static class DeviceTokenApplePushVoIP extends TdApi.DeviceToken {
        public String deviceToken;
        public boolean isAppSandbox;
        public boolean encrypt;
        public static final int CONSTRUCTOR = 804275689;

        public DeviceTokenApplePushVoIP() {
        }

        public DeviceTokenApplePushVoIP(String var1, boolean var2, boolean var3) {
            this.deviceToken = var1;
            this.isAppSandbox = var2;
            this.encrypt = var3;
        }

        public int getConstructor() {
            return 804275689;
        }
    }

    public static class DeviceTokenApplePush extends TdApi.DeviceToken {
        public String deviceToken;
        public boolean isAppSandbox;
        public static final int CONSTRUCTOR = 387541955;

        public DeviceTokenApplePush() {
        }

        public DeviceTokenApplePush(String var1, boolean var2) {
            this.deviceToken = var1;
            this.isAppSandbox = var2;
        }

        public int getConstructor() {
            return 387541955;
        }
    }

    public static class DeviceTokenFirebaseCloudMessaging extends TdApi.DeviceToken {
        public String token;
        public boolean encrypt;
        public static final int CONSTRUCTOR = -797881849;

        public DeviceTokenFirebaseCloudMessaging() {
        }

        public DeviceTokenFirebaseCloudMessaging(String var1, boolean var2) {
            this.token = var1;
            this.encrypt = var2;
        }

        public int getConstructor() {
            return -797881849;
        }
    }

    public abstract static class DeviceToken extends TdApi.Object {
        public DeviceToken() {
        }
    }

    public static class DeepLinkInfo extends TdApi.Object {
        public TdApi.FormattedText text;
        public boolean needUpdateApplication;
        public static final int CONSTRUCTOR = 1864081662;

        public DeepLinkInfo() {
        }

        public DeepLinkInfo(TdApi.FormattedText var1, boolean var2) {
            this.text = var1;
            this.needUpdateApplication = var2;
        }

        public int getConstructor() {
            return 1864081662;
        }
    }

    public static class DatedFile extends TdApi.Object {
        public TdApi.File file;
        public int date;
        public static final int CONSTRUCTOR = -1840795491;

        public DatedFile() {
        }

        public DatedFile(TdApi.File var1, int var2) {
            this.file = var1;
            this.date = var2;
        }

        public int getConstructor() {
            return -1840795491;
        }
    }

    public static class Date extends TdApi.Object {
        public int day;
        public int month;
        public int year;
        public static final int CONSTRUCTOR = -277956960;

        public Date() {
        }

        public Date(int var1, int var2, int var3) {
            this.day = var1;
            this.month = var2;
            this.year = var3;
        }

        public int getConstructor() {
            return -277956960;
        }
    }

    public static class DatabaseStatistics extends TdApi.Object {
        public String statistics;
        public static final int CONSTRUCTOR = -1123912880;

        public DatabaseStatistics() {
        }

        public DatabaseStatistics(String var1) {
            this.statistics = var1;
        }

        public int getConstructor() {
            return -1123912880;
        }
    }

    public static class CustomRequestResult extends TdApi.Object {
        public String result;
        public static final int CONSTRUCTOR = -2009960452;

        public CustomRequestResult() {
        }

        public CustomRequestResult(String var1) {
            this.result = var1;
        }

        public int getConstructor() {
            return -2009960452;
        }
    }

    public static class Count extends TdApi.Object {
        public int count;
        public static final int CONSTRUCTOR = 1295577348;

        public Count() {
        }

        public Count(int var1) {
            this.count = var1;
        }

        public int getConstructor() {
            return 1295577348;
        }
    }

    public static class Contact extends TdApi.Object {
        public String phoneNumber;
        public String firstName;
        public String lastName;
        public String vcard;
        public int userId;
        public static final int CONSTRUCTOR = -1483002540;

        public Contact() {
        }

        public Contact(String var1, String var2, String var3, String var4, int var5) {
            this.phoneNumber = var1;
            this.firstName = var2;
            this.lastName = var3;
            this.vcard = var4;
            this.userId = var5;
        }

        public int getConstructor() {
            return -1483002540;
        }
    }

    public static class ConnectionStateReady extends TdApi.ConnectionState {
        public static final int CONSTRUCTOR = 48608492;

        public ConnectionStateReady() {
        }

        public int getConstructor() {
            return 48608492;
        }
    }

    public static class ConnectionStateUpdating extends TdApi.ConnectionState {
        public static final int CONSTRUCTOR = -188104009;

        public ConnectionStateUpdating() {
        }

        public int getConstructor() {
            return -188104009;
        }
    }

    public static class ConnectionStateConnecting extends TdApi.ConnectionState {
        public static final int CONSTRUCTOR = -1298400670;

        public ConnectionStateConnecting() {
        }

        public int getConstructor() {
            return -1298400670;
        }
    }

    public static class ConnectionStateConnectingToProxy extends TdApi.ConnectionState {
        public static final int CONSTRUCTOR = -93187239;

        public ConnectionStateConnectingToProxy() {
        }

        public int getConstructor() {
            return -93187239;
        }
    }

    public static class ConnectionStateWaitingForNetwork extends TdApi.ConnectionState {
        public static final int CONSTRUCTOR = 1695405912;

        public ConnectionStateWaitingForNetwork() {
        }

        public int getConstructor() {
            return 1695405912;
        }
    }

    public abstract static class ConnectionState extends TdApi.Object {
        public ConnectionState() {
        }
    }

    public static class ConnectedWebsites extends TdApi.Object {
        public TdApi.ConnectedWebsite[] websites;
        public static final int CONSTRUCTOR = -1727949694;

        public ConnectedWebsites() {
        }

        public ConnectedWebsites(TdApi.ConnectedWebsite[] var1) {
            this.websites = var1;
        }

        public int getConstructor() {
            return -1727949694;
        }
    }

    public static class ConnectedWebsite extends TdApi.Object {
        public long id;
        public String domainName;
        public int botUserId;
        public String browser;
        public String platform;
        public int logInDate;
        public int lastActiveDate;
        public String ip;
        public String location;
        public static final int CONSTRUCTOR = -1538986855;

        public ConnectedWebsite() {
        }

        public ConnectedWebsite(long var1, String var3, int var4, String var5, String var6, int var7, int var8, String var9, String var10) {
            this.id = var1;
            this.domainName = var3;
            this.botUserId = var4;
            this.browser = var5;
            this.platform = var6;
            this.logInDate = var7;
            this.lastActiveDate = var8;
            this.ip = var9;
            this.location = var10;
        }

        public int getConstructor() {
            return -1538986855;
        }
    }

    public static class CheckChatUsernameResultPublicGroupsUnavailable extends TdApi.CheckChatUsernameResult {
        public static final int CONSTRUCTOR = -51833641;

        public CheckChatUsernameResultPublicGroupsUnavailable() {
        }

        public int getConstructor() {
            return -51833641;
        }
    }

    public static class CheckChatUsernameResultPublicChatsTooMuch extends TdApi.CheckChatUsernameResult {
        public static final int CONSTRUCTOR = 858247741;

        public CheckChatUsernameResultPublicChatsTooMuch() {
        }

        public int getConstructor() {
            return 858247741;
        }
    }

    public static class CheckChatUsernameResultUsernameOccupied extends TdApi.CheckChatUsernameResult {
        public static final int CONSTRUCTOR = 1320892201;

        public CheckChatUsernameResultUsernameOccupied() {
        }

        public int getConstructor() {
            return 1320892201;
        }
    }

    public static class CheckChatUsernameResultUsernameInvalid extends TdApi.CheckChatUsernameResult {
        public static final int CONSTRUCTOR = -636979370;

        public CheckChatUsernameResultUsernameInvalid() {
        }

        public int getConstructor() {
            return -636979370;
        }
    }

    public static class CheckChatUsernameResultOk extends TdApi.CheckChatUsernameResult {
        public static final int CONSTRUCTOR = -1498956964;

        public CheckChatUsernameResultOk() {
        }

        public int getConstructor() {
            return -1498956964;
        }
    }

    public abstract static class CheckChatUsernameResult extends TdApi.Object {
        public CheckChatUsernameResult() {
        }
    }

    public static class ChatsNearby extends TdApi.Object {
        public TdApi.ChatNearby[] usersNearby;
        public TdApi.ChatNearby[] supergroupsNearby;
        public static final int CONSTRUCTOR = 187746081;

        public ChatsNearby() {
        }

        public ChatsNearby(TdApi.ChatNearby[] var1, TdApi.ChatNearby[] var2) {
            this.usersNearby = var1;
            this.supergroupsNearby = var2;
        }

        public int getConstructor() {
            return 187746081;
        }
    }

    public static class Chats extends TdApi.Object {
        public long[] chatIds;
        public static final int CONSTRUCTOR = -1687756019;

        public Chats() {
        }

        public Chats(long[] var1) {
            this.chatIds = var1;
        }

        public int getConstructor() {
            return -1687756019;
        }
    }

    public static class ChatTypeSecret extends TdApi.ChatType {
        public int secretChatId;
        public int userId;
        public static final int CONSTRUCTOR = 136722563;

        public ChatTypeSecret() {
        }

        public ChatTypeSecret(int var1, int var2) {
            this.secretChatId = var1;
            this.userId = var2;
        }

        public int getConstructor() {
            return 136722563;
        }
    }

    public static class ChatTypeSupergroup extends TdApi.ChatType {
        public int supergroupId;
        public boolean isChannel;
        public static final int CONSTRUCTOR = 955152366;

        public ChatTypeSupergroup() {
        }

        public ChatTypeSupergroup(int var1, boolean var2) {
            this.supergroupId = var1;
            this.isChannel = var2;
        }

        public int getConstructor() {
            return 955152366;
        }
    }

    public static class ChatTypeBasicGroup extends TdApi.ChatType {
        public int basicGroupId;
        public static final int CONSTRUCTOR = 21815278;

        public ChatTypeBasicGroup() {
        }

        public ChatTypeBasicGroup(int var1) {
            this.basicGroupId = var1;
        }

        public int getConstructor() {
            return 21815278;
        }
    }

    public static class ChatTypePrivate extends TdApi.ChatType {
        public int userId;
        public static final int CONSTRUCTOR = 1700720838;

        public ChatTypePrivate() {
        }

        public ChatTypePrivate(int var1) {
            this.userId = var1;
        }

        public int getConstructor() {
            return 1700720838;
        }
    }

    public abstract static class ChatType extends TdApi.Object {
        public ChatType() {
        }
    }

    public static class ChatReportReasonCustom extends TdApi.ChatReportReason {
        public String text;
        public static final int CONSTRUCTOR = 544575454;

        public ChatReportReasonCustom() {
        }

        public ChatReportReasonCustom(String var1) {
            this.text = var1;
        }

        public int getConstructor() {
            return 544575454;
        }
    }

    public static class ChatReportReasonUnrelatedLocation extends TdApi.ChatReportReason {
        public static final int CONSTRUCTOR = 2632403;

        public ChatReportReasonUnrelatedLocation() {
        }

        public int getConstructor() {
            return 2632403;
        }
    }

    public static class ChatReportReasonCopyright extends TdApi.ChatReportReason {
        public static final int CONSTRUCTOR = 986898080;

        public ChatReportReasonCopyright() {
        }

        public int getConstructor() {
            return 986898080;
        }
    }

    public static class ChatReportReasonChildAbuse extends TdApi.ChatReportReason {
        public static final int CONSTRUCTOR = -1070686531;

        public ChatReportReasonChildAbuse() {
        }

        public int getConstructor() {
            return -1070686531;
        }
    }

    public static class ChatReportReasonPornography extends TdApi.ChatReportReason {
        public static final int CONSTRUCTOR = 722614385;

        public ChatReportReasonPornography() {
        }

        public int getConstructor() {
            return 722614385;
        }
    }

    public static class ChatReportReasonViolence extends TdApi.ChatReportReason {
        public static final int CONSTRUCTOR = -1330235395;

        public ChatReportReasonViolence() {
        }

        public int getConstructor() {
            return -1330235395;
        }
    }

    public static class ChatReportReasonSpam extends TdApi.ChatReportReason {
        public static final int CONSTRUCTOR = -510848863;

        public ChatReportReasonSpam() {
        }

        public int getConstructor() {
            return -510848863;
        }
    }

    public abstract static class ChatReportReason extends TdApi.Object {
        public ChatReportReason() {
        }
    }

    public static class ChatPhoto extends TdApi.Object {
        public TdApi.File small;
        public TdApi.File big;
        public static final int CONSTRUCTOR = -217062456;

        public ChatPhoto() {
        }

        public ChatPhoto(TdApi.File var1, TdApi.File var2) {
            this.small = var1;
            this.big = var2;
        }

        public int getConstructor() {
            return -217062456;
        }
    }

    public static class ChatPermissions extends TdApi.Object {
        public boolean canSendMessages;
        public boolean canSendMediaMessages;
        public boolean canSendPolls;
        public boolean canSendOtherMessages;
        public boolean canAddWebPagePreviews;
        public boolean canChangeInfo;
        public boolean canInviteUsers;
        public boolean canPinMessages;
        public static final int CONSTRUCTOR = 1584650463;

        public ChatPermissions() {
        }

        public ChatPermissions(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8) {
            this.canSendMessages = var1;
            this.canSendMediaMessages = var2;
            this.canSendPolls = var3;
            this.canSendOtherMessages = var4;
            this.canAddWebPagePreviews = var5;
            this.canChangeInfo = var6;
            this.canInviteUsers = var7;
            this.canPinMessages = var8;
        }

        public int getConstructor() {
            return 1584650463;
        }
    }

    public static class ChatNotificationSettings extends TdApi.Object {
        public boolean useDefaultMuteFor;
        public int muteFor;
        public boolean useDefaultSound;
        public String sound;
        public boolean useDefaultShowPreview;
        public boolean showPreview;
        public boolean useDefaultDisablePinnedMessageNotifications;
        public boolean disablePinnedMessageNotifications;
        public boolean useDefaultDisableMentionNotifications;
        public boolean disableMentionNotifications;
        public static final int CONSTRUCTOR = 1503183218;

        public ChatNotificationSettings() {
        }

        public ChatNotificationSettings(boolean var1, int var2, boolean var3, String var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10) {
            this.useDefaultMuteFor = var1;
            this.muteFor = var2;
            this.useDefaultSound = var3;
            this.sound = var4;
            this.useDefaultShowPreview = var5;
            this.showPreview = var6;
            this.useDefaultDisablePinnedMessageNotifications = var7;
            this.disablePinnedMessageNotifications = var8;
            this.useDefaultDisableMentionNotifications = var9;
            this.disableMentionNotifications = var10;
        }

        public int getConstructor() {
            return 1503183218;
        }
    }

    public static class ChatNearby extends TdApi.Object {
        public long chatId;
        public int distance;
        public static final int CONSTRUCTOR = 48120405;

        public ChatNearby() {
        }

        public ChatNearby(long var1, int var3) {
            this.chatId = var1;
            this.distance = var3;
        }

        public int getConstructor() {
            return 48120405;
        }
    }

    public static class ChatMembersFilterBots extends TdApi.ChatMembersFilter {
        public static final int CONSTRUCTOR = -1422567288;

        public ChatMembersFilterBots() {
        }

        public int getConstructor() {
            return -1422567288;
        }
    }

    public static class ChatMembersFilterBanned extends TdApi.ChatMembersFilter {
        public static final int CONSTRUCTOR = -1863102648;

        public ChatMembersFilterBanned() {
        }

        public int getConstructor() {
            return -1863102648;
        }
    }

    public static class ChatMembersFilterRestricted extends TdApi.ChatMembersFilter {
        public static final int CONSTRUCTOR = 1256282813;

        public ChatMembersFilterRestricted() {
        }

        public int getConstructor() {
            return 1256282813;
        }
    }

    public static class ChatMembersFilterMembers extends TdApi.ChatMembersFilter {
        public static final int CONSTRUCTOR = 670504342;

        public ChatMembersFilterMembers() {
        }

        public int getConstructor() {
            return 670504342;
        }
    }

    public static class ChatMembersFilterAdministrators extends TdApi.ChatMembersFilter {
        public static final int CONSTRUCTOR = -1266893796;

        public ChatMembersFilterAdministrators() {
        }

        public int getConstructor() {
            return -1266893796;
        }
    }

    public static class ChatMembersFilterContacts extends TdApi.ChatMembersFilter {
        public static final int CONSTRUCTOR = 1774485671;

        public ChatMembersFilterContacts() {
        }

        public int getConstructor() {
            return 1774485671;
        }
    }

    public abstract static class ChatMembersFilter extends TdApi.Object {
        public ChatMembersFilter() {
        }
    }

    public static class ChatMembers extends TdApi.Object {
        public int totalCount;
        public TdApi.ChatMember[] members;
        public static final int CONSTRUCTOR = -497558622;

        public ChatMembers() {
        }

        public ChatMembers(int var1, TdApi.ChatMember[] var2) {
            this.totalCount = var1;
            this.members = var2;
        }

        public int getConstructor() {
            return -497558622;
        }
    }

    public static class ChatMemberStatusBanned extends TdApi.ChatMemberStatus {
        public int bannedUntilDate;
        public static final int CONSTRUCTOR = -1653518666;

        public ChatMemberStatusBanned() {
        }

        public ChatMemberStatusBanned(int var1) {
            this.bannedUntilDate = var1;
        }

        public int getConstructor() {
            return -1653518666;
        }
    }

    public static class ChatMemberStatusLeft extends TdApi.ChatMemberStatus {
        public static final int CONSTRUCTOR = -5815259;

        public ChatMemberStatusLeft() {
        }

        public int getConstructor() {
            return -5815259;
        }
    }

    public static class ChatMemberStatusRestricted extends TdApi.ChatMemberStatus {
        public boolean isMember;
        public int restrictedUntilDate;
        public TdApi.ChatPermissions permissions;
        public static final int CONSTRUCTOR = 1661432998;

        public ChatMemberStatusRestricted() {
        }

        public ChatMemberStatusRestricted(boolean var1, int var2, TdApi.ChatPermissions var3) {
            this.isMember = var1;
            this.restrictedUntilDate = var2;
            this.permissions = var3;
        }

        public int getConstructor() {
            return 1661432998;
        }
    }

    public static class ChatMemberStatusMember extends TdApi.ChatMemberStatus {
        public static final int CONSTRUCTOR = 844723285;

        public ChatMemberStatusMember() {
        }

        public int getConstructor() {
            return 844723285;
        }
    }

    public static class ChatMemberStatusAdministrator extends TdApi.ChatMemberStatus {
        public String customTitle;
        public boolean canBeEdited;
        public boolean canChangeInfo;
        public boolean canPostMessages;
        public boolean canEditMessages;
        public boolean canDeleteMessages;
        public boolean canInviteUsers;
        public boolean canRestrictMembers;
        public boolean canPinMessages;
        public boolean canPromoteMembers;
        public static final int CONSTRUCTOR = 1800612058;

        public ChatMemberStatusAdministrator() {
        }

        public ChatMemberStatusAdministrator(String var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10) {
            this.customTitle = var1;
            this.canBeEdited = var2;
            this.canChangeInfo = var3;
            this.canPostMessages = var4;
            this.canEditMessages = var5;
            this.canDeleteMessages = var6;
            this.canInviteUsers = var7;
            this.canRestrictMembers = var8;
            this.canPinMessages = var9;
            this.canPromoteMembers = var10;
        }

        public int getConstructor() {
            return 1800612058;
        }
    }

    public static class ChatMemberStatusCreator extends TdApi.ChatMemberStatus {
        public String customTitle;
        public boolean isMember;
        public static final int CONSTRUCTOR = 2038475849;

        public ChatMemberStatusCreator() {
        }

        public ChatMemberStatusCreator(String var1, boolean var2) {
            this.customTitle = var1;
            this.isMember = var2;
        }

        public int getConstructor() {
            return 2038475849;
        }
    }

    public abstract static class ChatMemberStatus extends TdApi.Object {
        public ChatMemberStatus() {
        }
    }

    public static class ChatMember extends TdApi.Object {
        public int userId;
        public int inviterUserId;
        public int joinedChatDate;
        public TdApi.ChatMemberStatus status;
        public TdApi.BotInfo botInfo;
        public static final int CONSTRUCTOR = -806137076;

        public ChatMember() {
        }

        public ChatMember(int var1, int var2, int var3, TdApi.ChatMemberStatus var4, TdApi.BotInfo var5) {
            this.userId = var1;
            this.inviterUserId = var2;
            this.joinedChatDate = var3;
            this.status = var4;
            this.botInfo = var5;
        }

        public int getConstructor() {
            return -806137076;
        }
    }

    public static class ChatLocation extends TdApi.Object {
        public TdApi.Location location;
        public String address;
        public static final int CONSTRUCTOR = -1566863583;

        public ChatLocation() {
        }

        public ChatLocation(TdApi.Location var1, String var2) {
            this.location = var1;
            this.address = var2;
        }

        public int getConstructor() {
            return -1566863583;
        }
    }

    public static class ChatListArchive extends TdApi.ChatList {
        public static final int CONSTRUCTOR = 362770115;

        public ChatListArchive() {
        }

        public int getConstructor() {
            return 362770115;
        }
    }

    public static class ChatListMain extends TdApi.ChatList {
        public static final int CONSTRUCTOR = -400991316;

        public ChatListMain() {
        }

        public int getConstructor() {
            return -400991316;
        }
    }

    public abstract static class ChatList extends TdApi.Object {
        public ChatList() {
        }
    }

    public static class ChatInviteLinkInfo extends TdApi.Object {
        public long chatId;
        public TdApi.ChatType type;
        public String title;
        public TdApi.ChatPhoto photo;
        public int memberCount;
        public int[] memberUserIds;
        public boolean isPublic;
        public static final int CONSTRUCTOR = -323394424;

        public ChatInviteLinkInfo() {
        }

        public ChatInviteLinkInfo(long var1, TdApi.ChatType var3, String var4, TdApi.ChatPhoto var5, int var6, int[] var7, boolean var8) {
            this.chatId = var1;
            this.type = var3;
            this.title = var4;
            this.photo = var5;
            this.memberCount = var6;
            this.memberUserIds = var7;
            this.isPublic = var8;
        }

        public int getConstructor() {
            return -323394424;
        }
    }

    public static class ChatInviteLink extends TdApi.Object {
        public String inviteLink;
        public static final int CONSTRUCTOR = -882072492;

        public ChatInviteLink() {
        }

        public ChatInviteLink(String var1) {
            this.inviteLink = var1;
        }

        public int getConstructor() {
            return -882072492;
        }
    }

    public static class ChatEvents extends TdApi.Object {
        public TdApi.ChatEvent[] events;
        public static final int CONSTRUCTOR = -585329664;

        public ChatEvents() {
        }

        public ChatEvents(TdApi.ChatEvent[] var1) {
            this.events = var1;
        }

        public int getConstructor() {
            return -585329664;
        }
    }

    public static class ChatEventLogFilters extends TdApi.Object {
        public boolean messageEdits;
        public boolean messageDeletions;
        public boolean messagePins;
        public boolean memberJoins;
        public boolean memberLeaves;
        public boolean memberInvites;
        public boolean memberPromotions;
        public boolean memberRestrictions;
        public boolean infoChanges;
        public boolean settingChanges;
        public static final int CONSTRUCTOR = 941939684;

        public ChatEventLogFilters() {
        }

        public ChatEventLogFilters(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10) {
            this.messageEdits = var1;
            this.messageDeletions = var2;
            this.messagePins = var3;
            this.memberJoins = var4;
            this.memberLeaves = var5;
            this.memberInvites = var6;
            this.memberPromotions = var7;
            this.memberRestrictions = var8;
            this.infoChanges = var9;
            this.settingChanges = var10;
        }

        public int getConstructor() {
            return 941939684;
        }
    }

    public static class ChatEventIsAllHistoryAvailableToggled extends TdApi.ChatEventAction {
        public boolean isAllHistoryAvailable;
        public static final int CONSTRUCTOR = -1599063019;

        public ChatEventIsAllHistoryAvailableToggled() {
        }

        public ChatEventIsAllHistoryAvailableToggled(boolean var1) {
            this.isAllHistoryAvailable = var1;
        }

        public int getConstructor() {
            return -1599063019;
        }
    }

    public static class ChatEventLocationChanged extends TdApi.ChatEventAction {
        public TdApi.ChatLocation oldLocation;
        public TdApi.ChatLocation newLocation;
        public static final int CONSTRUCTOR = -405930674;

        public ChatEventLocationChanged() {
        }

        public ChatEventLocationChanged(TdApi.ChatLocation var1, TdApi.ChatLocation var2) {
            this.oldLocation = var1;
            this.newLocation = var2;
        }

        public int getConstructor() {
            return -405930674;
        }
    }

    public static class ChatEventStickerSetChanged extends TdApi.ChatEventAction {
        public long oldStickerSetId;
        public long newStickerSetId;
        public static final int CONSTRUCTOR = -1243130481;

        public ChatEventStickerSetChanged() {
        }

        public ChatEventStickerSetChanged(long var1, long var3) {
            this.oldStickerSetId = var1;
            this.newStickerSetId = var3;
        }

        public int getConstructor() {
            return -1243130481;
        }
    }

    public static class ChatEventSignMessagesToggled extends TdApi.ChatEventAction {
        public boolean signMessages;
        public static final int CONSTRUCTOR = -1313265634;

        public ChatEventSignMessagesToggled() {
        }

        public ChatEventSignMessagesToggled(boolean var1) {
            this.signMessages = var1;
        }

        public int getConstructor() {
            return -1313265634;
        }
    }

    public static class ChatEventSlowModeDelayChanged extends TdApi.ChatEventAction {
        public int oldSlowModeDelay;
        public int newSlowModeDelay;
        public static final int CONSTRUCTOR = -1653195765;

        public ChatEventSlowModeDelayChanged() {
        }

        public ChatEventSlowModeDelayChanged(int var1, int var2) {
            this.oldSlowModeDelay = var1;
            this.newSlowModeDelay = var2;
        }

        public int getConstructor() {
            return -1653195765;
        }
    }

    public static class ChatEventLinkedChatChanged extends TdApi.ChatEventAction {
        public long oldLinkedChatId;
        public long newLinkedChatId;
        public static final int CONSTRUCTOR = 1797419439;

        public ChatEventLinkedChatChanged() {
        }

        public ChatEventLinkedChatChanged(long var1, long var3) {
            this.oldLinkedChatId = var1;
            this.newLinkedChatId = var3;
        }

        public int getConstructor() {
            return 1797419439;
        }
    }

    public static class ChatEventInvitesToggled extends TdApi.ChatEventAction {
        public boolean canInviteUsers;
        public static final int CONSTRUCTOR = -62548373;

        public ChatEventInvitesToggled() {
        }

        public ChatEventInvitesToggled(boolean var1) {
            this.canInviteUsers = var1;
        }

        public int getConstructor() {
            return -62548373;
        }
    }

    public static class ChatEventPhotoChanged extends TdApi.ChatEventAction {
        public TdApi.Photo oldPhoto;
        public TdApi.Photo newPhoto;
        public static final int CONSTRUCTOR = 1037662734;

        public ChatEventPhotoChanged() {
        }

        public ChatEventPhotoChanged(TdApi.Photo var1, TdApi.Photo var2) {
            this.oldPhoto = var1;
            this.newPhoto = var2;
        }

        public int getConstructor() {
            return 1037662734;
        }
    }

    public static class ChatEventUsernameChanged extends TdApi.ChatEventAction {
        public String oldUsername;
        public String newUsername;
        public static final int CONSTRUCTOR = 1728558443;

        public ChatEventUsernameChanged() {
        }

        public ChatEventUsernameChanged(String var1, String var2) {
            this.oldUsername = var1;
            this.newUsername = var2;
        }

        public int getConstructor() {
            return 1728558443;
        }
    }

    public static class ChatEventDescriptionChanged extends TdApi.ChatEventAction {
        public String oldDescription;
        public String newDescription;
        public static final int CONSTRUCTOR = 39112478;

        public ChatEventDescriptionChanged() {
        }

        public ChatEventDescriptionChanged(String var1, String var2) {
            this.oldDescription = var1;
            this.newDescription = var2;
        }

        public int getConstructor() {
            return 39112478;
        }
    }

    public static class ChatEventPermissionsChanged extends TdApi.ChatEventAction {
        public TdApi.ChatPermissions oldPermissions;
        public TdApi.ChatPermissions newPermissions;
        public static final int CONSTRUCTOR = -1311557720;

        public ChatEventPermissionsChanged() {
        }

        public ChatEventPermissionsChanged(TdApi.ChatPermissions var1, TdApi.ChatPermissions var2) {
            this.oldPermissions = var1;
            this.newPermissions = var2;
        }

        public int getConstructor() {
            return -1311557720;
        }
    }

    public static class ChatEventTitleChanged extends TdApi.ChatEventAction {
        public String oldTitle;
        public String newTitle;
        public static final int CONSTRUCTOR = 1134103250;

        public ChatEventTitleChanged() {
        }

        public ChatEventTitleChanged(String var1, String var2) {
            this.oldTitle = var1;
            this.newTitle = var2;
        }

        public int getConstructor() {
            return 1134103250;
        }
    }

    public static class ChatEventMemberRestricted extends TdApi.ChatEventAction {
        public int userId;
        public TdApi.ChatMemberStatus oldStatus;
        public TdApi.ChatMemberStatus newStatus;
        public static final int CONSTRUCTOR = 584946294;

        public ChatEventMemberRestricted() {
        }

        public ChatEventMemberRestricted(int var1, TdApi.ChatMemberStatus var2, TdApi.ChatMemberStatus var3) {
            this.userId = var1;
            this.oldStatus = var2;
            this.newStatus = var3;
        }

        public int getConstructor() {
            return 584946294;
        }
    }

    public static class ChatEventMemberPromoted extends TdApi.ChatEventAction {
        public int userId;
        public TdApi.ChatMemberStatus oldStatus;
        public TdApi.ChatMemberStatus newStatus;
        public static final int CONSTRUCTOR = 1887176186;

        public ChatEventMemberPromoted() {
        }

        public ChatEventMemberPromoted(int var1, TdApi.ChatMemberStatus var2, TdApi.ChatMemberStatus var3) {
            this.userId = var1;
            this.oldStatus = var2;
            this.newStatus = var3;
        }

        public int getConstructor() {
            return 1887176186;
        }
    }

    public static class ChatEventMemberInvited extends TdApi.ChatEventAction {
        public int userId;
        public TdApi.ChatMemberStatus status;
        public static final int CONSTRUCTOR = -2093688706;

        public ChatEventMemberInvited() {
        }

        public ChatEventMemberInvited(int var1, TdApi.ChatMemberStatus var2) {
            this.userId = var1;
            this.status = var2;
        }

        public int getConstructor() {
            return -2093688706;
        }
    }

    public static class ChatEventMemberLeft extends TdApi.ChatEventAction {
        public static final int CONSTRUCTOR = -948420593;

        public ChatEventMemberLeft() {
        }

        public int getConstructor() {
            return -948420593;
        }
    }

    public static class ChatEventMemberJoined extends TdApi.ChatEventAction {
        public static final int CONSTRUCTOR = -235468508;

        public ChatEventMemberJoined() {
        }

        public int getConstructor() {
            return -235468508;
        }
    }

    public static class ChatEventMessageUnpinned extends TdApi.ChatEventAction {
        public static final int CONSTRUCTOR = 2002594849;

        public ChatEventMessageUnpinned() {
        }

        public int getConstructor() {
            return 2002594849;
        }
    }

    public static class ChatEventMessagePinned extends TdApi.ChatEventAction {
        public TdApi.Message message;
        public static final int CONSTRUCTOR = 438742298;

        public ChatEventMessagePinned() {
        }

        public ChatEventMessagePinned(TdApi.Message var1) {
            this.message = var1;
        }

        public int getConstructor() {
            return 438742298;
        }
    }

    public static class ChatEventPollStopped extends TdApi.ChatEventAction {
        public TdApi.Message message;
        public static final int CONSTRUCTOR = 2009893861;

        public ChatEventPollStopped() {
        }

        public ChatEventPollStopped(TdApi.Message var1) {
            this.message = var1;
        }

        public int getConstructor() {
            return 2009893861;
        }
    }

    public static class ChatEventMessageDeleted extends TdApi.ChatEventAction {
        public TdApi.Message message;
        public static final int CONSTRUCTOR = -892974601;

        public ChatEventMessageDeleted() {
        }

        public ChatEventMessageDeleted(TdApi.Message var1) {
            this.message = var1;
        }

        public int getConstructor() {
            return -892974601;
        }
    }

    public static class ChatEventMessageEdited extends TdApi.ChatEventAction {
        public TdApi.Message oldMessage;
        public TdApi.Message newMessage;
        public static final int CONSTRUCTOR = -430967304;

        public ChatEventMessageEdited() {
        }

        public ChatEventMessageEdited(TdApi.Message var1, TdApi.Message var2) {
            this.oldMessage = var1;
            this.newMessage = var2;
        }

        public int getConstructor() {
            return -430967304;
        }
    }

    public abstract static class ChatEventAction extends TdApi.Object {
        public ChatEventAction() {
        }
    }

    public static class ChatEvent extends TdApi.Object {
        public long id;
        public int date;
        public int userId;
        public TdApi.ChatEventAction action;
        public static final int CONSTRUCTOR = -609912404;

        public ChatEvent() {
        }

        public ChatEvent(long var1, int var3, int var4, TdApi.ChatEventAction var5) {
            this.id = var1;
            this.date = var3;
            this.userId = var4;
            this.action = var5;
        }

        public int getConstructor() {
            return -609912404;
        }
    }

    public static class ChatAdministrators extends TdApi.Object {
        public TdApi.ChatAdministrator[] administrators;
        public static final int CONSTRUCTOR = -2126186435;

        public ChatAdministrators() {
        }

        public ChatAdministrators(TdApi.ChatAdministrator[] var1) {
            this.administrators = var1;
        }

        public int getConstructor() {
            return -2126186435;
        }
    }

    public static class ChatAdministrator extends TdApi.Object {
        public int userId;
        public String customTitle;
        public boolean isOwner;
        public static final int CONSTRUCTOR = 487220942;

        public ChatAdministrator() {
        }

        public ChatAdministrator(int var1, String var2, boolean var3) {
            this.userId = var1;
            this.customTitle = var2;
            this.isOwner = var3;
        }

        public int getConstructor() {
            return 487220942;
        }
    }

    public static class ChatActionBarSharePhoneNumber extends TdApi.ChatActionBar {
        public static final int CONSTRUCTOR = 35188697;

        public ChatActionBarSharePhoneNumber() {
        }

        public int getConstructor() {
            return 35188697;
        }
    }

    public static class ChatActionBarAddContact extends TdApi.ChatActionBar {
        public static final int CONSTRUCTOR = -733325295;

        public ChatActionBarAddContact() {
        }

        public int getConstructor() {
            return -733325295;
        }
    }

    public static class ChatActionBarReportAddBlock extends TdApi.ChatActionBar {
        public static final int CONSTRUCTOR = -87894249;

        public ChatActionBarReportAddBlock() {
        }

        public int getConstructor() {
            return -87894249;
        }
    }

    public static class ChatActionBarReportUnrelatedLocation extends TdApi.ChatActionBar {
        public static final int CONSTRUCTOR = 758175489;

        public ChatActionBarReportUnrelatedLocation() {
        }

        public int getConstructor() {
            return 758175489;
        }
    }

    public static class ChatActionBarReportSpam extends TdApi.ChatActionBar {
        public static final int CONSTRUCTOR = -1603417249;

        public ChatActionBarReportSpam() {
        }

        public int getConstructor() {
            return -1603417249;
        }
    }

    public abstract static class ChatActionBar extends TdApi.Object {
        public ChatActionBar() {
        }
    }

    public static class ChatActionCancel extends TdApi.ChatAction {
        public static final int CONSTRUCTOR = 1160523958;

        public ChatActionCancel() {
        }

        public int getConstructor() {
            return 1160523958;
        }
    }

    public static class ChatActionUploadingVideoNote extends TdApi.ChatAction {
        public int progress;
        public static final int CONSTRUCTOR = 1172364918;

        public ChatActionUploadingVideoNote() {
        }

        public ChatActionUploadingVideoNote(int var1) {
            this.progress = var1;
        }

        public int getConstructor() {
            return 1172364918;
        }
    }

    public static class ChatActionRecordingVideoNote extends TdApi.ChatAction {
        public static final int CONSTRUCTOR = 16523393;

        public ChatActionRecordingVideoNote() {
        }

        public int getConstructor() {
            return 16523393;
        }
    }

    public static class ChatActionStartPlayingGame extends TdApi.ChatAction {
        public static final int CONSTRUCTOR = -865884164;

        public ChatActionStartPlayingGame() {
        }

        public int getConstructor() {
            return -865884164;
        }
    }

    public static class ChatActionChoosingContact extends TdApi.ChatAction {
        public static final int CONSTRUCTOR = -1222507496;

        public ChatActionChoosingContact() {
        }

        public int getConstructor() {
            return -1222507496;
        }
    }

    public static class ChatActionChoosingLocation extends TdApi.ChatAction {
        public static final int CONSTRUCTOR = -2017893596;

        public ChatActionChoosingLocation() {
        }

        public int getConstructor() {
            return -2017893596;
        }
    }

    public static class ChatActionUploadingDocument extends TdApi.ChatAction {
        public int progress;
        public static final int CONSTRUCTOR = 167884362;

        public ChatActionUploadingDocument() {
        }

        public ChatActionUploadingDocument(int var1) {
            this.progress = var1;
        }

        public int getConstructor() {
            return 167884362;
        }
    }

    public static class ChatActionUploadingPhoto extends TdApi.ChatAction {
        public int progress;
        public static final int CONSTRUCTOR = 654240583;

        public ChatActionUploadingPhoto() {
        }

        public ChatActionUploadingPhoto(int var1) {
            this.progress = var1;
        }

        public int getConstructor() {
            return 654240583;
        }
    }

    public static class ChatActionUploadingVoiceNote extends TdApi.ChatAction {
        public int progress;
        public static final int CONSTRUCTOR = -613643666;

        public ChatActionUploadingVoiceNote() {
        }

        public ChatActionUploadingVoiceNote(int var1) {
            this.progress = var1;
        }

        public int getConstructor() {
            return -613643666;
        }
    }

    public static class ChatActionRecordingVoiceNote extends TdApi.ChatAction {
        public static final int CONSTRUCTOR = -808850058;

        public ChatActionRecordingVoiceNote() {
        }

        public int getConstructor() {
            return -808850058;
        }
    }

    public static class ChatActionUploadingVideo extends TdApi.ChatAction {
        public int progress;
        public static final int CONSTRUCTOR = 1234185270;

        public ChatActionUploadingVideo() {
        }

        public ChatActionUploadingVideo(int var1) {
            this.progress = var1;
        }

        public int getConstructor() {
            return 1234185270;
        }
    }

    public static class ChatActionRecordingVideo extends TdApi.ChatAction {
        public static final int CONSTRUCTOR = 216553362;

        public ChatActionRecordingVideo() {
        }

        public int getConstructor() {
            return 216553362;
        }
    }

    public static class ChatActionTyping extends TdApi.ChatAction {
        public static final int CONSTRUCTOR = 380122167;

        public ChatActionTyping() {
        }

        public int getConstructor() {
            return 380122167;
        }
    }

    public abstract static class ChatAction extends TdApi.Object {
        public ChatAction() {
        }
    }

    public static class Chat extends TdApi.Object {
        public long id;
        public TdApi.ChatType type;
        public TdApi.ChatList chatList;
        public String title;
        public TdApi.ChatPhoto photo;
        public TdApi.ChatPermissions permissions;
        public TdApi.Message lastMessage;
        public long order;
        public boolean isPinned;
        public boolean isMarkedAsUnread;
        public boolean isSponsored;
        public boolean hasScheduledMessages;
        public boolean canBeDeletedOnlyForSelf;
        public boolean canBeDeletedForAllUsers;
        public boolean canBeReported;
        public boolean defaultDisableNotification;
        public int unreadCount;
        public long lastReadInboxMessageId;
        public long lastReadOutboxMessageId;
        public int unreadMentionCount;
        public TdApi.ChatNotificationSettings notificationSettings;
        public TdApi.ChatActionBar actionBar;
        public long pinnedMessageId;
        public long replyMarkupMessageId;
        public TdApi.DraftMessage draftMessage;
        public String clientData;
        public static final int CONSTRUCTOR = -861487386;

        public Chat() {
        }

        public Chat(long var1, TdApi.ChatType var3, TdApi.ChatList var4, String var5, TdApi.ChatPhoto var6, TdApi.ChatPermissions var7, TdApi.Message var8, long var9, boolean var11, boolean var12, boolean var13, boolean var14, boolean var15, boolean var16, boolean var17, boolean var18, int var19, long var20, long var22, int var24, TdApi.ChatNotificationSettings var25, TdApi.ChatActionBar var26, long var27, long var29, TdApi.DraftMessage var31, String var32) {
            this.id = var1;
            this.type = var3;
            this.chatList = var4;
            this.title = var5;
            this.photo = var6;
            this.permissions = var7;
            this.lastMessage = var8;
            this.order = var9;
            this.isPinned = var11;
            this.isMarkedAsUnread = var12;
            this.isSponsored = var13;
            this.hasScheduledMessages = var14;
            this.canBeDeletedOnlyForSelf = var15;
            this.canBeDeletedForAllUsers = var16;
            this.canBeReported = var17;
            this.defaultDisableNotification = var18;
            this.unreadCount = var19;
            this.lastReadInboxMessageId = var20;
            this.lastReadOutboxMessageId = var22;
            this.unreadMentionCount = var24;
            this.notificationSettings = var25;
            this.actionBar = var26;
            this.pinnedMessageId = var27;
            this.replyMarkupMessageId = var29;
            this.draftMessage = var31;
            this.clientData = var32;
        }

        public int getConstructor() {
            return -861487386;
        }
    }

    public static class CanTransferOwnershipResultSessionTooFresh extends TdApi.CanTransferOwnershipResult {
        public int retryAfter;
        public static final int CONSTRUCTOR = 984664289;

        public CanTransferOwnershipResultSessionTooFresh() {
        }

        public CanTransferOwnershipResultSessionTooFresh(int var1) {
            this.retryAfter = var1;
        }

        public int getConstructor() {
            return 984664289;
        }
    }

    public static class CanTransferOwnershipResultPasswordTooFresh extends TdApi.CanTransferOwnershipResult {
        public int retryAfter;
        public static final int CONSTRUCTOR = 811440913;

        public CanTransferOwnershipResultPasswordTooFresh() {
        }

        public CanTransferOwnershipResultPasswordTooFresh(int var1) {
            this.retryAfter = var1;
        }

        public int getConstructor() {
            return 811440913;
        }
    }

    public static class CanTransferOwnershipResultPasswordNeeded extends TdApi.CanTransferOwnershipResult {
        public static final int CONSTRUCTOR = 1548372703;

        public CanTransferOwnershipResultPasswordNeeded() {
        }

        public int getConstructor() {
            return 1548372703;
        }
    }

    public static class CanTransferOwnershipResultOk extends TdApi.CanTransferOwnershipResult {
        public static final int CONSTRUCTOR = -89881021;

        public CanTransferOwnershipResultOk() {
        }

        public int getConstructor() {
            return -89881021;
        }
    }

    public abstract static class CanTransferOwnershipResult extends TdApi.Object {
        public CanTransferOwnershipResult() {
        }
    }

    public static class CallbackQueryPayloadGame extends TdApi.CallbackQueryPayload {
        public String gameShortName;
        public static final int CONSTRUCTOR = 1303571512;

        public CallbackQueryPayloadGame() {
        }

        public CallbackQueryPayloadGame(String var1) {
            this.gameShortName = var1;
        }

        public int getConstructor() {
            return 1303571512;
        }
    }

    public static class CallbackQueryPayloadData extends TdApi.CallbackQueryPayload {
        public byte[] data;
        public static final int CONSTRUCTOR = -1977729946;

        public CallbackQueryPayloadData() {
        }

        public CallbackQueryPayloadData(byte[] var1) {
            this.data = var1;
        }

        public int getConstructor() {
            return -1977729946;
        }
    }

    public abstract static class CallbackQueryPayload extends TdApi.Object {
        public CallbackQueryPayload() {
        }
    }

    public static class CallbackQueryAnswer extends TdApi.Object {
        public String text;
        public boolean showAlert;
        public String url;
        public static final int CONSTRUCTOR = 360867933;

        public CallbackQueryAnswer() {
        }

        public CallbackQueryAnswer(String var1, boolean var2, String var3) {
            this.text = var1;
            this.showAlert = var2;
            this.url = var3;
        }

        public int getConstructor() {
            return 360867933;
        }
    }

    public static class CallStateError extends TdApi.CallState {
        public TdApi.Error error;
        public static final int CONSTRUCTOR = -975215467;

        public CallStateError() {
        }

        public CallStateError(TdApi.Error var1) {
            this.error = var1;
        }

        public int getConstructor() {
            return -975215467;
        }
    }

    public static class CallStateDiscarded extends TdApi.CallState {
        public TdApi.CallDiscardReason reason;
        public boolean needRating;
        public boolean needDebugInformation;
        public static final int CONSTRUCTOR = -190853167;

        public CallStateDiscarded() {
        }

        public CallStateDiscarded(TdApi.CallDiscardReason var1, boolean var2, boolean var3) {
            this.reason = var1;
            this.needRating = var2;
            this.needDebugInformation = var3;
        }

        public int getConstructor() {
            return -190853167;
        }
    }

    public static class CallStateHangingUp extends TdApi.CallState {
        public static final int CONSTRUCTOR = -2133790038;

        public CallStateHangingUp() {
        }

        public int getConstructor() {
            return -2133790038;
        }
    }

    public static class CallStateReady extends TdApi.CallState {
        public TdApi.CallProtocol protocol;
        public TdApi.CallConnection[] connections;
        public String config;
        public byte[] encryptionKey;
        public String[] emojis;
        public boolean allowP2p;
        public static final int CONSTRUCTOR = 1848397705;

        public CallStateReady() {
        }

        public CallStateReady(TdApi.CallProtocol var1, TdApi.CallConnection[] var2, String var3, byte[] var4, String[] var5, boolean var6) {
            this.protocol = var1;
            this.connections = var2;
            this.config = var3;
            this.encryptionKey = var4;
            this.emojis = var5;
            this.allowP2p = var6;
        }

        public int getConstructor() {
            return 1848397705;
        }
    }

    public static class CallStateExchangingKeys extends TdApi.CallState {
        public static final int CONSTRUCTOR = -1848149403;

        public CallStateExchangingKeys() {
        }

        public int getConstructor() {
            return -1848149403;
        }
    }

    public static class CallStatePending extends TdApi.CallState {
        public boolean isCreated;
        public boolean isReceived;
        public static final int CONSTRUCTOR = 1073048620;

        public CallStatePending() {
        }

        public CallStatePending(boolean var1, boolean var2) {
            this.isCreated = var1;
            this.isReceived = var2;
        }

        public int getConstructor() {
            return 1073048620;
        }
    }

    public abstract static class CallState extends TdApi.Object {
        public CallState() {
        }
    }

    public static class CallProtocol extends TdApi.Object {
        public boolean udpP2p;
        public boolean udpReflector;
        public int minLayer;
        public int maxLayer;
        public static final int CONSTRUCTOR = -1042830667;

        public CallProtocol() {
        }

        public CallProtocol(boolean var1, boolean var2, int var3, int var4) {
            this.udpP2p = var1;
            this.udpReflector = var2;
            this.minLayer = var3;
            this.maxLayer = var4;
        }

        public int getConstructor() {
            return -1042830667;
        }
    }

    public static class CallProblemDropped extends TdApi.CallProblem {
        public static final int CONSTRUCTOR = -1207311487;

        public CallProblemDropped() {
        }

        public int getConstructor() {
            return -1207311487;
        }
    }

    public static class CallProblemSilentRemote extends TdApi.CallProblem {
        public static final int CONSTRUCTOR = 573634714;

        public CallProblemSilentRemote() {
        }

        public int getConstructor() {
            return 573634714;
        }
    }

    public static class CallProblemSilentLocal extends TdApi.CallProblem {
        public static final int CONSTRUCTOR = 253652790;

        public CallProblemSilentLocal() {
        }

        public int getConstructor() {
            return 253652790;
        }
    }

    public static class CallProblemDistortedSpeech extends TdApi.CallProblem {
        public static final int CONSTRUCTOR = 379960581;

        public CallProblemDistortedSpeech() {
        }

        public int getConstructor() {
            return 379960581;
        }
    }

    public static class CallProblemInterruptions extends TdApi.CallProblem {
        public static final int CONSTRUCTOR = 1119493218;

        public CallProblemInterruptions() {
        }

        public int getConstructor() {
            return 1119493218;
        }
    }

    public static class CallProblemNoise extends TdApi.CallProblem {
        public static final int CONSTRUCTOR = 1053065359;

        public CallProblemNoise() {
        }

        public int getConstructor() {
            return 1053065359;
        }
    }

    public static class CallProblemEcho extends TdApi.CallProblem {
        public static final int CONSTRUCTOR = 801116548;

        public CallProblemEcho() {
        }

        public int getConstructor() {
            return 801116548;
        }
    }

    public abstract static class CallProblem extends TdApi.Object {
        public CallProblem() {
        }
    }

    public static class CallId extends TdApi.Object {
        public int id;
        public static final int CONSTRUCTOR = 65717769;

        public CallId() {
        }

        public CallId(int var1) {
            this.id = var1;
        }

        public int getConstructor() {
            return 65717769;
        }
    }

    public static class CallDiscardReasonHungUp extends TdApi.CallDiscardReason {
        public static final int CONSTRUCTOR = 438216166;

        public CallDiscardReasonHungUp() {
        }

        public int getConstructor() {
            return 438216166;
        }
    }

    public static class CallDiscardReasonDisconnected extends TdApi.CallDiscardReason {
        public static final int CONSTRUCTOR = -1342872670;

        public CallDiscardReasonDisconnected() {
        }

        public int getConstructor() {
            return -1342872670;
        }
    }

    public static class CallDiscardReasonDeclined extends TdApi.CallDiscardReason {
        public static final int CONSTRUCTOR = -1729926094;

        public CallDiscardReasonDeclined() {
        }

        public int getConstructor() {
            return -1729926094;
        }
    }

    public static class CallDiscardReasonMissed extends TdApi.CallDiscardReason {
        public static final int CONSTRUCTOR = 1680358012;

        public CallDiscardReasonMissed() {
        }

        public int getConstructor() {
            return 1680358012;
        }
    }

    public static class CallDiscardReasonEmpty extends TdApi.CallDiscardReason {
        public static final int CONSTRUCTOR = -1258917949;

        public CallDiscardReasonEmpty() {
        }

        public int getConstructor() {
            return -1258917949;
        }
    }

    public abstract static class CallDiscardReason extends TdApi.Object {
        public CallDiscardReason() {
        }
    }

    public static class CallConnection extends TdApi.Object {
        public long id;
        public String ip;
        public String ipv6;
        public int port;
        public byte[] peerTag;
        public static final int CONSTRUCTOR = 1318542714;

        public CallConnection() {
        }

        public CallConnection(long var1, String var3, String var4, int var5, byte[] var6) {
            this.id = var1;
            this.ip = var3;
            this.ipv6 = var4;
            this.port = var5;
            this.peerTag = var6;
        }

        public int getConstructor() {
            return 1318542714;
        }
    }

    public static class Call extends TdApi.Object {
        public int id;
        public int userId;
        public boolean isOutgoing;
        public TdApi.CallState state;
        public static final int CONSTRUCTOR = -1837599107;

        public Call() {
        }

        public Call(int var1, int var2, boolean var3, TdApi.CallState var4) {
            this.id = var1;
            this.userId = var2;
            this.isOutgoing = var3;
            this.state = var4;
        }

        public int getConstructor() {
            return -1837599107;
        }
    }

    public static class BotInfo extends TdApi.Object {
        public String description;
        public TdApi.BotCommand[] commands;
        public static final int CONSTRUCTOR = 1296528907;

        public BotInfo() {
        }

        public BotInfo(String var1, TdApi.BotCommand[] var2) {
            this.description = var1;
            this.commands = var2;
        }

        public int getConstructor() {
            return 1296528907;
        }
    }

    public static class BotCommand extends TdApi.Object {
        public String command;
        public String description;
        public static final int CONSTRUCTOR = -1032140601;

        public BotCommand() {
        }

        public BotCommand(String var1, String var2) {
            this.command = var1;
            this.description = var2;
        }

        public int getConstructor() {
            return -1032140601;
        }
    }

    public static class BasicGroupFullInfo extends TdApi.Object {
        public String description;
        public int creatorUserId;
        public TdApi.ChatMember[] members;
        public String inviteLink;
        public static final int CONSTRUCTOR = 161500149;

        public BasicGroupFullInfo() {
        }

        public BasicGroupFullInfo(String var1, int var2, TdApi.ChatMember[] var3, String var4) {
            this.description = var1;
            this.creatorUserId = var2;
            this.members = var3;
            this.inviteLink = var4;
        }

        public int getConstructor() {
            return 161500149;
        }
    }

    public static class BasicGroup extends TdApi.Object {
        public int id;
        public int memberCount;
        public TdApi.ChatMemberStatus status;
        public boolean isActive;
        public int upgradedToSupergroupId;
        public static final int CONSTRUCTOR = -317839045;

        public BasicGroup() {
        }

        public BasicGroup(int var1, int var2, TdApi.ChatMemberStatus var3, boolean var4, int var5) {
            this.id = var1;
            this.memberCount = var2;
            this.status = var3;
            this.isActive = var4;
            this.upgradedToSupergroupId = var5;
        }

        public int getConstructor() {
            return -317839045;
        }
    }

    public static class Backgrounds extends TdApi.Object {
        public TdApi.Background[] backgrounds;
        public static final int CONSTRUCTOR = 724728704;

        public Backgrounds() {
        }

        public Backgrounds(TdApi.Background[] var1) {
            this.backgrounds = var1;
        }

        public int getConstructor() {
            return 724728704;
        }
    }

    public static class BackgroundTypeFill extends TdApi.BackgroundType {
        public TdApi.BackgroundFill fill;
        public static final int CONSTRUCTOR = 993008684;

        public BackgroundTypeFill() {
        }

        public BackgroundTypeFill(TdApi.BackgroundFill var1) {
            this.fill = var1;
        }

        public int getConstructor() {
            return 993008684;
        }
    }

    public static class BackgroundTypePattern extends TdApi.BackgroundType {
        public TdApi.BackgroundFill fill;
        public int intensity;
        public boolean isMoving;
        public static final int CONSTRUCTOR = 649993914;

        public BackgroundTypePattern() {
        }

        public BackgroundTypePattern(TdApi.BackgroundFill var1, int var2, boolean var3) {
            this.fill = var1;
            this.intensity = var2;
            this.isMoving = var3;
        }

        public int getConstructor() {
            return 649993914;
        }
    }

    public static class BackgroundTypeWallpaper extends TdApi.BackgroundType {
        public boolean isBlurred;
        public boolean isMoving;
        public static final int CONSTRUCTOR = 1972128891;

        public BackgroundTypeWallpaper() {
        }

        public BackgroundTypeWallpaper(boolean var1, boolean var2) {
            this.isBlurred = var1;
            this.isMoving = var2;
        }

        public int getConstructor() {
            return 1972128891;
        }
    }

    public abstract static class BackgroundType extends TdApi.Object {
        public BackgroundType() {
        }
    }

    public static class BackgroundFillGradient extends TdApi.BackgroundFill {
        public int topColor;
        public int bottomColor;
        public int rotationAngle;
        public static final int CONSTRUCTOR = -1839206017;

        public BackgroundFillGradient() {
        }

        public BackgroundFillGradient(int var1, int var2, int var3) {
            this.topColor = var1;
            this.bottomColor = var2;
            this.rotationAngle = var3;
        }

        public int getConstructor() {
            return -1839206017;
        }
    }

    public static class BackgroundFillSolid extends TdApi.BackgroundFill {
        public int color;
        public static final int CONSTRUCTOR = 1010678813;

        public BackgroundFillSolid() {
        }

        public BackgroundFillSolid(int var1) {
            this.color = var1;
        }

        public int getConstructor() {
            return 1010678813;
        }
    }

    public abstract static class BackgroundFill extends TdApi.Object {
        public BackgroundFill() {
        }
    }

    public static class Background extends TdApi.Object {
        public long id;
        public boolean isDefault;
        public boolean isDark;
        public String name;
        public TdApi.Document document;
        public TdApi.BackgroundType type;
        public static final int CONSTRUCTOR = -429971172;

        public Background() {
        }

        public Background(long var1, boolean var3, boolean var4, String var5, TdApi.Document var6, TdApi.BackgroundType var7) {
            this.id = var1;
            this.isDefault = var3;
            this.isDark = var4;
            this.name = var5;
            this.document = var6;
            this.type = var7;
        }

        public int getConstructor() {
            return -429971172;
        }
    }

    public static class AutoDownloadSettingsPresets extends TdApi.Object {
        public TdApi.AutoDownloadSettings low;
        public TdApi.AutoDownloadSettings medium;
        public TdApi.AutoDownloadSettings high;
        public static final int CONSTRUCTOR = -782099166;

        public AutoDownloadSettingsPresets() {
        }

        public AutoDownloadSettingsPresets(TdApi.AutoDownloadSettings var1, TdApi.AutoDownloadSettings var2, TdApi.AutoDownloadSettings var3) {
            this.low = var1;
            this.medium = var2;
            this.high = var3;
        }

        public int getConstructor() {
            return -782099166;
        }
    }

    public static class AutoDownloadSettings extends TdApi.Object {
        public boolean isAutoDownloadEnabled;
        public int maxPhotoFileSize;
        public int maxVideoFileSize;
        public int maxOtherFileSize;
        public int videoUploadBitrate;
        public boolean preloadLargeVideos;
        public boolean preloadNextAudio;
        public boolean useLessDataForCalls;
        public static final int CONSTRUCTOR = -2144418333;

        public AutoDownloadSettings() {
        }

        public AutoDownloadSettings(boolean var1, int var2, int var3, int var4, int var5, boolean var6, boolean var7, boolean var8) {
            this.isAutoDownloadEnabled = var1;
            this.maxPhotoFileSize = var2;
            this.maxVideoFileSize = var3;
            this.maxOtherFileSize = var4;
            this.videoUploadBitrate = var5;
            this.preloadLargeVideos = var6;
            this.preloadNextAudio = var7;
            this.useLessDataForCalls = var8;
        }

        public int getConstructor() {
            return -2144418333;
        }
    }

    public static class AuthorizationStateClosed extends TdApi.AuthorizationState {
        public static final int CONSTRUCTOR = 1526047584;

        public AuthorizationStateClosed() {
        }

        public int getConstructor() {
            return 1526047584;
        }
    }

    public static class AuthorizationStateClosing extends TdApi.AuthorizationState {
        public static final int CONSTRUCTOR = 445855311;

        public AuthorizationStateClosing() {
        }

        public int getConstructor() {
            return 445855311;
        }
    }

    public static class AuthorizationStateLoggingOut extends TdApi.AuthorizationState {
        public static final int CONSTRUCTOR = 154449270;

        public AuthorizationStateLoggingOut() {
        }

        public int getConstructor() {
            return 154449270;
        }
    }

    public static class AuthorizationStateReady extends TdApi.AuthorizationState {
        public static final int CONSTRUCTOR = -1834871737;

        public AuthorizationStateReady() {
        }

        public int getConstructor() {
            return -1834871737;
        }
    }

    public static class AuthorizationStateWaitPassword extends TdApi.AuthorizationState {
        public String passwordHint;
        public boolean hasRecoveryEmailAddress;
        public String recoveryEmailAddressPattern;
        public static final int CONSTRUCTOR = 187548796;

        public AuthorizationStateWaitPassword() {
        }

        public AuthorizationStateWaitPassword(String var1, boolean var2, String var3) {
            this.passwordHint = var1;
            this.hasRecoveryEmailAddress = var2;
            this.recoveryEmailAddressPattern = var3;
        }

        public int getConstructor() {
            return 187548796;
        }
    }

    public static class AuthorizationStateWaitRegistration extends TdApi.AuthorizationState {
        public TdApi.TermsOfService termsOfService;
        public static final int CONSTRUCTOR = 550350511;

        public AuthorizationStateWaitRegistration() {
        }

        public AuthorizationStateWaitRegistration(TdApi.TermsOfService var1) {
            this.termsOfService = var1;
        }

        public int getConstructor() {
            return 550350511;
        }
    }

    public static class AuthorizationStateWaitOtherDeviceConfirmation extends TdApi.AuthorizationState {
        public String link;
        public static final int CONSTRUCTOR = 860166378;

        public AuthorizationStateWaitOtherDeviceConfirmation() {
        }

        public AuthorizationStateWaitOtherDeviceConfirmation(String var1) {
            this.link = var1;
        }

        public int getConstructor() {
            return 860166378;
        }
    }

    public static class AuthorizationStateWaitCode extends TdApi.AuthorizationState {
        public TdApi.AuthenticationCodeInfo codeInfo;
        public static final int CONSTRUCTOR = 52643073;

        public AuthorizationStateWaitCode() {
        }

        public AuthorizationStateWaitCode(TdApi.AuthenticationCodeInfo var1) {
            this.codeInfo = var1;
        }

        public int getConstructor() {
            return 52643073;
        }
    }

    public static class AuthorizationStateWaitPhoneNumber extends TdApi.AuthorizationState {
        public static final int CONSTRUCTOR = 306402531;

        public AuthorizationStateWaitPhoneNumber() {
        }

        public int getConstructor() {
            return 306402531;
        }
    }

    public static class AuthorizationStateWaitEncryptionKey extends TdApi.AuthorizationState {
        public boolean isEncrypted;
        public static final int CONSTRUCTOR = 612103496;

        public AuthorizationStateWaitEncryptionKey() {
        }

        public AuthorizationStateWaitEncryptionKey(boolean var1) {
            this.isEncrypted = var1;
        }

        public int getConstructor() {
            return 612103496;
        }
    }

    public static class AuthorizationStateWaitTdlibParameters extends TdApi.AuthorizationState {
        public static final int CONSTRUCTOR = 904720988;

        public AuthorizationStateWaitTdlibParameters() {
        }

        public int getConstructor() {
            return 904720988;
        }
    }

    public abstract static class AuthorizationState extends TdApi.Object {
        public AuthorizationState() {
        }
    }

    public static class AuthenticationCodeTypeFlashCall extends TdApi.AuthenticationCodeType {
        public String pattern;
        public static final int CONSTRUCTOR = 1395882402;

        public AuthenticationCodeTypeFlashCall() {
        }

        public AuthenticationCodeTypeFlashCall(String var1) {
            this.pattern = var1;
        }

        public int getConstructor() {
            return 1395882402;
        }
    }

    public static class AuthenticationCodeTypeCall extends TdApi.AuthenticationCodeType {
        public int length;
        public static final int CONSTRUCTOR = 1636265063;

        public AuthenticationCodeTypeCall() {
        }

        public AuthenticationCodeTypeCall(int var1) {
            this.length = var1;
        }

        public int getConstructor() {
            return 1636265063;
        }
    }

    public static class AuthenticationCodeTypeSms extends TdApi.AuthenticationCodeType {
        public int length;
        public static final int CONSTRUCTOR = 962650760;

        public AuthenticationCodeTypeSms() {
        }

        public AuthenticationCodeTypeSms(int var1) {
            this.length = var1;
        }

        public int getConstructor() {
            return 962650760;
        }
    }

    public static class AuthenticationCodeTypeTelegramMessage extends TdApi.AuthenticationCodeType {
        public int length;
        public static final int CONSTRUCTOR = 2079628074;

        public AuthenticationCodeTypeTelegramMessage() {
        }

        public AuthenticationCodeTypeTelegramMessage(int var1) {
            this.length = var1;
        }

        public int getConstructor() {
            return 2079628074;
        }
    }

    public abstract static class AuthenticationCodeType extends TdApi.Object {
        public AuthenticationCodeType() {
        }
    }

    public static class AuthenticationCodeInfo extends TdApi.Object {
        public String phoneNumber;
        public TdApi.AuthenticationCodeType type;
        public TdApi.AuthenticationCodeType nextType;
        public int timeout;
        public static final int CONSTRUCTOR = -860345416;

        public AuthenticationCodeInfo() {
        }

        public AuthenticationCodeInfo(String var1, TdApi.AuthenticationCodeType var2, TdApi.AuthenticationCodeType var3, int var4) {
            this.phoneNumber = var1;
            this.type = var2;
            this.nextType = var3;
            this.timeout = var4;
        }

        public int getConstructor() {
            return -860345416;
        }
    }

    public static class Audio extends TdApi.Object {
        public int duration;
        public String title;
        public String performer;
        public String fileName;
        public String mimeType;
        public TdApi.Minithumbnail albumCoverMinithumbnail;
        public TdApi.PhotoSize albumCoverThumbnail;
        public TdApi.File audio;
        public static final int CONSTRUCTOR = 1475294302;

        public Audio() {
        }

        public Audio(int var1, String var2, String var3, String var4, String var5, TdApi.Minithumbnail var6, TdApi.PhotoSize var7, TdApi.File var8) {
            this.duration = var1;
            this.title = var2;
            this.performer = var3;
            this.fileName = var4;
            this.mimeType = var5;
            this.albumCoverMinithumbnail = var6;
            this.albumCoverThumbnail = var7;
            this.audio = var8;
        }

        public int getConstructor() {
            return 1475294302;
        }
    }

    public static class Animations extends TdApi.Object {
        public TdApi.Animation[] animations;
        public static final int CONSTRUCTOR = 344216945;

        public Animations() {
        }

        public Animations(TdApi.Animation[] var1) {
            this.animations = var1;
        }

        public int getConstructor() {
            return 344216945;
        }
    }

    public static class Animation extends TdApi.Object {
        public int duration;
        public int width;
        public int height;
        public String fileName;
        public String mimeType;
        public TdApi.Minithumbnail minithumbnail;
        public TdApi.PhotoSize thumbnail;
        public TdApi.File animation;
        public static final int CONSTRUCTOR = -1629245379;

        public Animation() {
        }

        public Animation(int var1, int var2, int var3, String var4, String var5, TdApi.Minithumbnail var6, TdApi.PhotoSize var7, TdApi.File var8) {
            this.duration = var1;
            this.width = var2;
            this.height = var3;
            this.fileName = var4;
            this.mimeType = var5;
            this.minithumbnail = var6;
            this.thumbnail = var7;
            this.animation = var8;
        }

        public int getConstructor() {
            return -1629245379;
        }
    }

    public static class Address extends TdApi.Object {
        public String countryCode;
        public String state;
        public String city;
        public String streetLine1;
        public String streetLine2;
        public String postalCode;
        public static final int CONSTRUCTOR = -2043654342;

        public Address() {
        }

        public Address(String var1, String var2, String var3, String var4, String var5, String var6) {
            this.countryCode = var1;
            this.state = var2;
            this.city = var3;
            this.streetLine1 = var4;
            this.streetLine2 = var5;
            this.postalCode = var6;
        }

        public int getConstructor() {
            return -2043654342;
        }
    }

    public static class AccountTtl extends TdApi.Object {
        public int days;
        public static final int CONSTRUCTOR = 1324495492;

        public AccountTtl() {
        }

        public AccountTtl(int var1) {
            this.days = var1;
        }

        public int getConstructor() {
            return 1324495492;
        }
    }

    public abstract static class Function extends TdApi.Object {
        public Function() {
        }

        public native String toString();
    }

    public abstract static class Object {
        public Object() {
        }

        public native String toString();

        public abstract int getConstructor();
    }
}
