package com.wipro.spring_security.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping("/login")
	public String loginEndpoint() {
		return "Login!";
	}

	@GetMapping("/admin")
	public String adminEndpoint() {
		return "Admin!";
	}

	@GetMapping("/user")
	public String userEndpoint() {
		return "User!";
	}

	@GetMapping("/all")
	public String allRolesEndpoint() {
		return "All Roles!";
	}

	@DeleteMapping("/delete")
	public String deleteEndpoint(@RequestBody String s) {
		//call some service to delete a resource
		return "I am deleting " + s;
	}

}
