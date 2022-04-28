package paymentHandling;

import controllers.PaymentInputController;
import controllers.UserInputController;

import java.util.Scanner;

public class PaymentService{

    private final double totalPaid;

    public PaymentService(double totalPaid){
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
        PaymentInputController paymentInputController = new PaymentInputController();

        int option = paymentInputController.getPaymentModeOption();
        switch (option) {
            case 1 -> handleCOD();
            case 2 -> handleUPI();
            case 3 -> handleNetBanking();
            case 4 -> handleCard();
            case 5 -> {
                break;
            }
            default -> paymentMode();
        }
    }

    public void onPaymentSuccessful(String modeOfPayment){
            System.out.println("Order placed successfully. Thank you for shopping with us.\n");
            PostPayment p = new PostPayment();
            p.handlePostPayment(modeOfPayment, this.totalPaid);

    }

}
