package org.xiaojin.common.util;

import cn.hutool.core.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SpringContextHolder.java
 * @Description TODO
 * @createTime 2024年05月17日 14:53:00
 */
public class SpringContextHolder implements ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(SpringContextHolder.class);
    private static ApplicationContext applicationContext;

    public SpringContextHolder() {
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }

    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getHandler(String name, Class<T> cls) {
        T t = null;
        if (ObjectUtil.isNotEmpty(name)) {
            checkApplicationContext();

            try {
                t = applicationContext.getBean(name, cls);
            } catch (Exception var4) {
                log.warn("Customize redis listener handle [ " + name + " ], does not exist！");
            }
        }

        return t;
    }

    public static <T> T getBean(Class<T> clazz) {
        checkApplicationContext();
        return applicationContext.getBean(clazz);
    }

    public static void cleanApplicationContext() {
        applicationContext = null;
    }

    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
        }
    }
}
