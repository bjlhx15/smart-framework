package com.lhx.chapter4.aop;

public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        before();
        System.out.println("hello " + name);
        after();
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}
