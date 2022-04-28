package inventory;

import java.util.ArrayList;

import database.ProductsTable;

public class Products {

    private final ArrayList<Product> products;
    private static Products productsInstance = null;

    public Products(){
        ProductsTable allProducts = new ProductsTable();
        products = allProducts.getProducts();
    }

    public static Products getInstance()
    {
        if (productsInstance == null)
            productsInstance = new Products();
        return productsInstance;
    }

    public  void displayProducts(){
        for(Product p: this.products){
            System.out.println(p);
        }
    }

    public ArrayList<Product> getAllProducts(){
        return products;
    }

    public Product getProductById(int id){
        for(Product p: this.products){
            if(p.getProductId() == id){
                return p;
            }
        }
        return null;
    }
}
