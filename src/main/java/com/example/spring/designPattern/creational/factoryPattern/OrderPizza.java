package com.example.spring.designPattern.creational.factoryPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-03-31-13:49
 */
public class OrderPizza {
    public static void main(String[] args) {
        SimpleFactory.getFactory().getPizza("greek");
        BJSimpleFactory.getFactory().getPizza("greek");

    }
}
