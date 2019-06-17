package com.kk.config;

import com.kk.entity.Import.Orange;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        BeanDefinition beanDefinition=new RootBeanDefinition(Orange.class);
//        BeanDefinition beanDefinition=new RootBeanDefinition("com.kk.entity.Import.Orange");
        beanDefinitionRegistry.registerBeanDefinition("myOrange",beanDefinition); //id,class
    }
}
