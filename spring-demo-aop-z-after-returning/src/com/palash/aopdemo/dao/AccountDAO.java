package com.palash.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.palash.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public String getName() {
		System.out.println(getClass() + ": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account theAccount, boolean vipFlag) {

		System.out.println(getClass() + ": Doing my DB work: Adding an account");
	}

	public boolean doWork() {

		System.out.println(getClass() + ": doWork()");
		return false;
	}

	// add a new method: findAccounts()
	public List<Account> findAccounts() {
		List<Account> myAccounts = new ArrayList<>();

		// create sample accounts
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Sadie", "Gold");
		Account temp3 = new Account("Lucas", "Platinum");

		// add them to accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
}
