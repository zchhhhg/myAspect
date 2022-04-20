package com.example.spring.designPattern.structural.bridgePattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-06-10:19
 */
public class XiaomiBrand implements Brand {
    @Override
    public void open() {
        System.out.println("小米手机开机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }
}
