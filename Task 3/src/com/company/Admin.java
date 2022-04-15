package com.company;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Admin {
    HashMap<Integer, User> hm = new HashMap<>();
    private Role getRole(Scanner sc) throws IllegalArgumentException {
        System.out.println("Role: ");
        String role = sc.next();

        Role r = Role.valueOf(role.toUpperCase());
        return r;
    }

   void addUser(Scanner sc, Data data, boolean update, Integer id){
       try{
           System.out.println("Username: ");
           String username = sc.next();

           System.out.println("Password: ");
           String password = sc.nextLine();

           System.out.println("Standard: ");
           int std = sc.nextInt();

           System.out.println("Marks: ");
           int marks = sc.nextInt();

           Role role = getRole(sc);

           User u = new User(username, password, role, std, marks);

           User n = update ? data.updateUser(id, u): data.addUser(u);

       }catch(IllegalArgumentException err){
           System.out.println("Please enter Student or Admin or Teacher");
           this.addUser(sc, data, update, id);
       }catch(InputMismatchException | StackOverflowError e){
           System.out.println("Please enter a valid input");
           this.addUser(sc, data, update, id);
       }
   }

   void updateUser(Scanner sc, Data data){
        try{
            System.out.print("ID of the entry to be updated: ");
            int id = sc.nextInt();
            this.addUser(sc,data,true, id);
        }catch(InputMismatchException err){
            System.out.println("Please enter a valid input");
            this.updateUser(sc,data);
        }

   }

    void deleteUser(Scanner sc, Data data){
        try{
            System.out.print("ID of th entry to be deleted: ");
            Integer username = sc.nextInt();
            data.deleteUser(username);
        } catch(InputMismatchException err){
            System.out.println("Please enter a valid input");
            this.updateUser(sc,data);
        }
    }

    public void display(Data data){
       hm = data.getAllUsers();
        System.out.format("%5s%15s%15s%15s%15s\n","ID", "Username","Standard", "Role", "Marks");
        for(Map.Entry<Integer, User> user: hm.entrySet()){
            User u = user.getValue();
            System.out.format("%5s%15s%15s%15s%15s\n",user.getKey(), u.username, u.std, u.role, u.marks);
        }
    }
}
