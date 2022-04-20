package com.example.spring.designPattern.structural.compositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoucheng
 * @description 学校
 * @date 2022-04-06-20:28
 */
public class University extends Organization {

    List<Organization> organizations = new ArrayList<>();

    public University(String name, String desc) {
        super(name, desc);
    }

    @Override
    public void add(Organization organization) {
        organizations.add(organization);
    }

    @Override
    public void remove(Organization organization) {
        organizations.remove(organization);
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
        for(Organization organization:organizations){
            organization.print();
        }
    }
}
