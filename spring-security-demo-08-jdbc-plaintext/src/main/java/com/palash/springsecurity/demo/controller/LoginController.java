package com.palash.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {

		return "fancy-login";
	}

	// add request mapping for access denied page
	@GetMapping("/access-denied")
	public String showMyAccessDeniedPage() {
		return "access-denied";
	}
}
