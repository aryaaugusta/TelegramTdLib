package com.edts.tdlib.mapper;


import com.edts.tdlib.bean.message.MessageFileBean;
import com.edts.tdlib.model.message.MessageFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageFileMapper {

    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "fileId", source = "fileId")
    @Mapping(target = "fileUrl", source = "fileUrl")
    MessageFile toMessageFile(String createdBy, String fileId, String fileUrl);

    MessageFileBean toBean(MessageFile messageFile);
}
