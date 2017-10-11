package com.lhx.smart.framework;

import com.lhx.smart.framework.helper.BeanHelper;
import com.lhx.smart.framework.helper.ClassHelper;
import com.lhx.smart.framework.helper.ControllerHelper;
import com.lhx.smart.framework.helper.IocHelper;
import com.lhx.smart.framework.util.ClassUtil;

public final class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(),true);
        }
    }
}
