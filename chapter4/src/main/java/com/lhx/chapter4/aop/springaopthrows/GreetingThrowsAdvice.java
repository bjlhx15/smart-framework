package com.lhx.chapter4.aop.springaopthrows;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class GreetingThrowsAdvice implements ThrowsAdvice {
    //public void afterThrowing(Exception ex)
    //public void afterThrowing(RemoteException)
    //public void afterThrowing(Method method, Object[] args, Object target, Exception ex)
    //public void afterThrowing(Method method, Object[] args, Object target, ServletException ex)
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        System.out.println("--------Throw Exception-------");
        System.out.println("Target class:"+target.getClass().getName());
        System.out.println("Method name:"+method.getName());
        System.out.println("Exception:"+ex.getMessage());
        System.out.println("------------------------------");

    }
}
