package com.epam.laba.onlinestore.model;

import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class UsersTest {
    Session session;

    {
        session = new Configuration().configure()
                .buildSessionFactory().openSession();
        session.beginTransaction();
    }

    @Test
    void testApp() {
//        Users user = new Users();
//        user.name = "ADmmin";
//        user.mail = "admin@mail.com";
//        user.password = "1369";
//        session.save(user);
//        Users user1 = new Users();
//        user1.name = "I";
//        user1.mail = "i@mail.com";
//        user1.password = "1111";
//        session.save(user1);
//        Products products = new Products();
//        products.setPrice(112.33);
//        products.setName("Наушники");
//        products.setDescription("Хорошие наушшники");
//        session.save(products);
//        Products products1 = new Products();
//        products1.setPrice(11.33);
//        products1.setName("деталь");
//        products1.setDescription("Хорошая деталь наушшника");
//        session.save(products1);
//        Query selectUsers = session.createQuery("FROM Users");
//        Query selectProducts = session.createQuery("FROM Products");
//        List resultsUsers = selectUsers.list();
//        List resultsProducts = selectProducts.list();
//        for (Object resultsProduct : resultsProducts) {
//            System.out.println(resultsProduct.toString());
//        }
//        for (Object resultsUser : resultsUsers) {
//            System.out.println(resultsUser.toString());
//        }
//        List<Users> p = selectUsers.list();
//        for (Users users : p) {
//            System.out.println(users.name);
//        }
        // Вывод списка заказов пользователя
        List<Users> selectOrder = session.createQuery("FROM Users WHERE id = 1").list();
        for (Users users : selectOrder) {
            for (Orders orders : users.getOrders()) {
                System.out.println(orders.toString());
            }
        }

        session.getTransaction().commit();
        session.close();
    }

    public Set<Orders> findOrdersByUser(Users user) {
        return user.getOrders();
    }
    
}