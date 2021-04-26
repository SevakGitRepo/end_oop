package com.sevak.Vehicles.base;

import java.io.Serializable;

public class BaseClassForVehicles implements Serializable {
    private double price;
    private String model;
    private String owner;
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getSpeed() {
        return year;
    }

    public void setSpeed(int year) {
        this.year = year;
    }

    public BaseClassForVehicles(double price, String model, String owner, int year) {
        this.price = price;
        this.model = model;
        this.owner = owner;
        this.year = year;
    }

}

