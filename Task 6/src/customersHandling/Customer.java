package customersHandling;

import history.History;
import database.HistoryTable;

import java.util.ArrayList;

public class Customer {
    public final int customerId;
    private final String customerName;
    private final long phoneNum;
    private final String address;
    public static boolean isVip = false;

    public Customer(Integer customerId, String customerName, Long phoneNum, String address){
        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public int getCustomerId(){
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setIsVip(boolean vip){
        isVip = vip;
    }

    public double calculateOverallPurchase(){
        HistoryTable historyTable = HistoryTable.getInstance();
        double amount = 0.0;
        if(historyTable.getHistoryTable().containsKey(customerId)){
            ArrayList<History> historyTable1 = historyTable.getHistoryTable().get(customerId);
            amount = historyTable.getOverallAmount(historyTable1);
        }
        return amount;
    }

    public String toString(){
        return "Name: "+ customerName +"\nPhone Number: " + phoneNum + "\nAddress: " + address + "\nVIP: " + (isVip ? "Yes" : "No");
    }
}
