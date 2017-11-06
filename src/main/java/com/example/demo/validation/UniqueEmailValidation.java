package com.example.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.example.demo.repositories.UserRepository;

@Component
public class UniqueEmailValidation implements ConstraintValidator<UniqueEmail, String> {
	
	private UserRepository userRepository;
	
	

	public UniqueEmailValidation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}



	@Override
	public boolean isValid(String email, ConstraintValidatorContext arg1) {
		return !userRepository.findByEmail(email).isPresent();
		
	}

}
