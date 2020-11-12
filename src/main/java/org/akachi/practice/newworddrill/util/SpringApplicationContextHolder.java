package org.akachi.practice.newworddrill.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    /**
     * 获取context
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return context;
    }


    /**
     * 获得springBean
     *
     * @param beanName
     * @return
     */
    public static Object getSpringBean(String beanName) {
//        notEmpty(beanName, "bean name is required");  
        if (beanName != null && !"".equals(beanName)) {
            return context == null ? null : context.getBean(beanName);
        } else {
            System.out.println("bean name is required");
            return null;
        }
    }

    /**
     * 通过class获取Bean.
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }


    public static String[] getBeanDefinitionNames() {
        return context.getBeanDefinitionNames();
    }

}
