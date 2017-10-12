package com.lhx.smart.framework.helper;

import com.lhx.smart.framework.annotation.Action;
import com.lhx.smart.framework.bean.Handler;
import com.lhx.smart.framework.bean.Request;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/*
 * 控制器助手类
 */
public final class ControllerHelper {
    // 用于存放请求与处理器的映射关系
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        //获取 所有COntroller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtils.isNotEmpty(controllerClassSet)) {
            //遍历
            for (Class<?> controllerClass : controllerClassSet) {
                //获取Controller方法
                Method[] methods = controllerClass.getDeclaredMethods();
                if (ArrayUtils.isNotEmpty(methods)) {
                    // 遍历Controller 中的方法
                    for (Method method : methods) {
                        // 判断当前方法是否含有Action注解
                        if (method.isAnnotationPresent(Action.class)) {
                            // 从Action注解中获取URL映射规则
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            // 验证URL的映射规则
                            if (mapping.matches("\\w+:/\\w*")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtils.isNotEmpty(array) && array.length == 2) {
                                    // 获取请求方法与请求路径
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
