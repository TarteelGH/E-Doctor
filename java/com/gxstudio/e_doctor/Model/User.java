package com.gxstudio.e_doctor.Model;

public class User {

    public String username;
    public String email;
    public String password;
    public String age;
    public String phoneNumber;
    public String id;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email, String password, String age, String phoneNumber, String id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

}
