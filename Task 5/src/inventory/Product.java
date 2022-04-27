package inventory;
import category.Category;

import java.util.EnumSet;

public class Product {

    private Integer productId;
    private EnumSet<Category> category;
    private String name;
    private Float price;
    private Integer quantity;

    public Product(){}

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

    public Integer getProductId() {
        return productId;
    }

    public EnumSet<Category> getCategory() {
        return category;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
