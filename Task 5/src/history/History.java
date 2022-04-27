package history;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import inventory.Product;

public class History {

    private ArrayList<Product> products;
    public Double totalBill;
    private String timestamp;
    private String modeOfPayment;
    private Integer id;

    public History(){}

    public History(Integer orderId, ArrayList<Product> cart, String modeOfPayment, Double totalPaid){
        this.id = orderId;
        this.modeOfPayment = modeOfPayment;
        this.products = cart;
        this.totalBill = totalPaid;
        this.timestamp = getDateAndTime();
    }

    public String getDateAndTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public void displayHistory(History hist){
        System.out.println("Order ID: "+ hist.id+"\t | Total Products: "+hist.products.size()+"\nDate: "+hist.timestamp+"\n" +
                "Mode of Payment: "+hist.modeOfPayment+"\t | Total Paid: "+hist.totalBill+"\n");
        System.out.format("%5s%15s%10s%10s%15s\n", "ID", "NAME", "AMOUNT", "QUANTITY", "TOTAL AMOUNT");
        for(Product product : hist.products){
            Product prod = new Product();
            prod.displayProduct(product);
        }
        System.out.println("\n------------------------------------------------------------------\n");
    }
}
