package com.kk.config;

import com.kk.entity.Import.Apple;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean {
    public Object getObject() throws Exception {
        return new Apple();
    }

    public Class<?> getObjectType() {
        return Apple.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
