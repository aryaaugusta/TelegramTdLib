package com.edts.tdlib.service;

import com.edts.tdlib.bean.message.MessageTemplateBean;
import com.edts.tdlib.mapper.CommonMapper;
import com.edts.tdlib.mapper.MessageTemplateMapper;
import com.edts.tdlib.model.message.MessageTemplate;
import com.edts.tdlib.repository.MessageTemplateRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class MessageTemplateService {

    private final Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MessageTemplateRepo messageTemplateRepo;
    private MessageTemplateMapper messageTemplateMapper;
    private CommonMapper commonMapper;

    public MessageTemplateService(MessageTemplateRepo messageTemplateRepo, MessageTemplateMapper messageTemplateMapper, CommonMapper commonMapper) {
        this.messageTemplateRepo = messageTemplateRepo;
        this.messageTemplateMapper = messageTemplateMapper;
        this.commonMapper = commonMapper;
    }

    public void save(MessageTemplateBean messageTemplateBean) {
        messageTemplateRepo.save(messageTemplateMapper.toEntity(messageTemplateBean));
    }

    public MessageTemplateBean findById(long id) {
        Optional<MessageTemplate> optionalMessageTemplate = Optional.ofNullable(messageTemplateRepo.findById(id).orElseThrow(EntityNotFoundException::new));
        return messageTemplateMapper.toDto(optionalMessageTemplate.get());
    }

    public Page<MessageTemplateBean> getMessageTemplates(String title, Pageable pageable) {
        Page<MessageTemplate> messageTemplatePage;
        if (title == null) {
            messageTemplatePage = messageTemplateRepo.findAll(pageable);
        } else {
            messageTemplatePage = messageTemplateRepo.findAllByTitle(title, pageable);
        }

        Page<MessageTemplateBean> messageTemplateBeans = commonMapper.mapEntityPageIntoDtoPage(messageTemplatePage, MessageTemplateBean.class);
        return messageTemplateBeans;
    }

    public void edit(MessageTemplateBean messageTemplateBean) {
        Optional<MessageTemplate> optionalMessageTemplate = Optional.ofNullable(messageTemplateRepo.findById(messageTemplateBean.getId()).orElseThrow(EntityNotFoundException::new));
        MessageTemplate messageTemplate = optionalMessageTemplate.get();
        messageTemplate.setModifiedBy(messageTemplateBean.getModifiedBy());
        messageTemplate.setTitle(messageTemplate.getTitle());
        messageTemplate.setMessage(messageTemplateBean.getMessage());
        messageTemplateRepo.save(messageTemplate);
    }

    public void delete(long id) {
        Optional<MessageTemplate> optionalMessageTemplate = Optional.ofNullable(messageTemplateRepo.findById(id).orElseThrow(EntityNotFoundException::new));
        MessageTemplate messageTemplate = optionalMessageTemplate.get();
        messageTemplate.setDeleted(true);
        messageTemplateRepo.save(messageTemplate);

        Optional<Integer> s = Optional.of(0);
    }


}
