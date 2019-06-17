package com.kk.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component
public class MyListener implements ApplicationListener {

    //监听对象
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("监听对象:"+applicationEvent);
    }
}
