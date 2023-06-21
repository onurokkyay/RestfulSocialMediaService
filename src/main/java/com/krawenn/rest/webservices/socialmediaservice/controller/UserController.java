package com.krawenn.rest.webservices.socialmediaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krawenn.rest.webservices.socialmediaservice.entity.User;
import com.krawenn.rest.webservices.socialmediaservice.service.IUserService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@Validated
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/socialmediaservice/users")
	public List<User> retrieveAllUsers() {
		return userService.retrieveAllUsers();
	}

	@DeleteMapping("/socialmediaservice/users/{userId}")
	public void deleteUser(@Min(1 )@PathVariable int userId) {
		userService.deleteUser(userId);
	}

	@GetMapping("/socialmediaservice/users/{userId}")
	public EntityModel<User> retrieveUser(@Min(1) @PathVariable int userId) {
		return userService.retrieveUser(userId);
	}

	@PostMapping("/socialmediaservice/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		return userService.createUser(user);
	}

}
