package com.krawenn.rest.webservices.socialmediaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krawenn.rest.webservices.socialmediaservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
