package com.example.demo.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

	@Bean
	@Profile("dev")
	public IMailSender mockMailSender() {
		return new MockMailSender();
	}
	
	@Bean
	@Profile("!dev")
	public IMailSender smtpMailSender(JavaMailSender javaMailSender) {
		return new SmtpMailSender(javaMailSender);
	}
}
