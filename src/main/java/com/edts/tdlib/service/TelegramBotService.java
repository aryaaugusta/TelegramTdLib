package com.edts.tdlib.service;

import com.edts.tdlib.TdApi;
import com.edts.tdlib.bean.contact.AttributeBean;
import com.edts.tdlib.bean.contact.TelegramBotBean;
import com.edts.tdlib.bean.contact.TelegramUserBean;
import com.edts.tdlib.constant.GeneralConstant;
import com.edts.tdlib.engine.GlobalVariable;
import com.edts.tdlib.engine.TdFunctions;
import com.edts.tdlib.engine.handler.AuthorizationRequestHandler;
import com.edts.tdlib.engine.handler.UpdatesHandler;
import com.edts.tdlib.engine.handler.UserContactHandler;
import com.edts.tdlib.exception.HandledException;
import com.edts.tdlib.mapper.CommonMapper;
import com.edts.tdlib.mapper.ContactMapper;
import com.edts.tdlib.model.contact.Attribute;
import com.edts.tdlib.model.contact.TelegramBot;
import com.edts.tdlib.model.contact.TelegramUser;
import com.edts.tdlib.repository.TelegramBotRepo;
import com.edts.tdlib.repository.TelegramUserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class TelegramBotService {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final TelegramBotRepo telegramBotRepo;
    private final ContactMapper contactMapper;
    private final CommonMapper commonMapper;
    private final TelegramUserRepo telegramUserRepo;

    public TelegramBotService(TelegramBotRepo telegramBotRepo, ContactMapper contactMapper, CommonMapper commonMapper, TelegramUserRepo telegramUserRepo) {
        this.telegramBotRepo = telegramBotRepo;
        this.contactMapper = contactMapper;
        this.commonMapper = commonMapper;
        this.telegramUserRepo = telegramUserRepo;
    }

    public void add(TelegramBotBean telegramBotBean) {
        telegramUserRepo.findByUserTelegramId(telegramBotBean.getUserTelegramId()).ifPresent(b -> {
            throw new HandledException("Data duplikat");
        });
        TelegramUser telegramUser = contactMapper.toTelegramBot(telegramBotBean);
        telegramUser.setUserType(GeneralConstant.USER_TYPE_BOT);
        telegramUser.setChatId(String.valueOf(telegramBotBean.getUserTelegramId()));
        telegramUserRepo.save(telegramUser);
    }

    public void edit(TelegramBotBean telegramBotBean) {
        TelegramUser telegramUser = telegramUserRepo.findById(telegramBotBean.getId()).orElseThrow(EntityNotFoundException::new);

        telegramUser.setFirstName(telegramBotBean.getFirstName());
        telegramUserRepo.save(telegramUser);
    }


   /* public Page<TelegramBotBean> list(String name, Pageable pageable) {
        Page<TelegramBot> telegramBotPage = null;
        if (name == null) {
            telegramBotPage = telegramBotRepo.findByDeletedEquals(false, pageable);
        }else{
            telegramBotPage = telegramBotRepo.searchByParam(name, pageable);
        }

        Page<TelegramBotBean> attributeBeanPage = commonMapper.mapEntityPageIntoDtoPage(telegramBotPage, TelegramBotBean.class);
        return attributeBeanPage;
    }*/


    public Page<TelegramBotBean> list(String name, Pageable pageable) {

        String typeParam = GeneralConstant.USER_TYPE_BOT;

        Page<TelegramUser> telegramUserPage;
        if (name == null || name.isEmpty() || name.equalsIgnoreCase("")) {
            telegramUserPage = telegramUserRepo.findAll(typeParam, pageable);
        } else {
            telegramUserPage = telegramUserRepo.findAllByFirstNameOrLastName(name, typeParam, pageable);
        }

        Page<TelegramBotBean> telegramUserBeans = commonMapper.mapEntityPageIntoDtoPage(telegramUserPage, TelegramBotBean.class);
        return telegramUserBeans;
    }

    public void delete(long id) {
        TelegramUser telegramUser = telegramUserRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        telegramUser.setDeleted(true);
        telegramUserRepo.save(telegramUser);
    }


    public TelegramBotBean findById(long id) {
        TelegramUser telegramUser = telegramUserRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        return contactMapper.toTelegramBotBean(telegramUser);
    }
}
