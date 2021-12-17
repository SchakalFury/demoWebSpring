package com.example.demo.controllers;

import com.example.demo.dao.DeviceDaoImpl;
import com.example.demo.models.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String deviceById(@RequestParam(name = "id", required = false, defaultValue = "") int id, Model model) {
        Device device = deviceDaoimpl.getDeviceByIdNamed(id);
        model.addAttribute("device", device);
        return "device-by-id";
    };

    @RequestMapping("/device-named")//+
    public String getDeviceByNamed(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        Device device = deviceDaoimpl.getDeviceByNamed(name);
        model.addAttribute("device", device);
        return "device-named";
    };


    @RequestMapping("/devices-country")//+
    public String deviceCountry(@RequestParam(name = "country", required = false, defaultValue = "") String country, Model model){
        List<Device> devices = deviceDaoimpl.getDeviceCountry(country);
        model.addAttribute("devices", devices);
        return "all-devices";
    };

    @RequestMapping("/devices-brand")//++
    public String deviceBrand(@RequestParam(name = "brand", required = false, defaultValue = "") String brand, Model model){
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
