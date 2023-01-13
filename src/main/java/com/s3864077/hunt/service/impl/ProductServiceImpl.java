package com.s3864077.hunt.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.s3864077.hunt.engine.ProductProducer;
import com.s3864077.hunt.model.Product;
import com.s3864077.hunt.model.ProductCategory;
import com.s3864077.hunt.repository.ProductCategoryRepository;
import com.s3864077.hunt.repository.ProductRepository;
import com.s3864077.hunt.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductProducer productProducer;
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    @Override
    public Page<Product> searchProducts(String name, Pageable pageable){
        return productRepository.findByNameContainingIgnoreCase(name, pageable);
    }
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    public Page<Product> getAllProductsByCategory(String category, Pageable pageable) {
        return productRepository.findProductByCategory(category, pageable);
    }
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public void createProduct(Product product) throws JsonProcessingException {
        productRepository.save(product);

    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
