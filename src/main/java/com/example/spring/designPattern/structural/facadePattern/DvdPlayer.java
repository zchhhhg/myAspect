package com.example.spring.designPattern.structural.facadePattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-07-9:30
 */
public class DvdPlayer {

    // 饿汉式创建对象实例
    private static DvdPlayer player = new DvdPlayer();

    public static DvdPlayer getInstance() {
        return player;
    }

    public void open(){
        System.out.println("open DvdPlayer");
    }
    public void close(){
        System.out.println("close DvdPlayer");
    }
}
