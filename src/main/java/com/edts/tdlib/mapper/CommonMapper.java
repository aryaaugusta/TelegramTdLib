package com.edts.tdlib.mapper;

import com.edts.tdlib.bean.LoggerBean;
import com.edts.tdlib.bean.message.MessageTypeBean;
import com.edts.tdlib.model.message.MessageType;
import com.edts.tdlib.util.ExceptionUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommonMapper {

    @Value("${spring.application.name}")
    private String applicationName;


    private final ModelMapper modelMapper = new ModelMapper();

    /*
     * Create new modelMapper
     * */
    public ModelMapper getMapper() {
        return modelMapper;
    }

    /**
     * Mapping from {@link Throwable} subclasses to {@link LoggerBean}
     *
     * @param ex exception
     * @return {@link LoggerBean}
     */
    public LoggerBean toLoggerBean(Throwable ex) {
        LoggerBean loggerBean = new LoggerBean();
        loggerBean.setProjectName(applicationName);
        loggerBean.setErrorClass(ex.getClass().getName());
        loggerBean.setErrorMessage(ex.getMessage());
        loggerBean.setStackTraces(ExceptionUtil.filterStackTraceElements(ex.getStackTrace()));
        return loggerBean;
    }

    /**
     * Mapping from {@link Throwable} subclasses to {@link LoggerBean} with message broker info
     *
     * @param topic        Message broker topic
     * @param topicMessage Message broker message
     * @param ex           exception
     * @return {@link LoggerBean}
     */
    public LoggerBean toMessageBrokerLoggerBean(String topic, String topicMessage, Throwable ex) {
        LoggerBean loggerBean = new LoggerBean();
        loggerBean.setProjectName(applicationName);
        loggerBean.setErrorClass(ex.getClass().getName());
        loggerBean.setErrorMessage(ex.getMessage());
        loggerBean.setStackTraces(ExceptionUtil.filterStackTraceElements(ex.getStackTrace()));
        loggerBean.setTopic(topic);
        loggerBean.setTopicMessage(topicMessage);
        return loggerBean;
    }


    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }

    public <D, T> Page<D> mapEntityPageIntoDtoPage(Page<T> entities, Class<D> dtoClass) {
        return entities.map(objectEntity -> getMapper().map(objectEntity, dtoClass));
    }

    public Object convertToDto(Object obj, Object mapper) {
        return new ModelMapper().map(obj, mapper.getClass());
    }


}
