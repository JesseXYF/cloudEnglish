package com.yunqi.cloudenglish.modle.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 14:45 2018/5/14
 * @版本 v1.0
 */
@ApiModel
public class LoginReq {

    @ApiModelProperty(value = "身份标识",required = true,example = "10086")
    @NotBlank(message = "{auth.id.null}")
    private String identity;

    @ApiModelProperty(value = "密码",required = true,example = "password")
    @NotBlank(message = "{auth.pwd.null}")
    private String password;

    public String getIdentity() {
        return this.identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
