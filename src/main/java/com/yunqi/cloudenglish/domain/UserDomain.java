package com.yunqi.cloudenglish.domain;

import com.yunqi.cloudenglish.generate.model.Role;

import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 13:36 2018/5/14
 * @版本 v1.0
 */
public class UserDomain {
    private String id;

    private String identity;

    private String username;

    private String password;

    private List<Role> roles;

    public UserDomain() {
    }

    public static Builder newBuilder(){
        return new Builder();
    }
    private UserDomain(Builder builder) {
        setId(builder.id);
        setIdentity(builder.identity);
        setUsername(builder.username);
        setPassword(builder.password);
        setRoles(builder.roles);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public static final class Builder {
        private String id;
        private String identity;
        private String username;
        private String password;
        private List<Role> roles;

        public Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder identity(String val) {
            identity = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder roles(List<Role> val) {
            roles = val;
            return this;
        }

        public UserDomain build() {
            return new UserDomain(this);
        }
    }
}
