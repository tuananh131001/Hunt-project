package com.s3864077.hunt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;


//Each product will have the following information:
//Code
//Name
//Description
//Product category (must be flexible and allow to update and add more)
@Builder
@Getter
@Setter
@Table
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    private String code;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<BillOfMaterial> billOfMaterialList;
}
