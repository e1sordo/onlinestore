package com.epam.laba.onlinestore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Application {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Hello world";
    }
}
