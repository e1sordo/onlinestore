package com.epam.laba.onlinestore.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public @Data
class Order implements Serializable{
    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User id_user;

    @Basic(optional = false)
    private String numberOrder;

    @Basic(optional = false)
    private double cost = 0;

    @Basic(optional = false)
    private Date creation;

    @Basic(optional = false)
    private boolean done;
}
