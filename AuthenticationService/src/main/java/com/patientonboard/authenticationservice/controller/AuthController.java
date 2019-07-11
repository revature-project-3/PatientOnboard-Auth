package com.patientonboard.authenticationservice.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patientonboard.authenticationservice.dao.UserDao;
import com.patientonboard.authenticationservice.model.User;


//@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/auth")
public class AuthController {

	@PersistenceContext
	private EntityManager em;
	
	private UserDao userDao;
	private User user;

	public AuthController(UserDao userDao) {
		this.userDao = userDao;
	}
	//// Is set to return 
	@PostMapping(value = "/authenticate")
	public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password) {
		System.out.println("In Auth, Username input: " + username);	
		User user = new User("John","Jackson", "Doctor", "jjack@gmail.com","jjack","pass");
		user.setToken(JwtFactory.createJWT("0", "PatientOnboardingAuth", username, 1800000));
		
		//User user = UserDao.getHash(username, password);
//		if (user == null) {
//			return  new ResponseEntity<User>(new User(), HttpStatus.UNAUTHORIZED);
//		}		
		System.out.println(user.getToken());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	

	//// may need modifications
	@PostMapping(value = "/registerUser")
	public ResponseEntity<User> register(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("email") String email) {
		
		System.out.println("in registerUser" + username+" "+password+" "+ firstname);

		System.out.println("in the register user method");
		String userName = username;
		String passWord = password;
		String firstName = firstname;
		String lastName = lastname;
		String Email = email;
			

		User newUser = new User();
		newUser.setFirstName(firstname);
		newUser.setLastName(lastname);
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setEmail(email);
		System.out.println(newUser.toString());
		//this.em.persist(newUser);
		userDao.save(newUser);
		return new ResponseEntity<User>(newUser, HttpStatus.OK);
		
	}

	@PostMapping(value = "/test")
	public ResponseEntity<String> test(@RequestParam String username) {
		//User user = UserDao.getHash(username, password);
//		if (user == null) {
//			return  new ResponseEntity<User>(new User(), HttpStatus.UNAUTHORIZED);
//		}		
		System.out.println("in test case " + username);
		return new ResponseEntity<String>("valid", HttpStatus.OK);
	}
	
}
