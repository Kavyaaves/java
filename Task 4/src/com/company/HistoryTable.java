package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HistoryTable {
    HashMap<Integer, ArrayList<History>> historyTable;
    Customer customer;
    ArrayList<History> entries;
    public HistoryTable(){
        HashMap<Integer, ArrayList<History>> historyTable  = new HashMap<>();
        this.historyTable = historyTable;
    }
    public HashMap<Integer, ArrayList<History>> getHistoryTable(){
        return this.historyTable;
    }

    public void addToHistoryTable(Customer cust, History history){
        if(this.historyTable.containsKey(cust.custId)){
            ArrayList<History> existingRecord = this.historyTable.get(cust.custId);
            existingRecord.add(history);
            this.historyTable.put(cust.custId, existingRecord);
        }else{
            ArrayList<History> newHistory = new ArrayList<>();
            newHistory.add(history);
            this.historyTable.put(cust.custId, newHistory);
        }
    }
    Double getOverallAmount(ArrayList<History> histories){
        Double totalAmount = 0.0;
        for(History hist : histories) {
            totalAmount += hist.totalBill;
        }
        return totalAmount;
    }
    public void displayHistoryTable(){
        for(Map.Entry<Integer, ArrayList<History>> history: this.historyTable.entrySet()){
            ArrayList<History> val = history.getValue();
            Integer key = history.getKey();
            System.out.println("\n=====================================================================\n");

            for(History hist : val){
                History history1 = new History();
                history1.displayHistory(hist);
            }
            System.out.println("\n=====================================================================\n");
            System.out.format("\n%25s%15s\n","Total Amount spent: ", getOverallAmount(val));
        }
    }
}
