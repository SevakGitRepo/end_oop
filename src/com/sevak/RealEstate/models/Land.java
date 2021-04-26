package com.sevak.RealEstate.models;

import com.sevak.RealEstate.base.BaseClassForRealEstate;

import java.io.Serializable;

public class Land extends BaseClassForRealEstate implements Serializable {
    private int countOfTrees;

    public Land() {
    }

    public Land(double price, String owner, String address, int countOfTrees) {
        super(price, owner, address);
        this.countOfTrees = countOfTrees;
    }

    public int getCountOfTrees() {
        return countOfTrees;
    }

    public void setCountOfTrees(int countOfTrees) {
        this.countOfTrees = countOfTrees;
    }

    @Override
    public String toString() {
        return "Land " + "price=" + getPrice() +"$"+
                ", owner=" + getOwner() +
                ", address=" + getAddress() +
                ", countOfTrees=" + countOfTrees;
    }
}
