package com.example.btarekegn.schoolapp.entity;

public class User {

    private int id;
    private String fullName;
    private String email;
    private String role;
    private String password;
    private String gender;

    public User(int id, String fullName, String email, String role, String password, String gender) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.password = password;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
