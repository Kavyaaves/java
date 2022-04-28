package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import customersHandling.CurrentUser;
import customersHandling.Customer;
import history.History;

public class HistoryTable {

    private static HistoryTable tableInstance = null;
    private final HashMap<Integer, ArrayList<History>> historyTable = new HashMap<>();
    private HistoryTable(){}
    public HashMap<Integer, ArrayList<History>> getHistoryTable(){
        return this.historyTable;
    }

    public static HistoryTable getInstance()
    {
        if (tableInstance == null)
            tableInstance = new HistoryTable();
        return tableInstance;
    }

    public void addToHistoryTable(Customer customer, History history){
        if(this.historyTable.containsKey(customer.getCustomerId())){
            ArrayList<History> existingRecord = this.historyTable.get(customer.getCustomerId());
            existingRecord.add(history);
            this.historyTable.put(customer.getCustomerId(), existingRecord);
        }else{
            ArrayList<History> newHistory = new ArrayList<>();
            newHistory.add(history);
            this.historyTable.put(customer.getCustomerId(), newHistory);
        }
    }

    public double getOverallAmount(ArrayList<History> histories){
        double totalAmount = 0.0;
        for(History hist : histories) {
            totalAmount += hist.totalBill;
        }
        return totalAmount;
    }

    public void displayHistoryTable() {
            ArrayList<History> orders = historyTable.get(CurrentUser.getInstance().getCustomerId());
            if(orders == null){
                System.out.println("We haven't received any orders from you.");
            }else{
                for (History order : orders) {
                    order.displayHistory();
                }
            }
    }
}
