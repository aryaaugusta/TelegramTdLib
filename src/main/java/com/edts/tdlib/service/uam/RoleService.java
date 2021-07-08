package com.edts.tdlib.service.uam;

import com.edts.tdlib.bean.uam.Menu;
import com.edts.tdlib.bean.uam.MenuGroup;
import com.edts.tdlib.bean.uam.RoleBean;
import com.edts.tdlib.mapper.uam.RoleMapper;
import com.edts.tdlib.model.uam.*;
import com.edts.tdlib.repository.uam.*;
import com.edts.tdlib.service.uam.auth.AuthService;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final AuthService authService;

    private final RoleRepository roleRepository;
    private final AccessRightTypeRepository artRepository;
    private final AccessRightRepository accessRightRepository;
    private final UserRepository userRepository;
    private final RoleMapper roleMapper;
    private final Logger log = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    public RoleService(AuthService authService, RoleRepository roleRepository, AccessRightTypeRepository artRepository, AccessRightRepository accessRightRepository, UserRepository userRepository, RoleMapper roleMapper) {
        this.authService = authService;
        this.roleRepository = roleRepository;
        this.artRepository = artRepository;
        this.accessRightRepository = accessRightRepository;
        this.userRepository = userRepository;
        this.roleMapper = roleMapper;
    }

    public RoleBean save(RoleBean request) {
        Role role = roleMapper.toEntity(request);
        List<List<AccessRight>> accessRights =request.getMenuGroups().stream().map(menuGroup -> {
            AccessRightGroup arg = new AccessRightGroup();
            arg.setId(menuGroup.getId());
            return menuGroup.getMenus().stream().map(menu -> {
                AccessRightType art = new AccessRightType();
                art.setId(menu.getId());
                art.setAccessRightGroup(arg);
                AccessRight ar = new AccessRight();
                ar.setAccessRightType(art);
                ar.setId(menu.getAccessRights().getId());
                ar.setCanCreate(menu.getAccessRights().isCanCreate());
                ar.setCanRead(menu.getAccessRights().isCanRead());
                ar.setCanUpdate(menu.getAccessRights().isCanUpdate());
                ar.setCanDelete(menu.getAccessRights().isCanDelete());
                return ar;
            }).collect(Collectors.toList());
        }).collect(Collectors.toList());
        List<AccessRight> arlist = accessRights.stream().flatMap(List::stream).collect(Collectors.toList());
        role = roleRepository.save(role);
        long roleId = role.getId();
        arlist.forEach(accessRight -> {
            Role r = new Role();
            r.setId(roleId);
            accessRight.setRole(r);
        });
        accessRightRepository.saveAll(arlist);
        request.setId(roleId);
        userRepository.findUsersByRoleId(roleId).forEach(user -> {
            try {
                authService.createOrUpdate("update",user, Strings.EMPTY);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
        return request;
    }
    public RoleBean getCreateBody() {
        RoleBean roleBean = new RoleBean();
        List<AccessRightType> artList = artRepository.findAll();
        List<Map<Optional<AccessRight>,AccessRightType>>
                listOfMap = artList.stream()
                .map(accessRightType -> {
                    Map<Optional<AccessRight>,AccessRightType> aMap = new HashMap<>();
                    aMap.put(Optional.empty(),accessRightType);
                    return aMap;
                }).collect(Collectors.toList());
        roleBean.setMenuGroups(mapAccessRightsToMenus(listOfMap));
        return roleBean;
    }
    public Page<RoleBean> findAll(Pageable pageable) {
        Page<RoleBean> roleBeans = roleRepository.findAll(pageable).map(roleMapper::toDto);
//        List<RoleBean> roles = roleMapper.toDto(roleRepository.findAll(pageable));
        Map<Long, Integer> mapOfUserCount =
                roleRepository
                        .getUserCountGroupByRole()
                        .stream()
                        .collect(
                                Collectors
                                        .toMap(IUserCountByRole::getRoleId,IUserCountByRole::getUserCount)
                        );
        roleBeans.forEach(roleBean -> {
            if (mapOfUserCount.containsKey(roleBean.getId())){
                roleBean.setUserInRoleCount(mapOfUserCount.get(roleBean.getId()));
            }
        });
//        roles.forEach(roleBean -> {
//            if (mapOfUserCount.containsKey(roleBean.getId())){
//                roleBean.setUserInRoleCount(mapOfUserCount.get(roleBean.getId()));
//            }
//        });
        return roleBeans;
    }
    public Optional<RoleBean> findById(long id) {
        Optional<Role> found= roleRepository.findById(id);
        if(found.isEmpty()) {
            return Optional.empty();
        }
        List<Map<Optional<AccessRight>,AccessRightType>> accessRightTypes =
                found.get().getAccessRights()
                        .stream()
                        .map(accessRight -> {
                            Map<Optional<AccessRight>,AccessRightType> aMap = new HashMap<>();
                            aMap.put(Optional.of(accessRight),accessRight.getAccessRightType());
                            return aMap;
                        }).collect(Collectors.toList());
       RoleBean data = roleMapper.toDto(found.get());
       data.setUserInRoleCount(userRepository.countByRoleId(id));
       data.setMenuGroups(mapAccessRightsToMenus(accessRightTypes));
        return Optional.of(data);
    }
    public List<RoleBean> findAllRolesAssignedToUser() {
        return roleRepository.findAllRolesAssignedToUser().stream().map(roleMapper::toDto).collect(Collectors.toList());
    }
    public void deleteById(long id){
        List<User> userList = userRepository.findUsersByRoleId(id);
        userList.forEach(user -> user.setRole(null));
        roleRepository.deleteById(id);
        accessRightRepository.deleteAccessRightsByRoleId(id);

        userRepository.saveAll(userList);
    }

    private List<MenuGroup> mapAccessRightsToMenus(List<Map<Optional<AccessRight>,AccessRightType>> accessRights) {
        Map<String,MenuGroup> menuGroups = new HashMap<>();
        List<Menu> retVal = accessRights.stream().map(aMap -> {
            Menu menu = new Menu();
            MenuGroup menuGroup;
            List<Menu> menus;
            AtomicReference<AccessRight> ar = new AtomicReference<>();
            AtomicReference<AccessRightType> art = new AtomicReference<>();
            aMap.forEach((accessRight, accessRightType) -> {
                art.set(accessRightType);
                ar.set(accessRight.orElse(new AccessRight()));
            });

            AccessRightGroup arg = art.get().getAccessRightGroup();
            menu.setId(art.get().getId());
            menu.setCode(art.get().getCode());
            menu.setLabel(art.get().getLabel());
            menu.setUrl(Objects.requireNonNullElse(art.get().getUrl(),""));
            menu.setAccessRights(ar.get());
            menu.setOrder(art.get().getPosition());
            if (!menuGroups.containsKey(arg.getCode())){
                menuGroup = new MenuGroup();
                menuGroup.setId(arg.getId());
                menuGroup.setName(arg.getName());
                menuGroup.setCode(arg.getCode());
                menuGroup.setIcon(Objects.requireNonNullElse(arg.getIcon(),""));
                menuGroup.setOrder(arg.getPosition());
                menus = new ArrayList<>();
                menus.add(menu);
                menuGroup.setMenus(menus);
                menuGroups.put(arg.getCode(),menuGroup);
            }else {
                menuGroup = menuGroups.get(arg.getCode());
                menus = menuGroup.getMenus();
                menus.add(menu);
                menuGroup.setMenus(menus.stream().sorted(Comparator.comparingInt(Menu::getOrder)).collect(Collectors.toList()));
                menuGroups.replace(arg.getCode(),menuGroup);
            }
            return menu;
        }).collect(Collectors.toList());
        log.info(retVal.toString());
        return menuGroups.values().stream().sorted(Comparator.comparingInt(MenuGroup::getOrder)).collect(Collectors.toList());
    }
}
