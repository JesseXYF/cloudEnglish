package com.yunqi.cloudenglish.security;

import com.yunqi.cloudenglish.domain.UserDomain;
import com.yunqi.cloudenglish.mapper.UserExtMapper;
import com.yunqi.cloudenglish.utils.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 13:33 2018/5/14
 * @版本 v1.0
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserExtMapper userExtMapper;

    @Override
    public UserDetails loadUserByUsername(String identity) throws UsernameNotFoundException {
        UserDomain user=userExtMapper.loginByIdentity(identity);
        if (user==null){
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.",identity));
        }else {
            return JwtUserFactory.create(user);
        }
    }
}
