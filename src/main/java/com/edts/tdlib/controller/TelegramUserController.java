package com.edts.tdlib.controller;

import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.contact.EditTelegramUserBean;
import com.edts.tdlib.bean.contact.TelegramUserAuthorizationBean;
import com.edts.tdlib.bean.contact.TelegramUserBean;
import com.edts.tdlib.exception.uam.ValidationException;
import com.edts.tdlib.service.TelegramUserService;
import com.edts.tdlib.util.SortableUnpaged;
import org.apache.commons.compress.utils.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/contact")
public class TelegramUserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private TelegramUserService telegramUserService;

    @Autowired
    public TelegramUserController(TelegramUserService telegramUserService) {
        this.telegramUserService = telegramUserService;
    }

    @PostMapping(value = "/add-telegram-user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> addTelegramUser(@RequestBody TelegramUserAuthorizationBean telegramUserBean) throws InterruptedException {
        telegramUserService.addTelegramUser(telegramUserBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }


    @PostMapping(value = "/process-data-user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Map<String, Object>> processDataUser(@RequestParam("file") MultipartFile file) throws IOException {
        Map<String, Object> objectMap = telegramUserService.processDataUpload(file);
        return new GeneralWrapper<Map<String, Object>>().success(objectMap);
    }

    @PostMapping(value = "/add-bulk-telegram-user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> addBulkTelegramUser(@RequestBody List<TelegramUserBean> telegramUserBeanList) throws IOException {
        telegramUserService.addBulkTelegramUser(telegramUserBeanList);
        return new GeneralWrapper<String>().success("SUCCESS");
    }


    @PostMapping(value = "/add-bulk-telegram-user-by-file", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> addBulkTelegramUserByfile(@RequestParam("file") MultipartFile file) throws IOException {
        telegramUserService.addBulkTelegramUserByFile(file);
        return new GeneralWrapper<String>().success("SUCCESS");
    }


    @GetMapping(value = "/get-telegram-users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Page<TelegramUserBean>> getTelegramUsers(String name, String type ,Pageable pageable, boolean unpaged) {
        Page<TelegramUserBean> result;
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;
        result = telegramUserService.getTelegramUsers(name, type, pageable);
        return new GeneralWrapper<Page<TelegramUserBean>>().success(result);
    }

    @GetMapping(value = "/find-byId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<TelegramUserAuthorizationBean> findById(@PathVariable long id) throws ParseException {
        TelegramUserAuthorizationBean telegramUserBean = telegramUserService.findById(id);
        return new GeneralWrapper<TelegramUserAuthorizationBean>().success(telegramUserBean);
    }


    @PutMapping(value = "/edit-telegram-user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> editTelegramUser(@PathVariable(value = "id") long id, @RequestBody EditTelegramUserBean telegramUserBean) {
        if (telegramUserBean.getId() == 0 || telegramUserBean.getId() != id) {
            throw new ValidationException("request id tidak boleh kosong / tidak sesuai");
        }
        telegramUserService.editTelegramUser(id, telegramUserBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }


    @DeleteMapping(value = "/delete-telegram-user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> deleteTelegramUser(@PathVariable long id) {
        telegramUserService.delete(id);
        return new GeneralWrapper<String>().success("Deleted : " + id);
    }


    @PostMapping(value = "/sync-user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> syncUser() throws IOException {
        telegramUserService.syncUser();
        return new GeneralWrapper<String>().success("SUCCESS");
    }


    @GetMapping("/download")
    public ResponseEntity<Resource> download(String name, String type ,Pageable pageable, boolean unpaged) {
        Page<TelegramUserBean> result;
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;

        String filename = "telegram-users.xlsx";
        InputStreamResource file = new InputStreamResource(telegramUserService.downloadTelegramUser(name, type ,pageable));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }


}
