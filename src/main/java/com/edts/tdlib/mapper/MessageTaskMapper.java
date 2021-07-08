package com.edts.tdlib.mapper;

import com.edts.tdlib.bean.message.AddMessageBean;
import com.edts.tdlib.bean.message.MessageTaskBean;
import com.edts.tdlib.model.message.MessageReceiver;
import com.edts.tdlib.model.message.MessageTask;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageTaskMapper {


    private final ModelMapper modelMapper = new ModelMapper();

    /*
     * Create new modelMapper
     * */
    public ModelMapper getMapper() {
        return modelMapper;
    }


    public MessageTask toMessageTask(AddMessageBean addMessageBean) {
        return modelMapper.map(addMessageBean, MessageTask.class);
    }


}