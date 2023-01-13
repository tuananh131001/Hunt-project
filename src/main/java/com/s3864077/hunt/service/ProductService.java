package com.s3864077.hunt.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.s3864077.hunt.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Page<Product> getAllProducts(Pageable pageable);
    public Page<Product> getAllProductsByCategory(String category, Pageable pageable);

    Page<Product> searchProducts( String name,Pageable pageable);

    Optional<Product> getProductById(Long id);

    void createProduct(Product product) throws JsonProcessingException;

    Product updateProduct(Product product);

    void deleteProduct(Long id);
}
