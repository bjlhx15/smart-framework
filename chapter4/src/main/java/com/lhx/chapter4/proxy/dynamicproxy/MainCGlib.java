package com.lhx.chapter4.proxy.dynamicproxy;

import com.lhx.chapter4.proxy.Hello;
import com.lhx.chapter4.proxy.HelloImpl;

public class MainCGlib {
    public static void main(String[] args) {
        CGLibProxy proxy = new CGLibProxy();
        Hello hello = proxy.getProxy(HelloImpl.class);
        hello.say("muzixu");
    }
}
