package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PaymentService{

    ArrayList<Product> cart;
    Customer currUser;
    Customers customers;
    HistoryTable historyTable;
    Double totalPaid;

    public PaymentService(Cart cart, Customer customer, Customers customers, HistoryTable historyTable, Double totalPaid){
        this.customers = customers;
        this.currUser =  customer;
        this.historyTable = historyTable;
        this.cart = cart.getAllCartProducts();
        this.totalPaid = totalPaid;
    }
   public void pay(PaymentMode paymentMethod){
            paymentMethod.pay(this.totalPaid);
    }
    public void handleCOD(){
        onPaymentSuccessful("COD");
    }
    public void handleUPI(){
        onPaymentSuccessful("UPI");
    }
    public void handleNetBanking(){
        pay(new NetBankingPayment("kavya@gmail.com", "kavya"));
        onPaymentSuccessful("NetBanking");
    }
    public void handleCard(){
        pay(new CardPayment("Kavya", "123456", "2001", "12/30"));
        onPaymentSuccessful("Card");
    }

    public void paymentMode(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Select any one payment method: \n1. Cash on Delivery\n2. UPI\n3. Net Banking\n4. Card\n");
            int option = sc.nextInt();
//            PaymentMode mode = new PaymentMode();
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

        public void onPaymentSuccessful(String modeOfPayment){
            System.out.println("Order placed successfully. Thank you for shopping with us.\n");
            PostPayment p = new PostPayment();
            p.handlePostPayment(this.currUser,this.cart, this.customers, this.historyTable, modeOfPayment, this.totalPaid);

        }

}
