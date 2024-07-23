package com.abc.kafkaconsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.abc.kafkaproducer.model.Customer;



@Service
public class ConsumerService {

//	@KafkaListener(topics = "demo-topic", groupId = "group-id")
//	public void consumeMessage(String msg) {
//		System.out.println(msg);		 
//	}
	
	
	@KafkaListener(topics = "demo-topic", groupId = "group-id")
	public void consumeCustomerMessage(Customer customer) {
		System.out.println(customer.getCustomerName()+" "+customer.getAge()+" "+customer.getEmail());		 
	}	
}
