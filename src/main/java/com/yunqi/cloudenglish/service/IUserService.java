package com.yunqi.cloudenglish.service;

import com.yunqi.cloudenglish.dto.UserDto;
import com.yunqi.cloudenglish.modle.UserRegisterModel;
import com.yunqi.cloudenglish.modle.UserRoles;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 17:47 2018/5/14
 * @版本 v1.0
 */
public interface IUserService {
    boolean newUser(UserRegisterModel registerModel, UserRoles user);

    UserDto useInfo(String identity);
}
