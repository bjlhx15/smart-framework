package com.lhx.chapter4.aop.aopaspectjannotation;

import com.lhx.chapter4.aop.Greeting;
import org.springframework.stereotype.Component;

@Component
public class GreetingImplAspect implements Greeting {
    @Tag
    @Override
    public void sayHello(String name) {
        System.out.println("hello "+name);
    }

    @Override
    public void sayHelloNoPreSub(String name) {
        System.out.println("hello "+name);

    }

    @Override
    public void sayHelloThrows(String name) {
        System.out.println("hello "+name);

    }
}
