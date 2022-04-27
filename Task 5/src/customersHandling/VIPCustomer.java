package customersHandling;

import java.util.ArrayList;

import history.HistoryTable;
import history.History;


public class VIPCustomer {
    private Boolean isVip;
    private Double amount=0.0;
    public Boolean checkVIPStatus(Customer customer, HistoryTable historyTable){
        if(historyTable.getHistoryTable().containsKey(customer.customerId)){
            ArrayList<History> historyTable1 = historyTable.getHistoryTable().get(customer.customerId);
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
}
