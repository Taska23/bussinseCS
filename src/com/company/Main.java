package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    static ArrayList<User> users = new ArrayList<User>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
	// write your code here
        users = loadUsers();




        startMenu();


        saveUsers(users);
    }

    public static void startMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int input = 2222222;

        while (input != 0){
            System.out.println("");
            System.out.println("Options:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.println("");
            input = scanner.nextInt();
            switch (input){
                case 0:
                    break;
                case 1:
                    System.out.println("");
                    System.out.println("Login menu:");
                    System.out.println("");
                    loginMenu();
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Register menu:");
                    System.out.println("");
                    registerMenu();

                    break;
                default:
                    System.err.println("Invalid Optinon. Try another option number.");
                    break;
            }
        }
    }

    public static void loginMenu(){
        String loginToCheck = "";
        System.out.println("Enter your login: ");
        Scanner scanner = new Scanner(System.in);
        loginToCheck = scanner.next();
        for (int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equals(loginToCheck)) {
                System.out.println("Enter your password");
                String passwordToCheck = "";
                passwordToCheck = scanner.next();
                if (users.get(i).getPassword().equals(passwordToCheck)) {
                    System.out.println("Successfully login");

                    if (users.get(i).isAdmin()) {
                        //admin panel
                        adminPanelMenu(users.get(i));
                    } else {
                        //user panel
                        userPanelMenu(users.get(i));
                    }

                } else {
                    System.out.println("Wrong password...");
                }
            }
        }
        System.out.println("There is no user with this username, maybe you want to register new?");


    }

    public static void registerMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.println("Enter your login");
        user.setUsername(scanner.next());
        System.out.println("Enter your password");
        user.setPassword(scanner.next());

        System.out.println("Do you wish to continue registration? Y/N");
        if(scanner.next().equalsIgnoreCase("Y")){

            System.out.println("Enter Name");
            user.setName(scanner.next());
            System.out.println("Enter SurName");
            user.setSurname(scanner.next());
            System.out.println("Enter phone number");
            user.setPhonenumber(scanner.nextInt());

            users.add(user);
            saveUsers(users);
            loginMenu();
        }else if(scanner.next().equalsIgnoreCase("N")){
            users.add(user);
            saveUsers(users);
            loginMenu();
        }else {
            System.err.println("INVALID OPTION YOU GONNA BREAK DOWN THE WHOLE COMPUTER ALARM");
            users.add(user);
            saveUsers(users);
            loginMenu();
        }

    }

    public static void userPanelMenu(User user){
        System.out.println("Hi, " + user.getUsername());

    }

    public static void adminPanelMenu(User user){
        System.out.println("Hi, " + user.getUsername() + " as Admin");

    }


    public static void saveUsers(ArrayList<User> users) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("src/database/savedUsers.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(users);
        objectOutputStream.close();
        System.out.println("Users saved");
    }

    public static ArrayList loadUsers() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("src/database/savedUsers.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (ArrayList) objectInputStream.readObject();
    }

}
