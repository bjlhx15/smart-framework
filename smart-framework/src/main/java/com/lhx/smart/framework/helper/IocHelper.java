package com.lhx.smart.framework.helper;

import com.lhx.smart.framework.annotation.Inject;
import com.lhx.smart.framework.util.ReflectionUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;

public final class IocHelper {
    static {
        //获取bena映射（用于存放Bean类与Bean实例的映射关系）
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (MapUtils.isNotEmpty(beanMap)) {
            //遍历beanMap
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                //从BeanMap中获取Bean类 bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取所有成员变量
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtils.isNotEmpty(beanFields)){
                    //遍历bean Field
                    for (Field beanField : beanFields) {
                        //判断当前Bean Field 是否带有Inject注解
                        if(beanField.isAnnotationPresent(Inject.class)){
                            //在Beanmap中获取实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstace = beanMap.get(beanFieldClass);
                            if(beanFieldInstace!=null){
                                //通过反射初始化BeanField字段
                                ReflectionUtil.setFiled(beanInstance,beanField,beanFieldInstace);
                            }
                        }
                    }
                }
            }
        }

    }
}
