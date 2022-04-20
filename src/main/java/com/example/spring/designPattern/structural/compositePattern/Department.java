package com.example.spring.designPattern.structural.compositePattern;

/**
 * @author zhoucheng
 * @description 院系
 * @date 2022-04-06-20:38
 */
public class Department extends Organization{

    public Department(String name, String desc) {
        super(name, desc);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDesc() {
        return super.getDesc();
    }

    @Override
    public void print() {
        System.out.println(getName());
    }
}
