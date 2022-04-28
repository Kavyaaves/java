package com.company;

    public class NetBankingPayment implements PaymentMode {

        private String emailId;
        private String password;

        public NetBankingPayment(String email, String pwd){
            this.emailId=email;
            this.password=pwd;
        }

        @Override
        public void pay(Double amount) {
            System.out.println(amount + " paid using NetBanking.");
        }

}
