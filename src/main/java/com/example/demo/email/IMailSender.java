/**
 * 
 */
package com.example.demo.email;

/**
 * @author lvalbuena
 *
 */
public interface IMailSender {
	
	void send(String to, String subject, String body); 		

}
