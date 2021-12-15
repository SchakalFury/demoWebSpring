package com.example.demo.controllers;

import com.example.demo.dao.DeviceDaoImpl;
import com.example.demo.models.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;



@Controller
public class DeviceController {
    private DeviceDaoImpl deviceDaoimpl;

    @Autowired
    public DeviceController(DeviceDaoImpl deviceDaoimpl) {

        this.deviceDaoimpl = deviceDaoimpl;
    }

    @GetMapping("/all-devices")//+
    public String allDevices(Model model){
        List<Device> devices = deviceDaoimpl.getAllDevice();
        model.addAttribute("devices", devices);
        return "all-devices";
    };

    @GetMapping("/device-by-id")//+
    public String deviceById(Model model) {
        int id = 48;
        Device device = deviceDaoimpl.getDeviceByIdNamed(id);
        model.addAttribute("device", device);
        return "device-by-id";
    };

    @GetMapping("/device-question")//+
    public String deviceQuestion(Model model) {
        int id = 47;
        Device device = deviceDaoimpl.getDeviceByIdQuestion(id);
        model.addAttribute("device", device);
        return "device-question";
    };
    @GetMapping("/device-named")//+
    public String getDeviceByNamed(Model model) {
        String name = "Gear VR (SM-R324)";
        Device device = deviceDaoimpl.getDeviceByNamed(name);
        model.addAttribute("device", device);
        return "device-question";
    };


    @GetMapping("/devices-country")//+
    public String deviceCountry(Model model){
        String country = "France";
        List<Device> devices = deviceDaoimpl.getDeviceCountry(country);
        model.addAttribute("devices", devices);
        return "all-devices";
    };

    @GetMapping("/devices-brand")//++
    public String deviceBrand(Model model){
        String brand = "HOMIDO";
        List<Device> devices = deviceDaoimpl.getDeviceBrand(brand);
        model.addAttribute("devices", devices);
        return "all-devices";
    };

    @GetMapping("/devices-sorting-up")//+
    public String devicesAsc(Model model){
        List<Device> devices = deviceDaoimpl.getDeviceAsc();
        model.addAttribute("devices", devices);
        return "all-devices";
    };

    @GetMapping("/devices-sorting-down")//+
    public String devicesDesc(Model model){
        List<Device> devices = deviceDaoimpl.getDeviceDesc();
        model.addAttribute("devices", devices);
        return "all-devices";
    };
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("home", "Local Page");
        return "home";
    }
}
