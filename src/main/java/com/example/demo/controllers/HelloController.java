/**
 * 
 */
package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utils.MyUtils;

/**
 * @author lvalbuena
 *
 */
@Controller
public class HelloController {
	
	@Value("${app.name}")
	private String nameApp;

	@RequestMapping("/hello")
	public String hello(Model model) {
		
		String msg = MyUtils.getMessage("text", "url1", "url2" );
		
		model.addAttribute("name", msg);
		
		return "hello";
	}
}
