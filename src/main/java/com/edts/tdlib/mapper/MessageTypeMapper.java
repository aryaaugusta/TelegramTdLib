package com.edts.tdlib.mapper;

import com.edts.tdlib.bean.message.MessageTypeBean;
import com.edts.tdlib.model.message.MessageType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {}, imports = {})
public interface MessageTypeMapper extends EntityMapper<MessageTypeBean, MessageType> {

    MessageTypeBean toDto(MessageType messageType);

}
