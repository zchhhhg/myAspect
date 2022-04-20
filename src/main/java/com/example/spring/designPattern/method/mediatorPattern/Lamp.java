package com.example.spring.designPattern.method.mediatorPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-20-10:17
 */
public class Lamp implements Colleague {
    @Override
    public void start() {
        System.out.println("打开灯泡");
    }

    @Override
    public void stop() {
        System.out.println("熄灭灯泡");
    }
}
