package com.example.thymeleafTest.vo;

import lombok.Getter;

@Getter
public enum Agree {
    All("전체동의합니다."),
    AGREE("이용약관동의"),
    PRIVATE("개인정보 수집및이용 동의(필수)"),
    PRIVATESELECT("개인정보 수집및이용 동의(선택)");
    private final String description;

    Agree(String description) {
        this.description = description;
    }
}
