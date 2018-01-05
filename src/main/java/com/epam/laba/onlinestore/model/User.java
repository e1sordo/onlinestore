package com.epam.laba.onlinestore.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public @Data
class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public String name;

    public String mail;

    public String password;

    public String role_user = "ROLE_USER";

    private boolean added_blacklist = false;

    @OneToMany
    private List<Order> orders = new ArrayList<>();

}
