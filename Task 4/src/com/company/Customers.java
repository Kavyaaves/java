package com.company;

import java.util.ArrayList;

public class Customers {
    ArrayList<Customer> customers;
    Customer currUser;

    public void createCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();
        this.customers = customers;
    }
    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    public void displayCustomers(){
        for(Customer customer: this.customers){
            customer.displayCustomer(customer);
        }
    }

    public Customer getCustomer(String name, Long phoneNum){
        for(Customer c: this.customers){
            if(c.custName.equals(name) && c.phoneNum.equals(phoneNum)){
                this.currUser = c;
                break;
            }
        }
        return this.currUser;
    }
}
