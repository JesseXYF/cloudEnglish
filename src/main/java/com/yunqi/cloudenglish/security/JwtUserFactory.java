package com.yunqi.cloudenglish.security;

import com.yunqi.cloudenglish.domain.UserDomain;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 13:41 2018/5/14
 * @版本 v1.0
 */
public final class JwtUserFactory {
    private JwtUserFactory() {
    }

    public static JwtUserModel create(UserDomain user){
        return JwtUserModel.newBuilder()
                .id(user.getId())
                .customerId(user.getIdentity())
                .password(user.getPassword())
                .authorities(mapToGrantedAuthorities(user.getRoles().stream().map(r->r.getName()).collect(Collectors.toList())))
                .build();
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }


}
