package com.edts.tdlib.mapper;

import com.edts.tdlib.bean.message.MessageTemplateBean;
import com.edts.tdlib.model.message.MessageTemplate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageTemplateMapper  {

    private final ModelMapper modelMapper = new ModelMapper();

    /*
     * Create new modelMapper
     * */
    public ModelMapper getMapper() {
        return modelMapper;
    }


    public MessageTemplateBean toDto(MessageTemplate messageTemplate){
        return modelMapper.map(messageTemplate, MessageTemplateBean.class);
    }


    public MessageTemplate toEntity(MessageTemplateBean messageTemplateBean){
        return modelMapper.map(messageTemplateBean, MessageTemplate.class);
    }

}
