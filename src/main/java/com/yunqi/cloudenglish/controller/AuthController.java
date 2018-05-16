package com.yunqi.cloudenglish.controller;

import com.yunqi.cloudenglish.dto.ResponseDto;
import com.yunqi.cloudenglish.modle.req.LoginReq;
import com.yunqi.cloudenglish.modle.req.RegisterReq;
import com.yunqi.cloudenglish.modle.UserRegisterModel;
import com.yunqi.cloudenglish.service.IAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 14:36 2018/5/14
 * @版本 v1.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService iAuthService;


    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody RegisterReq registerReq){
        UserRegisterModel result=new UserRegisterModel();
        BeanUtils.copyProperties(registerReq, result);
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iAuthService.register(result)),HttpStatus.OK);
    }
    /**
     * 登录
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody LoginReq loginReq){
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iAuthService.login(loginReq.getIdentity(),loginReq.getPassword())), HttpStatus.OK);
    }
}
