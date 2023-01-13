package com.s3864077.hunt.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@Table
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_product_id")
    private Product parentProduct;

    //getters and setters
}
