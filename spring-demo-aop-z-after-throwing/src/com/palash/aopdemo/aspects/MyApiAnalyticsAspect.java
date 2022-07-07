package com.palash.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {
	@Before("com.palash.aopdemo.aspects.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void performApiAnalytics() {
		System.out.println("\n -------> Performing some API analytics");
	}
}
