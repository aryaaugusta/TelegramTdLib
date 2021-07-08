package com.edts.tdlib.controller;

import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.service.TelegramAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/telegram-account")
public class TelegramAccountController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final TelegramAccountService telegramAccountService;

    public TelegramAccountController(TelegramAccountService telegramAccountService) {
        this.telegramAccountService = telegramAccountService;
    }

    @PutMapping(value = "/switch-account/{phoneNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> switchAccount(@PathVariable String phoneNumber) {
        telegramAccountService.switchAccount(phoneNumber);
        return new GeneralWrapper<String>().success("Success");
    }


    /*@PutMapping(value = "/disable-account/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> disableAccount(@PathVariable String phone) {
        telegramAccountService.disableAccount(phone);
        return new GeneralWrapper<String>().success("Success");
    }

    @PutMapping(value = "/enable-account/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> enableAccount(@PathVariable String phone) {
        telegramAccountService.enableAccount(phone);
        return new GeneralWrapper<String>().success("Success");
    }
*/
}
