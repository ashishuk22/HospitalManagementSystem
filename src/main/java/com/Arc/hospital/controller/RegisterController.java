package com.Arc.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Arc.hospital.entity.User;
import com.Arc.hospital.repository.Userrepo;

@RestController
@RequestMapping("/register")
public class RegisterController {
    
	@Autowired
	private Userrepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping
	public String registerUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
		return "User registered successfully";
	}
}
