package com.palash.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	// Advice(s)
	
	@Before("com.palash.aopdemo.aspects.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ------> Executing @Before Advice on addAccount()");
	}
}
