package com.patientonboard.authenticationservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import com.patientonboard.authenticationservice.model.User;

public interface UserDao extends CrudRepository<User, Integer> {
	

	public ResponseEntity<User> login(String username, String password);
	public ResponseEntity<User> registerUser(String username, String password,
			String firstname, String lastname);
	public void insert(User user);
	public User selectById(int id);

}
