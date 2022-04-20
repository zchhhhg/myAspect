package com.example.spring.designPattern.method.mediatorPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-20-10:21
 */
public class Curtain implements Colleague {
    @Override
    public void start() {
        System.out.println("打开窗帘");
    }

    @Override
    public void stop() {
        System.out.println("关闭窗帘");
    }
}
