package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class User {
    private int id = 999999999;
    private String username = "null";
    private String password = "null";
    private String name = "null";
    private String surname = "null";
    private int phonenumber = 0;

    public void save() {

        FileWriter fw;
        {
            try {
                fw = new FileWriter("src/database/Users.txt");
                fw.write("{id: " + id + " username: " + username + " password: " + password + " name: " + name + " surname: " + surname + " phonenumber: " + phonenumber  + "}\n");
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public User() {
    }

    public User(int id, String username, String password, String name, String surname, int phonenumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phonenumber = phonenumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }
}
