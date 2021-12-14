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

    private final String GET_ALL_DEVICE_NAMED = "SELECT * FROM device";//+
    private final String GET_DEVICE_BY_ID_NAMED = "SELECT * FROM device WHERE device_id = :device_id";//+

    private final String GET_DEVICE_BY_ID_NAMED_QUESTION = "SELECT * FROM device WHERE device_id = ?";//+
    private final String GET_DEVICE_BY_NAMED = "SELECT * FROM device WHERE device_name = ?"; //+
    private final String GET_DEVICE_BY_COUNTRY = "SELECT * FROM device WHERE country_factory = :country_factory";//
    private final String GET_DEVICE_BY_BRAND = "SELECT * FROM device WHERE device_brand = :device_brand";//
    private final String GET_DEVICE_PRICE_ASC = "SELECT * FROM device ORDER BY price";//
    private final String GET_DEVICE_DESC = "SELECT * FROM device ORDER BY price DESC";//

    @Autowired
    public DeviceDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Device> getAllDevice() {
      List<Device> devices = namedParameterJdbcTemplate.query(GET_ALL_DEVICE_NAMED, new DeviceRowMapper());
        return devices;
    }

    @Override
    public Device getDeviceByIdNamed(int id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("device_id", id);
        Device device = namedParameterJdbcTemplate.queryForObject(GET_DEVICE_BY_ID_NAMED, paramMap,new DeviceRowMapper());
        return device;
    }

    @Override
    public Device getDeviceByIdQuestion(int id) {
        Device device = jdbcTemplate.queryForObject(GET_DEVICE_BY_ID_NAMED_QUESTION,new DeviceRowMapper(), id);
        return device;
    }

    @Override
    public Device getDeviceByNamed(String name) {
        Device device = jdbcTemplate.queryForObject(GET_DEVICE_BY_NAMED,new DeviceRowMapper(), name);
        return device;
    }

    @Override
    public List<Device> getDeviceCountry(String countryFactory) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("country_factory", countryFactory);
        List<Device> devices = namedParameterJdbcTemplate.query(GET_DEVICE_BY_COUNTRY, paramMap,new DeviceRowMapper() );
        return devices;
    }

    @Override
    public List<Device> getDeviceBrand(String deviceBrand) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("device_brand", deviceBrand);
        List<Device> devices = namedParameterJdbcTemplate.query(GET_DEVICE_BY_BRAND, paramMap,new DeviceRowMapper() );
        return devices;
    }

    @Override
    public List<Device> getDeviceAsc() {
        List<Device> devices = namedParameterJdbcTemplate.query(GET_DEVICE_PRICE_ASC, new DeviceRowMapper());
        return devices;
    }

    @Override
    public List<Device> getDeviceDesc() {
        List<Device> devices = namedParameterJdbcTemplate.query(GET_DEVICE_DESC, new DeviceRowMapper());
        return devices;
    }
}
