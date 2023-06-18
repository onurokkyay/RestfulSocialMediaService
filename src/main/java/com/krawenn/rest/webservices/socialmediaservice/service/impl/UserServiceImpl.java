package com.krawenn.rest.webservices.socialmediaservice.service.impl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.krawenn.rest.webservices.socialmediaservice.entity.User;
import com.krawenn.rest.webservices.socialmediaservice.exception.UserNotFoundException;
import com.krawenn.rest.webservices.socialmediaservice.repository.UserRepository;
import com.krawenn.rest.webservices.socialmediaservice.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	public EntityModel<User> retrieveUser(int userId) {
		Optional<User> user = retrieveUserEntiy(userId);
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

	public ResponseEntity<Object> createUser(User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	public Optional<User> retrieveUserEntiy (int userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isEmpty()) {
			throw new UserNotFoundException("User Not Found id:" + userId);
		}
		return user;
	}	

}
