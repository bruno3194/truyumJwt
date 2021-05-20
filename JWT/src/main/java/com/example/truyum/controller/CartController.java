package com.example.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.truyum.exception.CartEmptyException;
import com.example.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CartService service;


    @GetMapping("/{userId}")
    public List getAllCartItems(@PathVariable int userId) throws CartEmptyException
    {
        LOGGER.info("start getAllCartItems");
        List list=service.getAllCartItems(userId);
        double total=service.getCartToatal(userId);
        list.add("Total is:"+total);
        LOGGER.info("end getAllCartItems");
        return list;
    }

    @PostMapping("/{userId}/{menuItemId}")
    public void addCartItem(@PathVariable int userId,@PathVariable int menuItemId)
    {
        LOGGER.info("start addCartItem");
        service.addCartItem(userId, menuItemId);
        LOGGER.info("end addCartItem");
    }


    @DeleteMapping("/{userId}/{menuItemId}")
    public void removeCartItem(@PathVariable int userId,@PathVariable int menuItemId)
    {
        LOGGER.info("start removeCartItem");
        service.removeCartItem(userId, menuItemId);
        LOGGER.info("end removeCartItem");
    }
}