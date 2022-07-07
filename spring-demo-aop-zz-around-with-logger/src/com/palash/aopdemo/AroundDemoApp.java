package com.palash.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.palash.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read the spring java config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from the spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain Program: Around Demo App");

		System.out.println("Calling getFortune");

		String data = theFortuneService.getFortune();

		System.out.println("Today's fortune is: " + data);

		System.out.println("Finished!");

		// close the context
		context.close();
	}
}
