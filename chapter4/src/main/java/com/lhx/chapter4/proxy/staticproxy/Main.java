package com.lhx.chapter4.proxy.staticproxy;

import com.lhx.chapter4.proxy.Hello;

public class Main {
    public static void main(String[] args) {
        Hello helloProxy = new HelloProxy();
        helloProxy.say("muzixu");
    }
}
