package com.edts.tdlib.controller;

import com.edts.tdlib.bean.GeneralParameterBean;
import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.message.MessageTypeBean;
import com.edts.tdlib.service.GeneralParameterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/general-parameter")
public class GeneralParameterController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final GeneralParameterService generalParameterService;


    public GeneralParameterController(GeneralParameterService generalParameterService) {
        this.generalParameterService = generalParameterService;
    }


    @GetMapping(value = "/list-by-group/{groupParam}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<List<GeneralParameterBean>> listAll(@PathVariable String groupParam) {
        return new GeneralWrapper<List<GeneralParameterBean>>().success(generalParameterService.listAllParamByGroup(groupParam));
    }

    @GetMapping(value = "/find-byId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<GeneralParameterBean> findById(@PathVariable long id) {
        return new GeneralWrapper<GeneralParameterBean>().success(generalParameterService.findOneById(id));
    }



}
