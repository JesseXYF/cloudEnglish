package com.yunqi.cloudenglish.config.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 11:38 2018/5/17
 * @版本 v1.0
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint,Serializable{
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        Map<String,Object> result=new HashMap<>();
        Map<String,Object> header=new HashMap<>();
        if (authException instanceof BadCredentialsException){
            /**身份认证未通过*/
            header.put("errorcode","8002");
            header.put("errorinfo","用户名或密码错误，请重新输入！");
            result.put("header",header);
        }else {
            header.put("errorcode","8001");
            header.put("errorinfo","无效的token");
            result.put("header",header);
        }
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
    }
}
