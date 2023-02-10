package com.example.demo.validation;

import java.util.regex.Pattern;

public class SignupValidation {
	
	public static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	public static final String special_char = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	public static boolean validateusername(String username) throws Exception {
		if (username.length() == 0) {
			throw new Exception("not empty");
		}
		return true;

	}

	public static boolean validatepassword(String password) throws Exception {
		boolean validatesignup = true;
		if (password.length() < 8) {
			throw new Exception("Password should be less than 15 and more than 8 characters in length.");

		}

		String upperCaseChars = "(.*[A-Z].*)";
		if (!password.matches(upperCaseChars)) {
			throw new Exception("Password should contain atleast one upper case alphabet");

		}
		String lowerCaseChars = "(.*[a-z].*)";
		if (!password.matches(lowerCaseChars)) {
			throw new Exception("Password should contain atleast one lower case alphabet");

		}
		String numbers = "(.*[0-9].*)";
		if (!password.matches(numbers)) {
			throw new Exception("Password should contain atleast one number.");

		}

		if (!password.matches(special_char)) {
			throw new Exception("Password should contain atleast one special character");

		}

		return validatesignup;

	}

	public static boolean validateemail(String email) throws Exception {
		java.util.regex.Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {

		} else {
			throw new Exception("email is not valid");
		}
		return true;

	}

}
