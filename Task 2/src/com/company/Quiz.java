package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Quiz {
    public Questions questions[];
    public ArrayList<Integer> selected=new ArrayList<Integer>();
    public ArrayList<Integer> answers=new ArrayList<Integer>();

    public void createQuestionsSet(){
        ArrayList<String> op1 = new ArrayList<String>();
        op1.add("final");
        op1.add("static");
        op1.add("catch");
        op1.add("global");

        ArrayList<String> op2 = new ArrayList<String>();
        op2.add("default");
        op2.add("public");
        op2.add("private");
        op2.add("protected");

        ArrayList<String> op3 = new ArrayList<String>();
        op3.add("throw");
        op3.add("catch");
        op3.add("final");
        op3.add("throws");

        ArrayList<String> op4 = new ArrayList<String>();
        op4.add("JRE");
        op4.add("JDK");
        op4.add("JAVAC");
        op4.add("JVM");

        ArrayList<String> op5 = new ArrayList<String>();
        op5.add("extends");
        op5.add("instanceof");
        op5.add("then");
        op5.add("switch");

        Questions q[] = {
                new Questions("Which keyword is used to prevent reinitialization? ", op1, 1),
                new Questions("Which access modifier allows access only inside the class? ", op2, 3),
                new Questions("Exceptions created in try block are caught in which block? ", op3, 2),
                new Questions("Which provides runtime environment for java byte code to be executed? ", op4, 4),
                new Questions("Which of the following are not Java keywords? ", op5, 3)
        };
        this.questions = q;
    }

    public void handleStackOverflowError(Scanner sc){
        try{
            this.handleStackOverflowError(sc);
        }catch(StackOverflowError er){
            System.out.println("Stack Overflow");
        }
    }
    public int getInput(Scanner sc){
        System.out.print("Your Answer: ");
        int ans = sc.nextInt();
        if(ans > 0 && ans < 5){
            this.selected.add(ans);
        }else{
            System.out.println("Enter a valid option");
            getInput(sc);
        }
        return ans;
    }
    public void handleOutOfMemoryError(){
        try{
            Stack stack = new Stack();
            while(true){
                stack.push(this.selected);
            }
        }catch(OutOfMemoryError err){
            System.out.println("Out of Memory Error");
        }finally{
            System.out.println("Finally block of Out of Memory");
        }

    }

    public void start(Scanner sc){
        int i = 0;
        int score = 0;
        System.out.println("\n============================================\n");
        for(Questions each:this.questions){
            System.out.println(each.getQuestion());
            int option=1;
            for(String opt : each.getOptions()){
                System.out.println(option+". "+ opt);
                option+=1;
            }
            this.getInput(sc);
            int crt = each.getAns();
            if(crt == this.selected.get(i)){
                score+=1;
            }else{
                score-=1;
            }
            System.out.println("Your current score is: "+score);
            System.out.println("\n============================================\n");
            System.out.println("Quiz Ended\nFinal Score: " + score);
            System.out.println("\n============================================\n");
            i+=1;
        }


    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Quiz quiz = new Quiz();
        System.out.println("Quiz time starts from now");
        quiz.createQuestionsSet();
        quiz.handleStackOverflowError(sc);
        quiz.start(sc);
        quiz.handleOutOfMemoryError();;
        sc.close();
    }
}
