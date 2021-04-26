package com.sevak.Vehicles.services;

import com.sevak.Vehicles.models.Bus;
import com.sevak.Vehicles.models.Car;
import com.sevak.all.Characteristics;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CarService implements Characteristics {
    List<Car> cars = new ArrayList<>();

//    {
//        cars.add(new Car(10000.0, "BMW", "Owner1", 2000, 200));
//        cars.add(new Car(11000.0, "MERCEDES", "Owner2", 2001, 210));
//        cars.add(new Car(12000.0, "TOYOTA", "Owner3", 2002, 220));
//        cars.add(new Car(13000.0, "KIA", "Owner4", 2003, 230));
//        cars.add(new Car(14000.0, "RENO", "Owner5", 2004, 240));
//    }

    {
        //       FOR FIRST TIME
//        try (FileOutputStream f = new FileOutputStream(new File("Car.txt"));
//             ObjectOutputStream o = new ObjectOutputStream(f);) {
//
//            // Write objects to file
//            o.writeObject(new Car(10000.0, "BMW", "Owner1", 2000, 200));
//            o.writeObject(new Car(11000.0, "MERCEDES", "Owner2", 2001, 210));
//            o.writeObject(new Car(12000.0, "TOYOTA", "Owner3", 2002, 220));
//            o.writeObject(new Car(13000.0, "KIA", "Owner4", 2003, 230));
//            o.writeObject(new Car(14000.0, "RENO", "Owner5", 2004, 240));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try (FileInputStream fi = new FileInputStream(new File("Car.txt"));
             ObjectInputStream oi = new ObjectInputStream(fi)) {


            // Read objects
            Car car = null;


            while ((car = (Car) oi.readObject()) != null) {
                cars.add(car);
            }
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAll() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Override
    public void getCheapest(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(cars.get(i));
        }
    }

    @Override
    public void getExpensive(int n) {

        for (int i = 0; i < n; i++) {
            System.out.println(cars.get(cars.size() - i - 1));
        }
    }

    @Override
    public void save() {
        Car car = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter price 1000-100.000");
        double price = scanner.nextDouble();
        if (price < 1000 || price > 100_000) {
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
                        System.out.println("Enter speed 100-200");
                        int speed = scanner.nextInt();
                        if (speed < 100 || speed > 200) {
                            System.out.println("Speed is incorrect");
                        } else {
                            car = new Car(price, model, owner, year, speed);
                        }
                    }
                }
            }


        }
        if (car != null) {
            cars.add(car);
            cars.sort(Comparator.comparing(Car::getPrice));

            try (FileOutputStream f = new FileOutputStream(new File("Car.txt"));
                 ObjectOutputStream o = new ObjectOutputStream(f)) {
                for (Car value : cars) {
                    // Write objects to file
                    o.writeObject(value);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (Car car1 : cars) {
                System.out.println(car1);
            }

        }
    }
}
