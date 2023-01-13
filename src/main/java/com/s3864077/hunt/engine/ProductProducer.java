package com.s3864077.hunt.engine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.s3864077.hunt.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProductProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "products";

    public void send(Product product) throws JsonProcessingException {
        kafkaTemplate.send(TOPIC, new ObjectMapper().writeValueAsString(product));
    }
}