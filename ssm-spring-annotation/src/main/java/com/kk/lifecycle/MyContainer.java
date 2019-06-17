package com.kk.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

//拦截容器
@Component
public class MyContainer implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        beanFactory.getBeanDefinition("id");// 根据bean的名字(id)获取bean
        int size=beanFactory.getBeanDefinitionCount();
        System.out.println("容器中bean的个数:"+size);
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();// 获取所有bean的id
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
