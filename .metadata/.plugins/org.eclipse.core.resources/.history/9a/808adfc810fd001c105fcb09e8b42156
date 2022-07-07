package com.palash.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// expose / that returns hello world
	@GetMapping("/")
	public String sayHello() {
		return "Hello world ! Time on server is: " + LocalDateTime.now();
	}

	// add a rest point for workout
	@GetMapping("/workout")
	public String getWorkout() {
		return "Run a hard 5k";
	}
	
	// add a new endpoint for fortune
	@GetMapping("/fortune")
	public String getFortune() {
		return "Today is your lucky day";
	}
}
