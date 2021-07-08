package com.edts.tdlib.bean.uam;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class HomeResponse implements Serializable {
    private Profile profile;
    @JsonProperty("menu_group")
    private List<MenuGroup> menuGroups;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<MenuGroup> getMenuGroups() {
        return menuGroups;
    }

    public void setMenuGroups(List<MenuGroup> Menus) {
        this.menuGroups = Menus;
    }
}
