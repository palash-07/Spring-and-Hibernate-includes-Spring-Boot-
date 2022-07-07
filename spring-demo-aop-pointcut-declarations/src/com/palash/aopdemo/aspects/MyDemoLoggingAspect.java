package com.palash.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// Point cut declarations
	
	@Pointcut("execution(* com.palash.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	
	// Advice(s)
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ------> Executing @Before Advice on addAccount()");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n -------> Performing some API analytics");
	}
}
