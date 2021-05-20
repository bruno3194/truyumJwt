package com.example.truyum.controller;

import java.util.List;

import com.example.truyum.repository.MenuRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.truyum.model.MenuItem;
import com.example.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
    private MenuRepository repository;

    public MenuItemController(MenuRepository repository){
        this.repository = repository;
    }

    @Autowired
    MenuItemService service;


    @GetMapping("")
    public List<MenuItem> getAllMenuItems()
    {
        LOGGER.info("start getAllMenuItems");
        List<MenuItem> list=service.getMenuItemListCustomer();
        System.out.println("list : "+list);
        LOGGER.info("end getAllMenuItems");
        return list;
    }

    @GetMapping("/{id}")
    public MenuItem getMenuItem(@PathVariable int id)
    {
        LOGGER.info("start getMenuItem");
        MenuItem menuItem=service.getMenuItem(id);
        System.out.println("get menu item : "+menuItem);
        LOGGER.info("end getAllMenuItems");
        return menuItem;
    }

    //Addding method not modifying..
    @PutMapping("")
    public void modifyMenuItem(@RequestBody MenuItem menuitem)
    {
        LOGGER.info("start modifyMenuItem");
        service.modifyMenuItem(menuitem);
        LOGGER.info("end modifyMenuItem");
    }

}