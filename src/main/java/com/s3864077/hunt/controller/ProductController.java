package com.s3864077.hunt.controller;

import com.s3864077.hunt.model.BillOfMaterial;
import com.s3864077.hunt.model.Product;
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
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(value = "page", defaultValue = "0") int page,
                                        @RequestParam(value = "size", defaultValue = "5") int size,
                                        @RequestParam(value = "sort", defaultValue = "ASC") Sort.Direction sort,
                                        @RequestParam(required = false) String category) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort, "id"));
        if (category != null) {
            return productService.getAllProductsByCategory(category, pageable);
        }
        return productService.getAllProducts(pageable);
    }

    // search by name
    @GetMapping("/search")
    public Page<Product> searchProducts(@RequestParam String name, Pageable pageable) {
        return productService.searchProducts(name, pageable);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public String createProduct(@Validated @RequestBody Product product) {
        try {
            productService.createProduct(product);
            return "Product created successfully";
        } catch (Exception e) {
            return "Product creation failed";
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Validated @RequestBody Product product) {
        Optional<Product> existingProduct = productService.getProductById(id);
        if (existingProduct.isPresent()) {
            product.setId(id);
            return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
