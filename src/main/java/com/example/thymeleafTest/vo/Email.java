package com.example.thymeleafTest.vo;

import lombok.Getter;

@Getter
public enum Email {
    NAVER("naver.com"),
    DAUM("daum.net"),
    GOOGLE("gmail.com"),
    NATE("nate.com");
    private final String description;


    Email(String description) {
        this.description = description;
    }
}
