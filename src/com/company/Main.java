package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("");
            System.out.println("Options:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.println("");
            switch (scanner.nextInt()){
                case 0:
                    break;
                case 1:
                    System.out.println("");
                    System.out.println("Login menu:");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Register menu:");
                    System.out.println("");

                    User newUser = new User();
                    System.out.println("Enter your login:");
                    newUser.setUsername(scanner.next());
                    System.out.println("Enter your password");
                    newUser.setPassword(scanner.next());

                    System.out.println("");
                    System.out.println("Do you want to continue registration (Add more information about you)");
                    System.out.println("1.Yes, i want to continue");
                    System.out.println("0. No, skip it");
                    if(scanner.nextInt() == 1){
                        //fully registration
                    }else if(scanner.nextInt() == 0){
                        newUser.save();
                        //skip to loged in user interface
                    }else{
                        //error
                    }

                    break;
                default:
                    System.err.println("Invalid Optinon. Try another option number.");
                    break;
            }
        }

    }
}
