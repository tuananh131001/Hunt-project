package com.s3864077.hunt.controller;


import com.s3864077.hunt.model.Product;
import com.s3864077.hunt.model.ProductCategory;
import com.s3864077.hunt.service.ProductCategoryService;
import com.s3864077.hunt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
        public ResponseEntity<List<ProductCategory>> getAllProducts(
                @RequestParam(value = "page", defaultValue = "0") int page,
                @RequestParam(value = "size", defaultValue = "10") int size,
                @RequestParam(value = "sort", defaultValue = "ASC") Sort.Direction sort) {

            Pageable pageable = PageRequest.of(page, size, Sort.by(sort, "name"));
            return new ResponseEntity<>(productCategoryService.getAllProductsCategory(pageable), HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ProductCategory> getProductById(@PathVariable Long id) {
            Optional<ProductCategory> product = productCategoryService.getProductCategoryById(id);
            if (product.isPresent()) {
                return new ResponseEntity<>(product.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
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
