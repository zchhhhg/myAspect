package com.example.spring.designPattern.method.VisitorPatten;

/**
 * @author zhoucheng
 * @description 访问者模式
 * @date 2022-04-08-11:01
 */
public class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());
        objectStructure.show(new Fail());
    }
}
