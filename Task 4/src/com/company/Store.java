package com.company;

import java.util.Scanner;

public class Store {
    private void init(Scanner sc){
        Customers customers = new Customers();
        customers.createCustomers();
        HistoryTable historyTable = new HistoryTable();
        handleAuth(sc, customers, historyTable);
    }

    public void handleAuth(Scanner sc, Customers customers, HistoryTable historyTable){
        System.out.println("Choose\n1. Existing Customer\n2. New Customer\n3. Exit\n");
        int option = sc.nextInt();
        switch(option){
            case 1:
                this.login(sc, customers, historyTable);
                break;
            case 2:
                this.signUp(sc, customers, historyTable);
                break;
            case 3:
                break;
            default:
                this.handleAuth(sc, customers, historyTable);
                break;
        }
    }

    private void signUp(Scanner sc, Customers customers, HistoryTable historyTable){
        Details details = new Details();
        Customer customer = details.getCustDetails(sc);
        customers.addCustomer(customer);
        proceedWithShopping(customer, sc, customers, historyTable);
    }

    private void login(Scanner sc, Customers customers, HistoryTable historyTable){
        Details details = new Details();
        Customer customer = details.getLoginDetails(sc, customers);
        proceedWithShopping(customer, sc, customers, historyTable);
    }

    private void proceedWithShopping(Customer cust, Scanner sc, Customers customers, HistoryTable historyTable){
        Shop shop = new Shop(cust, customers, historyTable);
        shop.proceed(sc);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Store store = new Store();
        store.init(sc);
        sc.close();
    }
}
