package com.example.demo.models;

public class Device {
    private int id;
    private String deviceName;
    private String deviceBrand;
    private String countryFactory;
    private double price;

    public Device() {
    }

    public Device(int id, String deviceName, String deviceBrand, String countryFactory, double price) {
        this.id = id;
        this.deviceName = deviceName;
        this.deviceBrand = deviceBrand;
        this.countryFactory = countryFactory;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getCountryFactory() {
        return countryFactory;
    }

    public void setCountryFactory(String countryFactory) {
        this.countryFactory = countryFactory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Device:: ==>  {" +
                "id=" + id +
                ", deviceName='" + deviceName + '\'' +
                ", deviceBrand='" + deviceBrand + '\'' +
                ", countryFactory='" + countryFactory + '\'' +
                ", price=" + price +
                '}';
    }
}
