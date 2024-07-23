package com.abc.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.abc.kafkaproducer.model.Customer;

@Service
public class ProducerService {

	@Autowired
	private KafkaTemplate<String,Customer> kafkaTemplate;
	
//	public void sendMsg(String msg) {
//		kafkaTemplate.send("demo-topic",msg);
//	}
	
	public void sendCustomer(Customer customer) {
		kafkaTemplate.send("demo-topic", customer);
	}
}
