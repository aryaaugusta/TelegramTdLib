package com.edts.tdlib.controller.uam;


import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.uam.ChangePasswordBean;
import com.edts.tdlib.bean.uam.ResetPasswordBean;
import com.edts.tdlib.exception.HandledException;
import com.edts.tdlib.service.uam.ForgotPasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.security.auth.login.LoginException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/recovery")
public class RecoveryController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final ForgotPasswordService forgotPasswordService;

    public RecoveryController(ForgotPasswordService forgotPasswordService) {
        this.forgotPasswordService = forgotPasswordService;
    }

    @GetMapping(value = "/forgot-password/get-code/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> getCode(@PathVariable String email) throws MessagingException {

        forgotPasswordService.getVerificationCode(email);

        return new GeneralWrapper<String>().success("Success");
    }

    @PostMapping(value = "/forgot-password/verification-code", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<Map<String, Object>> verificationCode(@RequestBody Map<String, Object> param) throws MessagingException {

        String email = param.get("email").toString();
        String code = param.get("code").toString();

        Boolean verCode = forgotPasswordService.verificationCode(email, code);
        Map<String, Object> objReturn = new HashMap<>();
        objReturn.put("email", param.get("email").toString());
        objReturn.put("isValid", verCode);

        return new GeneralWrapper<Map<String, Object>>().success(objReturn);
    }


    @PostMapping(value = "/forgot-password/reset-password", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> resetPassword(@RequestBody ResetPasswordBean resetPasswordBean) throws URISyntaxException {

        if (!resetPasswordBean.getNewPassword().equals(resetPasswordBean.getConfirmNewPassword())) {
            throw new HandledException("Password tidak sama");
        }

        forgotPasswordService.resetPassword(resetPasswordBean);

        return new GeneralWrapper<String>().success("Success");
    }


    @PostMapping(value = "/change-password", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GeneralWrapper<String> changePassword(@RequestBody ChangePasswordBean changePasswordBean) throws URISyntaxException, LoginException {

        if (!changePasswordBean.getNewPassword().equals(changePasswordBean.getConfirmNewPassword())) {
            throw new HandledException("Password tidak sama");
        }

        forgotPasswordService.changePassword(changePasswordBean);

        return new GeneralWrapper<String>().success("Success");
    }

}
