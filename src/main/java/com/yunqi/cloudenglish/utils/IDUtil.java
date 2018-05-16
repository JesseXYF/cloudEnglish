package com.yunqi.cloudenglish.utils;

import java.util.UUID;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 12:31 2018/5/15
 * @版本 v1.0
 */
public class IDUtil {
    public static String newId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
