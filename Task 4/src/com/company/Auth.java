package com.company;

import java.util.Scanner;

public class Auth {
    public void init(Scanner sc){
        Customers customers = new Customers();
        customers.createCustomers();
        handleAuth(sc, customers);
    }

    public void handleAuth(Scanner sc, Customers customers){
        System.out.println("Choose\n1. Existing Customer\n2. New Customer\n3. Exit\n");
        int option = sc.nextInt();
        switch(option){
            case 1:
                this.login(sc, customers);
                break;
            case 2:
                this.signUp(sc, customers);
                break;
            case 3:
                return;
            default:
                Auth auth = new Auth();
                auth.handleAuth(sc, customers);
                break;
        }
    }

    void signUp(Scanner sc, Customers customers){
        Details details = new Details();
        Customer customer = details.getCustDetails(sc);
        customers.addCustomer(customer);
        proceedWithShopping(customer, sc, customers);
    }

    void login(Scanner sc, Customers customers){
        Details details = new Details();
        Customer customer = details.getLoginDetails(sc, customers);
        proceedWithShopping(customer, sc, customers);
    }

    void proceedWithShopping(Customer cust, Scanner sc, Customers customers){
        Shop shop = new Shop(cust, customers);
        shop.proceed(sc);
    }
}
