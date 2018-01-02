package com.epam.laba.onlinestore.model;

import javax.persistence.*;

@Entity
@Table(name = "product",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private int id;

    @Column(name = "name", nullable = false, unique = true, length = 20)
    private String name;

    @Column(name = "description", nullable = false, unique = true, length = 20)
    private String description;

    @Column(name = "price", nullable = false, length = 20)
    private double price;
}
