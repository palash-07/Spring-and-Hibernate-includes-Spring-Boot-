package com.palash.aopdemo.aspects;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.palash.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Around("execution(* com.palash.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		// print which method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n----> Executing @Around on method: " + method);

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// lets execute the method
		Object result = theProceedingJoinPoint.proceed();

		// get end timestamp
		long end = System.currentTimeMillis();

		// compute the duration
		long duration = end - begin;
		myLogger.info("The duration is: " + duration);

		return result;
	}

	// add a new advice for @After on the findAccounts Method
	@After("execution(* com.palash.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

		// print which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n----> Executing @After on method: " + method);
	}

	// add a new advice for @AfterThrowing on the findAccounts Method

	@AfterThrowing(pointcut = "execution(* com.palash.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		// print which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n----> Executing @AfterThrowing on method: " + method);

		// log the exception
		myLogger.info("\n----> The exception is: " + theExc);
	}

	// add a new advice for @AfterReturning on the findAccounts Method

	@AfterReturning(pointcut = "execution(* com.palash.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print method which we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n----> Executing @AfterReturning on method: " + method);

		// print out the results on the method call
		myLogger.info("\n----> Result is: " + result);

		// lets post-process the result data and modify it ;-)

		// convert the account names to upper case
		convertAccountNamesToUpperCase(result);

		myLogger.info("\n----> Result is: " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account tempAccount : result) {
			String theUpperName = tempAccount.getName().toUpperCase();

			tempAccount.setName(theUpperName);
		}
	}

	@Before("com.palash.aopdemo.aspects.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n ------> Executing @Before Advice on addAccount()");

		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: " + methodSig);

		// display the method arguments

		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop through the args
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());

			if (tempArg instanceof Account) {
				// downcast and print Account specific info
				Account theAccount = (Account) tempArg;

				myLogger.info("account name: " + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());
			}
		}
	}
}
