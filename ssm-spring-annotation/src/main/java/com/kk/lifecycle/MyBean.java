package com.kk.lifecycle;

import com.kk.entity.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Controller;

@Controller //4个功能性注解都行

//对所有bean进行拦截,可以作为bean的拦截器,管理bean的初始化和销毁

public class MyBean implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
//        System.out.println(" postProcessBeforeInitialization");

        if(o instanceof Person){
           Person person= (Person)o;
            person.setName("地球人666");
            System.out.println("初始化:"+o+":"+s);
            return person;
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if(o instanceof Person){
            System.out.println("销毁:"+o+":"+s);
        }
        return o;
    }
}
