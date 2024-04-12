package com.example.thymeleafTest.vo;

import lombok.Getter;

@Getter
public enum gender {
    Man("남자"),Woman("여자"),No("선택안함");
    private final String description;

    gender(String description) {
        this.description = description;
    }
}
