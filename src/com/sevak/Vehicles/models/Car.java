package com.sevak.Vehicles.models;

import com.sevak.Vehicles.base.BaseClassForVehicles;

import java.io.Serializable;

public class Car extends BaseClassForVehicles implements Serializable {
    private int speed;

    public Car(double price, String model, String owner, int year, int speed) {
        super(price, model, owner, year);
        this.speed = speed;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car " +
                "speed=" + speed +"km/h"+
                ", price=" +getPrice() + "$"+
                ", model='" + getModel() +
                ", owner='" + getOwner() +
                ", year=" + getYear();
    }
}
