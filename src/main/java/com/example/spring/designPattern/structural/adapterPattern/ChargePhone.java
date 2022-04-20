package com.example.spring.designPattern.structural.adapterPattern;

/**
 * @author zhoucheng
 * @description 适配器模式
 * @date 2022-04-01-13:35
 */
public class ChargePhone {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new ClassVoltageAdapter());
    }
}
