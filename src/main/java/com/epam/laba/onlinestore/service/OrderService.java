package com.epam.laba.onlinestore.service;

import com.epam.laba.onlinestore.DAO.OrdersRepository;
import com.epam.laba.onlinestore.model.Order;
import com.epam.laba.onlinestore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrdersRepository ordersRepository;

    @Transactional
    public Order getOrderByNumberOrder(String number) {
        Optional<Order> order = ordersRepository.getOrderByNumberOrder(number);
        return order.orElse(null);
    }

    @Transactional
    public List<Product> getProductsByOrder(Order order){
        return ordersRepository.getProductsByOrder(order);
    }
}
