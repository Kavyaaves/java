package paymentHandling;

import cartService.Cart;
import customersHandling.CurrentUser;
import customersHandling.Customer;
import customersHandling.VIPCustomer;
import history.History;
import database.HistoryTable;
import main.Shop;


public class PostPayment {

    private static int orderId = 0;

    public void handlePostPayment(String modeOfPayment, Double totalPaid){
        Customer currUser = CurrentUser.getInstance();
        orderId += 1;
        History history = new History(orderId, Cart.getInstance().getAllCartProducts(), modeOfPayment, totalPaid);
        HistoryTable historyTable = HistoryTable.getInstance();
        historyTable.addToHistoryTable(currUser, history);
        VIPCustomer vip = new VIPCustomer(currUser.getCustomerId(), currUser.getCustomerName(), currUser.getPhoneNum(), currUser.getAddress());
        vip.checkVIPStatus();
        clearCart();
    }

    public void clearCart(){
        Cart.getInstance().setCartInstance();
        Shop shop = new Shop();
        shop.proceed();
    }

}
