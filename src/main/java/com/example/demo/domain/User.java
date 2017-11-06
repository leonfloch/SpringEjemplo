package com.example.demo.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * @author lvalbuena
 *
 */
@Entity
//@Table(name="usr", indexes = {
//		@Index(columnList = "emai", unique=true)
//})
@Table(name="usr")
public class User {
	
	public static enum Role {
		UNVERIFIED, ADMIN, BLOCKED
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, length=250)
	private String email;
	
	@Column(nullable=false, length=100)
	private String name;
	
	@Column(nullable=false)
	private String password;
	
	@ElementCollection( fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private Collection<Role> roles = new HashSet<Role>();

	/**
	 * @return the roles
	 */
	public Collection<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
