package com.example.demo.rowMapper;


import com.example.demo.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("user_id");
        String userName = rs.getString("user_name");
        String pass = rs.getString("user_pass");
        String country = rs.getString("user_country");
        String email = rs.getString("user_email");
        String phone = rs.getString("user_phone");
        String orderAdress = rs.getString("order_adress");
        String userRole = rs.getString("user_role");
        String STATUS = rs.getString("status");
        User user = new User(id, userName, pass, country, email, phone, orderAdress, userRole, STATUS);
        return user;
    }
}
