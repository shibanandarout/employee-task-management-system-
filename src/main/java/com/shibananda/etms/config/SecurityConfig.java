package com.shibananda.etms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//Tells Spring that this class contains configuration.
public class SecurityConfig {

		@Bean 
		//Registers the SecurityFilterChain object in the Spring container.
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
			http.csrf(csrf -> csrf.disable())//We are building a REST API, not an HTML form application, so we disable CSRF for now.
			    .authorizeHttpRequests(
			    auth -> auth
				.anyRequest()
				.permitAll());//Allow every request without authentication.
			return http.build();
		}
	
}
