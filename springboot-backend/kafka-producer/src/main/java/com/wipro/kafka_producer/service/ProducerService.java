package com.wipro.kafka_producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	public void sendMsg(String msg) {
		kafkaTemplate.send("demo-topic",msg);
	}
}
