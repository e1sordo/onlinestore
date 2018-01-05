package com.epam.laba.onlinestore.DAO;

import com.epam.laba.onlinestore.model.User;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

@Component
public interface UsersRepository extends Repository<User, Integer> {
    User findById(Integer id);
}
