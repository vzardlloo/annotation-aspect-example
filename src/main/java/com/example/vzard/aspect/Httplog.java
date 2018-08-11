package com.example.vzard.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Httplog {


    // 切面表达式，描述所有所有需要记录log的类
    @Pointcut("execution(public * com.example.vzard.web..*.*(..))")
    public void log() {
    }


}
