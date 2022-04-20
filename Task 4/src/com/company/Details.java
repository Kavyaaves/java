package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Details {
    public String getNextLine(Scanner sc){
        try {
            String str = sc.next();
            return str;
        }catch (InputMismatchException err){
            System.out.println("Please enter a valid input");
            getNextLine(sc);
            return "";
        }
    }

    public Long getNextLong(Scanner sc){
        Long getNum = Long.valueOf(0);
        try {
            getNum = sc.nextLong();
        }catch (InputMismatchException err){
            System.out.println("Please enter a valid input");
            sc.nextLine();
            getNextLong(sc);
        }
        return getNum;
    }

    public Customer getCustDetails(Scanner sc){
        System.out.print("Enter your details:\nName: ");
        String custName = getNextLine(sc);

        System.out.print("Phone Number: ");
        Long phoneNum = getNextLong(sc);
        System.out.print("Address: ");
        String custAddress = getNextLine(sc);
        Random random = new Random();
        int custId = random.nextInt(99999);
        Customer customer =  new Customer(custId, custName, phoneNum, custAddress);
        return customer;
    }

    public Customer getLoginDetails(Scanner sc, Customers c){
        System.out.print("Enter login details:\nName:");
        String custName = getNextLine(sc);
        System.out.print("Phone Number: ");
        Long phoneNum = getNextLong(sc);
        Customer customer = c.getCustomer(custName, phoneNum);
        if(customer == null){
            System.out.println("Login failed");
            this.getLoginDetails(sc,c);
            return null;
        }else{
            return customer;
        }
    }
}
