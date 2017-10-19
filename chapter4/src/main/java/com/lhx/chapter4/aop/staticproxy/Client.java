package com.lhx.chapter4.aop.staticproxy;

import com.lhx.chapter4.aop.Greeting;
import com.lhx.chapter4.aop.GreetingImpl;

public class Client {
    public static void main(String[] args) {
        Greeting proxy = new GreetingProxy(new GreetingImpl());
        proxy.sayHello("木子旭");
    }
}
