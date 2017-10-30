package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.commands.UserCommand;
import com.example.demo.repositories.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService  {
	
	private UserRepository userRepository;
	
	

	/**
	 * Constructor que inyecta el UserRepository
	 * @param userRepository
	 */
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}



	@Override
	public void sigup(UserCommand userCommand) {
		userRepository.save(userCommand.toUser());		
	}

}
