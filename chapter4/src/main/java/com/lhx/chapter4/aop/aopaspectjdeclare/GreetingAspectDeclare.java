package com.lhx.chapter4.aop.aopaspectjdeclare;

import com.lhx.chapter4.aop.springaopintroductionadvice.Apology;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspectDeclare {
    @DeclareParents(value = "com.lhx.chapter4.aop.GreetingImpl",defaultImpl = ApologyImpl.class)
    private Apology apology;
}
