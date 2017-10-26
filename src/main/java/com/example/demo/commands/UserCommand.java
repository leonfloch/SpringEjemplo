/**
 * 
 */
package com.example.demo.commands;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author leonardovalbuenacalderon
 *
 */
public class UserCommand {
	
	@NotBlank(message="{blankEmail}")
	@Email
	@Size(min=4, max=25, message="{emailSizeError}")
	private String email;
	
	@NotBlank
	@Size(min=1, max=25)
	private String name;
	
	@NotBlank
	@Size(min=6, max=25)
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
	
	

}
