package com.company;

import java.util.*;

public class Login {
    public String username;
    public String password;
    public Role role;
    public User currentUser;


    public boolean loginUser(Scanner sc){
        try {
            System.out.println("Enter your username: ");
            String username = sc.next();
            System.out.print("Enter your password: ");
            String pw = sc.next();
            Data d = new Data();
            HashMap<Integer, User> u = d.getAllUsers();
            User newUser = new User(username, pw, role.ADMIN, null, null);


            boolean checked = false;
            for (Map.Entry<Integer, User> user : u.entrySet()) {
                if (user.getValue().username.equals(newUser.username) && user.getValue().password.equals(newUser.password)) {
                    this.currentUser = user.getValue();
                    checked = true;
                    break;
                }
            }
            return checked;
        }catch(NullPointerException | InputMismatchException e){
            System.out.println("Please enter valid data");
            this.loginUser(sc);
            return false;
        }
    }

    public void logout(){
        this.currentUser = null;
    }

}
