package com.example.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.truyum.dao.CartDao;
import com.example.truyum.exception.CartEmptyException;
import com.example.truyum.model.MenuItem;

@Service
public class CartService {

    @Autowired
    private CartDao dao;

    public void addCartItem(int userId, int menuItemId)
    {
        dao.addCartItem(userId, menuItemId);
    }

    public List<MenuItem> getAllCartItems(int userId) throws CartEmptyException
    {
        return dao.getAllCartItems(userId);
    }

    public void removeCartItem(int userId, int menuItemId)
    {
        dao.removeCartItem(userId, menuItemId);
    }

    public double getCartToatal(int userId) throws CartEmptyException
    {
        return dao.getCartTotal(userId);
    }

}