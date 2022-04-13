package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Questions {
    String question;
    HashMap<Integer,String> options;
    int ans;

    Questions(String question, HashMap<Integer,String> options, int ans){
        this.question = question;
        this.ans = ans;
        this.options = options;
    }

    HashMap<Integer,String> getOptions(){
        return this.options;
    }

    String getQuestion(){
        return this.question;
    }
    int getAns(){
        return this.ans;
    }

}
