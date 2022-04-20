package com.example.spring.designPattern.structural.facadePattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-07-9:29
 */
public class TheaterLight {
    private static TheaterLight TheaterLight = new TheaterLight();

    public static TheaterLight getInstance() {
        return TheaterLight;
    }

    public void open(){
        System.out.println("open TheaterLight");
    }
    public void close(){
        System.out.println("close TheaterLight");
    }
}
