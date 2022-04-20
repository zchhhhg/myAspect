package com.example.spring.designPattern.structural.decoratorPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-06-14:00
 */
public class Coffee extends Drink {
    public Coffee() {
        setDesc("咖啡");
        setPrice(10.0f);
    }

    @Override
    public float costPrice() {
        return super.getPrice();
    }
}
