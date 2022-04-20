package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PostPayment {
    public void handlePostPayment(Customer currUser, ArrayList<Product> cart, Customers customers){
        History history = new History(cart);
        HistoryTable historyTable = new HistoryTable();
        historyTable.addToHistoryTable(currUser, history);
        historyTable.displayHistoryTable();
        Scanner sc = new Scanner(System.in);
        Shop shop = new Shop(currUser, customers);
        shop.proceed(sc);
    }
}
