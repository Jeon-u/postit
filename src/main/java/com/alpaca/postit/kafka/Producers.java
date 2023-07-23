package com.alpaca.postit.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class Producers {
    @Value(value = "alpa")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    public Producers(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        logger.info("sending message", message);
        this.kafkaTemplate.send(topicName, message);
    }
}