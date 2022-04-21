package com.company;

import java.util.ArrayList;

public class Cart extends Products{
    ArrayList<Product> cart;

    Cart(){
        ArrayList<Product> cart = new ArrayList<>();
        this.cart = cart;
    }

    public void addToCart(Integer id, Integer quantity){
        Product p = getProductById(id);
        if(this.cart.contains(p)){
            p.setQuantity(p.quantity+ quantity);
        }else{
            p.setQuantity(quantity);
            this.cart.add(p);
        }
    }

    public ArrayList<Product> getAllCartProducts(){
        return this.cart;
    }

    public String removeFromCart(Integer id){
        Product p = getProductById(id);
        if(p == null){
            return "No item in cart matches the ID";
        }else{
            this.cart.remove(p);
            return "Item removed from cart successfully";
        }
    }

    public void displayCartProducts(){
        System.out.println("\n==================================================================\n");
        System.out.format("%5s%15s%10s%10s%15s\n", "ID", "NAME", "AMOUNT", "QTY", "TOTAL AMOUNT");
        for(Product p: this.cart){
            p.displayProduct(p);
        }
        System.out.println("\n==================================================================\n");
    }
}
