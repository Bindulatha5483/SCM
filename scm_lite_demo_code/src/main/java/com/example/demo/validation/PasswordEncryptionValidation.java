package com.example.demo.validation;

import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.validation.annotation.Validated;

import com.example.demo.model.Signup;

public class PasswordEncryptionValidation {

	public static String decode(String password) {
		AES256TextEncryptor encryptor = new AES256TextEncryptor();
		encryptor.setPassword("mypassword");
		String decryptedPassword = encryptor.decrypt(password);
		return decryptedPassword;
	}
	public static String encryption(@Validated Signup signup) {
		AES256TextEncryptor encryptor = new AES256TextEncryptor();
		encryptor.setPassword("mypassword");
		String myEncryptedPassword = encryptor.encrypt(signup.getPassword());
		signup.setPassword(myEncryptedPassword);
		return "successs";
	}
}
