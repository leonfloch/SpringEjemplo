/**
 * 
 */
package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
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
	
	public MailController(IMailSender mockMailSender) {
		this.iMailSender = mockMailSender;
		
	}

	@RequestMapping("/mail")
	public String mail() {
		iMailSender.send("leo@gmail.com", "titulo", "cuerpo");
		return "send mail";
	}
}
