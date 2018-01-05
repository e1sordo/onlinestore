package com.epam.laba.onlinestore.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "orders")
public @Data
class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String numberOrder;

    private double cost = 0;

    private Date creation = new Date();

    private boolean done;

    @OneToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "id_order", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id")
    )
    private List<Product> products = new ArrayList<>();

    public double getCost() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
