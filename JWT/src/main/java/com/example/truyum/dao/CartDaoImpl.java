package com.example.truyum.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.truyum.repository.CartRepository;
import com.example.truyum.repository.MenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.truyum.exception.CartEmptyException;
import com.example.truyum.model.Cart;
import com.example.truyum.model.MenuItem;

@Component
public class CartDaoImpl implements CartDao {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    private MenuItemDao menuItemDao;

    private static HashMap<String, Cart> userCarts;

    public CartDaoImpl() {
        super();
        if (userCarts == null) {
            userCarts = new HashMap<String, Cart>();
        }
    }
    public void addSamples()
    {
        MenuItem item1=menuItemDao.getMenuItem(1);
        MenuItem item2=menuItemDao.getMenuItem(2);
        Cart cartnew=new Cart(1,Arrays.asList(item1,item2),560);
        cartRepository.save(cartnew);
    }
    @Override
    public void addCartItem(int userId, int menuItemId) throws NoSuchElementException{

        Cart cart;
        if(cartRepository.existsById(userId))
            cart=(Cart)cartRepository.findById(userId).get();
        else
        {
            MenuItem item1=menuItemDao.getMenuItem(menuItemId);
            cart=new Cart(userId,Arrays.asList(item1),item1.getPrice());
            cartRepository.save(cart);
            return;
        }
        MenuItem menuItem=menuRepository.findById(menuItemId).get();
        System.out.println("carttt IS:"+cart);
        double newToatal= cart.getTotal()+menuItem.getPrice();
        cart.setTotal(newToatal);
        List<MenuItem> menuItems=cart.getMenuItems();
        menuItems.add(menuItem);

        cart.setMenuItems(menuItems);
        cartRepository.deleteById(userId);
        cartRepository.save(cart);

    }

    @Override
    public List<MenuItem> getAllCartItems(int userId) throws CartEmptyException {
        Cart cart=(Cart)cartRepository.findById(userId).get();
        return cart.getMenuItems();
    }

    @Override
    public Double getCartTotal(int userId) throws CartEmptyException {
        Cart cart=(Cart)cartRepository.findById(userId).get();
        return cart.getTotal();
    }


    @Override
    public void removeCartItem(int userId, int menuItemId) {
        Cart cart=(Cart)cartRepository.findById(userId).get();
        MenuItem menuItem=menuRepository.findById(menuItemId).get();
        double newToatal= cart.getTotal()-menuItem.getPrice();
        cart.setTotal(newToatal);
        List<MenuItem> menuItems=cart.getMenuItems();
        menuItems.remove(menuItem);
        cart.setMenuItems(menuItems);
        cartRepository.deleteById(userId);
        cartRepository.save(cart);
    }
}