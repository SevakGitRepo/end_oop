package com.sevak.Vehicles.models;

import com.sevak.Vehicles.base.BaseClassForVehicles;

import java.io.Serializable;

public class Bus extends BaseClassForVehicles implements Serializable {
   private int numberOfSits;
   private int length;

    public Bus(double price, String model, String owner, int year, int numberOfSit, int length) {
        super(price, model, owner, year);
        this.numberOfSits = numberOfSit;
        this.length = length;
    }

    public int getNumberOfSit() {
        return numberOfSits;
    }

    public void setNumberOfSit(int numberOfSit) {
        this.numberOfSits = numberOfSit;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Buses " +
                "numberOfSits=" + numberOfSits +
                ", length=" + length +"m"+
                ", price=" +getPrice() + "$"+
                ", model='" + getModel() +
                ", owner='" + getOwner() +
                ", year=" + getYear();

    }
}
