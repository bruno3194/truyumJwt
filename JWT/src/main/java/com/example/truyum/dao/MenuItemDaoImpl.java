package com.example.truyum.dao;

import java.util.List;

import com.example.truyum.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.example.truyum.model.MenuItem;


@Component
public class MenuItemDaoImpl implements MenuItemDao {

    @Autowired
    MenuRepository menuRepository;

    private static List<MenuItem> menuItemList;

    public MenuItemDaoImpl() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
        menuItemList = (List<MenuItem>) context.getBean("menuItems");
        System.out.println("Menu Items: "+menuItemList);

    }

    @Override
    public List<MenuItem> getMenuItemListAdmin() {
    	
 
        return menuItemList;
    }

    @Override
    public List<MenuItem> getMenuItemListCustomer() {
    	for(MenuItem menuItem:menuItemList)
        {  menuRepository.save(menuItem);}
        return menuRepository.findAll();
    }

    @Override
    public void modifyMenuItem(MenuItem menuItem) {
        menuRepository.save(menuItem);
    }

    @Override
    public MenuItem getMenuItem(int menuItemId) {
        return menuRepository.findById(menuItemId).get();
    }

}