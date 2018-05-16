package com.yunqi.cloudenglish.service;

import com.yunqi.cloudenglish.modle.UserRegisterModel;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 14:37 2018/5/14
 * @版本 v1.0
 */
public interface IAuthService {
    String login(String identity, String password);

    boolean register(UserRegisterModel registerModel);
}
