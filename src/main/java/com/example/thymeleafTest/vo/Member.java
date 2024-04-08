package com.example.thymeleafTest.vo;

public class Member {
    private int id;
    private String name;
    private String addr;

    public Member(int id, String name, String addr) {
        this.id = id;
        this.name = name;
        this.addr = addr;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }
}
