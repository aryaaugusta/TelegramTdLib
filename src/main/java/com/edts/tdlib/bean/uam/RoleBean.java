package com.edts.tdlib.bean.uam;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class RoleBean implements Serializable {
    private long id;
    @Size(min = 1, message = "general.empty")
    private String name = "";
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description = "";
    private boolean selected;
    private int userInRoleCount;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("menu_group")
    private List<MenuGroup> menuGroups;

    public List<MenuGroup> getMenuGroups() {
        return menuGroups;
    }

    public void setMenuGroups(List<MenuGroup> menuGroups) {
        this.menuGroups = menuGroups;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserInRoleCount() {
        return userInRoleCount;
    }

    public void setUserInRoleCount(int userInRoleCount) {
        this.userInRoleCount = userInRoleCount;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
