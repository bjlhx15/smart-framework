package com.lhx.chapter4.proxy.dynamicproxy;

import com.lhx.chapter4.proxy.Hello;
import com.lhx.chapter4.proxy.HelloImpl;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Hello hello=new HelloImpl();
        DynamicProxy dynamicProxy=new DynamicProxy(hello);
        Hello helloProxy = (Hello)Proxy.newProxyInstance(hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                dynamicProxy);
        helloProxy.say("muzixu");
    }
}
