package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HistoryTable {
    HashMap<Customer, ArrayList<History>> historyTable;
    Customer customer;
    ArrayList<History> entries;
    public HistoryTable(){
        HashMap<Customer, ArrayList<History>> historyTable  = new HashMap<>();
        this.historyTable = historyTable;
    }
    public HashMap<Customer, ArrayList<History>> getHistoryTable(){
        return this.historyTable;
    }

    public void addToHistoryTable(Customer cust, History history){
        if(this.historyTable.containsKey(cust)){
            ArrayList<History> existingRecord = this.historyTable.get(cust);
            existingRecord.add(history);
            this.historyTable.put(cust, existingRecord);
        }else{
            ArrayList<History> newHistory = new ArrayList<>();
            newHistory.add(history);
            this.historyTable.put(cust, newHistory);
        }
    }

    public void displayHistoryTable(){
        for(Map.Entry<Customer, ArrayList<History>> history: this.historyTable.entrySet()){
            ArrayList<History> val = history.getValue();
            Customer key = history.getKey();
            Float totalAmount = Float.valueOf(0);
            System.out.println("\n=====================================================================\n");
            System.out.println("Products\n");
            System.out.format("%15s%15s%15s%15s%15s\n", "ID", "NAME", "AMOUNT", "QUANTITY", "TOTAL AMOUNT");

            for(History hist : val){
                totalAmount+=hist.totalBill;
                for(Product product : hist.products){
                    Product prod = new Product();
                    prod.displayProduct(product);
                }
                System.out.println("\n=========\n");
            }
            System.out.println("\n=====================================================================\n");
            System.out.format("%15s%15s%15s\n", "CUSTOMER ID", "CUSTOMER NAME", "TOTAL AMOUNT");
            System.out.format("\n%15s%15s%15s", key.custId, key.custName, totalAmount);
            System.out.println("\n=====================================================================\n");
        }
    }
}
