package com.epam.laba.onlinestore.DAO;

import com.epam.laba.onlinestore.model.Order;
import com.epam.laba.onlinestore.model.Product;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface OrdersRepository extends Repository<Order, Integer> {
    Optional<Order> getOrderByNumberOrder(String number);

    default List<Product> getProductsByOrder(Order order) {
        return order.getProducts();
    }
}
