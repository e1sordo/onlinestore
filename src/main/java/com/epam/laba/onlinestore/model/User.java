package com.epam.laba.onlinestore.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
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
