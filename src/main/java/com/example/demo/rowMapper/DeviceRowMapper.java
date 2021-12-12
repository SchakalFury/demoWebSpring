package com.example.demo.rowMapper;

import com.example.demo.models.Device;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceRowMapper implements RowMapper<Device> {
    @Override
    public Device mapRow(ResultSet rs, int rowNum) throws SQLException {

        int id = rs.getInt("device_id");
        String deviceName = rs.getString("device_name");
        String deviceBrand = rs.getString("device_brand");
        String deviceCountry = rs.getString("country_factory");
        double price = rs.getDouble("price");
        Device device = new Device(id, deviceName, deviceBrand, deviceCountry, price);
        return device;
    }
}
