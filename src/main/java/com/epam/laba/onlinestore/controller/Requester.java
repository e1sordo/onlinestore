package com.epam.laba.onlinestore.controller;

import com.epam.laba.onlinestore.model.Order;
import com.epam.laba.onlinestore.model.Product;
import com.epam.laba.onlinestore.model.User;
import com.epam.laba.onlinestore.service.OrderService;
import com.epam.laba.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Requester {
    private UserService userService;
    private OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        User user = userService.findById(1);
        StringBuilder text = new StringBuilder(user.getName() + " has order number: ");
        for (Order order : userService.getOrdersById(user)) {
            text.append(order.getNumberOrder()).append(" in their turn has products:");
            for (Product product : orderService.getProductsByOrder(order)) {
                text.append(product.getName()).append("(").append(product.getDescription()).append(") ");
            }
        }
        return text.toString();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
