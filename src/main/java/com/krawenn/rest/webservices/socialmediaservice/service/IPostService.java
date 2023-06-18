package com.krawenn.rest.webservices.socialmediaservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.krawenn.rest.webservices.socialmediaservice.entity.Post;

public interface IPostService {
	List<Post> retrieveAllPostsOfUser(int userId);
	Optional<Post> retrievePostById(int postId);
	ResponseEntity<Object> createPostForUser(int id, Post post);
}
