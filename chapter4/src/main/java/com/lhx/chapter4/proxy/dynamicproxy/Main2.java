package com.lhx.chapter4.proxy.dynamicproxy;

import com.lhx.chapter4.proxy.Hello;
import com.lhx.chapter4.proxy.HelloImpl;

import java.lang.reflect.Proxy;

public class Main2 {
    public static void main(String[] args) {
        DynamicProxy2 dynamicProxy=new DynamicProxy2(new HelloImpl());
        Hello helloProxy = dynamicProxy.getProxy();
        helloProxy.say("muzixu");
    }
}
