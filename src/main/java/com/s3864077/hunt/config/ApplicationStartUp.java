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
    public CommandLineRunner loadData(ComponentRepository componentRepository , MaterialsPurchaseOrderRepository materialsPurchaseOrderRepository, ManufacturingOrderProductRepository manufacturingOrderProductRepository, ManufacturingOrderRepository manufacturingOrderRepository, BillOfMaterialRepository billOfMaterialRepository, ProductCategoryRepository productCategoryRepository, ProductRepository productRepository) {
        return (args) -> {
            List<ProductCategory> category = productCategoryRepository.findAll();
            List<Product> products = productRepository.findAll();

            if (ObjectUtils.isEmpty(category)) {
                ProductCategory category1 = productCategoryRepository.save(ProductCategory.builder().name("Computer").build());
                ProductCategory category2 = productCategoryRepository.save(ProductCategory.builder().name("Phone").build());
                ProductCategory category3 = productCategoryRepository.save(ProductCategory.builder().name("Tablet").build());
                ProductCategory category4 = productCategoryRepository.save(ProductCategory.builder().name("TV").build());
                ProductCategory category5 = productCategoryRepository.save(ProductCategory.builder().name("Camera").build());
                Product product1 = productRepository.save(Product.builder().name("MacBook").category(category1).build());
                Product product2 = productRepository.save(Product.builder().name("iPhone").category(category2).build());
                Product product3 = productRepository.save(Product.builder().name("iPad").category(category3).build());
                Product product4 = productRepository.save(Product.builder().name("Apple TV").category(category4).build());
                Product product5 = productRepository.save(Product.builder().name("iPod").category(category5).build());
                Product product6 = productRepository.save(Product.builder().name("iMac").category(category1).build());
                Product product7 = productRepository.save(Product.builder().name("Mac Pro").category(category1).build());
                Product product8 = productRepository.save(Product.builder().name("Mac Mini").category(category1).build());
                Product product9 = productRepository.save(Product.builder().name("Apple Watch").category(category2).build());
                Product product10 = productRepository.save(Product.builder().name("Apple Pencil").category(category3).build());
                Product product11 = productRepository.save(Product.builder().name("Apple TV 4K").category(category4).build());
                com.s3864077.hunt.model.Component component1 = componentRepository.save(com.s3864077.hunt.model.Component.builder().name("CPU").parentProduct(product1).build());
                com.s3864077.hunt.model.Component component2 = componentRepository.save(com.s3864077.hunt.model.Component.builder().name("GPU").parentProduct(product1).build());
                com.s3864077.hunt.model.Component component3 = componentRepository.save(com.s3864077.hunt.model.Component.builder().name("RAM").parentProduct(product1).build());
                com.s3864077.hunt.model.Component component4 = componentRepository.save(com.s3864077.hunt.model.Component.builder().name("SCREEN").parentProduct(product2).build());
                com.s3864077.hunt.model.Component component5 = componentRepository.save(com.s3864077.hunt.model.Component.builder().name("CPU").parentProduct(product2).build());
                com.s3864077.hunt.model.Component component6 = componentRepository.save(com.s3864077.hunt.model.Component.builder().name("RAM").parentProduct(product2).build());
                billOfMaterialRepository.save(BillOfMaterial.builder().name("MacBook bill").product(product1).build());
                billOfMaterialRepository.save(BillOfMaterial.builder().name("iPhone bill").product(product2).build());
                billOfMaterialRepository.save(BillOfMaterial.builder().name("iPad bill").product(product3).build());
                billOfMaterialRepository.save(BillOfMaterial.builder().name("Apple TV bill").product(product4).build());
                billOfMaterialRepository.save(BillOfMaterial.builder().name("iPod bill").product(product5).build());
                billOfMaterialRepository.save(BillOfMaterial.builder().name("iMac bill").product(product6).build());
                billOfMaterialRepository.save(BillOfMaterial.builder().name("Mac Pro bill").product(product7).build());
                ManufacturingOrderProduct manufacturingOrderProduct1 =  ManufacturingOrderProduct.builder().product(product1).quantity(1).build();
                manufacturingOrderProductRepository.save(manufacturingOrderProduct1);
                ManufacturingOrderProduct manufacturingOrderProduct2 =  ManufacturingOrderProduct.builder().product(product2).quantity(2).build();
                manufacturingOrderProductRepository.save(manufacturingOrderProduct2);
                ManufacturingOrderProduct manufacturingOrderProduct3 =  ManufacturingOrderProduct.builder().product(product3).quantity(3).build();
                manufacturingOrderProductRepository.save(manufacturingOrderProduct3);
                ManufacturingOrderProduct manufacturingOrderProduct4 =  ManufacturingOrderProduct.builder().product(product4).quantity(4).build();
                manufacturingOrderProductRepository.save(manufacturingOrderProduct4);

//                ManufacturingOrderProduct manufacturingOrderProduct2 = manufacturingOrderProductRepository.save((ManufacturingOrderProduct.builder().product(product2).quantity(5)).build());
                List<ManufacturingOrderProduct> manufacturingOrderProducts = List.of(manufacturingOrderProduct1, manufacturingOrderProduct2);
                //https://stackoverflow.com/questions/13370221/persistentobjectexception-detached-entity-passed-to-persist-thrown-by-jpa-and-h
                List<ManufacturingOrderProduct> manufacturingOrderProducts1 = List.of(manufacturingOrderProduct3, manufacturingOrderProduct4);

                ManufacturingOrder manufacturingOrder = manufacturingOrderRepository.save(ManufacturingOrder.builder().products(manufacturingOrderProducts).clientName("Quang").build());
                ManufacturingOrder manufacturingOrder1 = manufacturingOrderRepository.save(ManufacturingOrder.builder().products(manufacturingOrderProducts1).clientName("Thanh NN").build());

                MaterialsPurchaseOrder materialsPurchaseOrder = materialsPurchaseOrderRepository.save(MaterialsPurchaseOrder.builder().status( PurchaseOrderStatus.DONE ).manufacturingOrder(manufacturingOrder).build());
                MaterialsPurchaseOrder materialsPurchaseOrder1 = materialsPurchaseOrderRepository.save(MaterialsPurchaseOrder.builder().status( PurchaseOrderStatus.DRAFT ).manufacturingOrder(manufacturingOrder1).build());
            }
            if (ObjectUtils.isEmpty(category)) {

            }
        };
    }


}
