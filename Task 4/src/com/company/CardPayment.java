package com.company;

public class CardPayment implements PaymentMode {

        private String name;
        private String cardNumber;
        private String cvv;
        private String dateOfExpiry;

        public CardPayment(String nm, String ccNum, String cvv, String expiryDate){
            this.name=nm;
            this.cardNumber=ccNum;
            this.cvv=cvv;
            this.dateOfExpiry=expiryDate;
        }

        @Override
        public void pay(Double amount) {
            System.out.println(amount +" paid with credit/debit card");
        }

    }
