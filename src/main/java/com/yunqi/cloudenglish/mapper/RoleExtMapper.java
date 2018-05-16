package com.yunqi.cloudenglish.mapper;

import com.yunqi.cloudenglish.generate.model.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 13:19 2018/5/16
 * @版本 v1.0
 */
@Repository
public interface RoleExtMapper {

    @Select({"SELECT r.id,r.name",
            " FROM role as r",
            " INNER JOIN role_user as ru on r.id = ru.roleId",
            " WHERE ru.userId =#{userId}"})
    List<Role> selectRolesByUserId(@Param("userId")String userId);
}
