package com.edts.tdlib.controller;


import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.contact.*;
import com.edts.tdlib.exception.uam.ValidationException;
import com.edts.tdlib.repository.TelegramBotRepo;
import com.edts.tdlib.service.TelegramBotService;
import com.edts.tdlib.util.SortableUnpaged;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/telegram-bot")
public class TelegramBotController {


    private final TelegramBotService telegramBotService;

    public TelegramBotController(TelegramBotService telegramBotService) {
        this.telegramBotService = telegramBotService;
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> add(@RequestBody TelegramBotBean telegramBotBean) {

        telegramBotService.add(telegramBotBean);

        return new GeneralWrapper<String>().success("SUCCESS");
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Page<TelegramBotBean>> list(String name, Pageable pageable, boolean unpaged) {
        Page<TelegramBotBean> result;
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;
        result = telegramBotService.list(name, pageable);
        return new GeneralWrapper<Page<TelegramBotBean>>().success(result);
    }


    @GetMapping(value = "/find-by-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<TelegramBotBean> findById(@PathVariable long id) {
        TelegramBotBean telegramBotBean = telegramBotService.findById(id);
        return new GeneralWrapper<TelegramBotBean>().success(telegramBotBean);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> delete(@PathVariable long id) {
        telegramBotService.delete(id);
        return new GeneralWrapper<String>().success("Deleted : " + id);
    }


    @PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> edit(@PathVariable(value = "id") long id, @RequestBody TelegramBotBean telegramBotBean) {
        if (telegramBotBean.getId() == 0 || telegramBotBean.getId() != id) {
            throw new ValidationException("request id tidak boleh kosong / tidak sesuai");
        }
        telegramBotService.edit(telegramBotBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }

}
