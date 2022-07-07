package com.palash.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.palash.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {

		System.out.println(getClass() + ": Doing my DB work: Adding an account");
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork()");
		return false;
	}
}
