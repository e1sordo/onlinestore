package com.epam.laba.onlinestore.DAO;

import com.epam.laba.onlinestore.model.Order;
import com.epam.laba.onlinestore.model.User;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UsersRepository extends Repository<User, Integer> {
    Optional<User> findById(Integer id);

    default List<Order> getOrderByUser(User user) {
        return user.getOrders();
    }
}
