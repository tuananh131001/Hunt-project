package com.s3864077.hunt.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@Table
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bill_of_material_id")
    private BillOfMaterial billOfMaterial;

    private int beginningQuantity;
    private int totalIn;
    private int totalOut;
    private int available;
    private LocalDate startDate;
    private LocalDate endDate;

    public void updateTotalIn(int quantity) {
        this.totalIn += quantity;
        this.available += quantity;
    }

    public void updateTotalOut(int quantity) {
        this.totalOut += quantity;
        this.available -= quantity;
    }

    //getters and setters
}
