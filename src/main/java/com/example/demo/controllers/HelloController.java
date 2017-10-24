/**
 * 
 */
package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvalbuena
 *
 */
@RestController
public class HelloController {
	
	@Value("${app.name}")
	private String nameApp;

	@RequestMapping("/hello")
	public String hello() {
		return "hello World " + nameApp;
	}
}
