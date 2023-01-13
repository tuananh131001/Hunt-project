package com.s3864077.hunt.controller;


import com.s3864077.hunt.model.Product;
import com.s3864077.hunt.model.ProductCategory;
import com.s3864077.hunt.service.ProductCategoryService;
import com.s3864077.hunt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/products/category")
public class ProductCategoryController {

        private final ProductCategoryService productCategoryService;

        @Autowired
        public ProductCategoryController(ProductCategoryService productCategoryService) {
            this.productCategoryService = productCategoryService;
        }

    @GetMapping
    public Page<ProductCategory> getAllProducts(Pageable pageable, @RequestParam(required = false) String category) {
        if(category != null) {
            return productCategoryService.getAllProductsByCategory(category, pageable);
        }
        return productCategoryService.getAllProductsByCategory("", pageable);
    }


        @PostMapping
        public ResponseEntity<ProductCategory> createProductCategory(@Validated @RequestBody ProductCategory product) {
            return new ResponseEntity<>(productCategoryService.createProductCategory(product), HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<ProductCategory> updateProduct(@PathVariable Long id, @Validated @RequestBody ProductCategory product) {
            Optional<ProductCategory> existingProduct = productCategoryService.getProductCategoryById(id);
            if (existingProduct.isPresent()) {
                product.setId(id);
                return new ResponseEntity<>(productCategoryService.updateProductCategory(product), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<ProductCategory> deleteProduct(@PathVariable Long id) {
            Optional<ProductCategory> existingProduct = productCategoryService.getProductCategoryById(id);
            if (existingProduct.isPresent()) {
                productCategoryService.deleteProductCategory(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
}
