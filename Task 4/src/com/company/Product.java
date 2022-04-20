package com.company;

public class Product {

    public Integer productId;
    public Category category;
    public String name;
    public Float price;
    public Integer quantity;

    Product(){}

    Product(Integer productId, Category category, String name, float price){
        this.productId = productId;
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public void setQuantity(Integer q){
        this.quantity = q;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

    public void displayProduct(Product p){
        System.out.format("%5s%15s%15s%10s%10s%15s\n", p.productId,p.name, p.category,p.price, p.quantity != null ? p.quantity : "",  p.quantity != null ? p.quantity*p.price : "");
    }

}
