package inventory;
import category.Category;

import java.util.EnumSet;

public class Product {

    private final int productId;
    private final EnumSet<Category> category;
    private final String name;
    private final float price;
    private int quantity;

    public Product(int productId, EnumSet<Category> category, String name, float price){
        this.productId = productId;
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public String toString(){
        return productId + "\t" + name + "\t" +  price + "\t" + (quantity == 0 ? "" : quantity) + "\t" +  (quantity == 0 ? "" :  quantity * price );
    }

    public int getProductId() {
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

    public void setQuantity(int q){
        this.quantity = q;
    }

}
