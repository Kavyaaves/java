package com.company;

import java.util.Stack;

public class ExceptionHandling {

    public void handleStackOverflowError(){
        try{
            // Methods and variables are in stack, so stack gets full
            // Recursive call to throw StackOverflowError
            handleStackOverflowError();
        } catch(StackOverflowError err){
            // No StackOverflowError error, instead this statement is executed
            System.out.println("Stack Overflow");
        }finally{
            // always gets executed
            System.out.print("");
        }
    }

    // global method
    public void handleOutOfMemoryError(){
        try{
            // Objects are in heap so heap memory gets full
            Stack stack = new Stack();
            // Infinite loop called until memory full
            while(true){
                stack.push(10);
            }
        } catch(OutOfMemoryError err){
            // No OutOfMemoryError error, instead this statement is executed
            System.out.println("Heap ran out of memory");
        }finally{
            // always gets executed
            System.out.print("");
        }
    }

    public static void main(String args[]){
        ExceptionHandling stack = new ExceptionHandling();
        stack.handleStackOverflowError();
        stack.handleOutOfMemoryError();
    }
}
