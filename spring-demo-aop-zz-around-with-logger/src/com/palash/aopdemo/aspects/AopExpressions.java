package com.palash.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	// Point cut declarations

	@Pointcut("execution(* com.palash.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* com.palash.aopdemo.dao.*.get*(..))")
	public void getter() {
	}

	@Pointcut("execution(* com.palash.aopdemo.dao.*.set*(..))")
	public void setter() {
	}

	// combine the above three pointcut expressions
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterAndSetter() {
	}
}
