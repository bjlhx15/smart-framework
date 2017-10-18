package com.lhx.chapter4.proxy.dynamicproxy;

import com.lhx.chapter4.proxy.Hello;
import com.lhx.chapter4.proxy.HelloImpl;

public class MainCGlibSingle {
    public static void main(String[] args) {
        Hello hello = CGLibSingleProxy.getInstance().getProxy(HelloImpl.class);
        hello.say("muzixu");
    }
}
