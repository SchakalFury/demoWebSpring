package com.example.demo.dao;

import com.example.demo.models.Device;

import java.util.List;

public interface DeviceDao {
    List<Device> getAllDevice();
    Device getDeviceByIdNamed(int id);
    Device getDeviceByIdQuestion(int id);

    Device getDeviceByNamed(String name);
    List<Device> getDeviceCountry(String countryFactory);
    List<Device> getDeviceBrand(String deviceBrand);
    List<Device> getDeviceAsc();
    List<Device> getDeviceDesc();

}
