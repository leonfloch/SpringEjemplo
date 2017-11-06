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

@Constraint(validatedBy= {})
@NotBlank
@Size(min=6, max=25)
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface Password {
	
	String message() default "{}";
	
	Class[] groups() default {};
	
	Class[] payload() default {};
	
	

}
