package com.s3864077.hunt.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class PurchaseOrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private int quantity;


}

