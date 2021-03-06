package com.example.demo.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Constraint(validatedBy=UniqueEmailValidation.class)
@NotBlank(message="{blankEmail}")
@Email
@Size(min=4, max=25, message="{emailSizeError}")
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueEmail {
	
	String message() default "{duplicateEmail}";
	
	Class[] groups() default {};
	
	Class[] payload() default {};
	
	

}
