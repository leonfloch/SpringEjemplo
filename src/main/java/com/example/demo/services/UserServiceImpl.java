package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.commands.UserCommand;
import com.example.demo.domain.User;
import com.example.demo.domain.User.Role;
import com.example.demo.repositories.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService  {
	
	private UserRepository userRepository;
	
	

	/**
	 * Constructor que injecta el UserRepository
	 * @param userRepository
	 */
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
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
