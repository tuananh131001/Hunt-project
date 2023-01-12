package com.s3864077.hunt.model;

import com.s3864077.hunt.enums.PurchaseOrderStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Builder
@Getter
@Setter
@Table
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MaterialsPurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "manufacturing_order_id")
    private ManufacturingOrder manufacturingOrder;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_order_product_id")
    private List<PurchaseOrderProduct> products;

    private PurchaseOrderStatus status;

    //getters and setters
}

