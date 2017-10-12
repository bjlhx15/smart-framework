package com.lhx.chapter4.proxy.staticproxy;

import com.lhx.chapter4.proxy.Hello;
import com.lhx.chapter4.proxy.HelloImpl;

public class HelloProxy implements Hello {
    private Hello hello;

    public HelloProxy() {
        this.hello = new HelloImpl();
    }

    @Override
    public void say(String name) {
        before();
        hello.say(name);
        after();
    }
    private void before(){
        System.out.println("Before");
    }
    private void after(){
        System.out.println("After");
    }
}
