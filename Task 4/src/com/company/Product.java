package com.company;

import java.util.EnumSet;

public class Product {

    public Integer productId;
    public EnumSet<Category> category;
    public String name;
    public Float price;
    public Integer quantity;

    Product(){}

    Product(Integer productId, EnumSet<Category> category, String name, float price){
        this.productId = productId;
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public void setQuantity(Integer q){
        this.quantity = q;
    }

    public void displayProduct(Product p){
        System.out.format("%5s%15s%10s%10s%15s\n", p.productId,p.name,p.price, p.quantity != null ? p.quantity : "",  p.quantity != null ? p.quantity*p.price : "");
    }

}
