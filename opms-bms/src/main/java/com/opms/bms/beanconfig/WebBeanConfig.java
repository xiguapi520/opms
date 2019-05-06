package com.opms.bms.beanconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class WebBeanConfig {

    @Autowired
    @Qualifier("getApplication")
    private ApplicationContext ctx;

    @Bean
    public DefaultListableBeanFactory getDefaultListableBeanFactory(){
        DefaultListableBeanFactory defaultListableBeanFactory =
                (DefaultListableBeanFactory) ctx.getAutowireCapableBeanFactory();
        return defaultListableBeanFactory;
    }

    public <T> void buildBean(Class<T> t,String className) {
        try {
            T clazz = t.newInstance();
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz.getClass());
            getDefaultListableBeanFactory().registerBeanDefinition(className, beanDefinitionBuilder.getBeanDefinition());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void destoryBean(String beanName) {
        if (beanName != null && !beanName.isEmpty()) {
            getDefaultListableBeanFactory().removeBeanDefinition(beanName);
        }
    }

    public <T> T getBean(String beanName) {
        if (beanName != null && !beanName.isEmpty()) {
            return (T) getDefaultListableBeanFactory().getBean(beanName);
        } else
            return null;
    }

}
