package customersHandling;

import java.util.ArrayList;

public class Customers {

    private ArrayList<Customer> customers;
    private Customer currUser;

    public Customers(){};

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
            if(c.customerName.equals(name) && c.phoneNum.equals(phoneNum)){
                this.currUser = c;
                break;
            }
        }
        return this.currUser;
    }
}
