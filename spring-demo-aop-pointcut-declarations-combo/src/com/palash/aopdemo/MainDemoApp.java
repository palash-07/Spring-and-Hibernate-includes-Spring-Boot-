package com.palash.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.palash.aopdemo.dao.AccountDAO;
import com.palash.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read the spring java config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		Account myAccount = new Account();
		
		// call the business methods
		theAccountDAO.addAccount(myAccount,false);
		theAccountDAO.doWork();
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		// call the getters and setters
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();
		
		// close the context
		context.close();
	}
}
