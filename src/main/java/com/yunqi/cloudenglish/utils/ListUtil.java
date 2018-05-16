package com.yunqi.cloudenglish.utils;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 13:34 2018/5/15
 * @版本 v1.0
 */
public class ListUtil {
    public static <E,T>List<T> copyListProperties(List<E> source,List<T> target ,Class<T> clazz){
        if (CollectionUtils.isEmpty(source)){
            return null;
        }
        source.forEach(list->{
            target.add(BeanMapperUtil.createAndCopyProperties(list,clazz));
        });
        return target;
    }
}
