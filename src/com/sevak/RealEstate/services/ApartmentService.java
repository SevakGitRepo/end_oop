package com.sevak.RealEstate.services;

import com.sevak.RealEstate.models.House;
import com.sevak.all.Characteristics;
import com.sevak.RealEstate.models.Apartment;
import com.sevak.utilit.BubbleSortApartments;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class ApartmentService implements Characteristics {
    Apartment[]apartments = new Apartment[1000];

    {
//        Apartment apartment1 = new Apartment( 20000.0, "Owner1", "Address1", 1);
//        Apartment apartment2 = new Apartment( 30000.0, "Owner2", "Address2", 2);
//        Apartment apartment3 = new Apartment( 40000.0, "Owner3", "Address3", 3);
//        Apartment apartment4 = new Apartment( 50000.0, "Owner4", "Address4", 4);
//        Apartment apartment5 = new Apartment( 60000.0, "Owner5", "Address5", 5);
//        apartments[0] = apartment1;
//        apartments[1] = apartment2;
//        apartments[2] = apartment3;
//        apartments[3] = apartment4;
//        apartments[4] = apartment5;
    }

    {
//        try(FileOutputStream f = new FileOutputStream("Apartment.txt");
//            ObjectOutputStream o = new ObjectOutputStream(f)) {
//
//            Apartment apartment1 = new Apartment(20000.0, "Owner1", "Address1", 1);
//            Apartment apartment2 = new Apartment(30000.0, "Owner2", "Address2", 2);
//            Apartment apartment3 = new Apartment(40000.0, "Owner3", "Address3", 3);
//            Apartment apartment4 = new Apartment( 50000.0, "Owner4", "Address4", 4);
//            Apartment apartment5 = new Apartment( 60000.0, "Owner5", "Address5", 5);
//
//            // Write objects to file
//
//            o.writeObject(apartment1);
//            o.writeObject(apartment2);
//            o.writeObject(apartment3);
//            o.writeObject(apartment4);
//            o.writeObject(apartment5);
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        } catch (IOException e) {
//            System.out.println("Error initializing stream");
//        }

        try (FileInputStream fi = new FileInputStream("Apartment.txt");
             ObjectInputStream oi = new ObjectInputStream(fi)){

            // Read objects
            apartments[0] = (Apartment) oi.readObject();
            apartments[1] = (Apartment) oi.readObject();
            apartments[2] = (Apartment) oi.readObject();
            apartments[3] = (Apartment) oi.readObject();
            apartments[4] = (Apartment) oi.readObject();

        }catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getAll(){
        for (Apartment apartment : apartments) {
            if(apartment==null)
                break;
            System.out.println(apartment);
        }
    }

    @Override
    public void getCheapest(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(apartments[i]);
        }
    }


    public void getExpensive(int n){
        int k = 0;
        for (int i = 0; i < apartments.length; i++) {
            if(apartments[i]==null)
                break;
            k=i;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(apartments[k--]);
        }
    }

    public void save(){
        Apartment apartment = null;
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
                    System.out.println("Enter the floor 1-100");
                    int floor = scanner.nextInt();
                    if(floor<1||floor>100){
                        System.out.println("Floor is incorrect");
                    }else {
                        apartment = new Apartment(price,owner,address,floor);
                    }
                }

            }
        }
        if(apartment !=null){
            for (int i = 0; i < apartments.length; i++) {
                if(apartments[i]==null){
                    apartments[i]=apartment;
                    BubbleSortApartments.sort(apartments);
                    break;
                }
            }
            try (FileOutputStream f = new FileOutputStream(new File("Apartment.txt"));
                 ObjectOutputStream o = new ObjectOutputStream(f)) {
                for (Apartment value : apartments) {
                    // Write objects to file
                    if(value==null)
                        break;
                    o.writeObject(value);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (Apartment apartment1 : apartments) {
            if(apartment1==null)
                break;
            System.out.println(apartment1);
        }
        ////save file //,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

    }
}
