package com.example.demo.dao;

import com.example.demo.models.User;
import com.example.demo.rowMapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao{

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String GET_ALL_USER = "SELECT * FROM user_entity";
    private final String GET_ALL_USER_ID = "SELECT * FROM user_entity WHERE user_id = :user_id";
    @Autowired
    public UserDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<User> getAllUser() {
    List<User> users = namedParameterJdbcTemplate.query(GET_ALL_USER, new UserRowMapper());
       return users;
    }

    @Override
    public User getUserByIdNamed(Long id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_id", id);
        User user = namedParameterJdbcTemplate.queryForObject(GET_ALL_USER_ID, paramMap, new UserRowMapper());
        return user;
    }


}
