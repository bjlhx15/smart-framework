package com.lhx.chapter4.aop.aopaspectjdeclare;

import com.lhx.chapter4.aop.Greeting;
import com.lhx.chapter4.aop.springaopintroductionadvice.Apology;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        //获取spring content
        ApplicationContext context =new ClassPathXmlApplicationContext("application-aop-declare.xml");
        //从Content中根据id获取Bean对象，其实就是一个代理
        Greeting greetingProxy = (Greeting) context.getBean("greetingImpl");
        greetingProxy.sayHelloNoPreSub("muzixu ");
        Apology apology = (Apology) greetingProxy;
        //将目标类强制向上转型为Apology接口类型【引入增强的特性，即“动态接口实现”功能】
        apology.saySorry("Jack");

    }
}
