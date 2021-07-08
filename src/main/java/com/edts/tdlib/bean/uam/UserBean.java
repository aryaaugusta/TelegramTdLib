package com.edts.tdlib.bean.uam;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class UserBean implements Serializable {
    public interface ValidationPasswordOnCreate {
    }

    public interface ValidationPasswordOnUpdate {
    }

    private long id;
    @NotNull(message = "general.empty", groups = {ValidationPasswordOnCreate.class, ValidationPasswordOnUpdate.class})
    @Size(max = 50, message = "user.name.size", groups = {ValidationPasswordOnCreate.class, ValidationPasswordOnUpdate.class})
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "user.name.pattern", groups = {ValidationPasswordOnCreate.class, ValidationPasswordOnUpdate.class})
    private String username;
    @NotNull(message = "general.empty", groups = {ValidationPasswordOnCreate.class, ValidationPasswordOnUpdate.class})
    @Size(max = 12, message = "user.phone.size", groups = {ValidationPasswordOnCreate.class, ValidationPasswordOnUpdate.class})
    @Pattern(regexp = "^[0-9]+$", message = "user.phone.pattern", groups = {})
    private String phone = "n/a";
    @NotNull(message = "general.empty", groups = {ValidationPasswordOnCreate.class, ValidationPasswordOnUpdate.class})
    @Email(message = "user.email.valid", groups = {ValidationPasswordOnCreate.class, ValidationPasswordOnUpdate.class})
    @Size(max = 50, message = "user.email.max.char", groups = {ValidationPasswordOnCreate.class, ValidationPasswordOnUpdate.class})
    private String email;
    @Pattern(regexp = "^[\\[\\-\\\\\\]*/$=^()A-Za-z0-9 !\"',:;<>?_@.|{}%`~#&+]*$", message = "user.secret.pattern", groups = {ValidationPasswordOnCreate.class, ValidationPasswordOnUpdate.class})
    @NotNull(message = "general.empty", groups = {ValidationPasswordOnCreate.class, ValidationPasswordOnUpdate.class})
    @Size(
            min = 8,
            max = 15,
            message = "user.secret.size",
            groups = {ValidationPasswordOnCreate.class})
    private String secret = "";
    @NotNull(message = "general.empty", groups = {ValidationPasswordOnCreate.class, ValidationPasswordOnUpdate.class})
    private Long roleId;
    private String roleName = "n/a";
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<RoleBean> roles;

    private String firstName;
    private String lastName;
    private String modifiedBy;
    private Date modifiedDate;
    private int status;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<RoleBean> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleBean> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", secret='" + secret + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
