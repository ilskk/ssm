package com.kk.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ExceptionAdvice implements ThrowsAdvice {
    //异常通知具体方法
    public void afterThrowing(Method method, Object[] objects, Object o,Throwable ex){
        System.out.println("异常通知");
        System.out.println("目标对象:"+o);
        System.out.println("调用的方法名:"+method.getName());
        System.out.println("方法参数:"+ Arrays.toString(objects));
        System.out.println("异常类型:"+ex);
    }
}
