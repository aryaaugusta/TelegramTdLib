package com.edts.tdlib.service.uam;

import com.edts.tdlib.bean.uam.ChangePasswordBean;
import com.edts.tdlib.bean.uam.LoginRequest;
import com.edts.tdlib.bean.uam.ResetPasswordBean;
import com.edts.tdlib.constant.GeneralConstant;
import com.edts.tdlib.exception.HandledException;
import com.edts.tdlib.model.SystemConfiguration;
import com.edts.tdlib.model.uam.ForgotPassword;
import com.edts.tdlib.model.uam.User;
import com.edts.tdlib.repository.SystemConfigurationRepo;
import com.edts.tdlib.repository.uam.ForgotPasswordRepository;
import com.edts.tdlib.repository.uam.UserRepository;
import com.edts.tdlib.service.EmailService;
import com.edts.tdlib.service.uam.auth.AuthService;
import com.edts.tdlib.util.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.persistence.EntityNotFoundException;
import javax.security.auth.login.LoginException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class ForgotPasswordService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ForgotPasswordRepository forgotPasswordRepository;
    private final EmailService emailService;
    private final AuthService authSvc;
    private final SystemConfigurationRepo systemConfigurationRepo;

    @Autowired
    public ForgotPasswordService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ForgotPasswordRepository forgotPasswordRepository,
                                 EmailService emailService, AuthService authSvc, SystemConfigurationRepo systemConfigurationRepo) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.forgotPasswordRepository = forgotPasswordRepository;
        this.emailService = emailService;
        this.authSvc = authSvc;
        this.systemConfigurationRepo = systemConfigurationRepo;
    }


    public String getVerificationCode(String email) throws MessagingException {

        User user = userRepository.findByEmail(email).filter(u -> u.getStatus() == 1).orElseThrow(EntityNotFoundException::new);


        String code = String.valueOf(generateCode(6));

        forgotPasswordRepository.findByUser(user).ifPresentOrElse(f -> {
            f.setCode(code);
            f.setCodeEncryption(bCryptPasswordEncoder.encode(code));
            f.setGenerateDate(new Date());
            forgotPasswordRepository.save(f);
        }, () -> {
            ForgotPassword forgotPassword = new ForgotPassword();
            forgotPassword.setUser(user);
            forgotPassword.setCode(code);
            forgotPassword.setCodeEncryption(bCryptPasswordEncoder.encode(code));
            forgotPasswordRepository.save(forgotPassword);
        });


        emailService.sendMailHtml(email, code, user.getFirstName());

        return code;
    }

    public Boolean verificationCode(String email, String code) {
        Boolean verify = false;

        User user = userRepository.findByEmail(email).filter(u -> u.getStatus() == 1).orElseThrow(EntityNotFoundException::new);
        ForgotPassword forgotPassword = forgotPasswordRepository.findByUser(user).orElseThrow(EntityNotFoundException::new);

        Boolean isMatch = bCryptPasswordEncoder.matches(code, forgotPassword.getCodeEncryption());
        Boolean notExpire = isExpire(forgotPassword);

        if (isMatch && notExpire) {
            verify = true;
        }

        return verify;
    }

    public void resetPassword(ResetPasswordBean resetPasswordBean) throws URISyntaxException {
        User user = userRepository.findByEmail(resetPasswordBean.getEmail()).filter(u -> u.getStatus() == 1).orElseThrow(EntityNotFoundException::new);
        ForgotPassword forgotPassword = forgotPasswordRepository.findByUser(user).orElseThrow(EntityNotFoundException::new);

        Boolean isMatch = bCryptPasswordEncoder.matches(resetPasswordBean.getCode(), forgotPassword.getCodeEncryption());
        Boolean notExpire = isExpire(forgotPassword);

        if (isMatch && notExpire) {
            authSvc.createOrUpdate("update", user, resetPasswordBean.getNewPassword());
        } else {
            throw new HandledException("Kode kadaluarsa atau tidak valid");
        }

    }


    public void changePassword(ChangePasswordBean changePasswordBean) throws URISyntaxException, LoginException {

        //Cek valid old password with get token
        String username = SecurityUtil.getUsername().get();
        LoginRequest request = new LoginRequest();
        request.setPassword(changePasswordBean.getOldPassword());
        request.setUsername(username);
        ResponseEntity<Object> obj = authSvc.login(request);


        String email = SecurityUtil.getEmail().get();
        User user = userRepository.findByEmail(email).filter(u -> u.getStatus() == 1).orElseThrow(EntityNotFoundException::new);
        authSvc.createOrUpdate("update", user, changePasswordBean.getNewPassword());
    }


    private char[] generateCode(int length) {
        String numbers = "1234567890";
        Random random = new Random();
        char[] code = new char[length];

        for (int i = 0; i < length; i++) {
            code[i] = numbers.charAt(random.nextInt(numbers.length()));
        }
        return code;
    }

    private Boolean isExpire(ForgotPassword forgotPassword) {
        boolean expireReturn = false;
        long diffInMillies = Math.abs(new Date().getTime() - forgotPassword.getGenerateDate().getTime());
        long diff = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        Optional<SystemConfiguration> optionalSystemConfiguration = systemConfigurationRepo.findByGroupKeyAndKeyParam(GeneralConstant.GROUP_KEY_EXPIRE, GeneralConstant.KEY_PARAM_CODE_PASS);

        if (optionalSystemConfiguration.isPresent()) {
            int countSecond = (int) diff;
            int paramExpire = Integer.parseInt(optionalSystemConfiguration.get().getValueParam());
            if (countSecond < paramExpire) {
                expireReturn = true;
            }
        }

        return expireReturn;
    }


}
