package com.yunqi.cloudenglish.config.exception;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 13:33 2018/5/16
 * @版本 v1.0
 */
public class UserExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 创建一个新的实例 ResourceNotFoundException.
     *
     */
    public UserExistException() {
        super();
    }

    /**
     * 创建一个新的实例 ResourceNotFoundException.
     *
     */
    public UserExistException(String message) {
        super(message);
    }
}