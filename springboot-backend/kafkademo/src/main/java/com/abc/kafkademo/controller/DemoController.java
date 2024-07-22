package com.abc.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.kafkademo.service.ProducerService;

@RestController
public class DemoController {
	
	@Autowired
	private ProducerService producerService;

	@GetMapping("/demo")
	public ResponseEntity<String> sendMsgToBroker(@RequestParam String msg) {
		
		producerService.sendMsg(msg);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
