package controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PaymentInputController {
    public int getNextInt(Scanner sc){
        try {
            return Integer.parseInt(sc.next());
        }catch (InputMismatchException err){
            System.out.println("Please enter a valid input");
            getNextInt(sc);
            return 0;
        }
    }

    public int getPaymentModeOption(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Select any one payment method: \n1. Cash on Delivery\n2. UPI\n3. Net Banking\n4. Card\n5. Exit");
        return getNextInt(sc);
    }
}
