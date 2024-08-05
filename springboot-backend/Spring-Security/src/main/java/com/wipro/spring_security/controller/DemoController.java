package com.wipro.spring_security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
@GetMapping("/hello")
public ResponseEntity<String> getResponse(){
	String str="hello from ganesh";
	return new ResponseEntity<String>(str,HttpStatus.OK);
}
}
