package com.wipro.config_server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Value("${name}")
	private String username; 
	
	@Value("${pass}")
	private String password; 
	
	
	@GetMapping("/demo")
	public String getMessageFromConfig() {
		
		return username+" "+password;
	}
}
