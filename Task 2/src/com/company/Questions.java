package com.company;

import java.util.ArrayList;

public class Questions {
    String question;
    ArrayList<String> options;
    int ans;

    Questions(String question, ArrayList<String> options, int ans){
        this.question = question;
        this.ans = ans;
        this.options = options;
    }

    ArrayList<String> getOptions(){
        return this.options;
    }

    String getQuestion(){
        return this.question;
    }
    int getAns(){
        return this.ans;
    }

}
