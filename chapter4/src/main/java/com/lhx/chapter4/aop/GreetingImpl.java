package com.lhx.chapter4.aop;

import org.springframework.stereotype.Component;

@Component
public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        before();
        System.out.println("hello " + name);
        after();
    }

    @Override
    public void sayHelloThrows(String name) {
        System.out.println("hello " + name);
        throw new RuntimeException("Error");
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}
