package com.s3864077.hunt.repository;

import com.s3864077.hunt.model.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
    Page<ProductCategory> findProductCategoriesByNameContainingIgnoreCase(String category, Pageable pageable);
}
