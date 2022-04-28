package customersHandling;

public class CurrentUser extends Customer {
    private static CurrentUser userInstance = null;

    private CurrentUser(Customer customer) {
        super(customer.customerId, customer.getCustomerName(), customer.getPhoneNum(), customer.getAddress());
    }

    public static CurrentUser getInstance()
    {
        return userInstance;
    }

    public static CurrentUser getInstance(Customer customer)
    {
        if (userInstance == null)
            userInstance = new CurrentUser(customer);
        return userInstance;
    }

    public void logout(){
        userInstance = null;
    }

}
