package com.example.thymeleafTest.vo;

public class Users {
    private String userName;
    private int age;

    public Users(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }


    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }
}
