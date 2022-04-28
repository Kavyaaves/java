package cartService;

import customersHandling.*;
import category.Category;
import inventory.Product;
import paymentHandling.PaymentService;

public class Checkout {

    public double calculateTax(){
            double amount = 0.0;
            for(Product p: Cart.getInstance().getAllCartProducts())
                for (Category category : p.getCategory()) amount += ((category.getTax()) * p.getPrice());
            return amount;
    }

    public void generateBill(){
        Cart.getInstance().displayProducts();
        Customer currUser = CurrentUser.getInstance();
        VIPCustomer vip = new VIPCustomer(currUser.getCustomerId(), currUser.getCustomerName(), currUser.getPhoneNum(), currUser.getAddress());
        boolean check = vip.checkVIPStatus();
        double totalAmount = calculateAmount();
        double taxAmount = calculateTax();
        double totTax = totalAmount + taxAmount;
        double discountPrice;
        double totalPaid;
        System.out.println("Total Bill Amount: " + totalAmount + "\nTax Amount: " + taxAmount);
        if (check) {
            discountPrice = totTax - ( totTax * 0.1 );
            System.out.println("Discounted Price: "+discountPrice + "\nSavings: " + (totTax - discountPrice) + "\nAmount to pay: " + discountPrice);
            totalPaid = discountPrice;
        } else {
            totalPaid = totTax;
            System.out.println("Amount to pay: " + totTax);
        }
        proceedToPay(totalPaid);
    }

    public void proceedToPay(double totalPaid){
        PaymentService paymentService = new PaymentService(totalPaid);
        paymentService.paymentMode();
    }

    public double calculateAmount() {
        double amount = 0.0;
        for (Product p : Cart.getInstance().getAllCartProducts()) amount += (p.getPrice() * p.getQuantity());
        return amount;
    }

}
