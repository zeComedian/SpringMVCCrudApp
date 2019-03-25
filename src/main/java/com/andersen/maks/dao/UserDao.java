package com.andersen.maks.dao;

import com.andersen.maks.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    void save(User user);

    void delete(int id);

   User getById(int id);

    List<User> findAll();

}
