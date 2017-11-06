/**
 * 
 */
package com.example.demo.commands;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.domain.User;
import com.example.demo.validation.Password;
import com.example.demo.validation.UniqueEmail;

/**
 * @author leonardovalbuenacalderon
 *
 */
public class UserCommand {
	
	
	@UniqueEmail
	private String email;
	
	@NotBlank
	@Size(min=1, max=25)
	private String name;
	
	@Password
	private String password;
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User toUser() {
		User user = new User();
		user.setEmail(this.email);
		user.setName(this.name);
		user.setPassword(this.password);
		return user;
	}
	
	

}
