package com.s3864077.hunt.model;

import com.s3864077.hunt.enums.PurchaseOrderStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Builder
@Getter
@Setter
@Table
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MaterialPurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "manufacturing_order_id")
    private ManufacturingOrder manufacturingOrder;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "materials_purchase_order_id")
    private List<PurchaseOrderProduct> products;

    @Column(nullable = false)
    private PurchaseOrderStatus status;

    //getters and setters
}

