package com.edts.tdlib.controller;

import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.TelegramMessageBean;
import com.edts.tdlib.bean.contact.ChatRoomBean;
import com.edts.tdlib.bean.contact.EditTelegramUserBean;
import com.edts.tdlib.bean.contact.TelegramUserAuthorizationBean;
import com.edts.tdlib.bean.message.*;
import com.edts.tdlib.exception.uam.ValidationException;
import com.edts.tdlib.service.MessageService;
import com.edts.tdlib.service.MessageTaskService;
import com.edts.tdlib.util.SecurityUtil;
import com.edts.tdlib.util.SortableUnpaged;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/message")
public class MessageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MessageService messageService;
    private MessageTaskService messageTaskService;

    @Autowired
    public MessageController(MessageService messageService, MessageTaskService messageTaskService) {
        this.messageService = messageService;
        this.messageTaskService = messageTaskService;
    }

    @PostMapping(value = "/send-message", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Description("for test send message")
    public GeneralWrapper<String> sendMessage(@RequestBody TelegramMessageBean telegramMessageBean) throws IOException {
        messageService.sendText(telegramMessageBean);
        //messageService.sendTelegram(telegramMessageBean);
        return new GeneralWrapper<String>().success("Terkirim");
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> addMessage(@RequestBody AddMessageBean addMessageBean) throws ParseException {
        String email = SecurityUtil.getEmail().get();
        addMessageBean.setCreatedBy(email);
        messageTaskService.addMessageTask(addMessageBean);
        return new GeneralWrapper<String>().success("Added");
    }


    @PostMapping("/upload-file")
    public GeneralWrapper<MessageFileBean> uploadMessageFile(
            @RequestParam("file") MultipartFile multipartFile) throws IOException {
        logger.debug("Upload stamp bucket image :: ");

        MessageFileBean messageFileBean = messageService.uploadMessageFile(multipartFile, multipartFile.getContentType());
        return new GeneralWrapper<MessageFileBean>().success(messageFileBean);
    }


    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Page<MessageTaskBean>> list(String subject, String type, Integer status, Pageable pageable, boolean unpaged) {
        Page<MessageTaskBean> result;
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;

        result = messageTaskService.getMessages(subject, type, status, pageable);
        return new GeneralWrapper<Page<MessageTaskBean>>().success(result);
    }

    @GetMapping(value = "/find-byId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Map<String, String>> findById(@PathVariable long id) throws ParseException {
        Map<String, String> viewMessageTaskBean = messageTaskService.findById(id);
        return new GeneralWrapper<Map<String, String>>().success(viewMessageTaskBean);
    }

    @PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> edit(@PathVariable(value = "id") long id, @RequestBody EditMessageBean editMessageBean) {
        if (editMessageBean.getId() == 0 || editMessageBean.getId() != id) {
            throw new ValidationException("request id tidak boleh kosong / tidak sesuai");
        }
        String email = SecurityUtil.getEmail().get();
        editMessageBean.setModifiedBy(email);
        messageTaskService.editMessage(editMessageBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> delete(@PathVariable long id) {
        messageTaskService.delete(id);
        return new GeneralWrapper<String>().success("Deleted : " + id);
    }

    @PostMapping(value = "/test-message", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> testSendMessage(@RequestParam long chatId, @RequestParam int iterator, @RequestParam String message) {
        for (int i = 0; i <= iterator; i++) {
            String msg = i + "-" + message;
            messageService.sendText(new TelegramMessageBean(chatId, msg, null));
        }

        return new GeneralWrapper<String>().success("SUCCESS");
    }

}
