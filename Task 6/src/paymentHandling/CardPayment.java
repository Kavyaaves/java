package paymentHandling;

public class CardPayment implements PaymentMode {
        private final String name;
        private final String cardNumber;
        private final String cvv;
        private final String dateOfExpiry;

        public CardPayment(String name, String ccNum, String cvv, String expiryDate){
            this.name=name;
            this.cardNumber=ccNum;
            this.cvv=cvv;
            this.dateOfExpiry=expiryDate;
        }

        @Override
        public void pay(Double amount) {
            System.out.println(amount +" paid with credit/debit card");
        }

    }
