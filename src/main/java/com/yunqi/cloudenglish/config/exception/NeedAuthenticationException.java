package com.yunqi.cloudenglish.config.exception;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 14:14 2018/5/16
 * @版本 v1.0
 */
public class NeedAuthenticationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 创建一个新的实例 ResourceNotFoundException.
     *
     */
    public NeedAuthenticationException() {
        super();
    }

    /**
     * 创建一个新的实例 ResourceNotFoundException.
     *
     */
    public NeedAuthenticationException(String message) {
        super(message);
    }
}
