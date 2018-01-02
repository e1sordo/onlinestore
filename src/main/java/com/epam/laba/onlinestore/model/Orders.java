package com.epam.laba.onlinestore.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private int id;

    @Id
    @Column(name = "id_user", nullable = false, length = 11)
    private int id_user;

    @Column(name = "num_order", nullable = false, unique = true, length = 20)
    private String numberOrder;

    @Column(name = "cost_order", nullable = false, length = 20)
    private double cost;

    @Column(name = "date_creation", nullable = false, length = 20)
    private Date creation;

    @Column(name = "order_done", nullable = false, length = 20)
    private boolean done;
}
