package com.edts.tdlib.service;

import com.edts.tdlib.TdApi;
import com.edts.tdlib.engine.GlobalVariable;
import com.edts.tdlib.helper.CoreHelper;
import com.edts.tdlib.model.TelegramAccount;
import com.edts.tdlib.repository.TelegramAccountRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TelegramAccountService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TelegramAccountRepo telegramAccountRepo;

    public TelegramAccountService(TelegramAccountRepo telegramAccountRepo) {
        this.telegramAccountRepo = telegramAccountRepo;
    }


    public void switchAccount(String enableAccount) {
        CoreHelper.accountEnable = enableAccount;
        GlobalVariable.mainTelegram.client.send(new TdApi.Close(), GlobalVariable.mainTelegram.defaultHandler);
    }

    public void closeTelegram(String disableAccount, String enableAccount) {
        CoreHelper.accountDisable = disableAccount;
        CoreHelper.accountEnable = enableAccount;
        GlobalVariable.mainTelegram.client.send(new TdApi.Close(), GlobalVariable.mainTelegram.defaultHandler);
    }

    @Transactional
    public void disableAccount(String phoneNumber) {
        telegramAccountRepo.disableAccount(phoneNumber);
    }

    @Transactional
    public void enableAccount(String phoneNumber) {
        telegramAccountRepo.enableAccount(phoneNumber);
    }

    public TelegramAccount findByEnableEquals(boolean enable) {
        return telegramAccountRepo.findByEnableEquals(enable).orElseThrow();
    }

}
