package com.s3864077.hunt.model;

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
public class ManufacturingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private LocalDate deliveryDate;

    private LocalDate startDate;

    private LocalDate expectedCompletion;

    private String clientName;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "manufacturing_order_product_id")
    private List<ManufacturingOrderProduct> products;

    //getters and setters
}

