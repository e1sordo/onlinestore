package com.epam.laba.onlinestore.model;

import javax.persistence.*;

@Entity
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private int id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "mail", nullable = false, length = 20)
    private String mail;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "role_user", nullable = false, length = 20)
    private String role_user;

    @Column(name = "added_blacklist", nullable = false, length = 20)
    private boolean added_blacklist;

}
