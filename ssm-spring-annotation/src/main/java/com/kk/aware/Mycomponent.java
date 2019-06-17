package com.kk.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Mycomponent implements ApplicationContextAware, BeanNameAware {

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("wryyyyyyyyyyyyyy:"+applicationContext);
        this.applicationContext=applicationContext;
    }

    public void setBeanName(String name) {
        System.out.println("获取当前bean的name:"+name);
    }
}
