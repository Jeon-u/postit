package com.alpaca.postit.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumers {
    @KafkaListener(topics = "alpa", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        System.out.println("received message : " + message);
    }
}