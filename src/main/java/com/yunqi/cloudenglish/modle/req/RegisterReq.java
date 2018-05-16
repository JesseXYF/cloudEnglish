package com.yunqi.cloudenglish.modle.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 17:09 2018/5/14
 * @版本 v1.0
 */
@ApiModel
public class RegisterReq extends LoginReq {

    @ApiModelProperty(value = "用户昵称",required = true ,example = "Jesse")
    @NotBlank(message = "{auth.username.null}")
    private String username;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
