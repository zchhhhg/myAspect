package com.example.spring.designPattern.structural.adapterPattern;

/**
 * @author zhoucheng
 * @description 适配器模式
 * @date 2022-04-01-13:29
 */
public class Phone {
    public void charging(Voltage5V voltage5V){
        int voltage = voltage5V.output5V();
        if(voltage == 5){
            System.out.println("电压为5V，开始给手机充电");
        }else {
            System.out.println("电压不匹配，无法充电");
        }
    }
}
