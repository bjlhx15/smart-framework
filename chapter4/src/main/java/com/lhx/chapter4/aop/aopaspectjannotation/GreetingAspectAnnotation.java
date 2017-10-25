package com.lhx.chapter4.aop.aopaspectjannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspectAnnotation {
    @Around("@annotation(com.lhx.chapter4.aop.aopaspectjannotation.Tag)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        before();
        Object proceed = point.proceed();
        after();
        return proceed;
    }

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }
}
