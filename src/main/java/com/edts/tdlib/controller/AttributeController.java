package com.edts.tdlib.controller;


import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.contact.AddUpdateAttributeBean;
import com.edts.tdlib.bean.contact.AttributeBean;
import com.edts.tdlib.bean.contact.HDTelegramUserGroupBean;
import com.edts.tdlib.bean.contact.ViewAttributeBean;
import com.edts.tdlib.exception.uam.ValidationException;
import com.edts.tdlib.service.AttributeService;
import com.edts.tdlib.util.SortableUnpaged;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/attribute")
public class AttributeController {


    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> add(@RequestBody AddUpdateAttributeBean addUpdateAttributeBean) {

        attributeService.add(addUpdateAttributeBean);

        return new GeneralWrapper<String>().success("SUCCESS");
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Page<AttributeBean>> list(String name, String dataType, Pageable pageable, boolean unpaged) {
        Page<AttributeBean> result;
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;
        result = attributeService.list(name, dataType, pageable);
        return new GeneralWrapper<Page<AttributeBean>>().success(result);
    }


    @GetMapping(value = "/find-by-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<ViewAttributeBean> findById(@PathVariable long id) {
        ViewAttributeBean attributeBean = attributeService.findById(id);
        return new GeneralWrapper<ViewAttributeBean>().success(attributeBean);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> delete(@PathVariable long id) {
        attributeService.delete(id);
        return new GeneralWrapper<String>().success("Deleted : " + id);
    }


    @PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> edit(@PathVariable(value = "id") long id, @RequestBody AddUpdateAttributeBean addUpdateAttributeBean) {
        if (addUpdateAttributeBean.getId() == 0 || addUpdateAttributeBean.getId() != id) {
            throw new ValidationException("request id tidak boleh kosong / tidak sesuai");
        }
        attributeService.edit(addUpdateAttributeBean);
        return new GeneralWrapper<String>().success("SUCCESS");
    }


    @PostMapping(value = "/process-data-member", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Map<String, Object>> processDataMember(@RequestParam("file") MultipartFile file,@RequestParam("dataType") String dataType) throws IOException {
        Map<String, Object> objectMap = attributeService.processDataUpload(file, dataType);
        return new GeneralWrapper<Map<String, Object>>().success(objectMap);
    }


    @PostMapping(value = "/add-bulk", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> addBulk(@RequestParam("file") MultipartFile file, @RequestParam String name, String dataType) throws IOException {
        attributeService.addBulk(file, new AttributeBean(name, dataType));
        return new GeneralWrapper<String>().success("SUCCESS");
    }
}
