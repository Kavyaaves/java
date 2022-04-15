package com.company;

import java.util.*;

public class Quiz {
    public ArrayList<Questions> questions;
    public Stack selected=new Stack<Integer>();

    public void createQuestionsSet(){
        HashMap<Integer, String> op1 = new HashMap<Integer, String>();
        op1.put(1, "final");
        op1.put(2, "static");
        op1.put(3, "catch");
        op1.put(4, "global");

        HashMap<Integer,String> op2 = new HashMap<Integer,String>();
        op2.put(1, "default");
        op2.put(2, "public");
        op2.put(3, "private");
        op2.put(4, "protected");

        HashMap<Integer,String> op3 = new HashMap<Integer,String>();
        op3.put(1,"throw");
        op3.put(2,"catch");
        op3.put(3,"final");
        op3.put(4,"throws");

        HashMap<Integer,String> op4 = new HashMap<Integer,String>();
        op4.put(1,"JRE");
        op4.put(2,"JDK");
        op4.put(3,"JAVAC");
        op4.put(4,"JVM");

        HashMap<Integer,String> op5 = new HashMap<Integer,String>();
        op5.put(1,"extends");
        op5.put(2,"instanceof");
        op5.put(3,"then");
        op5.put(4,"switch");

        ArrayList<Questions> q= new ArrayList<Questions>();

        q.add(new Questions("Which keyword is used to prevent reinitialization? ", op1, 1));
        q.add(new Questions("Which access modifier allows access only inside the class? ", op2, 3));
        q.add(new Questions("Exceptions created in try block are caught in which block? ", op3, 2));
        q.add(new Questions("Which provides runtime environment for java byte code to be executed? ", op4, 4));
        q.add( new Questions("Which of the following are not Java keywords? ", op5, 3));
        this.questions = q;
        }

    public void countOptions(){
        int count = 0;
        try{
            count+=4;
            countOptions();
        }catch(StackOverflowError er){
            System.out.println("Stack Overflow");
        }
    }
    public int getInput(Scanner sc){
        try{
            System.out.print("Your Answer: ");
            int ans = sc.nextInt();

            if(ans > 0 && ans < 5){
                this.selected.push(ans);
            }else{
                System.out.println("Enter a valid option");
                getInput(sc);
            }
            return ans;
        }catch(StackOverflowError er){
             System.out.println("Stack Overflow");
             return 0;
        }
    }
    public void pushAnsToStack(){
        try {
            Stack stack = new Stack();
            while (true) {
                for (Object elem : this.selected) {
                    stack.push(elem);
                }
            }
        }catch(OutOfMemoryError err){
            System.out.println("Out of Memory Error");
        } finally{
            System.out.println("Finally block of Out of Memory");
        }
    }

    public void start(Scanner sc){
        int i = 0;
        int score = 0;
        System.out.println("\n============================================\n");
        for(Questions each:this.questions) {
            System.out.println(each.getQuestion());
            for (Map.Entry opt : each.getOptions().entrySet()) {
                System.out.println(opt.getKey() + ". " + opt.getValue());
            }
            this.getInput(sc);

            int crt = each.getAns();
            if (crt == (int)this.selected.peek()) {
                score += 1;
            }
            System.out.println("Your current score is: "+score);
            System.out.println("Correct Answer: "+ (each.getAns()) +". "+ each.getOptions().get(each.getAns()));
            System.out.println("\n============================================\n");
        }

            System.out.println("Quiz Ended\nFinal Score: " + score);
            System.out.println("\n============================================\n");
            i+=1;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Quiz quiz = new Quiz();
        System.out.println("Quiz time starts from now");
        quiz.createQuestionsSet();
        quiz.countOptions();
        quiz.start(sc);
        quiz.pushAnsToStack();;
        sc.close();
    }
}
