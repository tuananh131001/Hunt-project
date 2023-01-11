package com.s3864077.hunt.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@Table(name="Product")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ManufacturingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    private LocalDate deliveryDate;

    private LocalDate startDate;

    private LocalDate expectedCompletion;

    @Column(nullable = false)
    private String clientName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturing_order_id")
    private List<ManufacturingOrderProduct> products;

    //getters and setters
}

