package com.edts.tdlib.service;

import com.edts.tdlib.bean.GeneralParameterBean;
import com.edts.tdlib.mapper.CommonMapper;
import com.edts.tdlib.mapper.GeneralParameterMapper;
import com.edts.tdlib.model.GeneralParameter;
import com.edts.tdlib.repository.GeneralParameterRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralParameterService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final CommonMapper commonMapper;
    private final GeneralParameterRepo generalParameterRepo;
    private final GeneralParameterMapper generalParameterMapper;

    public GeneralParameterService(CommonMapper commonMapper, GeneralParameterRepo generalParameterRepo, GeneralParameterMapper generalParameterMapper) {
        this.commonMapper = commonMapper;
        this.generalParameterRepo = generalParameterRepo;
        this.generalParameterMapper = generalParameterMapper;
    }


    public List<GeneralParameterBean> listAllParamByGroup(String groupParam) {
        List<GeneralParameter> generalParameters = (List<GeneralParameter>) generalParameterRepo.findAllByGroupParam(groupParam);
        return commonMapper.mapList(generalParameters, GeneralParameterBean.class);
    }

    public GeneralParameterBean findOneById(long id) {
        return (GeneralParameterBean) generalParameterMapper.toDto(generalParameterRepo.findById(id).orElseThrow());
    }

}
