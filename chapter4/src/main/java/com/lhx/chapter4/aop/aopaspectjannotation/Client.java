package com.lhx.chapter4.aop.aopaspectjannotation;

import com.lhx.chapter4.aop.Greeting;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        //获取spring content
        ApplicationContext context =new ClassPathXmlApplicationContext("application-aop-aspectj.xml");
        //从Content中根据id获取Bean对象，其实就是一个代理
        Greeting greetingProxy = (Greeting) context.getBean("greetingImplAspect");
        greetingProxy.sayHelloNoPreSub("muzixu ");
        greetingProxy.sayHello("muzixu ");
    }
}
