package com.worolo.api.controller;

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

import com.worolo.api.model.Citizen;
import com.worolo.api.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<Citizen> getAllUser() {
		return userService.getAllUser();
	}
	
	@GetMapping("/{id}")
	public Citizen getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@PostMapping
	public Citizen createUser(@RequestBody Citizen user) {
		return userService.createUser(user);
	}
	
	@PutMapping("/{id}")
	public Citizen updateUser(@PathVariable Long id, @RequestBody Citizen updatedUser) {
		return userService.updateUser(id, updatedUser);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}
}
