package com.lhx.chapter4.aop.aopaspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {
    @Around("execution(* com.lhx.chapter4.aop.GreetingImpl.*(..))")
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
