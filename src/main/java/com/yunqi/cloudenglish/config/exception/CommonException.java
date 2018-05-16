package com.yunqi.cloudenglish.config.exception;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 12:02 2018/5/15
 * @版本 v1.0
 */
public class CommonException extends RuntimeException{

    private Object args[];

    public CommonException(String message) {
        super(message);
        this.args = null;
    }

    public CommonException(String message,Object... args) {
        this(message, null, args);
    }
    public CommonException(String msg, Throwable throwable, Object... args) {
        super(msg, throwable);
        this.args = args;
    }
}
