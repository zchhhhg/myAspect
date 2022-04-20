package com.example.spring.designPattern.structural.facadePattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-07-9:29
 */
public class Projector {
    // 饿汉式创建对象实例
    private static Projector projector = new Projector();

    public static Projector getInstance() {
        return projector;
    }

    public void open(){
        System.out.println("open Projector");
    }
    public void close(){
        System.out.println("close Projector");
    }
}
