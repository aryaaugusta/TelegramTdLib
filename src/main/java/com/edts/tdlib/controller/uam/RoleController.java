package com.edts.tdlib.controller.uam;


import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.uam.RoleBean;
import com.edts.tdlib.constant.PermissionConstant;
import com.edts.tdlib.exception.uam.ValidationException;
import com.edts.tdlib.service.uam.RoleService;
import com.edts.tdlib.util.SortableUnpaged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    //@PreAuthorize("hasPermission('" + PermissionConstant.SETTING_ROLES + "','" + PermissionConstant.CREATE_ACCESS + "')")
    @PostMapping("/create")
    public GeneralWrapper<RoleBean> create(@RequestBody @Valid RoleBean request) throws URISyntaxException {
        if (noAccessRightIsSet(request)) {
            throw new ValidationException("pilih salah satu hak akses menu terlebih dahulu");
        }
        RoleBean result = roleService.save(request);
        return new GeneralWrapper<RoleBean>().success(result);
    }

    //@PreAuthorize("hasPermission('" + PermissionConstant.SETTING_ROLES + "','" + PermissionConstant.CREATE_ACCESS + "')")
    @GetMapping("/add")
    public GeneralWrapper<RoleBean> getCreateObject() {
        return new GeneralWrapper<RoleBean>().success(roleService.getCreateBody());
    }

    //@PreAuthorize("hasPermission('" + PermissionConstant.SETTING_ROLES + "','" + PermissionConstant.READ_ACCESS + "')")
    @GetMapping("")
    public GeneralWrapper<Page<RoleBean>> getAll(@RequestParam(value = "unpaged", defaultValue = "false") boolean unpaged, @PageableDefault Pageable pageable) {
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;
        Page<RoleBean> result = roleService.findAll(pageable);
        //HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(result, "/api/role");
        return new GeneralWrapper<Page<RoleBean>>().success(result);
    }

    @GetMapping("/{id}")
    public GeneralWrapper<RoleBean> findOne(@PathVariable long id) {
        Optional<RoleBean> role = roleService.findById(id);
        return new GeneralWrapper<RoleBean>().success(role.get());
    }

    //@PreAuthorize("hasPermission('" + PermissionConstant.SETTING_ROLES + "','" + PermissionConstant.UPDATE_ACCESS + "')")
    @PutMapping("/{id}")
    public GeneralWrapper<String> edit(@PathVariable long id, @RequestBody @Valid RoleBean request) {
        if (request.getId() == 0 || request.getId() != id) {
            throw new ValidationException("request id tidak boleh kosong / tidak sesuai");
        }
        if (noAccessRightIsSet(request)) {
            throw new ValidationException("pilih salah satu hak akses menu terlebih dahulu");
        }
        boolean accessRightIdIsNotSet = request.getMenuGroups()
                .stream()
                .anyMatch(menuGroup ->
                        menuGroup.getMenus()
                                .stream()
                                .anyMatch(menu ->
                                        menu.getAccessRights().getId() == 0
                                )
                );
        if (accessRightIdIsNotSet) {
            throw new ValidationException("id object access right harus terisi (bukan 0)");
        }

        roleService.save(request);
        return new GeneralWrapper<String>().success("Updated role : " + request.getName());
    }

    //@PreAuthorize("hasPermission('" + PermissionConstant.SETTING_ROLES + "','" + PermissionConstant.DELETE_ACCESS + "')")
    @DeleteMapping("/{id}")
    public GeneralWrapper<String> delete(@PathVariable long id) {
        roleService.deleteById(id);
        return new GeneralWrapper<String>().success("Deleted : " + id);
    }

    private boolean noAccessRightIsSet(RoleBean data) {
        return data.getMenuGroups()
                .stream()
                .noneMatch(menuGroup ->
                        menuGroup.getMenus()
                                .stream()
                                .anyMatch(menu ->
                                        menu.getAccessRights().isCanDelete()
                                                || menu.getAccessRights().isCanUpdate()
                                                || menu.getAccessRights().isCanRead()
                                                || menu.getAccessRights().isCanCreate()));
    }
}
