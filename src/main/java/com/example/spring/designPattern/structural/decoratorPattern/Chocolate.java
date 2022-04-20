package com.example.spring.designPattern.structural.decoratorPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-06-14:08
 */
public class Chocolate extends Decorator {
    public Chocolate(Drink drink) {
        super(drink);
        setDesc("巧克力");
        setPrice(3.0f);
    }
}
