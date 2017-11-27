package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	// @formatter:off
		protected void configure(HttpSecurity http) throws Exception {
			

			http
				.authorizeRequests()					
					.anyRequest().authenticated()
					.antMatchers("/css/**").permitAll()
					.and()
				.formLogin().loginPage("/login").permitAll();
		}
		// @formatter:on

}
