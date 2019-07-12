package com.patientonboard.authenticationservice.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int userId;
	
	@Column(name="user_fname", nullable=false)
	private String fullName;
	
	@Column(name="user_username", unique=true, nullable=false)
	private String username;
	
	@Column(name="user_password", nullable=false)
	private String password;

	@Column(name="user_role")
	private String role;
	
	@Column(name="user_email", unique=true, nullable=false)
	private String email;
	
	@Column(name="user_occupation")
	private String occupation;
	
	@Column(name="user_birthDate")
	private Timestamp birthdate; 
	
	private String jwtToken;
	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(String fullName, String role, String email, String username, String password) {
		super();
		this.fullName = fullName;
		this.role = role;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	

	public User(int userId, String fullName, String role, String email, String username,
			String password, String occupation, Timestamp birthdate, String homePhone, String mobilePhone,
			String address) {
		super();
		this.userId = userId;
		this.role = role;
		this.email = email;
		this.username = username;
		this.password = password;
		this.occupation = occupation;
		this.birthdate = birthdate;
	
	}
	public String getToken() {
		return this.jwtToken;
	}

	public void setToken(String tok) {
		this.jwtToken = tok;
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Timestamp getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Timestamp birthdate) {
		this.birthdate = birthdate;
	}

	
	

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName  + ", role=" + role
				+ ", email=" + email + ", username=" + username + ", password=" + password + ", occupation="
				+ occupation + ", birthdate=" + birthdate + "]";
	}

	
	
	
	
	
	

}
