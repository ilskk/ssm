package com.kk.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

public class AroundAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object result=null;
        //方法1...
        try {
            System.out.println("环绕-前");
            //方法体2...
            result= methodInvocation.proceed(); //控制目标方法的执行
            System.out.println("目标对象:"+methodInvocation.getThis());
            System.out.println("方法名:"+methodInvocation.getMethod().getName());
            System.out.println("方法参数:"+ Arrays.toString(methodInvocation.getArguments()));
            System.out.println("方法返回值:"+result);
            System.out.println("环绕-后");
        } catch (Exception e) {
            //方法体3...
            System.out.println("环绕-异常");
        }

        return result; //就是目标方法的返回值
    }
}
