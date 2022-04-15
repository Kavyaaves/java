package com.company;

import java.util.Scanner;

public class School {

    private void handleAdmin(Scanner sc, Login auth, Data data){
        System.out.println("Choose any one operation: ");
        System.out.println("1. Add User\n2. Update User\n3. Delete User\n4. View Users Logs\n5. Logout\n6. Exit");
        int option=sc.nextInt();
        Admin admin = new Admin();
        switch(option) {
            case 1:
                admin.addUser(sc, data,false, null);
                handleAdmin(sc,auth, data);
                break;
            case 2:
                admin.updateUser(sc, data);
                handleAdmin(sc,auth, data);
                break;
            case 3:
                admin.deleteUser(sc,data);
                handleAdmin(sc,auth, data);
                break;
            case 4:
                admin.display(data);
                handleAdmin(sc,auth,data);
                break;
            case 5:
                auth.logout();
                login(sc);
                break;
            default:
                return;
        }
    }

    private void handleStudent(Scanner sc, Login auth, Data data){
            System.out.println("Choose any one operation: \n1. View profile\n2. Logout\n3. Exit");
            int option = sc.nextInt();
            Student student = new Student();
            student.setStudents();
            switch(option) {
                case 1:
                    student.viewProfile(auth.currentUser);
                    handleStudent(sc, auth, data);
                    break;
                case 2:
                    auth.logout();
                    break;
                default:
                    return;
        }
    }

    private void handleTeacher(Scanner sc, Login auth, Data data) {
        System.out.println("Choose any one operation:\n1. View Students\n2. Update Students Marks\n3. Logout\n4. Exit");
        int option = sc.nextInt();
        Teacher teacher = new Teacher();
        switch (option) {
            case 1:
                teacher.getMyStudents(auth.currentUser);
                handleTeacher(sc, auth, data);
                break;
            case 2:
                teacher.updateMarksById(sc,auth, data);
                handleTeacher(sc, auth, data);
                break;
            case 3:
                auth.logout();
                break;
            default:
                return;
        }
    }

    private void manageRoles(Login auth, Scanner sc){
        User curr = auth.currentUser;
        Data data = new Data();
        if(curr.role == Role.ADMIN){
            handleAdmin(sc, auth, data);
        }else if(curr.role == Role.STUDENT){
            handleStudent(sc, auth, data);
        }else if(curr.role == Role.TEACHER){
            handleTeacher(sc, auth, data);
        }
    }

    private void login(Scanner sc){
        Login login = new Login();
        boolean loggedIn = login.loginUser(sc);
        if(loggedIn){
            manageRoles(login, sc);
        }else{
            System.out.println("Login Failed. Please retry again");
            login(sc);
        }
    }

    public static void main(String[] args) {
        School school = new School();
        Scanner sc = new Scanner(System.in);
        Data d = new Data();
        d.createUsers();
        school.login(sc);
    }
}
