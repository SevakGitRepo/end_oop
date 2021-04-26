package com.sevak;

import com.sevak.RealEstate.services.ApartmentService;
import com.sevak.RealEstate.services.HouseService;
import com.sevak.RealEstate.services.LandService;
import com.sevak.Vehicles.models.Bus;
import com.sevak.Vehicles.services.BusService;
import com.sevak.Vehicles.services.CarService;
import com.sevak.Vehicles.services.SportCarsService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome");
        System.out.println("For Real Estate enter 1");
        System.out.println("For Vehicles enter 2");

        //Start part
        int part;
        while (true) {
            try {
                part = scanner.nextInt();
                if (part == 1) {
                    System.out.println("Welcome to Real Estate part");
                    break;
                }
                if (part == 2) {
                    System.out.println("Welcome to Vehicles part");

                    break;
                }
                System.out.println("Number is incorrect");
            } catch (InputMismatchException e) {
                System.out.println("Number is incorrect");
                scanner.nextLine();
            }
        }
        System.err.println("For finish enter 0");

        if(part==1){

            //Apartment
            System.out.println("For apartment 11");//tttttttttttttttttttttttexanoc
            System.out.println("For cheapest apartment 12");//tttttttttttttttttttttttexanoc
            System.out.println("For expensive apartment  13");//tttttttttttttttttttttttexanoc
            System.out.println("------------------");
            //Houses
            System.out.println("For houses enter 14");
            System.out.println("For cheapest houses enter 15");
            System.out.println("For expensive houses enter 16");
            System.out.println("------------------");
            //Land
            System.out.println("For land enter 17");
            System.out.println("For cheapest land enter 18");
            System.out.println("For expensive land enter 19");
            System.out.println("------------------");
            int realEstate = 0;
            while (true) {
                try {
                    realEstate = scanner.nextInt();
                    if (realEstate==0)
                        break;
                    if (realEstate > 10 && realEstate < 20) {
                        switch (realEstate) {
                            case 11:
                                System.out.println("All Apartments");
                                new ApartmentService().getAll();
                                break;
                            case 12:
                                System.out.println("Cheapest Apartments");
                                new ApartmentService().getCheapest(2);
                                break;
                            case 13:
                                System.out.println("Expensive Apartments");
                                new ApartmentService().getExpensive(3);
                                break;
                            case 14:
                                System.out.println("All Houses");
                                new HouseService().getAll();
                                break;
                            case 15:
                                System.out.println("Cheapest Houses");
                                new HouseService().getCheapest(4);
                                break;
                            case 16:
                                System.out.println("Expensive Houses");
                                new HouseService().getExpensive(3);
                                break;
                            case 17:
                                System.out.println("All Land");
                                new LandService().getAll();
                                break;
                            case 18:
                                System.out.println("Cheapest Land");
                                new LandService().getCheapest(2);
                                break;
                            case 19:
                                System.out.println("Expensive Lands");
                                new LandService().getExpensive(2);
                                break;
                            default:
                                System.out.println("Something get wrong");
                        }

                        continue;
                    }
                    System.out.println("Number is incorrect");
                } catch (InputMismatchException e) {
                    System.out.println("Number is incorrect");
                    scanner.nextLine();
                }
            }
        }else{
                //Bus
                System.out.println("For 30-50 sets bus enter 21");
                System.out.println("For 15-30 sets bus enter 22");
                System.out.println("For cheapest bus enter 23");
                System.out.println("For expensive bus enter 24");
                System.out.println("--------------------------");
                //Car
                System.out.println("For car enter 25");
                System.out.println("For cheapest car enter 26");
                System.out.println("For expensive car enter 27");
                System.out.println("--------------------------");
                System.out.println("For Sport car enter 28");
                System.out.println("For cheapest Sport car enter 29");
                System.out.println("For expensive Sport car enter 30");
                System.out.println("For speed Sport car enter 31");
                System.out.println("--------------------------");

                //Car part
                int car = 0;
                while (true) {
                    try {
                        car = scanner.nextInt();
                        if(car==0)
                            break;
                        if (car > 20 && car <= 31) {
                            switch (car) {
                                case 21:
                                    System.out.println("All Buss 30-50 sets");
                                    new BusService().getAll();
                                    break;
                                case 22:
                                    System.out.println("All Buss 15-30 sets");
                                    new BusService().getAllNext();
                                    break;
                                case 23:
                                    System.out.println("Cheapest Buss");
                                    new BusService().getCheapest(2);
                                    break;
                                case 24:
                                    System.out.println("Expensive Buss");
                                    new BusService().getExpensive(3);
                                    break;
                                case 25:
                                    System.out.println("All car");
                                    new CarService().getAll();
                                    break;
                                case 26:
                                    System.out.println("Cheapest car");
                                    new  CarService().getCheapest(3);
                                    break;
                                case 27:
                                    System.out.println("Expensive car");
                                    new  CarService().getExpensive(2);
                                    break;
                                case 28:
                                    System.out.println("All Sport Cars");
                                    new SportCarsService().getAll();
                                    break;
                                case 29:
                                    System.out.println("Cheapest Sport Cars");
                                    new SportCarsService().getCheapest(2);
                                    break;
                                case 30:
                                    System.out.println("Expensive Sport Cars");
                                    new SportCarsService().getExpensive(1);
                                    break;
                                case 31:
                                    System.out.println("Sort Sport Cars by speed");
                                    new SportCarsService().getByMaxSpeeds();
                                    break;
                                default:
                                    System.out.println("Something get wrong");
                            }
                            continue;
                        }
                        System.out.println("Number is incorrect");
                    } catch (InputMismatchException e) {
                        System.out.println("Number is incorrect");
                        scanner.nextLine();
                    }
                }
            }
        System.out.println("Do you want add something ? please enter YES");
        scanner.nextLine();
        String add = scanner.nextLine();

            if (add.equals("YES")) {
                while (true) {//dfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdf
                    System.out.println("Add Apartment 1, Add House 2, Add Land 3");
                    System.out.println("Add Bus 4, Add Car 5, Add Sport Car 6");
                    try {


                        int command = scanner.nextInt();

                        switch (command) {
                            case 1:
                                new ApartmentService().save();
                                ///fil@ aPPARTMENTUM
                                break;
                            case 2:
                                new HouseService().save();
                                //File//////////house
                                break;
                            case 3:
                                new LandService().save();
                                //File//////////land
                                break;
                            case 4:
                                new BusService().save();
                                //File//////////bus
                                break;
                            case 5:
                                new CarService().save();
                                ////////////car Fle
                                break;
                            case 6:
                                new SportCarsService().save();
                                ////////////sportCar file
                                break;
                            default:
                                System.out.println("Number is incorrect");
                        }
                    }catch (InputMismatchException e){
                        System.out.println("InputMismatchException");
                        scanner.nextLine();
                    }
                    }

               // continue;//8888888888888888888888
                }   else {
                    System.out.println("Thank you");
                }

    }
}
