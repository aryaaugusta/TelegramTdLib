package com.edts.tdlib.mapper;

import com.edts.tdlib.bean.GeneralParameterBean;
import com.edts.tdlib.model.GeneralParameter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {}, imports = {})
public interface GeneralParameterMapper extends EntityMapper<GeneralParameterBean, GeneralParameter>{
    GeneralParameterBean toDto(GeneralParameter generalParameter);
}
