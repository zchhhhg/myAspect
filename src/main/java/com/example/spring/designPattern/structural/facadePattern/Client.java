package com.example.spring.designPattern.structural.facadePattern;

/**
 * @author zhoucheng
 * @description 外观模式
 * 对外屏蔽了子系统的细节，降低了客户端对子系统使用的复杂性
 * @date 2022-04-07-9:18
 */
public class Client {
    public static void main(String[] args) {
        TheaterCenter theaterCenter = new TheaterCenter();
        theaterCenter.start();
        theaterCenter.close();
    }
}
