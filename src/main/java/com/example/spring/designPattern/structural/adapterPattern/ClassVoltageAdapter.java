package com.example.spring.designPattern.structural.adapterPattern;

/**
 * @author zhoucheng
 * @description 类适配器
 * 优：可以灵活的重写src类中的方法
 * 缺：必须继承srr类，src的方法也必须在adapter中暴露出来
 * @date 2022-04-01-13:28
 */
public class ClassVoltageAdapter extends Voltage220V implements Voltage5V {
    @Override
    public int output5V() {
        int voltage = super.output220();
        System.out.println("电源适配器转换为5V电压");
        return voltage/44;
    }
}
