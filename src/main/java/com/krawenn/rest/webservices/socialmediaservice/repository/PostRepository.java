package com.krawenn.rest.webservices.socialmediaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krawenn.rest.webservices.socialmediaservice.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
}
