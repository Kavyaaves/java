package customersHandling;

public class Customer {
    public Integer customerId;
    public String customerName;
    public Long phoneNum;
    public String address;

    public Customer(){}

    public Customer(Integer customerId, String customerName,Long phoneNum,String address){
        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public void displayCustomer(Customer customer){
        System.out.format("%15s%15s%15s%15s", customer.customerId, customer.customerName, customer.phoneNum, customer.address);
    }

}
