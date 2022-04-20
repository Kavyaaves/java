package com.company;

import java.util.Scanner;

public class Store {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Customers customers = new Customers();
        Auth auth =  new Auth();
        auth.init(sc);
//        auth.(sc, customers);

        sc.close();
    }
}
