package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PostPayment {
    public static Integer orderId = 0;
    public void handlePostPayment(Customer currUser, ArrayList<Product> cart, Customers customers, HistoryTable historyTable, String modeOfPayment, Double totalPaid){
        orderId+=1;
        History history = new History(orderId, cart, modeOfPayment, totalPaid);
        historyTable.addToHistoryTable(currUser, history);
        callFromFirst(currUser, customers, historyTable);
    }

    public void callFromFirst(Customer currUser,Customers customers,HistoryTable historyTable){
        Scanner sc = new Scanner(System.in);
        Shop shop = new Shop(currUser, customers, historyTable);
        shop.proceed(sc);
    }
}
