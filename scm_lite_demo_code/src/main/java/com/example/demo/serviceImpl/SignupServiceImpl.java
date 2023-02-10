package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Signup;
import com.example.demo.repository.SignupRepository;
import com.example.demo.service.SignupService;
import com.example.demo.validation.PasswordEncryptionValidation;
@Service
public class SignupServiceImpl implements SignupService {
	
	@Autowired
	private SignupRepository signupRepository;

	
	
	public SignupServiceImpl(SignupRepository signupRepository) {
		super();
		this.signupRepository = signupRepository;
	}



	@Override
	public Signup SigupUsers(Signup signup) {
		return signupRepository.save(signup);
		
	}



	@Override
	public List<Signup> getallUsers() {
		return signupRepository.findAll();
	}



	@Override
	public boolean Authenticate(String email, String password) {
		Signup signup = signupRepository.findByemail(email);

		String string = PasswordEncryptionValidation.decode(signup.getPassword());
		if (signup == null || (!string.equals(password))) {
			return false;
		}
		return true;

	}
	
	
	

}
