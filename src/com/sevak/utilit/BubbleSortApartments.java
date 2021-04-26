package com.sevak.utilit;

import com.sevak.RealEstate.models.Apartment;

import java.util.Objects;

public class BubbleSortApartments {
    public static Apartment[] sort(Apartment[] array) {
        Apartment []newArray = null;

        //chap
        for (int i = 0; i < array.length; i++) {
         if(array[i]==null){
             newArray = new Apartment[i];
             break;
         }
        }

        //sort elements
        for (int i = 0; i < Objects.requireNonNull(newArray).length; i++) {
            newArray[i]=array[i];
        }

        boolean cycle = false;
        while (!cycle) {

            cycle = true;
            for (int i = 0; i < newArray.length - 1; i++) {
                if (newArray[i].getPrice() > newArray[i + 1].getPrice()) {
                    Apartment current = newArray[i];
                    newArray[i] = newArray[i + 1];
                    newArray[i + 1] = current;
                    cycle = false;
                }
            }
        }

        //return
        for (int i = 0; i < newArray.length; i++) {
            array[i]=newArray[i];
        }
        return array;
    }
}
