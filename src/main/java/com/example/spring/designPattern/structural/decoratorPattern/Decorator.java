package com.example.spring.designPattern.structural.decoratorPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-06-14:02
 */
public class Decorator extends Drink{
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float costPrice() {
        return super.getPrice()+drink.costPrice();
    }

    @Override
    public String getDesc() {
        return super.getDesc()+":"+super.getPrice()+drink.getDesc();
    }
}
