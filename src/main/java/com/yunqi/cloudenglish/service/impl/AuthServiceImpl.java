package com.yunqi.cloudenglish.service.impl;

import com.yunqi.cloudenglish.modle.UserRegisterModel;
import com.yunqi.cloudenglish.modle.UserRoles;
import com.yunqi.cloudenglish.security.JwtTokenUtil;
import com.yunqi.cloudenglish.service.IAuthService;
import com.yunqi.cloudenglish.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 14:39 2018/5/14
 * @版本 v1.0
 */
@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public String login(String identity, String password) {
        UsernamePasswordAuthenticationToken upToken=new UsernamePasswordAuthenticationToken(identity,password);
        final Authentication authentication=authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails=userDetailsService.loadUserByUsername(identity);
        final String token=jwtTokenUtil.generateToken(userDetails);
        return token;
    }

    @Override
    public boolean register(UserRegisterModel registerModel) {
        return iUserService.newUser(registerModel, UserRoles.USER);
    }
}
