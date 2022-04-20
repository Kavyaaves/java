package com.company;

import java.util.ArrayList;

public class Products {
    ArrayList<Product> products;
    Products(){
        ArrayList<Product> products =  new ArrayList<>();
        products.add(new Product(1, Category.STATIONARY, "Pencil", 5));
        products.add(new Product(2, Category.ELECTRONICS, "Speaker", 500));
        products.add(new Product(3, Category.STATIONARY, "Pen", 50));
        products.add(new Product(4, Category.ELECTRONICS, "Charger", 200));
        products.add(new Product(5, Category.SNACKS, "Wafer", 40));
        products.add(new Product(6, Category.SNACKS, "Biscuits", 20));
        products.add(new Product(7, Category.STATIONARY, "Eraser", 15));
        products.add(new Product(8, Category.ELECTRONICS, "Scratch Card", 350));
        products.add(new Product(9, Category.ELECTRONICS, "Phone Cover", 500));
        products.add(new Product(10, Category.SNACKS, "Chocolate", 20));
        this.products = products;
    }

    public void displayProducts(){

        for(Product p:this.products){
            p.displayProduct(p);
        }
    }

    public Product getProductById(Integer id){
        Product product = null;
        for(Product p: this.products){
            if(p.productId.equals(id)){
                product = p;
            }
        }
        return product;
    }

    public ArrayList<Product> getAllProducts(){
        return this.products;
    }


}
