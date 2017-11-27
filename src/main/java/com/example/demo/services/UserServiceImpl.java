package com.example.demo.services;



import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.commands.UserCommand;
import com.example.demo.domain.User;
import com.example.demo.domain.User.Role;
import com.example.demo.repositories.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService  {
	
	private static Log log = LogFactory.getLog(UserServiceImpl.class);
	
	private UserRepository userRepository;
	
	@Value("${application.admin.email}")
	private String adminEmail;
	
	@Value("${application.admin.name: nameDefault}")
	private String adminName;
	
	@Value("${application.admin.password}")
	private String adminPassword;
	
	

	/**
	 * Constructor que injecta el UserRepository
	 * @param userRepository
	 */
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@PostConstruct
	public void init() {
		log.info("Inside Post construct");
		
	}
	
	@Override
	@EventListener
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void affterAplicationReady(ApplicationReadyEvent event) {
		
		if (!userRepository.findByEmail(adminEmail).isPresent()) {
			User user = new User();
			user.setEmail(adminEmail);
			user.setName(adminName);
			user.setPassword(adminPassword);
			user.getRoles().add(Role.ADMIN);
			userRepository.save(user);
		}
	
		
		
	}



	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void sigup(UserCommand userCommand) {
		
		User user = userCommand.toUser();
		user.getRoles().add(Role.UNVERIFIED);
		userRepository.save(user);	
		throw new RuntimeException("problema al guardar");
	}

}
