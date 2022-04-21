package com.company;

import java.util.ArrayList;

public class VIPCustomer extends Customer {
    Boolean isVip;
    Double amount=0.0;
    public Boolean checkVIPStatus(Customer customer, HistoryTable historyTable){
        if(historyTable.getHistoryTable().containsKey(customer.custId)){
            ArrayList<History> historyTable1 = historyTable.getHistoryTable().get(customer.custId);
            System.out.println(historyTable1+" "+historyTable1.size());
            this.amount = historyTable.getOverallAmount(historyTable1);
        }
        if(this.amount > 2000){
            this.isVip = true;
            return true;
        }
        this.isVip = false;
        return false;
    }

    public void setIsVip(Boolean vip){
        this.isVip = vip;
    }
    public Boolean getIsVip(){
        return this.isVip;
    }
}
