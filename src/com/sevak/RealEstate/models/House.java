package com.sevak.RealEstate.models;

import com.sevak.RealEstate.base.BaseClassForRealEstate;
import com.sevak.all.Characteristics;

import java.io.Serializable;

public class House extends BaseClassForRealEstate implements Serializable {
    private boolean havePool;

    public House() {
    }

    public House(double price, String owner, String address, boolean havePool) {
        super(price, owner, address);
        this.havePool = havePool;
    }

    public boolean isHavePool() {
        return havePool;
    }

    public void setHavePool(boolean havePool) {
        this.havePool = havePool;
    }

    @Override
    public String toString() {
        return "Houses " + "price=" + getPrice() +"$"+
                ", owner=" + getOwner() +
                ", address=" + getAddress() +
                ", havePool=" + isHavePool();
    }



}
