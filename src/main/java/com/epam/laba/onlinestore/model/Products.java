package com.epam.laba.onlinestore.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public @Data
class Products implements Serializable{
    @Id
    private int id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String description;

    @Basic(optional = false)
    private double price;
}
