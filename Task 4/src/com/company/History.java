package com.company;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class History {

    ArrayList<Product> products;
    Float totalBill;
    String timestamp;

    History(ArrayList<Product> cart){
        this.products = cart;
        this.totalBill = calculateAmount();
        this.timestamp = getDateAndTime();
    }

    public Float calculateAmount(){
        Float amount = Float.valueOf(0);

        for(Product p: this.products){
            amount+=(p.price*p.quantity);
        }
        return amount;
    }

    public String getDateAndTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
