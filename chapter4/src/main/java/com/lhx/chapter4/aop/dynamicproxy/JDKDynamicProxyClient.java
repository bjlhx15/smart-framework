package com.lhx.chapter4.aop.dynamicproxy;

import com.lhx.chapter4.aop.Greeting;
import com.lhx.chapter4.aop.GreetingImpl;

public class JDKDynamicProxyClient {
    public static void main(String[] args) {
        JDKDynamicProxy dynamicProxy = new JDKDynamicProxy(new GreetingImpl());
        Greeting proxy = dynamicProxy.getProxy();
        proxy.sayHello("muzixu");
    }
}
