package com.andersen.maks.dao;

import com.andersen.maks.entity.User;
import com.andersen.maks.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO userstable (name, email, phone_number) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPhoneNumber());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM userstable WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM userstable WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM userstable";
        return  jdbcTemplate.query(sql, new UserMapper());
    }
}
