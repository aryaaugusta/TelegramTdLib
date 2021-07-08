package com.edts.tdlib.service.uam;

import com.edts.tdlib.bean.uam.HomeResponse;
import com.edts.tdlib.bean.uam.Menu;
import com.edts.tdlib.bean.uam.MenuGroup;
import com.edts.tdlib.bean.uam.Profile;
import com.edts.tdlib.model.uam.AccessRightType;
import com.edts.tdlib.model.uam.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HomeService {
    private final UserService userService;
    private final Logger log = LoggerFactory.getLogger(HomeService.class);

    @Autowired
    public HomeService(UserService userService){
        this.userService = userService;
    }

    public HomeResponse getHome(String email) {
        User user = userService.getUserByEmail(email);
        HomeResponse response = new HomeResponse();
        Profile profile = new Profile();
        profile.setName(user.getUsername());
        profile.setEmail(user.getEmail());

        Map<String, MenuGroup> groups = new HashMap<>();
        if (user.getRole() != null){
            List<Menu> totalMenu = user.getRole().getAccessRights().stream()
                    .map(accessRight -> {
                        Menu menu = new Menu();
                        AccessRightType art = accessRight.getAccessRightType();
                        menu.setCode(art.getCode());
                        menu.setLabel(art.getLabel());
                        menu.setUrl(art.getUrl());
                        menu.setOrder(art.getPosition());
                        if (accessRight.isCanRead()) {
                            menu.setEnabled(true);
                        }
                        menu.setAccessRights(accessRight);
                        if (!groups.containsKey(art.getAccessRightGroup().getCode())) {
                            MenuGroup newGroup = new MenuGroup();
                            newGroup.setCode(art.getAccessRightGroup().getCode());
                            newGroup.setName(art.getAccessRightGroup().getName());
                            newGroup.setIcon(art.getAccessRightGroup().getIcon());
                            newGroup.setOrder(art.getAccessRightGroup().getPosition());
                            List<Menu> menus = new ArrayList<>();
                            menus.add(menu);
                            newGroup.setMenus(menus);
                            groups.put(newGroup.getCode(),newGroup);
                        } else {
                            MenuGroup group = groups.get(art
                                    .getAccessRightGroup()
                                    .getCode());
                            List<Menu> menus = group.getMenus();
                            menus.add(menu);
                            menus =menus.stream().sorted(Comparator.comparingInt(Menu::getOrder)).collect(Collectors.toList());
                            group.setMenus(menus);
                            groups.replace(art.getAccessRightGroup().getCode(),group);
                        }
                        return menu;
                    }).collect(Collectors.toList());
            log.info(totalMenu.toString());
        }

        List<MenuGroup> groupAsList = new ArrayList<>(groups.values());
        groupAsList = groupAsList.stream().sorted(Comparator.comparingInt(MenuGroup::getOrder)).collect(Collectors.toList());
        response.setMenuGroups(groupAsList);
        response.setProfile(profile);

        return response;
    }
}
