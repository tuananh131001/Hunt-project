package com.s3864077.hunt.config;

import com.s3864077.hunt.enums.PurchaseOrderStatus;
import com.s3864077.hunt.model.*;
import com.s3864077.hunt.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationStartUp {
    private final ProductCategoryRepository productCategoryRepository;

    @Bean
    public CommandLineRunner loadData(MaterialsPurchaseOrderRepository materialsPurchaseOrderRepository, ManufacturingOrderProductRepository manufacturingOrderProductRepository, ManufacturingOrderRepository manufacturingOrderRepository, BillOfMaterialRepository billOfMaterialRepository, ProductCategoryRepository productCategoryRepository, ProductRepository productRepository) {
        return (args) -> {
            List<ProductCategory> category = productCategoryRepository.findAll();
            List<Product> products = productRepository.findAll();

            if (ObjectUtils.isEmpty(category)) {
                ProductCategory category1 = productCategoryRepository.save(ProductCategory.builder().name("Computer").build());
                ProductCategory category2 = productCategoryRepository.save(ProductCategory.builder().name("Phone").build());
                Product product1 = productRepository.save(Product.builder().name("MacBook").category(category1).build());
                Product product2 = productRepository.save(Product.builder().name("iPhone").category(category2).build());
                billOfMaterialRepository.save(BillOfMaterial.builder().name("MacBook bill").product(product1).build());
                billOfMaterialRepository.save(BillOfMaterial.builder().name("iPhone bill").product(product2).build());
                ManufacturingOrderProduct manufacturingOrderProduct1 =  ManufacturingOrderProduct.builder().product(product1).quantity(1).build();
                manufacturingOrderProductRepository.save(manufacturingOrderProduct1);
                ManufacturingOrderProduct manufacturingOrderProduct2 =  ManufacturingOrderProduct.builder().product(product2).quantity(1).build();
                manufacturingOrderProductRepository.save(manufacturingOrderProduct2);
//                ManufacturingOrderProduct manufacturingOrderProduct2 = manufacturingOrderProductRepository.save((ManufacturingOrderProduct.builder().product(product2).quantity(5)).build());
                List<ManufacturingOrderProduct> manufacturingOrderProducts = List.of(manufacturingOrderProduct1, manufacturingOrderProduct2);
                //https://stackoverflow.com/questions/13370221/persistentobjectexception-detached-entity-passed-to-persist-thrown-by-jpa-and-h

                ManufacturingOrder manufacturingOrder = manufacturingOrderRepository.save(ManufacturingOrder.builder().products(manufacturingOrderProducts).clientName("sir").build());
                MaterialsPurchaseOrder materialsPurchaseOrder = materialsPurchaseOrderRepository.save(MaterialsPurchaseOrder.builder().status( PurchaseOrderStatus.DONE ).manufacturingOrder(manufacturingOrder).build());
            }
            if (ObjectUtils.isEmpty(category)) {

            }
        };
    }


}
