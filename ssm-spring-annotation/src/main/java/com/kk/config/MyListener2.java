package com.kk.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener2 {

    @EventListener(value = {ApplicationEvent.class})
    public void lstener(ApplicationEvent event){
        System.out.println("监听对象:"+event);
    }
}
