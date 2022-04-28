package database;

import category.Category;
import inventory.Product;

import java.util.ArrayList;
import java.util.EnumSet;

public class ProductsTable {
    private final ArrayList<Product> products = new ArrayList<>();
    public ArrayList<Product> getProducts(){
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
        return products;
    }
}
