package com.sevak.RealEstate.services;

import com.sevak.RealEstate.base.BaseClassForRealEstate;
import com.sevak.RealEstate.models.Apartment;
import com.sevak.RealEstate.models.House;
import com.sevak.RealEstate.models.Land;
import com.sevak.all.Characteristics;

import java.io.*;
import java.util.*;

public class HouseService extends BaseClassForRealEstate implements Characteristics {
    List<House> houses = new ArrayList<>();
//    {
//        House house1 = new House( 20000.0, "Owner1", "Address1", true);
//        House house2 = new House( 30000.0, "Owner2", "Address2", false);
//        House house3 = new House( 40000.0, "Owner3", "Address3", false);
//        House house4 = new House( 50000.0, "Owner4", "Address4", true);
//        House house5 = new House( 60000.0, "Owner5", "Address5", true);
//        houses.add(house1);
//        houses.add(house2);
//        houses.add(house3);
//        houses.add(house4);
//        houses.add(house5);
//    }
{
//          FOR FIRST TIME
//    try(FileOutputStream f = new FileOutputStream(new File("House.txt"));
//        ObjectOutputStream o = new ObjectOutputStream(f)) {
//
//
//        // Write objects to file
//        o.writeObject(new House( 20000.0, "Owner1", "Address1", true));
//        o.writeObject(new House( 30000.0, "Owner2", "Address2", false));
//        o.writeObject(new House( 40000.0, "Owner3", "Address3", false));
//        o.writeObject(new House( 50000.0, "Owner4", "Address4", true));
//        o.writeObject(new House( 60000.0, "Owner5", "Address5", true));
//
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
    try(FileInputStream fi = new FileInputStream(new File("House.txt"));
        ObjectInputStream oi = new ObjectInputStream(fi)) {

        // Read objects
        House house = null;


        while ((house = (House) oi.readObject()) != null) {
            houses.add(house);
        }
    } catch (EOFException ignored) {
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}
    @Override
    public void getAll() {
        for (House house : houses) {
            System.out.println(house);
        }
    }

    @Override
    public void getCheapest(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(houses.get(i));
        }
    }

    @Override
    public void getExpensive(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(houses.get(houses.size()-i-1));
        }
    }

    @Override
    public void save() {
        House house = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter price 0-200.000");
        try {
            double price = scanner.nextDouble();
            if (price < 0 || price > 200_000) {
                System.out.println("Price is incorrect");
            } else {
                System.out.println("Enter the owner name 2-20 symbol");
                scanner.nextLine();
                String owner = scanner.nextLine().trim();
                if (owner.length() < 2 || owner.length() > 20) {
                    System.out.println("Owner name is incorrect");
                } else {
                    System.out.println("Enter the address 5-50 symbol");
                    String address = scanner.nextLine().trim();
                    if (address.length() < 5 || address.length() > 50) {
                        System.out.println("Address is incorrect");
                    } else {
                        System.out.println("Enter have pool true/false");
                        boolean havePool = scanner.nextBoolean();

                        house = new House(price, owner, address, havePool);

                    }

                }
            }
        }catch (InputMismatchException e){
            System.out.println("InputMismatchException");
        }
        if(house!=null) {
            houses.add(house);
            houses.sort(Comparator.comparing(House::getPrice));
            try (FileOutputStream f = new FileOutputStream(new File("House.txt"));
                 ObjectOutputStream o = new ObjectOutputStream(f)) {
                for (House value : houses) {
                    // Write objects to file
                    o.writeObject(value);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (House house1 : houses) {
                System.out.println(house1);
            }

        }

    }
}
