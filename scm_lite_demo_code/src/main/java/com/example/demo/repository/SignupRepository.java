package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Signup;
@Repository

public interface SignupRepository extends MongoRepository<Signup, String> {

	Signup findByemail(String email);
	
	boolean existsByEmail(String string);


}
