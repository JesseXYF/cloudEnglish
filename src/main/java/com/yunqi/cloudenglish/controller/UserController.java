package com.yunqi.cloudenglish.controller;

import com.yunqi.cloudenglish.config.exception.NeedAuthenticationException;
import com.yunqi.cloudenglish.dto.ResponseDto;
import com.yunqi.cloudenglish.security.Authentication;
import com.yunqi.cloudenglish.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 14:04 2018/5/16
 * @版本 v1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Authentication authentication;

    @Autowired
    private IUserService iUserService;

    @ApiOperation(value = "获取用户信息",produces = "application/json")
    @GetMapping("/info")
    public ResponseEntity<ResponseDto> userInfo(){
        String identity = authentication.getUserName();
        if (StringUtils.isEmpty(identity)){
            throw new NeedAuthenticationException();
        }
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iUserService.useInfo(identity)), HttpStatus.OK);
    }
}
