package com.lhx.chapter4.aop.springaopthrows;

import com.lhx.chapter4.aop.GreetingImpl;
import org.springframework.aop.framework.ProxyFactory;

public class Client {
    public static void main(String[] args) {

        ProxyFactory proxyFactory = new ProxyFactory();//创建代理工厂
        proxyFactory.setTarget(new GreetingImpl());//射入目标类对象
        proxyFactory.addAdvice(new GreetingThrowsAdvice());

        GreetingImpl greeting = (GreetingImpl) proxyFactory.getProxy();
        greeting.sayHelloThrows("木子旭");
    }
}
