package com.sevak.Vehicles.services;

import com.sevak.Vehicles.models.Car;
import com.sevak.Vehicles.models.SportsCar;
import com.sevak.all.Characteristics;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SportCarsService implements Characteristics {

    List<SportsCar> sportsCars = new ArrayList<>();

//    {
//        sportsCars.add(new SportsCar(19000.0, "BMW", "Owner1", 2005, 300));
//        sportsCars.add(new SportsCar(18000.0, "MERCEDES", "Owner2", 2007, 340));
//        sportsCars.add(new SportsCar(20000.0, "TOYOTA", "Owner3", 2011, 320));
//        sportsCars.add(new SportsCar(25000.0, "MERCEDES", "Owner4", 2015, 350));
//        sportsCars.add(new SportsCar(30000.0, "FERRARI", "Owner5", 2018, 400));
//    }

    {
        //       FOR FIRST TIME
//        try (FileOutputStream f = new FileOutputStream(new File("SportsCar.txt"));
//             ObjectOutputStream o = new ObjectOutputStream(f);) {
//
//            // Write objects to file
//            o.writeObject(new SportsCar(19000.0, "BMW", "Owner1", 2005, 300));
//            o.writeObject(new SportsCar(18000.0, "MERCEDES", "Owner2", 2007, 340));
//            o.writeObject(new SportsCar(20000.0, "TOYOTA", "Owner3", 2011, 320));
//            o.writeObject(new SportsCar(25000.0, "MERCEDES", "Owner4", 2015, 350));
//            o.writeObject(new SportsCar(30000.0, "FERRARI", "Owner5", 2018, 400));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try (
                FileInputStream fi = new FileInputStream(new File("SportsCar.txt"));
                ObjectInputStream oi = new ObjectInputStream(fi)) {


            // Read objects
            SportsCar sportsCar = null;


            while ((sportsCar = (SportsCar) oi.readObject()) != null) {
                sportsCars.add(sportsCar);
            }
        } catch (
                EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAll() {
        for (SportsCar sportsCar : sportsCars) {
            System.out.println(sportsCar);
        }
    }

    @Override
    public void getCheapest(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(sportsCars.get(i));
        }
    }

    @Override
    public void getExpensive(int n) {

        for (int i = 0; i < n; i++) {
            System.out.println(sportsCars.get(sportsCars.size()-i-1));
        }
    }

    @Override
    public void save() {
        SportsCar sportsCar = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter price 10.000-1000.000");
        double price = scanner.nextDouble();
        if (price < 10000 || price > 1000_000) {
            System.out.println("Price is incorrect");
        } else {
            System.out.println("Enter model 2-30 symbol");
            scanner.nextLine();
            String model = scanner.nextLine().trim();
            if (model.length() < 2 || model.length() > 30) {
                System.out.println("Model name is incorrect");
            } else {
                System.out.println("Enter the owner name 2-20 symbol");
                String owner = scanner.nextLine().trim();
                if (owner.length() < 2 || owner.length() > 20) {
                    System.out.println("Owner name is incorrect");
                } else {
                    System.out.println("Enter year 2000-2021");
                    int year = scanner.nextInt();
                    if (year < 2000 || year > 2021) {
                        System.out.println("Year is incorrect");
                    } else {
                        System.out.println("Enter Max speed 200-500");
                        int maxSpeed = scanner.nextInt();
                        if (maxSpeed < 200 || maxSpeed > 500) {
                            System.out.println("Speed is incorrect");
                        } else {
                            sportsCar = new SportsCar(price, model, owner, year, maxSpeed);
                        }
                    }
                }
            }


        }
        if (sportsCar != null) {
            sportsCars.add(sportsCar);
            sportsCars.sort(Comparator.comparing(SportsCar::getPrice));
            try (FileOutputStream f = new FileOutputStream(new File("SportsCar.txt"));
                 ObjectOutputStream o = new ObjectOutputStream(f)) {
                for (SportsCar value : sportsCars) {
                    // Write objects to file
                    o.writeObject(value);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (SportsCar sportsCar1 : sportsCars) {
                System.out.println(sportsCar1);
            }
        }
    }

    public void getByMaxSpeeds(){
        sportsCars.sort(Comparator.comparing(SportsCar::getMaxSpeed));
        for (SportsCar car : sportsCars) {
            System.out.println(car);
        }
    }
}
