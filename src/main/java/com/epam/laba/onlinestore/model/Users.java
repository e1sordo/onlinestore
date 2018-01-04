package com.epam.laba.onlinestore.model;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public @Data
class Users implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String name;

    public String mail;

    public String password;

    public String role_user = "ROLE_USER";

    private boolean added_blacklist = false;

    @OneToMany
    private Set<Orders> orders = new HashSet<>();

}
