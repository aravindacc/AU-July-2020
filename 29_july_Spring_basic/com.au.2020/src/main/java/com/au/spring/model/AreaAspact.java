package com.au.spring.model;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Around;

@Aspect
public class AreaAspact {
	
	@Around("getpointcut()")
	public void Aroundfunction(ProceedingJoinPoint pjp)
	{
		System.out.println("before calling Area function ");
		System.out.println("Join Point : " + pjp.getSignature().getName());
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After calling Area function");
	}
	
	
	@Pointcut("execution(public void com.au.spring.model.AreaCollector.getArea(..))")
	public void getpointcut() throws Throwable  {}
}
