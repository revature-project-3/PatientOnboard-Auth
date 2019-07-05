package com.patientonboard.authenticationservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Column(name="user_fname", nullable=false)
	private String fName;

	@Column(name="user_lname", nullable=false)
	private String lName;
	
	@Column(name="user_role", nullable=false)
	private String role;
	
	@Column(name="user_email", unique=true, nullable=false)
	private String email;

	@Column(name="user_username", unique=true, nullable=false)
	private String username;
	
	@Column(name="user_password", nullable=false)
	private String password;
	
	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String fName, String lName, String role, String email, String username, String password) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
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
		return "Patient [fName=" + fName + ", lName=" + lName + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
	
	
	

}
