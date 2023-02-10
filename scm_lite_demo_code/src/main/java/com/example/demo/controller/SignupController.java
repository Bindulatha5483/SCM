package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Signup;
import com.example.demo.repository.SignupRepository;
import com.example.demo.service.SignupService;
import com.example.demo.validation.PasswordEncryptionValidation;

import static com.example.demo.validation.SignupValidation.validateusername;

import java.util.List;

import static com.example.demo.validation.SignupValidation.validateemail;
import static com.example.demo.validation.SignupValidation.validatepassword;



@RestController
public class SignupController {
	
	@Autowired
	SignupRepository signupreopository;
	
	@Autowired
	private SignupService  signupService;

	@PostMapping(value ="/register")
	
	public ResponseEntity<Object> Createuser (@RequestBody Signup signup) throws Exception {
		if (signupreopository.existsByEmail(signup.getEmail())) {
			return ResponseEntity.ok().header("Custom-Header", "already exist").body("User already exits");

		}
		if (signup.getPassword().length() == 0) {

			return ResponseEntity.ok().header("Custom-Header", "password length").body("Failure case");

		}
		if (signup.getPassword().length() < 8) {

			return ResponseEntity.ok().header("Custom-Header", "password min length").body("Failure case");

		}

		else {
		validateusername(signup.getUsername());
		validatepassword(signup.getPassword());
		validateemail(signup.getEmail());
		PasswordEncryptionValidation.encryption(signup);

		 signupService.SigupUsers(signup);
		 
		 return ResponseEntity.ok().header("Custom-Header", "Scucess").body("200 ok sucessfully created");

		}
		
	}
	@PostMapping(value = "/login")
	public ResponseEntity<Object> Loginuser (@RequestBody Signup signup) throws Exception {
		if (!signupService.Authenticate(signup.getEmail(), signup.getPassword())) {

			return ResponseEntity.ok().header("Custom-Header", "failure").body("Failure Again you change something");

		} else {
			return ResponseEntity.ok().header("Custom-Header", "success").body("Success");

		}		
			
	}
	@GetMapping(value="/allusers")
	public List<Signup> getAllEmployees() {

		return signupService.getallUsers();
	} 
	
	
}
