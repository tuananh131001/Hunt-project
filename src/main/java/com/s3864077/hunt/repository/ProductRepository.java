package com.s3864077.hunt.repository;

import com.s3864077.hunt.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p where lower(p.name) like lower(concat('%',:name,'%'))")
    Page<Product> findByName(@Param("name") String name, Pageable pageable);

    @Query("SELECT p FROM Product p where lower(p.code) like lower(concat('%',:code,'%'))")
    Page<Product> findByCode(@Param("code") String code, Pageable pageable);

    Page<Product> findByCategory_Name(String category, Pageable pageable);

    //findByNameContainingIgnoreCase
    @Query("SELECT p FROM Product p where lower(p.name) like lower(concat('%',:name,'%'))")
    List<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
}

