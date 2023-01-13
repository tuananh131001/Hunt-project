package com.s3864077.hunt.engine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.s3864077.hunt.model.Product;
import com.s3864077.hunt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductConsumer {

    @Autowired
    private ProductService productService;

    @KafkaListener(topics = "products", groupId = "group_id")
    public void listen(String message) throws JsonProcessingException {
        Product product = new ObjectMapper().readValue(message, Product.class);
        productService.createProduct(product);
    }

    @KafkaListener(topics = "updateProducts", groupId = "group_id")
    public void listenUpdateProduct(String message) throws JsonProcessingException {
        Product product = new ObjectMapper().readValue(message, Product.class);
        productService.updateProduct(product);
    }
}