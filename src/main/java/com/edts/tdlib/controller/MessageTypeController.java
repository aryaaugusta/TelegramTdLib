package com.edts.tdlib.controller;

import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.message.MessageTypeBean;
import com.edts.tdlib.service.MessageTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class MessageTypeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MessageTypeService messageTypeService;

    public MessageTypeController(MessageTypeService messageTypeService) {
        this.messageTypeService = messageTypeService;
    }

    @GetMapping(value = "/message-type-list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<List<MessageTypeBean>> listAll()  {
        return new GeneralWrapper<List<MessageTypeBean>>().success(messageTypeService.listAllMessageType());
    }

    @GetMapping(value = "/message-type-find-byId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<MessageTypeBean> findById(@PathVariable long id)  {
        return new GeneralWrapper<MessageTypeBean>().success(messageTypeService.findOneById(id));
    }

}
