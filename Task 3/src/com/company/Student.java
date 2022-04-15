package com.company;
import java.util.HashMap;
import java.util.Map;

public class Student {
    public HashMap<Integer, User> students;
    public void setStudents(){
        Data d = new Data();
        HashMap<Integer, User> studentsArr = new HashMap<>();
        HashMap<Integer, User> allUsers = d.getAllUsers();
        for(Map.Entry<Integer, User> user: allUsers.entrySet()){
            if(user.getValue().role.equals(Role.STUDENT)){
                studentsArr.put(user.getKey(), user.getValue());
            }
        }
        this.students = studentsArr;
    }

    public void viewProfile(User curr){
        System.out.format("%5s%15s%15s%15s\n","ID", "Username","Standard", "Marks");
        for(Map.Entry<Integer, User> u: this.students.entrySet()){
            if(curr.username.equals(u.getValue().username)){
                System.out.format("%5s%15s%15s%15s\n", u.getKey(),u.getValue().username, u.getValue().std, u.getValue().marks);
            }
        }
    }

    public void display(){
        System.out.format("%15s%15s%15s\n", "ID","Username","Standard", "Marks");
        for(Map.Entry<Integer, User> user: this.students.entrySet()){
            System.out.format("%15s%15s%15s\n", user.getValue().username, user.getValue().std, user.getValue().role, user.getValue().marks);
        }
    }


}
