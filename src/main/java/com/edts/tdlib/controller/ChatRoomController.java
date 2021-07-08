package com.edts.tdlib.controller;

import com.edts.tdlib.TdApi;
import com.edts.tdlib.bean.AddMembersRequestBean;
import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.contact.*;
import com.edts.tdlib.engine.GlobalVariable;
import com.edts.tdlib.engine.handler.ChatRoomHandler;
import com.edts.tdlib.engine.handler.UpdatesHandler;
import com.edts.tdlib.exception.uam.ValidationException;
import com.edts.tdlib.service.ChatRoomPermissionService;
import com.edts.tdlib.service.ChatRoomService;
import com.edts.tdlib.util.GeneralUtil;
import com.edts.tdlib.util.SortableUnpaged;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/contact/chat-room")
public class ChatRoomController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ChatRoomService chatRoomService;


    public ChatRoomController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @PostMapping(value = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> newGroup(@RequestBody ChatRoomRequestBean chatRoomRequestBean) {
        chatRoomService.addSuperGroup(chatRoomRequestBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }


    @PostMapping(value = "/add-members", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> addMembersGroup(@RequestBody AddMembersRequestBean addMembersRequestBean) {
        chatRoomService.addMembersGroup(addMembersRequestBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }


    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Page<ChatRoomBean>> list(String name, Pageable pageable, boolean unpaged) {
        Page<ChatRoomBean> result;
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;
        result = chatRoomService.getChatRooms(name, pageable);
        return new GeneralWrapper<Page<ChatRoomBean>>().success(result);
    }

    @PostMapping(value = "/process-data-user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Map<String, Object>> processDataUser(@RequestParam("file") MultipartFile file) throws IOException {
        Map<String, Object> objectMap = chatRoomService.processDataUpload(file);
        return new GeneralWrapper<Map<String, Object>>().success(objectMap);
    }

    @PostMapping(value = "/new-group-member-bulk", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> newGroupMemberBulk(@RequestParam("file") MultipartFile file, @RequestParam String name) throws IOException {
        chatRoomService.newChatRoomMemberBulk(file, name);
        return new GeneralWrapper<String>().success("SUCCESS");
    }


    @GetMapping(value = "/find-byId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<ChatRoomBean> findById(@PathVariable long id) throws ParseException {
        ChatRoomBean chatRoomBean = chatRoomService.findById(id);
        return new GeneralWrapper<ChatRoomBean>().success(chatRoomBean);
    }


    @PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> edit(@PathVariable(value = "id") long id, @RequestBody EditChatRoomBean editChatRoomBean) {
        if (editChatRoomBean.getId() == 0 || editChatRoomBean.getId() != id) {
            throw new ValidationException("request id tidak boleh kosong / tidak sesuai");
        }
        chatRoomService.editChatRoom(editChatRoomBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> delete(@PathVariable long id) {
        chatRoomService.delete(id);
        return new GeneralWrapper<String>().success("Deleted : " + id);
    }


    @PostMapping(value = "/get-members", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> getMembersGroup(@RequestParam long groupId) {
        chatRoomService.getChatMembersTelegram(groupId);
        return new GeneralWrapper<String>().success("SUCCESS");
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download(String name, Pageable pageable, boolean unpaged) {

        Page<ChatRoomBean> result;
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;


        String filename = "chatroom.xlsx";
        InputStreamResource file = new InputStreamResource(chatRoomService.downloadChatroom(name ,pageable));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }
}