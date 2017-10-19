package com.lhx.chapter4.aop.staticproxy;

import com.lhx.chapter4.aop.Greeting;
import com.lhx.chapter4.aop.GreetingImpl;

public class GreetingProxy implements Greeting {
    private GreetingImpl greetingImpl;
    public GreetingProxy(GreetingImpl greetingImpl){
        this.greetingImpl=greetingImpl;
    }

    @Override
    public void sayHello(String name) {
        before();
        greetingImpl.sayHello(name);
        after();
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}