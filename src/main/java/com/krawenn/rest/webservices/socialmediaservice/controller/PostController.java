package com.krawenn.rest.webservices.socialmediaservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krawenn.rest.webservices.socialmediaservice.entity.Post;
import com.krawenn.rest.webservices.socialmediaservice.service.impl.PostServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@Validated
public class PostController {
	
	@Autowired
	private PostServiceImpl postService;

	@GetMapping("/socialmediaservice/post/{postId}")
	public Optional<Post> retrievePostById(@Min(1) @PathVariable int postId) {
		return postService.retrievePostById(postId);
	}
	
	@GetMapping("/socialmediaservice/posts/{userId}")
	public List<Post> retrieveAllPostsOfUser(@Min(1) @PathVariable int userId) {
		return postService.retrieveAllPostsOfUser(userId);
	}

	@PostMapping("/socialmediaservice/posts/{userId}")
	public ResponseEntity<Object> createPostForUser(@Min(1) @PathVariable int id,@Valid @RequestBody Post post) {
		return postService.createPostForUser(id, post);
	}

}
