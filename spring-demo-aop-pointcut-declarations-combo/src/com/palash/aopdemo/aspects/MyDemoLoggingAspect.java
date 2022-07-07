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
	
	@Pointcut("execution(* com.palash.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* com.palash.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// combine the above three pointcut expressions
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterAndSetter() {}
	
	// Advice(s)
	
	@Before("forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ------> Executing @Before Advice on addAccount()");
	}
	
	@Before("forDaoPackageNoGetterAndSetter()")
	public void performApiAnalytics() {
		System.out.println("\n -------> Performing some API analytics");
	}
}
