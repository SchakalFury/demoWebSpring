package com.example.demo.dao;

import com.example.demo.models.Device;
import com.example.demo.rowMapper.DeviceRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DeviceDaoImpl implements DeviceDao{

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    private final String GET_ALL_DEVICE_NAMED = "SELECT * FROM device";
    private final String GET_DEVICE_BY_ID_NAMED = "SELECT * FROM device WHERE device_id = :device_id";

    private final String GET_DEVICE_BY_ID_NAMED_QUESTION = "SELECT * FROM device WHERE device_id = ?";

    @Autowired
    public DeviceDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void getAllDevice() {
      List<Device> devices = namedParameterJdbcTemplate.query(GET_ALL_DEVICE_NAMED, new DeviceRowMapper());
        System.out.println(devices);
    }

    @Override
    public void getDeviceByIdNamed(int id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("device_id", id);
        Device device = namedParameterJdbcTemplate.queryForObject(GET_DEVICE_BY_ID_NAMED, paramMap,new DeviceRowMapper());
        System.out.println(device);
    }

    @Override
    public void getDeviceByIdQuestion(int id) {
        Device device = jdbcTemplate.queryForObject(GET_DEVICE_BY_ID_NAMED_QUESTION,new DeviceRowMapper(), id);
        System.out.println(device);
    }
}
