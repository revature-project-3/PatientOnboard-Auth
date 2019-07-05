package com.patientonboard.authenticationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patientonboard.authenticationservice.dao.UserDao;
import com.patientonboard.authenticationservice.model.User;


@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping(value="/auth")
public class AuthController {

	
	private UserDao userDao;

	public AuthController(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<User> login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		System.out.println("In Auth, Username input: " + username);	
		User user = new User("John","Jackson","jjack@gmail.com","Doctor","jjack","pass");
		//User user = UserDao.getHash(username, password);
//		if (user == null) {
//			return  new ResponseEntity<User>(new User(), HttpStatus.UNAUTHORIZED);
//		}		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping(value="/updateUserProfile")
	public User updateUser(@RequestParam("username") String usernameParam,
			@RequestParam("password") String passwordParam, @RequestParam("email") String emailParam, 
			@RequestParam("profession") String professionParam){
				
				System.out.println("in the update user method");
				String username = usernameParam;
				String password = passwordParam;
				String email = emailParam;
				String profession = professionParam;

				User newUser = new User(username, password);
				User updateUser = new User(username, password);
				updateUser.setUsername(username);
				updateUser.setPassword(password);
				System.out.println(updateUser.toString());
				userDao.update(updateUser);
				
				return updateUser;
			}
	//// 
	@PostMapping(value = "/registerUser")
	public ResponseEntity<User> registerUser(@RequestParam("username") String usernameParam,
			@RequestParam("password") String passwordParam, @RequestParam("firstname") String firstnameParam,
			@RequestParam("lastname") String lastnameParam, @RequestParam("email") String emailParam) {

		System.out.println("in the register user method");
		String username = usernameParam;
		String password = passwordParam;
		String firstname = firstnameParam;
		String lastname = lastnameParam;
		String email = emailParam;		

		User newUser = new User(username, password);
		newUser.setEmail(email);
		newUser.setfName(firstname);
		newUser.setlName(lastname);	
		System.out.println(newUser.toString());
		userDao.insert(newUser);
		return new ResponseEntity<User>(newUser, HttpStatus.OK);
		
	}

	
	
}
