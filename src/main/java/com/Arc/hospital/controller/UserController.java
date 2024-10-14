package com.Arc.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Arc.hospital.entity.User;
import com.Arc.hospital.service.Userservice;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private Userservice uservice;
	
	@GetMapping
	public List<User> getAllUsers(){
		return uservice.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable long id) {
		return uservice.getUserById(id);
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return uservice.createUser(user);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable long id, @RequestBody User user) {
		return uservice.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable long id) {
		uservice.deleteUser(id);
	}
	
}
