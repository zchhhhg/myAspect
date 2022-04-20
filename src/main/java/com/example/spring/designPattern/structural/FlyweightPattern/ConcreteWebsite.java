package com.example.spring.designPattern.structural.FlyweightPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-07-11:01
 */
public class ConcreteWebsite extends Website {

    private String type;

    public ConcreteWebsite(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站的发布形式为"+type+"用户为"+user.getName());
    }
}
