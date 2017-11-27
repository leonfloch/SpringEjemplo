package com.example.demo.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class InitApp implements CommandLineRunner {
	
	private static Log log = LogFactory.getLog(InitApp.class);

	@Override
	public void run(String... args) throws Exception {
		log.info("Inside app");
		
	}

}
