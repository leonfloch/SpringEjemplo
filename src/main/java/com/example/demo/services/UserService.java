package com.example.demo.services;

import org.springframework.boot.context.event.ApplicationReadyEvent;

import com.example.demo.commands.UserCommand;

public interface UserService {
	
	void sigup(UserCommand userCommand);
	
	void affterAplicationReady(ApplicationReadyEvent event);

}
