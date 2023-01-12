package com.s3864077.hunt.service;

import com.s3864077.hunt.model.Product;
import com.s3864077.hunt.model.ProductCategory;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {
    // CRUD
    List<ProductCategory> getAllProductsCategory(Pageable pageable);

    Optional<ProductCategory> getProductCategoryById(Long id);

    ProductCategory createProductCategory(ProductCategory product);

    ProductCategory updateProductCategory(ProductCategory product);

    void deleteProductCategory(Long id);
}
