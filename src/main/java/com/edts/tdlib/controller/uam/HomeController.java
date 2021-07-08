package com.edts.tdlib.controller.uam;

import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.uam.HomeResponse;
import com.edts.tdlib.service.uam.HomeService;
import com.edts.tdlib.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {
    private final HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("")
    @ResponseBody
    public GeneralWrapper<HomeResponse> home() {
        HomeResponse response = homeService.getHome(SecurityUtil.getEmail().get());
        return new GeneralWrapper<HomeResponse>().success(response);
    }
}
