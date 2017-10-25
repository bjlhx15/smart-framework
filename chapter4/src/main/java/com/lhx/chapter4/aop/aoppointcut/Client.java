package com.lhx.chapter4.aop.aoppointcut;

import com.lhx.chapter4.aop.Greeting;
import com.lhx.chapter4.aop.springaopintroductionadvice.Apology;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        //获取spring content
        ApplicationContext context =new ClassPathXmlApplicationContext("application-aop-advisor.xml");
        //从Content中根据id获取Bean对象，其实就是一个代理
        GreetingGood greetingProxy = (GreetingGood) context.getBean("greetingProxy");
        greetingProxy.sayHello("muzixu ");
        greetingProxy.goodMorning("muzixuss ");

    }
}
