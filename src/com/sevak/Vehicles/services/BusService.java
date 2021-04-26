package com.sevak.Vehicles.services;

import com.sevak.RealEstate.models.Land;
import com.sevak.Vehicles.models.Bus;
import com.sevak.all.Characteristics;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BusService implements Characteristics {
    List<Bus> buses = new ArrayList<>();

//    {
//        buses.add(new Bus(20000.0, "BMW", "Owner1", 2000, 20, 7));
//        buses.add(new Bus(22000.0, "MERCEDES", "Owner2", 2001, 30, 8));
//        buses.add(new Bus(24000.0, "TOYOTA", "Owner3", 2002, 40, 8));
//        buses.add(new Bus(26000.0, "KIA", "Owner4", 2003, 35, 9));
//        buses.add(new Bus(28000.0, "RENO", "Owner5", 2004, 28, 10));
//    }

    {
//          FOR FIRST TIME
//        try {
//            FileOutputStream f = new FileOutputStream(new File("Bus.txt"));
//            ObjectOutputStream o = new ObjectOutputStream(f);
//
//            // Write objects to file
//            o.writeObject(new Bus(20000.0, "BMW", "Owner1", 2000, 20, 7));
//            o.writeObject(new Bus(22000.0, "MERCEDES", "Owner2", 2001, 30, 8));
//            o.writeObject(new Bus(24000.0, "TOYOTA", "Owner3", 2002, 40, 8));
//            o.writeObject(new Bus(26000.0, "KIA", "Owner4", 2003, 35, 9));
//            o.writeObject(new Bus(28000.0, "RENO", "Owner5", 2004, 28, 10));
//
//
//            o.close();
//            f.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try(FileInputStream fi = new FileInputStream(new File("Bus.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi)) {



            // Read objects
            Bus bus = null;


            while ((bus = (Bus) oi.readObject()) != null) {
                buses.add(bus);
            }
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAll() {
        for (Bus bus : buses) {
            if (bus.getNumberOfSit() >= 30)
                System.out.println(bus);
        }
    }


    public void getAllNext() {
        for (Bus bus : buses) {
            if (bus.getNumberOfSit() < 30)
                System.out.println(bus);
        }
    }

    @Override
    public void getCheapest(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(buses.get(i));
        }
    }

    @Override
    public void getExpensive(int n) {

        for (int i = 0; i < n; i++) {
            System.out.println(buses.get(buses.size() - i - 1));
        }
    }

    @Override
    public void save() {
        Bus bus = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter price 0-200.000");
        double price = scanner.nextDouble();
        if (price < 0 || price > 200_000) {
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
                        System.out.println("Enter number of sits 15-50");
                        int numberOfSits = scanner.nextInt();
                        if (numberOfSits < 15 || numberOfSits > 50) {
                            System.out.println("Number of sits is incorrect");
                        } else {
                            System.out.println("Enter length 5-10");
                            int length = scanner.nextInt();
                            if (length < 5 || length > 10) {
                                System.out.println("Length is incorrect");
                            } else {
                                bus = new Bus(price, model, owner, year, numberOfSits, length);
                            }
                        }
                    }
                }


            }
        }
        if (bus != null) {
            buses.add(bus);
            buses.sort(Comparator.comparing(Bus::getPrice));

            try (FileOutputStream f = new FileOutputStream(new File("Bus.txt"));
                 ObjectOutputStream o = new ObjectOutputStream(f)) {
                for (Bus value : buses) {
                    // Write objects to file
                    o.writeObject(value);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (Bus bus1 : buses) {
            System.out.println(bus1);
        }
    }

}

