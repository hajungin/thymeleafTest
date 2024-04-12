package com.example.thymeleafTest.vo;

import lombok.Data;

import java.util.List;

@Data
public class LogIn {
    private String id;
    private String password;
    private String name;
    private String date;
    private String Sex;
    private List<String> agrees;
    private String Email;
    private String phone;
}
