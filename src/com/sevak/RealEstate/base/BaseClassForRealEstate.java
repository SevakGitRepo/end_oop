package com.sevak.RealEstate.base;

import java.io.Serializable;

public class BaseClassForRealEstate implements Serializable {

    private double price;
    private String owner;
    private String address;

    public BaseClassForRealEstate() {
    }

    public BaseClassForRealEstate(double price, String owner, String address) {

        this.price = price;
        this.owner = owner;
        this.address = address;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
