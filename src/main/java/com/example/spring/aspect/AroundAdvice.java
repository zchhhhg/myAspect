package com.example.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Cheng
 * @date 2021-08-27-9:50
 */
@Aspect
@Component
public class AroundAdvice {
    @Pointcut("execution(* com.example.spring..*.getCache(..))")
    private void pt(){};

    @Around("pt()")
    public void doAround(ProceedingJoinPoint jointPoint){
        try {
            System.out.println("开始进行环绕！");
            System.out.println("这里是before前置通知");
            jointPoint.proceed();
            System.out.println("这里是after后置通知");
        } catch (Throwable e) {
            System.out.println("这里是afterThrow异常后置通知");
        }finally {
            System.out.println("这里是afterReturn返回后置通知");
        }
    }
}
