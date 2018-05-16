package com.yunqi.cloudenglish.service.impl;

import com.yunqi.cloudenglish.config.exception.UserExistException;
import com.yunqi.cloudenglish.domain.UserDomain;
import com.yunqi.cloudenglish.dto.UserDto;
import com.yunqi.cloudenglish.generate.mapper.RoleUserMapper;
import com.yunqi.cloudenglish.generate.mapper.UserMapper;
import com.yunqi.cloudenglish.generate.model.RoleUser;
import com.yunqi.cloudenglish.generate.model.User;
import com.yunqi.cloudenglish.mapper.UserExtMapper;
import com.yunqi.cloudenglish.modle.UserRegisterModel;
import com.yunqi.cloudenglish.modle.UserRoles;
import com.yunqi.cloudenglish.service.IUserService;
import com.yunqi.cloudenglish.utils.BeanMapperUtil;
import com.yunqi.cloudenglish.utils.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 17:47 2018/5/14
 * @版本 v1.0
 */
@Service
public class IUserServiceImpl implements IUserService{

    @Autowired
    private UserExtMapper userExtMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    @Transactional
    public boolean newUser(UserRegisterModel registerModel, UserRoles role) {
        if (userExtMapper.selectByIdentity(registerModel.getIdentity())!=null){
            throw  new UserExistException("Identity:"+registerModel.getIdentity());
        }

        User user=new User();
        user.setId(IDUtil.newId());
        user.setIdentity(registerModel.getIdentity());
        user.setUsername(registerModel.getUsername());
        user.setPassword(encoder.encode(registerModel.getPassword()));
        return userMapper.insert(user)==1 &&roleUserMapper.insert(new RoleUser(IDUtil.newId(),user.getId(),role.getId()))==1;
    }

    @Override
    public UserDto useInfo(String identity) {
        UserDomain userDomain = userExtMapper.loginByIdentity(identity);
        UserDto userDto = BeanMapperUtil.createAndCopyProperties(userDomain, UserDto.class);
        //userDto.setRoles(userDomain.getRoles());
        return userDto;
    }
}
