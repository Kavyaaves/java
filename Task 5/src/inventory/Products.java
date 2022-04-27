package inventory;

import java.util.ArrayList;
import java.util.EnumSet;

import category.Category;

public abstract class Products {

    private ArrayList<Product> products;

    public Products(){
        ArrayList<Product> products =  new ArrayList<>();
        products.add(new Product(1, EnumSet.of(Category.STATIONARY), "Pencil", 5));
        products.add(new Product(2, EnumSet.of(Category.ELECTRONICS), "Speaker", 500));
        products.add(new Product(3, EnumSet.of(Category.STATIONARY), "Pen", 50));
        products.add(new Product(4, EnumSet.of(Category.ELECTRONICS), "Charger", 200));
        products.add(new Product(5, EnumSet.of(Category.SNACKS, Category.FOOD), "Wafer", 40));
        products.add(new Product(6, EnumSet.of(Category.SNACKS), "Biscuits", 20));
        products.add(new Product(7, EnumSet.of(Category.STATIONARY), "Eraser", 15));
        products.add(new Product(8,  EnumSet.of(Category.ELECTRONICS), "Scratch Card", 350));
        products.add(new Product(9,  EnumSet.of(Category.ELECTRONICS), "Phone Cover", 500));
        products.add(new Product(10, EnumSet.of(Category.SNACKS, Category.FOOD), "Chocolate", 20));
        this.products = products;
    }

    public void deleteStock(ArrayList<Product> cart){
        for(Product p: cart){
            System.out.println(p.getQuantity());
            Product product = this.products.get(p.getProductId());
            System.out.println(product.getStock());
            product.setStock(product.getStock() - p.getQuantity());
        }
    }

    // abstract method
    public abstract void displayProducts(Products products);

    public ArrayList<Product> getAllProducts(){
        return products;
    }
    public Product getProductById(Integer id){
        Product product = null;
        for(Product p: this.products){
            if(p.getProductId().equals(id)){
                product = p;
            }
        }
        return product;
    }
}
