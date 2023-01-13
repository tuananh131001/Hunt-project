package com.s3864077.hunt.service.impl;

import com.s3864077.hunt.model.Product;
import com.s3864077.hunt.model.ProductCategory;
import com.s3864077.hunt.repository.ProductCategoryRepository;
import com.s3864077.hunt.repository.ProductRepository;
import com.s3864077.hunt.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {


    private final ProductCategoryRepository productCategoryRepository;

    // getAllProductsByCategory
    @Override
    @Cacheable("ProductCategory")
    public Page<ProductCategory> getAllProductsByCategory(String category, Pageable pageable){
        return productCategoryRepository.findProductCategoriesByNameContainingIgnoreCase(category, pageable);
    }

    @Override
    @Cacheable("ProductCategory")
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
