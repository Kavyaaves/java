package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Checkout extends Cart  {
    Customer currUser;
    ArrayList<Product> cart;
    Customers customers;

    public void checkoutBill(Customer currUser, Cart cart, Customers customers){
        this.customers = customers;
        this.currUser = currUser;
        this.cart = cart.getAllCartProducts();
        this.generateBill(cart);
    }

    public void generateBill(Cart cart){
        cart.displayCartProducts();
        Float totalAmount = calculateAmount();
        Scanner sc = new Scanner(System.in);
        System.out.println("Total Bill" +
                "Amount: "+totalAmount+"\nAre you sure you want to proceed with this amount?\n1. Yes\n2. No");

        int option = sc.nextInt();
        if(option == 2){
            return;
        }else if(option == 1){
            PaymentService paymentService = new PaymentService(cart, currUser,this.customers);
            paymentService.paymentMode();
        }
    }

      public Float calculateAmount(){
        Float amount = Float.valueOf(0);

        for(Product p: this.cart){
            amount+=(p.price*p.quantity);
        }
        return amount;
    }

}
