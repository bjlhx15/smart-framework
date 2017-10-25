package com.lhx.chapter4.aop.springaop;

import com.lhx.chapter4.aop.GreetingImpl;
import org.springframework.aop.framework.ProxyFactory;

public class GreetingAdviceClient {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();//创建代理工厂
        proxyFactory.setTarget(new GreetingImpl());//射入目标类对象
        proxyFactory.addAdvice(new GreetingBeforeAdvice());//前置通知
        proxyFactory.addAdvice(new GreetingAfterAdvice());//后置
        //proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());//前后结合
        proxyFactory.addAdvice(new GreetingAroundAdvice());//环绕

        GreetingImpl greeting = (GreetingImpl) proxyFactory.getProxy();
        greeting.sayHello("木子旭");
    }
}
