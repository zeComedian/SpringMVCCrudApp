package com.andersen.maks.service;

import com.andersen.maks.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll();
    void save(User user);

    void delete(int id);

    User getById(int id);
}
