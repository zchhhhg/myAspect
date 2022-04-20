package com.example.spring.designPattern.structural.adapterPattern;

/**
 * @author zhoucheng
 * @description 对象适配器 合成复用原则 将集成关系变成组合关系
 * @date 2022-04-01-13:43
 */
public class ObjectVoltageAdapter implements Voltage5V {
    private Voltage220V voltage220V;

    public ObjectVoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int voltage = voltage220V.output220();
        System.out.println("电源适配器转换为5V电压");
        return voltage/44;
    }
}
