package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import cartService.*;
import customersHandling.*;
import history.*;
import inventory.*;
import category.CategorySet;

public class Shop extends Products {
    private Customer currUser;
    private Customers customers;
    private HistoryTable historyTable;

    Shop(){}

    // Abstract method implementation
    @Override
    public void displayProducts(Products products) {
        System.out.println(products.getAllProducts().size());
        for(Product p: products.getAllProducts()){
            p.displayProduct(p);
        }
    }

    public Shop(Customer customer, Customers customers, HistoryTable historyTable){
        this.customers = customers;
        this.currUser = customer;
        this.historyTable = historyTable;
    }

    public void proceed(Scanner sc){
        System.out.println("\n===========Let's start shopping!!===============\n");
        Products products = new Shop();
        products.displayProducts(products);
        System.out.println("\n================================================\n");
        Cart cart = new Cart();
        this.shop(cart,sc);
    }

    public Integer getProductId(Scanner sc){
        try {
            System.out.print("Product ID: ");
            Integer id = sc.nextInt();
            Product p = getProductById(id);
            if(p==null){
                throw new InputMismatchException("Product not available for this id.");
            }else{
                return id;
            }
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

    private void handleCheckout(Cart cart){
        boolean hasProducts =  checkCart(cart);
        if(hasProducts) {
            Checkout checkout = new Checkout();
            checkout.checkoutBill(currUser, cart, this.customers, this.historyTable);
        }else{
            System.out.println("Could not proceed with checkout since your cart is empty");
        }
    }

    private boolean checkCart(Cart cart){
        if(cart.getAllCartProducts().size() > 0) return true;
        return false;
    }

    private void shop(Cart cart, Scanner sc){
        System.out.println("1. Add to cart\n2. Remove from cart\n3. View Cart\n4. Checkout\n5. View Orders\n6. View Products\n7. View All Categories\n8. Logout");
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
                String response = cart.removeFromCart(i);
                System.out.println(response);
                this.shop(cart, sc);
                break;
            case 3:
                cart.displayProducts();
                this.shop(cart, sc);
                break;
            case 4:
                handleCheckout(cart);
                this.shop(cart, sc);
                break;
            case 5:
                historyTable.displayHistoryTable();
                this.shop(cart, sc);
                break;
            case 6:
                System.out.println("\n================================================\n");
                Products products = new Shop();
                products.displayProducts(products);
                System.out.println("\n================================================\n");
                this.shop(cart, sc);
                break;
            case 7:
                // static class
                CategorySet.GetCategory getCategory = new CategorySet.GetCategory();

                // normal class
//                CategorySet categorySet = new CategorySet();
//                CategorySet.GetCategory getCategory = categorySet.new GetCategory();

                getCategory.displayCategories();
                this.shop(cart, sc);
                break;
            case 8:
               Store store = new Store();
               store.handleAuth(sc, customers, this.historyTable);
               break;
            default:
                this.shop(cart, sc);
                return;
        }
    }


}
