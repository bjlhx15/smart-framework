package com.lhx.chapter4.aspect;

import com.lhx.smart.framework.annotation.Aspect;
import com.lhx.smart.framework.annotation.Controller;
import com.lhx.smart.framework.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {
    private  static  final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);
    private long begin;
    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        logger.debug("----begin-----");
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        logger.debug(String.valueOf(System.currentTimeMillis()-begin));
    }
}
