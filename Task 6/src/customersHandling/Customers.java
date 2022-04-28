package customersHandling;

import java.util.ArrayList;

public class Customers {

    private final ArrayList<Customer> customers =  new ArrayList<>();
    private static Customers customersInstance = null;

    public static Customers getInstance()
    {
        if (customersInstance == null)
            customersInstance = new Customers();
        return customersInstance;
    }

    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    public Customer getCustomer(String name, long phoneNum){
        Customer customer = null;
        for(Customer c: this.customers){
            if(c.getCustomerName().equals(name) && c.getPhoneNum() == phoneNum){
                customer = c;
            }
        }
        return customer;
    }
}
