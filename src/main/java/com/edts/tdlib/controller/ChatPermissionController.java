package com.edts.tdlib.controller;

import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.contact.ChatPermissionBean;
import com.edts.tdlib.bean.contact.MemberPermissionBean;
import com.edts.tdlib.service.ChatRoomPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/chat-permission/")
public class ChatPermissionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ChatRoomPermissionService chatRoomPermissionService;

    public ChatPermissionController(ChatRoomPermissionService chatRoomPermissionService) {
        this.chatRoomPermissionService = chatRoomPermissionService;
    }

    @PostMapping(value = "/set-chat-room", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> setChatRoomPermission(@RequestBody ChatPermissionBean chatPermissionBean) {
        chatRoomPermissionService.updateChatRoomPermissionToTelegram(chatPermissionBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }

    @GetMapping(value = "/chat-room-permission/find-one/{chatId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<ChatPermissionBean> findByChatIdAndUserId(@PathVariable long chatId) {
        ChatPermissionBean chatPermissionBean = chatRoomPermissionService.findByChatId(chatId);
        return new GeneralWrapper<ChatPermissionBean>().success(chatPermissionBean);
    }


    @PostMapping(value = "/set-member-permission", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> restrictedMember(@RequestBody MemberPermissionBean memberPermissionBean) {
        chatRoomPermissionService.setMemberPermission(memberPermissionBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }

    @PutMapping(value = "/set-member-status-member/{chatId}/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> setMemberStatusMember(@PathVariable long chatId, @PathVariable int userId) {
        chatRoomPermissionService.setMemberStatusMember(chatId, userId);
        return new GeneralWrapper<String>().success("SUCCESS");
    }

    @GetMapping(value = "/member-permission/find-one/{chatId}/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Map<String, Object>> findByChatIdAndUserId(@PathVariable long chatId, @PathVariable int userId) {
        Map<String, Object> result = chatRoomPermissionService.findByChatIdAndUserTelegramId(chatId, userId);
        return new GeneralWrapper<Map<String, Object>>().success(result);
    }

}
