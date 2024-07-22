package com.abc.kafkademo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	
	@KafkaListener(topics = "demo-topic", groupId = "group-id")
	public void consumeMessage(String msg) {
		System.out.println(msg);
	}
}
