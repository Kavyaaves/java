package controllers;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import customersHandling.Customers;
import customersHandling.Customer;

public class UserInputController {

    public String getNextLine(Scanner sc){
        try {
            return sc.nextLine();
        }catch (InputMismatchException err){
            System.out.println("Please enter a valid input");
            getNextLine(sc);
            return "";
        }
    }

    public long getNextLong(Scanner sc){
        long getNum = 0;
        try {
            getNum = sc.nextLong();
            sc.nextLine();
        }catch (InputMismatchException err){
            System.out.println("Please enter a valid input");
            sc.nextLine();
            getNextLong(sc);
        }
        return getNum;
    }

    public Customer getCustomerDetails(Scanner sc){
        System.out.print("Enter your details:\nName: ");
        String customerName = getNextLine(sc);
        System.out.print("Phone Number: ");
        long phoneNum = getNextLong(sc);
        System.out.print("Address: ");
        String customerAddress = getNextLine(sc);
        Random random = new Random();
        int customerId = random.nextInt(99999);
        return new Customer(customerId, customerName, phoneNum, customerAddress);
    }

    public Customer getLoginDetails(Scanner sc){
        Customers customers = Customers.getInstance();
        System.out.print("Enter login details:\nName:");
        String customerName = getNextLine(sc);
        System.out.print("Phone Number: ");
        long phoneNum = getNextLong(sc);
        Customer customer = customers.getCustomer(customerName, phoneNum);
        if(customer == null){
            System.out.println("Login failed");
            this.getLoginDetails(sc);
            return null;
        }else{
            return customer;
        }
    }
}
