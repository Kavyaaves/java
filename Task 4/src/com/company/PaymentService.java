package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PaymentService{

    ArrayList<Product> cart;
    Customer currUser;
    Customers customers;
    public PaymentService(Cart cart, Customer customer, Customers customers){
        this.customers = customers;
        this.currUser =  customer;
        this.cart = cart.getAllCartProducts();
    }
    public void handleCOD(){
        onPaymentSuccessful();
    }
    public void handleUPI(){
        onPaymentSuccessful();
    }
    public void handleNetBanking(){
        onPaymentSuccessful();
    }
    public void handleCard(){
        onPaymentSuccessful();
    }

    public void paymentMode(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Select any one payment method: \n1. Cash on Delivery\n2. UPI\n3. Net Banking\n4. Card\n");
            int option = sc.nextInt();
            switch(option){
                case 1:
                    handleCOD();
                    break;
                case 2:
                    handleUPI();
                    break;
                case 3:
                    handleNetBanking();
                    break;
                case 4:
                    handleCard();
                    break;
                default:
                    return;
            }
        }

        public void onPaymentSuccessful(){
            System.out.println("Order placed successfully ");
            PostPayment p = new PostPayment();
            p.handlePostPayment(this.currUser,this.cart, this.customers);

        }

}
