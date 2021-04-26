package com.sevak.RealEstate.services;

import com.sevak.RealEstate.base.BaseClassForRealEstate;
import com.sevak.RealEstate.models.House;
import com.sevak.RealEstate.models.Land;
import com.sevak.Vehicles.models.Bus;
import com.sevak.Vehicles.models.SportsCar;
import com.sevak.all.Characteristics;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LandService extends BaseClassForRealEstate implements Characteristics {

    List<Land> lands = new ArrayList<>();
//    {
//        Land land1 = new Land( 20000.0, "Owner1", "Address1", 10);
//        Land land2 = new Land( 30000.0, "Owner2", "Address2", 20);
//        Land land3 = new Land( 40000.0, "Owner3", "Address3", 30);
//        Land land4 = new Land( 50000.0, "Owner4", "Address4", 40);
//        Land land5 = new Land( 60000.0, "Owner5", "Address5", 50);
//        lands.add(land1);
//        lands.add(land2);
//        lands.add(land3);
//        lands.add(land4);
//        lands.add(land5);
//    }

    {
//          FOR FIRST TIME
//        try(FileOutputStream f = new FileOutputStream(new File("Land.txt"));
//            ObjectOutputStream o = new ObjectOutputStream(f);) {
//
//
//            // Write objects to file
//            o.writeObject(new Land( 20000.0, "Owner1", "Address1", 10));
//            o.writeObject(new Land( 30000.0, "Owner2", "Address2", 20));
//            o.writeObject(new Land( 40000.0, "Owner3", "Address3", 30));
//            o.writeObject(new Land( 50000.0, "Owner4", "Address4", 40));
//            o.writeObject(new Land( 60000.0, "Owner5", "Address5", 50));
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try(FileInputStream fi = new FileInputStream(new File("Land.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi)) {

            // Read objects
            Land land = null;


            while ((land = (Land) oi.readObject()) != null) {
                lands.add(land);
            }
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void getAll() {
        for (Land land : lands) {
            System.out.println(land);
        }
    }

    @Override
    public void getCheapest(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(lands.get(i));
        }
    }

    @Override
    public void getExpensive(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(lands.get(lands.size()-i-1));
        }
    }

    @Override
    public void save() {
        Land land = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter price 0-200.000");
        double price = scanner.nextDouble();
        if(price<0||price>200_000){
            System.out.println("Price is incorrect");
        }else{
            System.out.println("Enter the owner name 2-20 symbol");
            scanner.nextLine();
            String owner = scanner.nextLine().trim();
            if(owner.length()<2||owner.length()>20){
                System.out.println("Owner name is incorrect");
            }else{
                System.out.println("Enter the address 5-50 symbol");
                String address = scanner.nextLine().trim();
                if(address.length()<5||address.length()>50) {
                    System.out.println("Address is incorrect");
                }else {
                    System.out.println("Enter count of trees 0-50000");
                    int countOfTrees = scanner.nextInt();
                    if(countOfTrees<0||countOfTrees>50000){
                        System.out.println("Count of trees is incorrect");
                    }else {
                        land = new Land(price, owner, address, countOfTrees);
                    }
                }

            }
        }
        if(land!=null) {
            lands.add(land);
            lands.sort(Comparator.comparing(Land::getPrice));
            try (FileOutputStream f = new FileOutputStream(new File("Land.txt"));
                 ObjectOutputStream o = new ObjectOutputStream(f)) {
                for (Land value : lands) {
                    // Write objects to file
                    o.writeObject(value);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (Land land1 : lands) {
                System.out.println(land1);
            }
            //savejkkjggkjlgjkgjklkk
        }

    }
}
