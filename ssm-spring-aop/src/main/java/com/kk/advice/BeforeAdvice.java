package com.kk.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

//普通类->前置通知
public class BeforeAdvice implements MethodBeforeAdvice {
    //前置通知内容
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("前置通知");
        System.out.println("目标对象:"+o);
        System.out.println("调用的方法名:"+method.getName());
        System.out.println("方法参数:"+ Arrays.toString(objects));
    }
}
