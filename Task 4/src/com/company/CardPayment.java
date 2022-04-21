package com.company;

public class CardPayment implements PaymentMode {
        private String name;
        private String cardNumber;
        private String cvv;
        private String dateOfExpiry;

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
