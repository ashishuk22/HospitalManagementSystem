package com.Arc.hospital.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
   
	@GetMapping("/login")
	public String login() {
		return "Please login with your credentiale";
	}
}
