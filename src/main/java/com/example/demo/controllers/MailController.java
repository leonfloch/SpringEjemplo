/**
 * 
 */
package com.example.demo.controllers;


import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.email.IMailSender;


/**
 * @author lvalbuena
 *
 */
@RestController
public class MailController {
	
	
	private IMailSender iMailSender;
	
	public MailController(IMailSender smtp) {
		this.iMailSender = smtp;
		
	}

	@RequestMapping("/mail")
	public String mail() throws MessagingException {
		iMailSender.send("lvalbuena@asesoftware.com", "titulo", "cuerpo");
		return "send mail";
	}
}
