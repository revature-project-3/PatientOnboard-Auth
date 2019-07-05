package com.patientonboard.authenticationservice.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patientonboard.authenticationservice.dao.UserDao;
import com.patientonboard.authenticationservice.model.User;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/auth")
public class AuthController {

	@PersistenceContext
	private EntityManager em;
	private UserDao userDao;

	public AuthController(UserDao userDao) {
		this.userDao = userDao;
	}
	//// Is set to return 
	@PostMapping(value = "/authenticate")
	public ResponseEntity<User> login(@RequestParam String username,
			@RequestParam String password) {
		System.out.println("In Auth, Username input: " + username);	
		User user = new User("John","Jackson", "Doctor", "jjack@gmail.com","jjack","pass");
		//User user = UserDao.getHash(username, password);
//		if (user == null) {
//			return  new ResponseEntity<User>(new User(), HttpStatus.UNAUTHORIZED);
//		}		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	

	//// may need modifications
	@PostMapping(value = "/registerUser")
	public ResponseEntity<User> register(@RequestParam("username") String usernameParam,
			@RequestParam("password") String passwordParam, @RequestParam("firstname") String firstnameParam,
			@RequestParam("lastname") String lastnameParam) {

		System.out.println("in the register user method");
		String username = usernameParam;
		String password = passwordParam;
		String firstname = firstnameParam;
		String lastname = lastnameParam;
			

		User newUser = new User(username, password);
		newUser.setFirstName(firstname);
		newUser.setLastName(lastname);
		newUser.setUsername(username);
		newUser.setPassword(password);
		System.out.println(newUser.toString());
		//em.persist(newUser);
		return new ResponseEntity<User>(newUser, HttpStatus.OK);
		
	}

	
	
}
