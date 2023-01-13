package com.s3864077.hunt.service;

import com.s3864077.hunt.model.Product;
import com.s3864077.hunt.model.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {
    // CRUD
    Page<ProductCategory> getAllProductsByCategory(String category,Pageable pageable);

    Optional<ProductCategory> getProductCategoryById(Long id);



    ProductCategory createProductCategory(ProductCategory product);

    ProductCategory updateProductCategory(ProductCategory product);

    void deleteProductCategory(Long id);
}
