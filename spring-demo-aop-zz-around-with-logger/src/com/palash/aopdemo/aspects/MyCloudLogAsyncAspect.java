package com.palash.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
	@Before("com.palash.aopdemo.aspects.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void logToCloudAsync() {
		System.out.println("\n -------> logging to cloud in async fashion");
	}
}
