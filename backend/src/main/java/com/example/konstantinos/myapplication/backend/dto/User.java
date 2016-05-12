package com.example.konstantinos.myapplication.backend.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by konstantinos on 8/5/2016.
 */

public class User implements Serializable {

    // variables
    private static final long serialVersionUID = 1L;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private ArrayList<KeyObject> keys;

    // constructor
    public User() {
        this.email = null;
        this.password = null;
        this.firstName = null;
        this.lastName = null;
    }

    // constructor
    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // getters
    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<KeyObject> getKeys() {
        return keys;
    }

    // setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setKeys(ArrayList<KeyObject> keys) {
        this.keys = keys;
    }

    // to String
    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}

