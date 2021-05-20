package com.example.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.truyum.dao.MenuItemDao;
import com.example.truyum.model.MenuItem;

@Service
public class MenuItemService {


    @Autowired
    private MenuItemDao dao;

    public List<MenuItem> getMenuItemListCustomer()
    {
        return dao.getMenuItemListCustomer();
    }

    public MenuItem getMenuItem(int menuItemId)
    {
        return dao.getMenuItem(menuItemId);
    }

    public void modifyMenuItem(MenuItem menuItem)
    {
        dao.modifyMenuItem(menuItem);
    }
}