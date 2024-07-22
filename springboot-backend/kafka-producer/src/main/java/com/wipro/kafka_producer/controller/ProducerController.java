package com.wipro.kafka_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.kafka_producer.service.ProducerService;



@RestController
@RequestMapping("/api")
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;

	@GetMapping("/send")
	public ResponseEntity<String> sendMsgToBroker(@RequestParam String msg) {
		
		producerService.sendMsg(msg);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
