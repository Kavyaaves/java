package cartService;

import java.util.ArrayList;

import inventory.*;

public class Cart {

    private final ArrayList<Product> cart = new ArrayList<>();
    private static Cart cartInstance = null;
    private Cart(){}
    public static Cart getInstance()
    {
        if (cartInstance == null)
            cartInstance = new Cart();
        return cartInstance;
    }

    public void setCartInstance(){
        cartInstance = null;
    }

    public ArrayList<Product> getAllCartProducts(){
        return this.cart;
    }

    public void addToCart(int id, int quantity){
        Product p = Products.getInstance().getProductById(id);
        if (p == null) {
            System.out.println("Product not available for this id.");
        } else {
            if(cart.contains(p)){
                p.setQuantity(p.getQuantity() + quantity);
            } else{
                p.setQuantity(quantity);
                this.cart.add(p);
            }
            System.out.println("Product added to cart successfully");
        }

    }

    public String removeFromCart(int id){
        Product p = Products.getInstance().getProductById(id);
        if(p == null){
            return "No item in cart matches the ID";
        }else{
            this.cart.remove(p);
            return "Item removed from cart successfully";
        }
    }

    public void displayProducts(){
        for(Product p: cart){
            System.out.println(p);
        }
    }

    public boolean checkCart(){
        return getAllCartProducts().size() > 0;
    }

}
