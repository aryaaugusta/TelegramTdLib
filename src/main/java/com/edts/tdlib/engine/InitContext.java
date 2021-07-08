package com.edts.tdlib.engine;

import com.edts.tdlib.helper.CoreHelper;
import com.edts.tdlib.repository.*;
import com.edts.tdlib.service.*;
import com.edts.tdlib.thread.CommandMessageThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitContext {

    @Autowired
    private TelegramUserRepo telegramUserRepo;
    @Autowired
    private ChatRoomRepo chatRoomRepo;
    @Autowired
    private ChatRoomService chatRoomService;
    @Autowired
    private TelegramUserGroupService telegramUserGroupService;
    @Autowired
    private TelegramMessageRepo telegramMessageRepo;
    @Autowired
    private MessageReportService messageReportService;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private TelegramAccountService telegramAccountService;
    @Autowired
    private ChatRoomPermissionService chatRoomPermissionService;
    @Autowired
    private CommandMessageThread commandMessageThread;
    @Autowired
    private ChatRoomMemberRepo chatRoomMemberRepo;

    @PostConstruct
    public void init() {
        CoreHelper.setTelegramMessageRepo(telegramUserRepo, chatRoomRepo, chatRoomService, telegramUserGroupService,
                telegramMessageRepo, messageReportService, telegramAccountService, chatRoomPermissionService, commandMessageThread,
                chatRoomMemberRepo);

    }

}
