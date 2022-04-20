package com.example.spring.designPattern.structural.compositePattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-06-20:25
 */
public abstract class Organization {
    private String name;
    private String desc;

    public Organization(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public abstract void print();

    // 添加默认实现
    public void add(Organization organization){
        throw new UnsupportedOperationException();
    }

    public void remove(Organization organization){
        throw new UnsupportedOperationException();
    }
}
