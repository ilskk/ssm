package com.kk.lifecycle;

import com.kk.entity.Import.Orange;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyLoadBean implements BeanDefinitionRegistryPostProcessor {

    //继承方法
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("[a后]postProcessBeanFactory容器中注册bean的数量:"+beanFactory.getBeanDefinitionCount());

        Object myBean=beanFactory.getBean("myBean");
        System.out.println(myBean);
    }

    //自身方法维护容器中所有bean的注册信息
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("[a前]postProcessBeanDefinitionRegistry容器中注册bean的数量:"+
                registry.getBeanDefinitionCount());

        //额外为容器增加bean
        //Orange
        BeanDefinitionBuilder builder=BeanDefinitionBuilder.rootBeanDefinition(Orange.class);

        registry.registerBeanDefinition("myBean",builder.getBeanDefinition());
    }


}
