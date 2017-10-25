package com.lhx.chapter4.aop.aoppointcut;

import com.lhx.chapter4.aop.Greeting;
import org.springframework.stereotype.Component;

@Component
public class GreetingGood implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }

    public void goodMorning(String name) {
        System.out.println("goodMorning " + name);
    }

    public void goodNight(String name) {
        System.out.println("goodNight " + name);
    }

    @Override
    public void sayHelloThrows(String name) {

    }
}
