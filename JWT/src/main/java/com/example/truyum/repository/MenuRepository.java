package com.example.truyum.repository;

import com.example.truyum.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MenuRepository extends JpaRepository<MenuItem, Integer> {


}
