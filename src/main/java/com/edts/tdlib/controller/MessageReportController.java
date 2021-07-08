package com.edts.tdlib.controller;

import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.MessageReportReceiverBean;
import com.edts.tdlib.bean.message.MessageReportBean;
import com.edts.tdlib.bean.message.MessageTaskBean;
import com.edts.tdlib.service.MessageReportService;
import com.edts.tdlib.util.SortableUnpaged;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/message-report")
public class MessageReportController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final MessageReportService messageReportService;

    public MessageReportController(MessageReportService messageReportService) {
        this.messageReportService = messageReportService;
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Page<MessageReportBean>> list(String subject, String type, Pageable pageable, boolean unpaged) {
        Page<MessageReportBean> result;
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;

        result = messageReportService.getMessagesReport(subject, type, pageable);
        return new GeneralWrapper<Page<MessageReportBean>>().success(result);
    }


    @GetMapping(value = "/find-message-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<List<MessageReportBean>> findById(@PathVariable long id) throws ParseException {
        List<MessageReportBean> messageReportBeans = messageReportService.findAllByMessageTaskId(id);
        return new GeneralWrapper<List<MessageReportBean>>().success(messageReportBeans);
    }

    @GetMapping(value = "/report-detail/{id}/{batch}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Map<String, Object>> reportDetail(@PathVariable long id, @PathVariable int batch) throws ParseException {
        Map<String, Object> messageReportBeans = messageReportService.reportDetail(id, batch);
        return new GeneralWrapper<Map<String, Object>>().success(messageReportBeans);
    }

    @GetMapping(value = "/recipient-list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Page<MessageReportReceiverBean>> list(long messageTaskId, int batch, String name,String status, Pageable pageable, boolean unpaged) {
        Page<MessageReportReceiverBean> result;
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;

        result = messageReportService.recipientList(messageTaskId, batch, name, status ,pageable);
        return new GeneralWrapper<Page<MessageReportReceiverBean>>().success(result);
    }

}
