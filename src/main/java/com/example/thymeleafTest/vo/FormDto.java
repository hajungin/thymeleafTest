package com.example.thymeleafTest.vo;

import lombok.Data;

import java.util.List;

@Data
public class FormDto {
    private String name;
    private boolean trueOrFalse;
    private List<String> hobbies;   //multi-checkbox
    private String language;    //radio-button
    private String country;     //select


}
