package com.edts.tdlib.controller;

import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.contact.*;
import com.edts.tdlib.exception.uam.ValidationException;
import com.edts.tdlib.service.TelegramUserGroupService;
import com.edts.tdlib.util.SortableUnpaged;
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

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/contact")
public class TelegramUserGroupController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final TelegramUserGroupService telegramUserGroupService;


    @Autowired
    public TelegramUserGroupController(TelegramUserGroupService telegramUserGroupService) {
        this.telegramUserGroupService = telegramUserGroupService;
    }


    @PostMapping(value = "/create-telegram-user-group", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> createTelegramUserGroup(@RequestBody HDTelegramUserGroupBean telegramUserGroupBean) {
        telegramUserGroupService.save(telegramUserGroupBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }

    @PostMapping(value = "/create-telegram-user-group-bulk", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> createTelegramUserGroupBulk(@RequestParam("file") MultipartFile file, @RequestParam String name) throws IOException {
        telegramUserGroupService.createUserGroupBulk(file, name);
        return new GeneralWrapper<String>().success("SUCCESS");
    }

    @GetMapping(value = "/get-telegram-users-group", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Page<TelegramUserGroupBean>> getTelegramUsersGroup(String name, Pageable pageable, boolean unpaged) {
        Page<TelegramUserGroupBean> result;
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;
        result = telegramUserGroupService.getTelegramUSerGroup(name, pageable);
        return new GeneralWrapper<Page<TelegramUserGroupBean>>().success(result);
    }

    @GetMapping(value = "/telegram-users-group/find-byId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<ViewUserGroupBean> groupFindById(@PathVariable long id) {
        ViewUserGroupBean viewUserGroupBean = telegramUserGroupService.findById(id);
        return new GeneralWrapper<ViewUserGroupBean>().success(viewUserGroupBean);
    }

    @PutMapping(value = "/edit-telegram-user-group/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> editTelegramUserGroup(@PathVariable(value = "id") long id, @RequestBody HDTelegramUserGroupBean telegramUserGroupBean) {
        if (telegramUserGroupBean.getId() == 0 || telegramUserGroupBean.getId() != id) {
            throw new ValidationException("request id tidak boleh kosong / tidak sesuai");
        }
        telegramUserGroupService.edit(telegramUserGroupBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }


    @PutMapping(value = "/add-member-user-group/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> addMemberUserGroup(@PathVariable(value = "id") long id, @RequestBody AddMemberUserGroupBean addMemberUserGroupBean) {
        if (addMemberUserGroupBean.getId() == 0 || addMemberUserGroupBean.getId() != id) {
            throw new ValidationException("request id tidak boleh kosong / tidak sesuai");
        }
        telegramUserGroupService.addMemberUserGroup(addMemberUserGroupBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }


    @PostMapping(value = "/process-data-user-group", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Map<String, Object>> processDataUserGroupBulk(@RequestParam("file") MultipartFile file) throws IOException {
        Map<String, Object> objectMap = telegramUserGroupService.processDataUpload(file);
        return new GeneralWrapper<Map<String, Object>>().success(objectMap);
    }

    @DeleteMapping(value = "/delete-telegram-user-group/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> deleteTelegramUserGroup(@PathVariable long id) {
        telegramUserGroupService.delete(id);
        return new GeneralWrapper<String>().success("Deleted : " + id);
    }

    @GetMapping("/download-telegram-user-group")
    public ResponseEntity<Resource> download(String name, Pageable pageable, boolean unpaged) {

        Page<ChatRoomBean> result;
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;


        String filename = "telegram-user-group.xlsx";
        InputStreamResource file = new InputStreamResource(telegramUserGroupService.download(name ,pageable));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

}
