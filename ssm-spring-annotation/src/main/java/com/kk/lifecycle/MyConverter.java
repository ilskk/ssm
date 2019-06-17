package com.kk.lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MyConverter {

    @PostConstruct
    public void init(){System.out.println("转换器初始化");}

    public void converter(){System.out.println("转换......");}

    @PreDestroy
    public void destroy(){System.out.println("转换器销毁");}

}
