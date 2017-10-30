/**
 * 
 */
package com.example.demo.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.commands.UserCommand;
import com.example.demo.services.UserService;
import com.example.demo.utils.MyUtils;

/**
 * @author lvalbuena
 *
 */
@Controller
@RequestMapping("/signup")
public class SignupController {
	
	private static Log log = LogFactory.getLog(SignupController.class);
	
	private UserService userService; 
	
	

	/**
	 * 
	 * @param userService
	 */
	public SignupController(UserService userService) {		
		this.userService = userService;
	}

	@GetMapping
	public String signup(Model model) {
		model.addAttribute("user", new UserCommand());
		return "signup";
	}
	
	@PostMapping
	public String doSignup(@Validated @ModelAttribute("user") UserCommand user, BindingResult result) {
		
		if (result.hasErrors())
			return "signup";
		
		this.userService.sigup(user);
		
		return "redirect:/";
		
	}
}
