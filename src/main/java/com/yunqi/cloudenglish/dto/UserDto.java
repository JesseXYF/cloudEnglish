package com.yunqi.cloudenglish.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yunqi.cloudenglish.generate.model.Role;

import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 14:17 2018/5/16
 * @版本 v1.0
 */
@JsonIgnoreProperties(value = {"password"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private String identity;

    private String username;

    private String password;

    private List<Role> roles;

    public String getIdentity() {
        return this.identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "identity='" + identity + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
