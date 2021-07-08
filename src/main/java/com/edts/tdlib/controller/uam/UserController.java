package com.edts.tdlib.controller.uam;

import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.uam.*;
import com.edts.tdlib.constant.PermissionConstant;
import com.edts.tdlib.exception.HandledException;
import com.edts.tdlib.exception.uam.ValidationException;
import com.edts.tdlib.service.uam.RoleService;
import com.edts.tdlib.service.uam.UserService;
import com.edts.tdlib.util.SecurityUtil;
import com.edts.tdlib.util.uam.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.security.auth.login.LoginException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userSvc;
    private final RoleService roleSvc;

    @Autowired
    public UserController(UserService userSvc, RoleService roleSvc) {
        this.userSvc = userSvc;
        this.roleSvc = roleSvc;
    }

    @GetMapping("/status/check")
    public String status() {
        return "working";
    }

    //@PreAuthorize("hasPermission('" + PermissionConstant.MASTER_USER + "','" + PermissionConstant.CREATE_ACCESS + "')")
    @PostMapping("/new")
    public GeneralWrapper<UserBean> addUser(@RequestBody @Validated(UserBean.ValidationPasswordOnCreate.class) UserBean request) throws URISyntaxException {
        log.info("add new user : " + request.toString());
        UserBean result = userSvc.save(request);
        return new GeneralWrapper<UserBean>().success(result);
    }

    //@PreAuthorize("hasPermission('" + PermissionConstant.MASTER_USER + "','" + PermissionConstant.READ_ACCESS + "')")
    @GetMapping("/{id}")
    public GeneralWrapper<UserBean> getUser(@PathVariable long id) {
        Optional<UserBean> user = Optional.ofNullable(userSvc.findById(id).orElseThrow());
        return new GeneralWrapper<UserBean>().success(user.get());
    }

    //@PreAuthorize("hasPermission('" + PermissionConstant.MASTER_USER + "','" + PermissionConstant.READ_ACCESS + "')")
    @GetMapping("")
    public GeneralWrapper<UserListResponse> findUsers(@RequestParam Optional<String> name,@RequestParam Optional<Long> roleId, @RequestParam Optional<Integer> status, Pageable pageable) {
        Page<UserBean> users = userSvc.findAll(name.orElse(""), roleId.orElse((long) 0), status.orElse(0), pageable);
        List<RoleBean> roles = roleSvc.findAllRolesAssignedToUser();
        UserListResponse response = new UserListResponse(roles, users);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(users, "/api/users");
        return new GeneralWrapper<UserListResponse>().success(response);
    }

    //@PreAuthorize("hasPermission('" + PermissionConstant.MASTER_USER + "','" + PermissionConstant.UPDATE_ACCESS + "')")
    @PutMapping("/{id}")
    public GeneralWrapper<UserBean> editUser(@PathVariable long id, @RequestBody @Validated(UserBean.ValidationPasswordOnUpdate.class) UserBean request) throws URISyntaxException {
        if (request.getId() == 0 || request.getId() != id) {
            throw new ValidationException("request id tidak boleh kosong / tidak sesuai");
        }
        log.info("add new user : " + request.toString());
        request.setModifiedBy(SecurityUtil.getEmail().get());
        UserBean result = userSvc.save(request);
        return new GeneralWrapper<UserBean>().success(result);
    }

    //@PreAuthorize("hasPermission('" + PermissionConstant.MASTER_USER + "','" + PermissionConstant.DELETE_ACCESS + "')")
    @DeleteMapping("{id}")
    public GeneralWrapper<String> deleteUser(@PathVariable long id) throws URISyntaxException, EntityNotFoundException {
        log.info("add new user : " + id);
        userSvc.delete(id);
        return new GeneralWrapper<String>().success("Data Deleted " + id);
    }

    @PostMapping("/login")
    public GeneralWrapper<Object> login(@RequestBody LoginRequest request) throws URISyntaxException, LoginException {
        ResponseEntity<Object> res = userSvc.login(request);
        return new GeneralWrapper<Object>().success(res.getBody());
    }

    @PostMapping("/refresh")
    public GeneralWrapper<Object> refresh(@RequestBody RefreshTokenRequest request) throws URISyntaxException, LoginException {
        ResponseEntity<Object> res = userSvc.refresh(request);
        return new GeneralWrapper<Object>().success(res.getBody());
    }
}
