package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Checkout extends Cart  {

    Customer currUser;
    ArrayList<Product> cart;
    Customers customers;
    HistoryTable historyTable;
    Double totalPaid = 0.0;

    public void checkoutBill(Customer currUser, Cart cart, Customers customers, HistoryTable historyTable){
        this.customers = customers;
        this.currUser = currUser;
        this.historyTable = historyTable;
        this.cart = cart.getAllCartProducts();
        this.generateBill(cart);
    }

    public Double calculateTax(){
            double amount = 0.0;
            for(Product p: this.cart){
                for(Category category : p.category){
                    amount+=((category.getTax())*p.price);
                }
            }
            return amount;
    }

    public void displayAmountBill(){
        VIPCustomer vip = new VIPCustomer();
        Boolean check = vip.checkVIPStatus(this.currUser, this.historyTable);
        double totalAmount = calculateAmount();
        double taxAmount = calculateTax();
        double totTax = totalAmount + taxAmount;
        double discountPrice;
        System.out.println("Total Bill Amount: "+totalAmount+"\nTax Amount: "+taxAmount);
        if(check) {
            vip.setIsVip(true);
            discountPrice = totTax - ( totTax * 0.1 );
            System.out.println("Discounted Price: "+discountPrice);
            System.out.println("Savings: "+(totTax - discountPrice));
            System.out.println("Amount to pay: "+discountPrice);
            this.totalPaid = discountPrice;
        }else{
            vip.setIsVip(false);
            this.totalPaid = totTax;
            System.out.println("Amount to pay: "+totTax);
        }
    }

    public void generateBill(Cart cart){

        Scanner sc = new Scanner(System.in);
        cart.displayCartProducts();

        displayAmountBill();
        System.out.println("\nAre you sure you want to proceed with this amount?\n1. Yes\n2. No");
        int option = sc.nextInt();
        if(option == 2){
            return;
        }else if(option == 1){
            PaymentService paymentService = new PaymentService(cart, currUser,this.customers, historyTable, this.totalPaid);
            paymentService.paymentMode();
        }
    }

    public Float calculateAmount() {
        Float amount = Float.valueOf(0);

        for (Product p : this.cart) {
            amount += (p.price * p.quantity);
        }
        return amount;
    }

}
