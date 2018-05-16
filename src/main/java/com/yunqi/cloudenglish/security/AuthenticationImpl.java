package com.yunqi.cloudenglish.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 14:07 2018/5/16
 * @版本 v1.0
 */
@Component
public class AuthenticationImpl implements Authentication {

    private JwtUserModel getUserDetails(){
        return (JwtUserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public String getUserId() {
        return getUserDetails().getId();
    }

    @Override
    public String getUserName() {
        return getUserDetails().getUsername();
    }
}
