package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Example {

    public int calculateGCD(int a, int b)
    {
        try{
            if (b == 0)
                return a;
            return calculateGCD(b, a % b);
        }catch(StackOverflowError err){
            System.out.println("No Stack overflow error because base condition is present");
        }finally{
            System.out.println("GCD Calculation Completed");
        }
        return a;
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
            //No base condition so infinite recursion
            return num*calculateFactorialWithOverflow(num-1);
        }catch(StackOverflowError err){
            System.out.println("Stack Overflow Error");
            return 0;
        }
    }

    public int calculateFactorial(int num){
        try {
            if (num == 0) {
                return 1;
            } else {
                return num * calculateFactorial(num - 1);
            }
        }catch(StackOverflowError err){
            System.out.println("No Stack Overflow error since base condition is specified");
            return 0;
        }finally{
            System.out.println("Factorial found");
        }
    }

    public void factorial(Scanner sc){
        System.out.print("Enter the number to find the factorial: ");
        int f = sc.nextInt();
        int fact = this.calculateFactorial(f);
        System.out.println("Factorial of "+f+" is "+fact);
        this.calculateFactorialWithOverflow(f);
    }

    public void pushToStack(Scanner sc, String str){
        try{
            Stack stack = new Stack();
            while(true){
                stack.push(1);
            }
        } catch(OutOfMemoryError err){
            // No OutOfMemoryError, instead this statement is executed
            System.out.println("Heap ran out of memory");
        }finally{
            // always gets executed
            System.out.print("");
        }
    }

    public void reverseString1(Scanner sc, String str) {
        try {
            StringBuilder strBuild = new StringBuilder(str);
            while (true) {
                strBuild.reverse();
                // to stop infinite loop
                break;
            }
            System.out.println(strBuild.toString());
        } catch (OutOfMemoryError err) {
            System.out.println("Heap ran out of memory");
        } finally {
            // always gets executed
            System.out.print("");
        }
    }

    public String getStringInput(Scanner sc){
        System.out.println("Enter the string: ");
        return sc.next();
    }

    public void init(Scanner sc){
        System.out.println("Choose the operation: ");
        System.out.println("1. Factorial of the number");
        System.out.println("2. GCD of 2 numbers");
        System.out.println("3. Reverse a String");
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
            case 3:
                String str = this.getStringInput(sc);
                this.reverseString1(sc, str);
                init(sc);
                break;
            case 4:
                String s = this.getStringInput(sc);
                this.pushToStack(sc, s);
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
