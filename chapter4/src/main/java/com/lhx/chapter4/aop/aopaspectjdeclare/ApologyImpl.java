package com.lhx.chapter4.aop.aopaspectjdeclare;

import com.lhx.chapter4.aop.springaopintroductionadvice.Apology;

public class ApologyImpl implements Apology {
    @Override
    public void saySorry(String name) {
        System.out.println("Sorry " + name);
    }
}
