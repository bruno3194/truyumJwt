package com.example.truyum.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.truyum.exception.CartEmptyException;
import com.example.truyum.model.MenuItem;

@Component
public interface CartDao {

    public List<MenuItem> getAllCartItems(int userId) throws CartEmptyException;

    public void removeCartItem(int userId, int menuItemId);

    void addCartItem(int userId, int menuItemId);

    Double getCartTotal(int userId) throws CartEmptyException;
}