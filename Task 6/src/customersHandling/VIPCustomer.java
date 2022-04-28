package customersHandling;


public class VIPCustomer extends Customer {

    public VIPCustomer(int customerId, String customerName, long phoneNum, String address){
        super(customerId, customerName, phoneNum, address);
    }

    public boolean checkVIPStatus(){
        double amount = calculateOverallPurchase();
        return checkForVIPCondition(amount);
    }

    public boolean checkForVIPCondition(double amount)
    {
        if(amount > 2000){
            setIsVip(true);
            return true;
        }
        setIsVip(false);
        return false;
    }

}
