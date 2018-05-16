package com.yunqi.cloudenglish.utils;

import com.yunqi.cloudenglish.config.exception.CommonException;
import org.springframework.beans.BeanUtils;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 11:54 2018/5/15
 * @版本 v1.0
 */
public class BeanMapperUtil {
    public static <T> T createAndCopyProperties(Object source, Class<T> clazz){
        try {
            T dest = clazz.newInstance();
            BeanUtils.copyProperties(source,dest);
            return dest;
        } catch (InstantiationException|IllegalAccessException e) {
            ExceptionUtil.propagate(CommonException.class,"the target object of the createAndCopyProperties must provided a default constructor",null);
        }
        return null;
    }
}
