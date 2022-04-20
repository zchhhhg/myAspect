package com.example.spring.designPattern.creational.factoryPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-03-31-13:28
 */
public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("制作希腊pizza，准备原材料");
    }
}
