package com.example.demo.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class Signup {

	private String username;
	
	private String email;
	
	private String password;
	   
    
	public Signup() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
