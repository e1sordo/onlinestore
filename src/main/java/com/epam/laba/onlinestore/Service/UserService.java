package com.epam.laba.onlinestore.service;

import com.epam.laba.onlinestore.DAO.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UsersRepository usersRepository;

    @Transactional
    public String findById(Integer id) {
        return usersRepository.findById(id).isPresent() ?
                usersRepository.findById(id).get().name :
                "Нет такого пользователя";
    }
}
