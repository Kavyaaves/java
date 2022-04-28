package history;

import java.util.ArrayList;

import helpers.DateTimeHelper;
import inventory.Product;

public class History {

    private ArrayList<Product> products;
    public double totalBill;
    private String modeOfPayment;
    private int id;
    private final String timestamp = new DateTimeHelper().getDateAndTime();

    public History(){}

    public History(int orderId, ArrayList<Product> cart, String modeOfPayment, double totalPaid) {
        this.id = orderId;
        this.modeOfPayment = modeOfPayment;
        this.products = cart;
        this.totalBill = totalPaid;
    }

    public void displayHistory(){
        System.out.println("Order ID: "+ id+"\t | Total Products: "+ products.size() +"\nDate: " + timestamp +
                "\nMode of Payment: " + modeOfPayment + "\t | Total Paid: " + totalBill + "\n");

        for(Product product : products){
            System.out.println(product);
        }
    }
}
