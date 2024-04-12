package com.example.thymeleafTest.vo;

import lombok.Getter;

@Getter
public enum Sex {
    Man("남자"),Woman("여자"),No("선택안함");
    private final String description;

    Sex(String description) {
        this.description = description;
    }
}
