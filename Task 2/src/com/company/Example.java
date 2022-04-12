package com.company;

import java.util.Scanner;

public class Example {

    public int calculateGCD(int a, int b)
    {
        if (b == 0)
            return a;
        return calculateGCD(b, a % b);
    }
    public void gcd(Scanner sc){
        System.out.print("Enter the first num: ");
        int num1 = sc.nextInt();
        System.out.print("Enter the second num: ");
        int num2 = sc.nextInt();
        int gcd = this.calculateGCD(num1, num2);
        System.out.println("GCD of "+num1+" and " +num2+ " is "+gcd);
    }

    // No base condition => infinite recursion => Overflow
    public int calculateFactorialWithOverflow(int num){
        try{
            return num*calculateFactorialWithOverflow(num-1);
        }catch(StackOverflowError err){
            System.out.println("Stack Overflow Error");
            return 0;
        }
    }
    public int calculateFactorial(int num){
        if(num == 0){
            return 1;
        } else {
        return num*calculateFactorial(num-1);
        }
    }

    public void factorial(Scanner sc){
        System.out.print("Enter the number to find the factorial: ");
        int f = sc.nextInt();
        int fact = this.calculateFactorial(f);
        System.out.println("Factorial of "+f+" is "+fact);
        this.calculateFactorialWithOverflow(f);
    }
    public void init(Scanner sc){
        System.out.println("Choose the mathematical operation: ");
        System.out.println("1. Factorial of the number");
        System.out.println("2. GCD of 2 numbers");
        int option = sc.nextInt();
        switch(option){
            case 1:
                this.factorial(sc);
                init(sc);
                break;
            case 2:
                this.gcd(sc);
                init(sc);
                break;
            default:
                break;
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Example ex = new Example();
        ex.init(sc);
    }
}
