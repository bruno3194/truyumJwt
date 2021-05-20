package com.example.truyum.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;



@NoArgsConstructor
@Entity
public class Cart {

    @Id
    private int id;
    @ManyToMany(targetEntity=MenuItem.class)
    private List<MenuItem> menuItems;

    private double total;

    public Cart(int id, List<MenuItem> menuItems){
        this.id = id;
        this.menuItems = menuItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cart(int id, List<MenuItem> menuItems, double total) {
        super();
        this.id = id;
        this.menuItems = menuItems;
        this.total = total;
    }


}