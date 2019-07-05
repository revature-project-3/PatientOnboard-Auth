package com.patientonboard.authenticationservice.model;

public class User {
	
	private String fName;
	private String lName;
	private String role;
	private String email;
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

	private String username;
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
