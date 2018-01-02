package com.epam.laba.onlinestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_products")
public class OrderProducts {
    @Id
    @Column(name = "id_order", nullable = false, length = 11)
    private int idOrder;

    @Id
    @Column(name = "id_product", nullable = false, length = 11)
    private int idProduct;

}
