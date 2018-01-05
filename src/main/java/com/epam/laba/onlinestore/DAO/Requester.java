package com.epam.laba.onlinestore.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Requester {
    @Autowired
    UsersRepository usersRepository;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return usersRepository.findById(1).name;
    }
}
