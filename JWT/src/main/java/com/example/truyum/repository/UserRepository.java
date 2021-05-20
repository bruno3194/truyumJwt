package com.example.truyum.repository;

import com.example.truyum.dao.UserDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserDao, Integer> {

    UserDao findByUsername(String username);

}