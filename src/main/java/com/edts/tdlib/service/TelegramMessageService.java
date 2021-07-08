package com.edts.tdlib.service;

import com.edts.tdlib.bean.message.TransferMessageBean;
import com.edts.tdlib.helper.CoreHelper;
import com.edts.tdlib.model.message.MessageReport;
import com.edts.tdlib.model.message.TelegramMessage;
import com.edts.tdlib.repository.MessageReportRepo;
import com.edts.tdlib.repository.TelegramMessageRepo;
import com.edts.tdlib.thread.MessageReportThread;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegramMessageService {


    private final Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TelegramMessageRepo telegramMessageRepo;
    private final MessageReportThread messageReportThread;
    private final MessageReportRepo messageReportRepo;

    public TelegramMessageService(TelegramMessageRepo telegramMessageRepo, MessageReportThread messageReportThread, MessageReportRepo messageReportRepo) {
        this.telegramMessageRepo = telegramMessageRepo;
        this.messageReportThread = messageReportThread;
        this.messageReportRepo = messageReportRepo;
    }

    /**
     * save and update to telegram message
     * update to message report
     */
    public void saveNewTelegramMessage(TelegramMessage telegramMessage) {
        telegramMessageRepo.save(telegramMessage);

        List<TelegramMessage> telegramMessages = telegramMessageRepo.findAllByMessageTaskIdAndBatch(telegramMessage.getMessageTaskId(), telegramMessage.getBatch());
        MessageReport messageReport = messageReportRepo.findByMessageTaskIdAndBatch(telegramMessage.getMessageTaskId(), telegramMessage.getBatch()).orElseThrow();
        messageReport.setSender(String.valueOf(telegramMessage.getSenderUserId()));
        messageReport.setSendCount(telegramMessages.size());
        messageReportRepo.save(messageReport);

    }
}
