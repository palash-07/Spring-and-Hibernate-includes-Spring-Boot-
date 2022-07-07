package com.palash.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.palash.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read the spring java config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call the findAccount method

		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate an exception
			boolean tripWire = false;
					
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Caught exception: " + e);
		}

		// display the accounts
		System.out.println("\n\nMain program: AfterFinallyDemoApp");
		System.out.println(theAccounts);
		System.out.println("\n");

		// close the context
		context.close();
	}
}
