package com.epam.laba.onlinestore.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserTest {
    @Test
    void testApp() {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query selectUsers = session.createQuery("FROM com.epam.laba.onlinestore.model.User");
        Query selectProducts = session.createQuery("FROM com.epam.laba.onlinestore.model.Product");
        List resultsUsers = selectUsers.list();
        List resultsProducts = selectProducts.list();
        for (Object resultsProduct : resultsProducts) {
            System.out.println(resultsProduct.toString());
        }
        for (Object resultsUser : resultsUsers) {
            System.out.println(resultsUser.toString());
        }
        User user = new User();
        user.name = "Artem";
        user.mail = "artem@mail.com";
        user.password = "1369";
        session.save(user);

        session.getTransaction().commit();
        session.close();
    }
}