package com.example.spring.designPattern.structural.bridgePattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-06-10:15
 */
public class HuaweiBrand implements Brand {
    @Override
    public void open() {
        System.out.println("华为手机开机");
    }

    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }
}
