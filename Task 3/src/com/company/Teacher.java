package com.company;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Teacher {

    public HashMap<Integer, User> myStudents;

    public void getMyStudents(User teacher){
        Data d = new Data();
        HashMap<Integer, User> studentsArr = new HashMap<>();
        HashMap<Integer, User> allUsers = d.getAllUsers();
        for(Map.Entry<Integer, User> user: allUsers.entrySet()){
            if(user.getValue().role.equals(Role.STUDENT) && user.getValue().std.equals(teacher.std)){
                studentsArr.put(user.getKey(), user.getValue());
            }
        }
        this.myStudents = studentsArr;
        this.display();
    }

    public void display() {
        System.out.format("%5s%15s%15s%15s%15s\n","ID", "Username", "Standard", "Role", "Marks");
        for (Map.Entry<Integer, User> user : this.myStudents.entrySet()) {
            System.out.format("%5s%15s%15s%15s%15s\n",user.getKey(), user.getValue().username, user.getValue().std, user.getValue().role, user.getValue().marks);
        }
    }

    public void updateMarksById(Scanner sc, Login auth, Data data) {
        try {
            System.out.println("Enter the Student ID: ");
            int id = sc.nextInt();

            System.out.println("Enter the updated mark: ");
            int mark = sc.nextInt();
            data.updateMark(id, mark);
        } catch (InputMismatchException err) {
            System.out.println("Please enter a valid input");
            updateMarksById(sc, auth, data);
        }
    }
}
