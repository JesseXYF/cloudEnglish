package com.yunqi.cloudenglish.enums;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 15:18 2018/5/14
 * @版本 v1.0
 */
public enum ResponseMsg {
    OK("请求成功"),
    BAD_REQUEST("非法的请求"),
    NOT_FOUND("找不到资源"),
    INVALID_PARAM("错误的参数");

    private String msg;

    ResponseMsg(String msg){
        this.msg=msg;
    }
    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
