package com.epam.laba.onlinestore.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public @Data
class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic(optional = false)
    public String name;

    @Basic(optional = false)
    public String mail;

    @Basic(optional = false)
    public String password;

    @Basic(optional = false)
    public String role_user = "ROLE_USER";

    @Basic(optional = false)
    private boolean added_blacklist = false;

}
