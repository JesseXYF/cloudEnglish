package com.yunqi.cloudenglish.utils;

import com.yunqi.cloudenglish.config.exception.CommonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 12:01 2018/5/15
 * @版本 v1.0
 */
public class ExceptionUtil {

    private static final Logger logger= LoggerFactory.getLogger(ExceptionUtil.class);

    public final static <T extends RuntimeException> void propagate(Class<T> clazz, String msg, Throwable t, Object... args) {
        try {
            Constructor<T> constructor=clazz.getConstructor(String.class,Throwable.class,Object[].class);
            T instance = constructor.newInstance(msg, t, args);
            throw instance;
        } catch (NoSuchMethodException e) {
            logger.warn("get constructor of the exception failed, use default constructor "+e);
        } catch (IllegalAccessException e) {
            logger.warn("the exception occurs when invoke exception constructor, use default exception  ", e);
        } catch (InstantiationException e) {
            logger.warn("the failed occurs when instantiate exception, use default exception  ", e);
        } catch (InvocationTargetException e) {
            logger.warn("the illegal privilege when access exception constructor, use default exception  ", e);
        }
    }
}
