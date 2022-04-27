package paymentHandling;

import java.util.ArrayList;
import java.util.Scanner;

import customersHandling.Customer;
import customersHandling.Customers;
import inventory.Product;
import inventory.Products;
import history.HistoryTable;
import history.History;
import main.Shop;

public class PostPayment {

    private static Integer orderId = 0;

    public void handlePostPayment(Customer currUser, ArrayList<Product> cart, Customers customers, HistoryTable historyTable, Products products, String modeOfPayment, Double totalPaid){
        orderId+=1;
        History history = new History(orderId, cart, modeOfPayment, totalPaid);
        historyTable.addToHistoryTable(currUser, history);
        products.deleteStock(cart);
        callFromFirst(currUser, customers, historyTable);
    }

    public void callFromFirst(Customer currUser,Customers customers,HistoryTable historyTable){
        Scanner sc = new Scanner(System.in);
        Shop shop = new Shop(currUser, customers, historyTable);
        shop.proceed(sc);
    }

    public Integer getOrderId(){
        return orderId;
    }
}
