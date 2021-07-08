package com.edts.tdlib.mapper;

import com.edts.tdlib.bean.message.MessageReportBean;
import com.edts.tdlib.model.message.MessageReport;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageReportMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    /*
     * Create new modelMapper
     * */
    public ModelMapper getMapper() {
        return modelMapper;
    }


    public MessageReportBean toBean(MessageReport messageReport) {
        return modelMapper.map(messageReport, MessageReportBean.class);
    }

}
