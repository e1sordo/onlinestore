package com.epam.laba.onlinestore.controller;

import com.epam.laba.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Requester {
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return userService.findById(1);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
