package main;

import java.util.Scanner;

import cartService.*;
import controllers.ProductDetailsController;
import customersHandling.*;
import database.HistoryTable;
import inventory.*;
import category.CategorySet;

public class Shop {

    public void proceed(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n===========Let's start shopping!!===============\n");
        Products products = new Products();
        products.displayProducts();
        System.out.println("\n================================================\n");
        Cart cart = Cart.getInstance();
        this.shop(sc, cart);
    }

    private void handleCheckout(){
        boolean hasProducts =  Cart.getInstance().checkCart();
        if(hasProducts) {
            Checkout checkout = new Checkout();
            checkout.generateBill();
        }else{
            System.out.println("Could not proceed with checkout since your cart is empty");
        }
    }

    private void shop(Scanner sc, Cart cart){
        System.out.println("1. Add to cart\n2. Remove from cart\n3. View Cart\n4. Checkout\n5. View Orders\n6. View Products\n7. View All Categories\n8. View My Details\n9. Logout");
        int op = sc.nextInt();
        ProductDetailsController productDetails = new ProductDetailsController();
        switch (op) {
            case 1 -> {
                int id = productDetails.getProductId(sc);
                int quantity = productDetails.getQuantity(sc);
                cart.addToCart(id, quantity);
                shop(sc, cart);
            }
            case 2 -> {
                int i = productDetails.getProductId(sc);
                String response = cart.removeFromCart(i);
                System.out.println(response);
                shop(sc, cart);
            }
            case 3 -> {
                cart.displayProducts();
                shop(sc, cart);
            }
            case 4 -> {
                handleCheckout();
                shop(sc, cart);
            }
            case 5 -> {
                HistoryTable historyTable = HistoryTable.getInstance();
                historyTable.displayHistoryTable();
                shop(sc, cart);
            }
            case 6 -> {
                Products products = Products.getInstance();
                products.displayProducts();
                shop(sc, cart);
            }
            case 7 -> {
                // static class
                CategorySet.GetCategory getCategory = new CategorySet.GetCategory();
                getCategory.displayCategories();
                shop(sc, cart);
            }
            case 8 -> {
                System.out.println(CurrentUser.getInstance());
                shop(sc, cart);
            }
            case 9 -> {
                CurrentUser currentUser = CurrentUser.getInstance(CurrentUser.getInstance());
                currentUser.logout();
                Store store = new Store();
                store.handleAuth(sc);
            }
            default -> shop(sc, cart);

        }
    }


}
