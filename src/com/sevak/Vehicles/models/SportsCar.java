package com.sevak.Vehicles.models;

import com.sevak.Vehicles.base.BaseClassForVehicles;

import java.io.Serializable;

public class SportsCar extends BaseClassForVehicles implements Serializable {
    private int maxSpeed;


    public SportsCar(double price, String model, String owner, int year, int maxSpeed ) {
        super(price, model, owner, year);
        this.maxSpeed = maxSpeed;

    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }


    @Override
    public String toString() {
        return "SportsCar " +
                "Max speed=" + getMaxSpeed() +"km/h"+
                ", price=" +getPrice() + "$"+
                ", model='" + getModel() +
                ", owner='" + getOwner() +
                ", year=" + getYear();
    }
}
