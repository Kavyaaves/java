package com.company;

public class User {
    public static int id = 4;
    public String username;
    public String password;
    public Enum role;
    public Integer std;
    public Integer marks;

    public User(String name, String password, Enum role, Integer std, Integer marks){
            this.username = name;
            this.password = password;
            this.role = role;
            this.std = std;
            this.marks = marks;
            this.id = id;
    }

    public void updateMark(int mark){
        this.marks = mark;
    }

}
