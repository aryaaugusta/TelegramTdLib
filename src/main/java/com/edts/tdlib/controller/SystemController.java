package com.edts.tdlib.controller;

import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.service.EmailService;
import com.edts.tdlib.service.SystemConfigurationService;
import com.edts.tdlib.service.TelegramAccountService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/system-configuration")
public class SystemController {


    private final TelegramAccountService telegramAccountService;
    private final SystemConfigurationService systemConfigurationService;
    private final EmailService emailService;

    public SystemController(TelegramAccountService telegramAccountService, SystemConfigurationService systemConfigurationService, EmailService emailService) {
        this.telegramAccountService = telegramAccountService;
        this.systemConfigurationService = systemConfigurationService;
        this.emailService = emailService;
    }


    @PutMapping(value = "/config-scheduler/{groupKey}/{keyParam}/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> configScheduler(@PathVariable String groupKey, @PathVariable String keyParam, @PathVariable String value) {
        systemConfigurationService.setSystemConfiguration(groupKey, keyParam, value);
        return new GeneralWrapper<String>().success("Success");
    }


    @PostMapping(value = "/send-mail", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> sendMail() {
        emailService.sendEmail();
        return new GeneralWrapper<String>().success("Success");
    }


   /* @PostMapping(value = "/logout}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> logout() {
        GlobalVariable.mainTelegram.client.send(new TdApi.LogOut(), GlobalVariable.mainTelegram.defaultHandler);
        return new GeneralWrapper<String>().success("Success");
    }

    @PostMapping(value = "/login}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> login() {
        GlobalVariable.mainTelegram.client = Client.create(new UpdatesHandler(), null, null); // recreate client after previous has closed
        return new GeneralWrapper<String>().success("Success");
    }*/

}
