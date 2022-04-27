package cartService;

import java.util.ArrayList;

import inventory.*;

public class Cart extends Products{

    private ArrayList<Product> cart;

    public Cart(){
        ArrayList<Product> cart = new ArrayList<>();
        this.cart = cart;
    }

    public void addToCart(Integer id, Integer quantity){
        Product p = getProductById(id);
        if(p == null){
            System.out.println("Product not available for this id.");
        }else{
            if(this.cart.contains(p)){
                p.setQuantity(p.getQuantity()+ quantity);
            }else{
                p.setQuantity(quantity);
                this.cart.add(p);
            }
            System.out.println("Product added to cart successfully");
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

    // Abstract method implementation
    @Override
    public void displayProducts(Products products) {
        for(Product p: products.getAllProducts()){
            p.displayProduct(p);
        }
    }

    public void displayProducts(){
        System.out.println("\n==================================================================\n");
        System.out.format("%5s%15s%10s%10s%15s\n", "ID", "NAME", "AMOUNT", "QTY", "TOTAL AMOUNT");
        for(Product p: this.cart){
            p.displayProduct(p);
        }
        System.out.println("\n==================================================================\n");
    }
}
