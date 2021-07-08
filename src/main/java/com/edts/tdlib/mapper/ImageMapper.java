package com.edts.tdlib.mapper;

import com.edts.tdlib.bean.CDNFileBean;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    @Mapping(target = "fileId", source = "fileId")
    @Mapping(target = "url", source = "url")
    CDNFileBean toCDNFileBEAN(String fileId, String url);

}
