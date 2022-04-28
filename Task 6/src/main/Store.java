package main;

import java.util.Scanner;

import customersHandling.CurrentUser;
import customersHandling.Customer;
import customersHandling.Customers;
import controllers.UserInputController;

public class Store {

    protected void handleAuth(Scanner sc){
        System.out.println("Choose\n1. Existing Customer\n2. New Customer\n3. Exit\n");
        String option = sc.nextLine();
        switch(option){
            case "1":
                this.login(sc);
                break;
            case "2":
                this.signUp(sc);
                break;
            case "3":
                break;
            default:
                this.handleAuth(sc);
                break;
        }
    }

    private void signUp(Scanner sc){
        Customers customers = Customers.getInstance();
        UserInputController controller = new UserInputController();
        Customer customer = controller.getCustomerDetails(sc);
        customers.addCustomer(customer);
        CurrentUser currentUser = CurrentUser.getInstance(customer);
        System.out.println(currentUser);
        proceedWithShopping();
    }

    private void login(Scanner sc){
        UserInputController controller = new UserInputController();
        Customer customer = controller.getLoginDetails(sc);
        System.out.println(customer);
        CurrentUser currentUser = CurrentUser.getInstance(customer);
        System.out.println(currentUser.getCustomerId());
        proceedWithShopping();
    }

    private void proceedWithShopping(){
        Shop shop = new Shop();
        Scanner sc = new Scanner(System.in);
        shop.proceed();
        handleAuth(sc);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Store store = new Store();
        store.handleAuth(sc);
        sc.close();
    }
}
