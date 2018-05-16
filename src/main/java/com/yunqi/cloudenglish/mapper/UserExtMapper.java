package com.yunqi.cloudenglish.mapper;

import com.yunqi.cloudenglish.domain.UserDomain;
import com.yunqi.cloudenglish.generate.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 13:34 2018/5/14
 * @版本 v1.0
 */
@Repository
public interface UserExtMapper {

   @Select({
           "select",
           "id, identity, username, password",
           "from user",
           "where identity = #{identity,jdbcType=VARCHAR}"
   })
   @Results({
           @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
           @Result(column="identity", property="identity", jdbcType=JdbcType.VARCHAR),
           @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
           @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
           @Result(property = "roles",column = "id",many = @Many(select = "com.yunqi.cloudenglish.mapper.RoleExtMapper.selectRolesByUserId"))
   })
    UserDomain loginByIdentity(@Param("identity") String identity);

   @Select({
           "select",
           "id, identity, username, password",
           "from user",
           "where identity = #{identity,jdbcType=VARCHAR}"
   })
    User selectByIdentity(@Param("identity")String identity);
}
