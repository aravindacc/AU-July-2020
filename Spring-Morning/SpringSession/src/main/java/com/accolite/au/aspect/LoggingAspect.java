package com.accolite.au.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    @Around("allGetters()")
    public void log(JoinPoint jp){
        System.out.println("Aspect logging: " + jp.toString());
        System.out.println(jp.getSignature().getDeclaringType());
        System.out.println(jp.getTarget().getClass());
    }

    @Pointcut("execution(* getArea(..))")
    public void allGetters() {}
}
