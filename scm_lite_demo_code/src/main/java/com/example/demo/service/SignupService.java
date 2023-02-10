package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Signup;


@Component
public interface SignupService {
	
	public Signup SigupUsers (Signup signup);

	public List<Signup> getallUsers();

	public boolean Authenticate(String email, String password);


}
