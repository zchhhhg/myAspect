package com.example.spring.designPattern.structural.decoratorPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-06-14:11
 */
public class Milk extends Decorator {
    public Milk(Drink drink) {
        super(drink);
        setDesc("牛奶");
        setPrice(2.0f);
    }
}
