package com.patientonboard.authenticationservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.patientonboard.authenticationservice.model.User;

public interface UserDao extends CrudRepository<User, Integer> {
	
	User findByUsername(String username);

}
