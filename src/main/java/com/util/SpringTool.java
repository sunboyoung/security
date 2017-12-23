package com.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 普通类并不在spring容器的管辖范围内
 * 为了在普通类中使用service层
 * 要手动获取bean
 *
 * @Author zms
 * @CreateTime 2017年12月1日上午11:08:05
 * @Description
 */

public final class SpringTool implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringTool.applicationContext == null) {
            SpringTool.applicationContext = applicationContext;
            System.out.println("-----ApplicationContext-------");
            System.out.println("=====配置成功=====");
            System.out.println("通过ToolSrping,getAppContext()获取applicationContext对象");
            System.out.println("applicationContext对象为:" + applicationContext);
        }
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

}