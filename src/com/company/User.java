package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int counter = 0;
    private int id = 999999999;
    private String username = "null";
    private String password = "null";
    private String name = "null";
    private String surname = "null";
    private int phonenumber = 0;
    private boolean isAdmin = false;


    public User() {
        this.id = ++counter;
    }

    public User(String username, String password, String name, String surname, int phonenumber) {
        this.id = ++counter;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phonenumber = phonenumber;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phonenumber=" + phonenumber +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
