package com.sample.myapp;


import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class HelloLog {
	@Pointcut(value="execution(* com.sample..*.sayHello(..))")
	private void helloPointcut() {}
	
	@Pointcut(value="execution(* com.sample..*.sayGoodbye(..))")
	private void goodbyePointcut() {}
	
	@Before("helloPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		System.out.println("[Before] "+methodName + "메소드가 호출됩니다.");

	}
	
	@After("helloPointcut()")
	public void afterLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		System.out.println("[After] "+methodName + "메소드가 호출됩니다.");

	}
	

	
	@AfterReturning(pointcut="helloPointcut()", returning="message")
	public Object afterReturning(JoinPoint joinPoint, String message) {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		System.out.println("[afterReturning] "+methodName + "메소드가 호출됩니다.");
		
		System.out.println("afterReturning 메서드 리턴 값: "+message);
		return message;
	}
	
	@AfterThrowing(pointcut="goodbyePointcut()", throwing="exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		System.out.println("[afterThrowing] "+methodName + "메소드가 호출됩니다.");
		System.out.println("[afterThrowing] 예외발생 "+ exception.getMessage());


	}
	
	@Around("execution(* com.sample..*.*(..))")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		System.out.println("[Around] "+methodName + " time check start");
		
		long startTime = System.nanoTime();
		
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch(Exception e) {
			System.out.println("[Around] excption: "+ methodName);
		} finally {
			System.out.println("[Around] finally : " + methodName);
		}
		
		long endTime = System.nanoTime();
		System.out.println("[Around]" + methodName + " Processing time is "+ (endTime-startTime) + "ns");
		return result;
		
		
		
	}
}
