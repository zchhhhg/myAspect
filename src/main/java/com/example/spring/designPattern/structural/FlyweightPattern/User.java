package com.example.spring.designPattern.structural.FlyweightPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-07-11:12
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
