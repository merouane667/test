package com.demo.productmicroservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private Double price;

    // Created to be used in the dao unit test class
    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
