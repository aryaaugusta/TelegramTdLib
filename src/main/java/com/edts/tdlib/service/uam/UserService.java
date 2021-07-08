package com.edts.tdlib.service.uam;

import com.edts.tdlib.bean.uam.LoginRequest;
import com.edts.tdlib.bean.uam.RefreshTokenRequest;
import com.edts.tdlib.bean.uam.RoleBean;
import com.edts.tdlib.bean.uam.UserBean;
import com.edts.tdlib.exception.BadRequestException;
import com.edts.tdlib.exception.HandledException;
import com.edts.tdlib.mapper.uam.UserMapper;
import com.edts.tdlib.model.uam.Role;
import com.edts.tdlib.model.uam.User;
import com.edts.tdlib.repository.uam.RoleRepository;
import com.edts.tdlib.repository.uam.UserRepository;
import com.edts.tdlib.service.uam.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.security.auth.login.LoginException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepository;
    private final AuthService authSvc;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepo, RoleRepository roleRepository, AuthService authSvc, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.roleRepository = roleRepository;
        this.authSvc = authSvc;
        this.userMapper = userMapper;
    }

    public UserBean save(UserBean request) throws URISyntaxException {
        String method = "create";
        User oldUser = new User();
        if (request.getId() > 0) {
            method = "update";
            oldUser = userRepo.findById(request.getId()).orElseThrow(() -> new BadRequestException("User not found"));
        }
        User data = new User();
        data.setFirstName(request.getFirstName());
        data.setLastName(request.getLastName());
        data.setModifiedBy(request.getModifiedBy());
        data.setEmail(request.getEmail());
        data.setUsername(request.getUsername());
        String finalMethod = method;
        User finalOldUser = oldUser;
        if (userRepo.existsByUsernameOrEmail(request.getUsername(), request.getEmail())) {
            if (finalMethod.equals("create") ||
                    (!finalOldUser.getUsername().equals(request.getUsername()) || !finalOldUser.getEmail().equals(request.getEmail()))) {
                throw new BadRequestException("username or email is already taken");
            }
        }

        data.setId(request.getId());
        data.setEmail(request.getEmail());
        data.setPhone(request.getPhone());
        data.setStatus(request.getStatus());
        Role role = new Role();
        role.setId(request.getRoleId());
        data.setRole(role);
        data = userRepo.save(data);
        request.setId(data.getId());
        List<Role> roles = roleRepository.findAll();
        role = roles.stream().filter(role1 -> role1.getId() == request.getRoleId()).findFirst().orElseThrow(EntityNotFoundException::new);
        request.setRoles(getRoleBeansWithSelectedId(roles, request.getRoleId()));
        request.setRoleName(role.getName());
        data.setRole(role);
        authSvc.createOrUpdate(method, data, request.getSecret());
        request.setSecret("********");
        return request;
    }

    public ResponseEntity<Object> login(LoginRequest req) throws URISyntaxException, LoginException {
        return authSvc.login(req);
    }

    public User getUserByEmail(String email) {
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isEmpty()) {
            return null;
        }
        return user.get();
    }

    public ResponseEntity<Object> refresh(RefreshTokenRequest request) throws LoginException, URISyntaxException {
        return authSvc.refresh(request);
    }

    public Page<UserBean> findAll(String name, long roleId, int status, Pageable pageable) {
        if (!name.isEmpty() && roleId != 0 && status == 0) {
            return userRepo.findUsersByNameContainingAndRoleIdAndStatusNotEquals(name, roleId, 0, pageable).map(userMapper::toDto);
        }else if (!name.isEmpty() && roleId == 0 && status == 0) {
            return userRepo.findUsersByNameContainingAndStatusNotEquals(name, 0, pageable).map(userMapper::toDto);
        } else if (name.isEmpty() && roleId == 0 && status != 0) {
            return userRepo.findUserByStatusEquals(status, pageable).map(userMapper::toDto);
        } else if (name.isEmpty() && roleId != 0 && status != 0) {
            return userRepo.findUsersByRoleIdAndStatusEquals(roleId, status, pageable).map(userMapper::toDto);
        }else if (name.isEmpty() && roleId != 0 && status == 0) {
            return userRepo.findUsersByRoleIdAndStatusNotEquals(roleId, pageable).map(userMapper::toDto);
        }else if (name.isEmpty() && roleId != 0 && status != 0) {
            return userRepo.findUsersByRoleIdAndStatusEquals(roleId, status, pageable).map(userMapper::toDto);
        }
        else {
            return userRepo.findUserByStatusNotEquals(0, pageable).map(userMapper::toDto);
        }
    }

    public Optional<UserBean> findById(long id) {
        Optional<User> user = userRepo.findByIdAndStatusNotEquals(id);
        if (user.isEmpty()) {
            return Optional.empty();
        }
        List<Role> roles = roleRepository.findAll();
        List<RoleBean> roleBeans = new ArrayList<>();
        if (user.get().getRole() != null) {
            roleBeans = getRoleBeansWithSelectedId(roles, user.get().getRole().getId());
        }
        UserBean userBean = new UserBean();
        userBean.setId(user.get().getId());
        userBean.setFirstName(user.get().getFirstName());
        userBean.setLastName(user.get().getLastName());
        userBean.setModifiedBy(user.get().getModifiedBy());
        userBean.setModifiedDate(user.get().getModifiedDate());
        userBean.setUsername(user.get().getUsername());
        userBean.setPhone(user.get().getPhone());
        userBean.setEmail(user.get().getEmail());
        userBean.setStatus(user.get().getStatus());
        userBean.setRoleId(getSelectedRole(roleBeans).getId());
        userBean.setRoleName(getSelectedRole(roleBeans).getName());
        userBean.setRoles(roleBeans);
        return Optional.of(userBean);
    }

    public void delete(long id) throws URISyntaxException {
        //User user = userRepo.getOne(id);
        User user = userRepo.findById(id).orElseThrow(() -> new HandledException("Data tidak ditemukan"));

        user.setStatus(0);
        userRepo.save(user);
        authSvc.delete(user.getUsername());
    }

    private List<RoleBean> getRoleBeansWithSelectedId(List<Role> roles, long id) {
        return roles.stream().map(role1 -> {
            RoleBean r = new RoleBean();
            r.setId(role1.getId());
            r.setName(role1.getName());
            if (r.getId() == id) {
                r.setSelected(true);
            }
            return r;
        })
                .collect(Collectors.toList());
    }

    private RoleBean getSelectedRole(List<RoleBean> roleBeans) {
        if (roleBeans.size() == 0) {
            return new RoleBean();
        }
        return roleBeans.stream().filter(RoleBean::isSelected).findFirst().orElseThrow(EntityNotFoundException::new);
    }
}
