package com.epam.laba.onlinestore.service;

import com.epam.laba.onlinestore.DAO.UsersRepository;
import com.epam.laba.onlinestore.model.Order;
import com.epam.laba.onlinestore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UsersRepository usersRepository;

    @Transactional
    public User findById(Integer id) {
        Optional<User> user = usersRepository.findById(id);
        return user.orElse(null);
    }

    @Transactional
    public List<Order> getOrdersById(User user){
        return usersRepository.getOrderByUser(user);
    }
}
