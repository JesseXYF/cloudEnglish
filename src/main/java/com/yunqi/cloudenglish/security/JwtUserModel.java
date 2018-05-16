package com.yunqi.cloudenglish.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 13:17 2018/5/14
 * @版本 v1.0
 */
public class JwtUserModel implements UserDetails{
    private String id;
    private String customerId;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserModel() {
    }

    private JwtUserModel(Builder builder) {
        setId(builder.id);
        setCustomerId(builder.customerId);
        setPassword(builder.password);
        setAuthorities(builder.authorities);
    }

    public static Builder newBuilder(){
        return new Builder();
    }
    public static Builder newBuilder(JwtUserModel copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.customerId = copy.getCustomerId();
        builder.password = copy.getPassword();
        builder.authorities = copy.getAuthorities();
        return builder;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return customerId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public static final class Builder {
        private String id;
        private String customerId;
        private String password;
        private Collection<? extends GrantedAuthority> authorities;

        public Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder customerId(String val) {
            customerId = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder authorities(Collection<? extends GrantedAuthority> val) {
            authorities = val;
            return this;
        }

        public JwtUserModel build() {
            return new JwtUserModel(this);
        }
    }
}
