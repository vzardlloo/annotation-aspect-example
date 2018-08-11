package com.example.vzard.annotation;

import com.example.vzard.common.TimeStampRank;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2018/8/11
 * Time: 22:07
 * To change this template use File | Settings | File Templates.
 * Description:
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeStamp {
    Class type() default Object.class;

    TimeStampRank rank() default TimeStampRank.FULL;
}
