package com.palash.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// set up logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declarations
	@Pointcut("execution(* com.palash.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.palash.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.palash.springdemo.dao.*.*(..))")
	private void forDAOPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {
	}

	// @Before
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		// display the method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("====> in @Before: calling method: " + theMethod);

		// display the arguments in the method

		// get the arguments
		Object[] args = theJoinPoint.getArgs();

		// loop through and display the args
		for (Object tempArg : args) {
			myLogger.info("===> argument: " + tempArg);
		}
	}

	// @AfterReturning
	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	public void afterReturning(JoinPoint theJoinPoint, Object result) {

		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("====> in @AfterReturning: calling method: " + theMethod);

		// display the data returned
		myLogger.info("===> result: " + result);
	}
}
