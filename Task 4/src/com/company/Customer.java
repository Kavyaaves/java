package com.company;

public class Customer {
    public Integer custId;
    public String custName;
    public Long phoneNum;
    public String address;

    public Customer(){}
    public Customer(Integer custId, String custName,Long phoneNum,String address){
        this.custId = custId;
        this.custName = custName;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public void displayCustomer(Customer customer){
        System.out.format("%15s%15s%15s%15s", customer.custId, customer.custName, customer.phoneNum, customer.address);
    }

}
