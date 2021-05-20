package com.example.truyum.repository;

import com.example.truyum.model.Cart;
import com.example.truyum.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {


}