package com.kk.schema;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Advice {

    //JoinPoint适用于注解schema
    public void before(JoinPoint joinPoint) throws Throwable {
        System.out.println("schema-前置");
        System.out.println("目标对象:"+joinPoint.getThis());
        System.out.println("方法名:"+joinPoint.getSignature().getName());
        System.out.println("参数列表:"+ Arrays.toString(joinPoint.getArgs()));
    }

    public void myAfterReturn(JoinPoint joinPoint,Object returnValue){
        System.out.println("schema-后置");
        System.out.println("返回值:"+returnValue);
    }

    public void myException(JoinPoint joinPoint,ArithmeticException e){
        System.out.println("schema-异常");
    }

    public Object myAround(ProceedingJoinPoint proceedingJoinPoint){
        Object result=null;
        try {
            System.out.println("schema-环绕-前");
            result=proceedingJoinPoint.proceed();
            System.out.println("schema-环绕-后");
        } catch (Throwable e) {
//            e.printStackTrace();
            System.out.println("schema-环绕-异常");
        }finally {
            System.out.println("schema-环绕-最终通知");
        }
        return result;
    }

    public void myAfter(JoinPoint joinPoint){
        System.out.println("schema-最终通知");
    }
}
