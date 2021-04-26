package com.sevak.RealEstate.models;

import com.sevak.RealEstate.base.BaseClassForRealEstate;

import java.io.Serializable;

public class Apartment extends BaseClassForRealEstate implements Serializable {
        private int floor;

    public Apartment() {
    }

    public Apartment( double price, String owner, String address, int floor) {
        super( price, owner, address);
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Apartment " + "price=" + getPrice() +"$"+
                ", owner=" + getOwner() +
                ", address=" + getAddress() +
                ", floor=" + getFloor() ;

    }
}
