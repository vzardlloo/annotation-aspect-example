package com.example.vzard.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
@Order(1)
@Slf4j
public class HttpLogAspect {


    ThreadLocal<Long> startTime = new ThreadLocal<>();

    // 切面表达式，描述所有所有需要记录log的类
    @Pointcut("@within(com.example.vzard.annotation.HttpLog)")
    public void httpLog() {
    }

    @Before("httpLog()")
    public void preHandler(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        log.info("Current Url: {}", httpServletRequest.getRequestURI());
        log.info("Current Http Method: {}", httpServletRequest.getMethod());
        log.info("Current IP: {}", httpServletRequest.getRemoteAddr());
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        log.info("=======http headers=======");
        while (headerNames.hasMoreElements()) {
            String nextName = headerNames.nextElement();
            log.info(nextName.toUpperCase() + ": {}", httpServletRequest.getHeader(nextName));
        }
        log.info("======= header end =======");
        log.info("Current Class Method: {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("Parms: {}", null != httpServletRequest.getQueryString() ? JSON.toJSONString(httpServletRequest.getQueryString().split("&")) : "EMPTY");

    }

    @AfterReturning(returning = "response", pointcut = "httpLog()")
    public void afterReturn(Object response) {
        log.info("Response: {}", JSON.toJSONString(response));
        log.info("Spend Time: [ {}", System.currentTimeMillis() - startTime.get() + " ms ]");

    }


}
