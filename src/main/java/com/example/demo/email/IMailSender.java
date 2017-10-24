/**
 * 
 */
package com.example.demo.email;

import javax.mail.MessagingException;

/**
 * @author lvalbuena
 *
 */
public interface IMailSender {
	
	void send(String to, String subject, String body) throws MessagingException; 		

}
