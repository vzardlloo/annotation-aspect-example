package com.example.vzard.aspect;

import com.example.vzard.annotation.TimeStamp;
import com.example.vzard.common.TimeStampRank;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

@Aspect
@Component
@Slf4j
public class TimeStampAspect {

    //所有打上@TimeStamp注解的方法作为切点
    @Pointcut("@annotation(com.example.vzard.annotation.TimeStamp)")
    public void pointCut() {

    }

    @Before("pointCut() && @annotation(timeStamp)")
    public void before(JoinPoint joinPoint, TimeStamp timeStamp) {
        Long currentTime = System.currentTimeMillis();
        Class type = timeStamp.type();

        List argList = Arrays.stream(joinPoint.getArgs())
                .filter(t -> (t != null))
                .filter(t -> (t.getClass().getName().equals(type.getName())))
                .collect(Collectors.toList());

        for (Object arg : argList) {
            Method[] methods = arg.getClass().getMethods();
            for (Method m : methods) {

                if (timeStamp.rank().equals(TimeStampRank.FULL)) {
                    setCurrentTime(m, arg, "setUpdatedAt", "setCreatedAt");
                }

                if (timeStamp.rank().equals(TimeStampRank.UPDATE)) {
                    setCurrentTime(m, arg, "setUpdatedAt");
                }

                if (timeStamp.rank().equals(TimeStampRank.CREATE)) {
                    setCurrentTime(m, arg, "setCreatedAt");
                }

            }

        }

    }

    private void setCurrentTime(Method method, Object o, String... methodNames) {
        for (String name : methodNames) {
            if (method.getName().equals(name)) {
                try {
                    method.setAccessible(true);
                    method.invoke(o, new Date(System.currentTimeMillis()));

                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
