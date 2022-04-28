package controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

import inventory.Product;
import inventory.Products;

public class ProductDetailsController {

    public int getProductId(Scanner sc){

        try {
            System.out.print("Product ID: ");
            int id = Integer.parseInt(sc.next());
            Products products = Products.getInstance();
            Product p = products.getProductById(id);
            if(p==null) throw new InputMismatchException("Product not available for this id.");
            else return id;

        }catch (InputMismatchException err){
            System.out.println("Enter a valid product id");
            getProductId(sc);
            return 0;
        }

    }

    public int getQuantity(Scanner sc){
        try{
            System.out.print("Quantity: ");
            return sc.nextInt();
        }catch (InputMismatchException err){
            System.out.println("Enter a valid number");
            getQuantity(sc);
            return 0;
        }
    }
}
