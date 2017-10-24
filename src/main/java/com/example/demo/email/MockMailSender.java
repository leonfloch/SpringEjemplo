package com.example.demo.email;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


@Component
public class MockMailSender implements IMailSender {
	
	private static Log log = LogFactory.getLog(MockMailSender.class);

	@Override
	public void send(String to, String subject, String body) {
		log.info("Send MOCK: " + to);
		log.info("Send MOCK: " + subject);
		log.info("Send MOCK: " + body);
	}

}
