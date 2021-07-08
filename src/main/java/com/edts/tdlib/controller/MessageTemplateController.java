package com.edts.tdlib.controller;

import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.contact.TelegramUserAuthorizationBean;
import com.edts.tdlib.bean.contact.TelegramUserGroupBean;
import com.edts.tdlib.bean.message.MessageTemplateBean;
import com.edts.tdlib.bean.message.MessageTypeBean;
import com.edts.tdlib.exception.uam.ValidationException;
import com.edts.tdlib.service.MessageTemplateService;
import com.edts.tdlib.util.SecurityUtil;
import com.edts.tdlib.util.SortableUnpaged;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/message-template")
public class MessageTemplateController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MessageTemplateService messageTemplateService;


    public MessageTemplateController(MessageTemplateService messageTemplateService) {
        this.messageTemplateService = messageTemplateService;
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> add(@RequestBody MessageTemplateBean messageTemplateBean) {
        messageTemplateBean.setCreatedBy(SecurityUtil.getEmail().get());
        messageTemplateService.save(messageTemplateBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Page<MessageTemplateBean>> list(String title, Pageable pageable, boolean unpaged) {
        Page<MessageTemplateBean> result;
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;
        result = messageTemplateService.getMessageTemplates(title, pageable);
        return new GeneralWrapper<Page<MessageTemplateBean>>().success(result);
    }

    @GetMapping(value = "/find-byId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<MessageTemplateBean> findById(@PathVariable long id) {
        MessageTemplateBean messageTemplateBean = messageTemplateService.findById(id);
        return new GeneralWrapper<MessageTemplateBean>().success(messageTemplateBean);
    }

    @PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> edit(@PathVariable(value = "id") long id, @RequestBody MessageTemplateBean messageTemplateBean) {
        if (messageTemplateBean.getId() == 0 || messageTemplateBean.getId() != id) {
            throw new ValidationException("request id tidak boleh kosong / tidak sesuai");
        }
        messageTemplateBean.setModifiedBy(SecurityUtil.getEmail().get());
        messageTemplateService.edit(messageTemplateBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> delete(@PathVariable long id) {
        messageTemplateService.delete(id);
        return new GeneralWrapper<String>().success("Deleted : " + id);
    }
}
