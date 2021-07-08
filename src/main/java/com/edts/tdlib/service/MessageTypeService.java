package com.edts.tdlib.service;

import com.edts.tdlib.bean.message.MessageTypeBean;
import com.edts.tdlib.mapper.CommonMapper;
import com.edts.tdlib.mapper.EntityMapper;
import com.edts.tdlib.mapper.MessageTypeMapper;
import com.edts.tdlib.model.message.MessageType;
import com.edts.tdlib.repository.MessageTypeRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageTypeService {


    private final Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MessageTypeRepo messageTypeRepo;
    private CommonMapper commonMapper;
    private MessageTypeMapper messageTypeMapper;
    ;

    public MessageTypeService(MessageTypeRepo messageTypeRepo, CommonMapper commonMapper, MessageTypeMapper messageTypeMapper) {
        this.messageTypeRepo = messageTypeRepo;
        this.commonMapper = commonMapper;
        this.messageTypeMapper = messageTypeMapper;
    }

    public List<MessageTypeBean> listAllMessageType() {
        List<MessageType> messageTypes = (List<MessageType>) messageTypeRepo.findAll();
        return commonMapper.mapList(messageTypes, MessageTypeBean.class);
    }

    public MessageTypeBean findOneById(long id) {
        return (MessageTypeBean) messageTypeMapper.toDto(messageTypeRepo.findById(id).orElseThrow());
    }

}
