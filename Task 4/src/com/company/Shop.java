package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop extends Products {
    Customer currUser;
    Customers customers;

    Shop(){}
    Shop(Customer customer, Customers customers){
        this.customers = customers;
        this.currUser = customer;
    }

    public void proceed(Scanner sc){
        System.out.println("\n===========Let's start shopping!!===============\n");
        this.displayProducts();
        System.out.println("\n================================================\n");
        Cart cart = new Cart();
        this.shop(cart,sc);
    }

    public Integer getProductId(Scanner sc){
        try {
            System.out.print("Product ID: ");
            Integer id = sc.nextInt();
            return id;
        }catch (InputMismatchException err){
            System.out.println("Enter a valid product id");
            getProductId(sc);
            return 0;
        }
    }

    public Integer getQuantity(Scanner sc){
        try{
            System.out.print("Quantity: ");
            Integer id = sc.nextInt();
            return id;
        }catch (InputMismatchException err){
            System.out.println("Enter a valid number");
            getQuantity(sc);
            return 0;
        }
    }

    void shop(Cart cart, Scanner sc){
        System.out.println("1. Add to cart\n2. Remove from cart\n3. View Cart\n4. Checkout\n");
        int op = sc.nextInt();
        switch(op){
            case 1:
                Integer id = this.getProductId(sc);
                Integer quantity = this.getQuantity(sc);
                cart.addToCart(id, quantity);
                this.shop(cart, sc);
                break;
            case 2:
                Integer i = this.getProductId(sc);
                cart.removeFromCart(i);
                this.shop(cart, sc);
                break;
            case 3:
                cart.displayCartProducts();
                this.shop(cart, sc);
                break;
            case 4:
                Checkout checkout = new Checkout();
                checkout.checkoutBill(currUser,cart, this.customers);
                this.shop(cart, sc);
                break;
            case 5:
               Auth auth = new Auth();
               auth.handleAuth(sc, customers);
            default:
                this.shop(cart, sc);
                return;
        }
    }


}
