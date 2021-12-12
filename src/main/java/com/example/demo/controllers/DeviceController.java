package com.example.demo.controllers;

import com.example.demo.dao.DeviceDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeviceController {
    private DeviceDaoImpl deviceDaoimpl;

    @Autowired
    public DeviceController(DeviceDaoImpl deviceDaoimpl) {
        this.deviceDaoimpl = deviceDaoimpl;
    }

    @GetMapping("/get-all-devices")
        public void getAllDevice() {
        deviceDaoimpl.getAllDevice();
    }

    @GetMapping("/get-devices-by-id-named")
    public void getDeviceByIdNamed() {
        int id = 46;
        deviceDaoimpl.getDeviceByIdNamed(id);
    }

    @GetMapping("/get-devices-by-id-Question")
    public void getDeviceByIdQuestion() {
        int id = 47;
        deviceDaoimpl.getDeviceByIdQuestion(id);
    }


}
