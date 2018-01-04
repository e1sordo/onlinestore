package com.epam.laba.onlinestore.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public @Data
class OrderProduct implements Serializable{
    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    public Order idOrder;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    public Product idProduct;

}
