package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Data {
    public static int id = 4;
    public Role role;
    public HashMap<Integer, User> hm = new HashMap<Integer, User>();
    public static HashMap<Integer,User> users;

    public void createUsers(){
        HashMap<Integer,User> users = new HashMap<Integer,User>();
        users.put(1,new User("Kavya", "1234", Role.ADMIN, null, null));
        users.put(2,new User("Priya", "1234", Role.TEACHER, 12, null));
        users.put(3,new User("Amir", "1234", Role.STUDENT, 12, null));
        this.users = users;
    }

    public HashMap<Integer,User> getAllUsers(){
        return this.users;
    }

    public User addUser(User user){
        this.users.put(this.id, user);
        this.id = this.id+1;
        return user;
    }

    public User updateUser(int id, User updated){
        this.users.put(id, updated);
        return updated;
    }

    public void updateMark(int id, int mark){
        User u = this.users.get(id);
        u.updateMark(mark);
        this.users.put(id, u);
    }

    public void deleteUser(Integer id){
        this.users.remove(id);
    }


}
