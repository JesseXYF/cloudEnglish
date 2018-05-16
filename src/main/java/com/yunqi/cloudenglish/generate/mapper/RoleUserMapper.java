package com.yunqi.cloudenglish.generate.mapper;

import com.yunqi.cloudenglish.generate.model.RoleUser;
import com.yunqi.cloudenglish.generate.model.RoleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RoleUserMapper {
    @SelectProvider(type=RoleUserSqlProvider.class, method="countByExample")
    long countByExample(RoleUserExample example);

    @DeleteProvider(type=RoleUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(RoleUserExample example);

    @Delete({
        "delete from role_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into role_user (id, userId, ",
        "roleId)",
        "values (#{id,jdbcType=VARCHAR}, #{userid,jdbcType=VARCHAR}, ",
        "#{roleid,jdbcType=INTEGER})"
    })
    int insert(RoleUser record);

    @InsertProvider(type=RoleUserSqlProvider.class, method="insertSelective")
    int insertSelective(RoleUser record);

    @SelectProvider(type=RoleUserSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="userId", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="roleId", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<RoleUser> selectByExample(RoleUserExample example);

    @Select({
        "select",
        "id, userId, roleId",
        "from role_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="userId", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="roleId", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    RoleUser selectByPrimaryKey(String id);

    @UpdateProvider(type=RoleUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RoleUser record, @Param("example") RoleUserExample example);

    @UpdateProvider(type=RoleUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RoleUser record, @Param("example") RoleUserExample example);

    @UpdateProvider(type=RoleUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RoleUser record);

    @Update({
        "update role_user",
        "set userId = #{userid,jdbcType=VARCHAR},",
          "roleId = #{roleid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(RoleUser record);
}