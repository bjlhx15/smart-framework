package com.lhx.chapter4.aop.springaopintroductionadvice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class GreetingIntroductionAdvice extends DelegatingIntroductionInterceptor implements Apology {
    @Override
    public void saySorry(String name) {
        System.out.println("sorry " + name);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return super.invoke(mi);
    }
}
