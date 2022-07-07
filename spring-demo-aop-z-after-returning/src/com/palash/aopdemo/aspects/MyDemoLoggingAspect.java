package com.palash.aopdemo.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

	// add a new advice for @AfterReturning on the findAccounts Method

	@AfterReturning(pointcut = "execution(* com.palash.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print method which we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n----> Executing @AfterReturning on method: " + method);

		// print out the results on the method call
		System.out.println("\n----> Result is: " + result);
		
		// lets post-process the result data and modify it ;-)
		
		// convert the account names to upper case
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n----> Result is: " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account tempAccount : result) {
			String theUpperName = tempAccount.getName().toUpperCase();
			
			tempAccount.setName(theUpperName);
		}
	}

	@Before("com.palash.aopdemo.aspects.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n ------> Executing @Before Advice on addAccount()");

		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);

		// display the method arguments

		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop through the args
		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {
				// downcast and print Account specific info
				Account theAccount = (Account) tempArg;

				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
	}
}
