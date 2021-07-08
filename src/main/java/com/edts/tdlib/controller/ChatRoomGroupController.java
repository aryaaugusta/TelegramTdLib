package com.edts.tdlib.controller;

import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.contact.*;
import com.edts.tdlib.exception.uam.ValidationException;
import com.edts.tdlib.service.ChatRoomGroupService;
import com.edts.tdlib.util.SortableUnpaged;
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
@RequestMapping(value = "/api/contact/chat-room-group")
public class ChatRoomGroupController {


    private final ChatRoomGroupService chatRoomGroupService;

    public ChatRoomGroupController(ChatRoomGroupService chatRoomGroupService) {
        this.chatRoomGroupService = chatRoomGroupService;
    }


    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> add(@RequestBody ChatRoomGroupBean chatRoomGroupBean) {
        chatRoomGroupService.save(chatRoomGroupBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Page<ChatRoomGroupBean>> list(String name, Pageable pageable, boolean unpaged) {
        Page<ChatRoomGroupBean> result;
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;
        result = chatRoomGroupService.list(name, pageable);
        return new GeneralWrapper<Page<ChatRoomGroupBean>>().success(result);
    }


    @GetMapping(value = "/find-byId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<ViewChatRoomGroupBean> findById(@PathVariable long id) {
        ViewChatRoomGroupBean viewChatRoomGroupBean = chatRoomGroupService.findById(id);
        return new GeneralWrapper<ViewChatRoomGroupBean>().success(viewChatRoomGroupBean);
    }

    @PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> edit(@PathVariable(value = "id") long id, @RequestBody ChatRoomGroupBean chatRoomGroupBean) {
        if (chatRoomGroupBean.getId() == 0 || chatRoomGroupBean.getId() != id) {
            throw new ValidationException("request id tidak boleh kosong / tidak sesuai");
        }
        chatRoomGroupService.edit(chatRoomGroupBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> delete(@PathVariable(value = "id") long id) {
        chatRoomGroupService.delete(id);
        return new GeneralWrapper<String>().success("SUCCESS");
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download(String name, Pageable pageable, boolean unpaged) {

        Page<ChatRoomBean> result;
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;


        String filename = "chatroom-group.xlsx";
        InputStreamResource file = new InputStreamResource(chatRoomGroupService.download(name ,pageable));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

    @PostMapping(value = "/process-data-user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Map<String, Object>> processDataUser(@RequestParam("file") MultipartFile file) throws IOException {
        Map<String, Object> objectMap = chatRoomGroupService.processDataUpload(file);
        return new GeneralWrapper<Map<String, Object>>().success(objectMap);
    }

   @PostMapping(value = "/add-chatroom-bulk", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> addChatroomBulk(@RequestParam("file") MultipartFile file, @RequestParam String name) throws IOException {
       chatRoomGroupService.addChatroomBulk(file, name);
        return new GeneralWrapper<String>().success("SUCCESS");
    }

}
