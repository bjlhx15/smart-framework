package com.lhx.chapter4.aop.dynamicproxy;

import com.lhx.chapter4.aop.Greeting;
import com.lhx.chapter4.aop.GreetingImpl;

public class CGLibDynamicProxyClient {
    public static void main(String[] args) {
        Greeting proxy = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        proxy.sayHello("muzixu");
    }
}
