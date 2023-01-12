package com.s3864077.hunt.service.impl;

import com.s3864077.hunt.model.Product;
import com.s3864077.hunt.model.ProductCategory;
import com.s3864077.hunt.repository.ProductCategoryRepository;
import com.s3864077.hunt.repository.ProductRepository;
import com.s3864077.hunt.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {


    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> getAllProductsCategory(Pageable pageable) {
        return productCategoryRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<ProductCategory> getProductCategoryById(Long id) {
        return productCategoryRepository.findById(id);
    }

    @Override
    public ProductCategory createProductCategory(ProductCategory product) {
        return productCategoryRepository.save(product);
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory product) {
        return productCategoryRepository.save(product);
    }

    @Override
    public void deleteProductCategory(Long id) {
        productCategoryRepository.deleteById(id);
    }
}
