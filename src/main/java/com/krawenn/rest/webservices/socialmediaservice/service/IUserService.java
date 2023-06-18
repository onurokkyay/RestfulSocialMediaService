package com.krawenn.rest.webservices.socialmediaservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import com.krawenn.rest.webservices.socialmediaservice.entity.User;

public interface IUserService {
	List<User> retrieveAllUsers();
	void deleteUser(int userId);
	EntityModel<User> retrieveUser(int userId);
	Optional<User> retrieveUserEntiy (int userId);
	ResponseEntity<Object> createUser(User user);
}
