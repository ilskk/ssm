package com.kk.annotations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect //普通类->通知类
public class Advice {

    @Before("execution(* com.kk.service.*.*(..) )") //属性:定义切点
    public void myBefore(JoinPoint joinPoint){
        System.out.println("注解-前置");
        System.out.println("目标对象:"+joinPoint.getThis());
        System.out.println("方法名:"+joinPoint.getSignature().getName());
        System.out.println("参数列表:"+ Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "execution(* com.kk.service.*.*(..) )",returning ="returnValue")
    public void myAfter(JoinPoint joinPoint,Object returnValue){
        System.out.println("注解-后置");
        System.out.println("返回值:"+returnValue);
    }

    //如果只捕获指定异常,可以通过第二个参数来指定
    @AfterThrowing(pointcut = "execution(* com.kk.service.*.*(..) )",throwing = "e")
    public void myException(JoinPoint joinPoint,ArithmeticException e){
        System.out.println("注解-异常");
    }

    @Around("execution(* com.kk.service.*.*(..) )")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint){
        Object result=null;
        try {
            System.out.println("注解-环绕-前");
            result=proceedingJoinPoint.proceed();
            System.out.println("注解-环绕-后");
        } catch (Throwable e) {
//            e.printStackTrace();
            System.out.println("注解-环绕-异常");
        }finally {
            System.out.println("注解-环绕-最终通知");
        }
        return result;
    }

    @After("execution(* com.kk.service.*.*(..) )") //最终通知
    public void myAfter(JoinPoint joinPoint){
        System.out.println("注解-最终通知");
    }
}
