package com.krawenn.rest.webservices.socialmediaservice.service.impl;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.krawenn.rest.webservices.socialmediaservice.entity.Post;
import com.krawenn.rest.webservices.socialmediaservice.entity.User;
import com.krawenn.rest.webservices.socialmediaservice.repository.PostRepository;
import com.krawenn.rest.webservices.socialmediaservice.service.IPostService;
import com.krawenn.rest.webservices.socialmediaservice.service.IUserService;

@Service
public class PostServiceImpl implements IPostService {

	@Autowired
	private IUserService userService;

	@Autowired
	private PostRepository postRepository;

	public List<Post> retrieveAllPostsOfUser(int userId) {
		Optional<User> user = userService.retrieveUserEntiy(userId);
		return user.get().getPosts();
	}

	public Optional<Post> retrievePostById(int postId) {
		return postRepository.findById(postId);
	}

	public ResponseEntity<Object> createPostForUser(int userId,Post post) {
		Optional<User> user = userService.retrieveUserEntiy(userId);
		post.setUser(user.get());
		Post savedPost = postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
