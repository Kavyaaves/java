package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
public class Cart extends Products{
    ArrayList<Product> cart;

    Cart(){
        ArrayList<Product> cart = new ArrayList<>();
        this.cart = cart;
    }

    public void addToCart(Integer id, Integer q){
        Product p = getProductById(id);
        if(this.cart.contains(p)){
            p.setQuantity(p.quantity+ q);
        }else{
            p.setQuantity(q);
            this.cart.add(p);
        }
    }

    public ArrayList<Product> getAllCartProducts(){
        return this.cart;
    }

    public void removeFromCart(Integer id){
        Product p = getProductById(id);
        this.cart.remove(p);
    }

    public void displayCartProducts(){
        System.out.println("\n==================================================================\n");
        System.out.format("%5s%15s%15s%10s%10s%15s\n", "ID", "NAME", "CATEGORY", "AMOUNT", "QTY", "TOTAL AMOUNT");
        for(Product p: this.cart){
            p.displayProduct(p);
        }
        System.out.println("\n==================================================================\n");
    }
}
