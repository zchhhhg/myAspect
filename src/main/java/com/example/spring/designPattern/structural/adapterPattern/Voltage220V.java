package com.example.spring.designPattern.structural.adapterPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-01-13:26
 */
public class Voltage220V {

    public int output220(){
        System.out.println("插座提供220V交流电压");
        return 220;
    }
}
