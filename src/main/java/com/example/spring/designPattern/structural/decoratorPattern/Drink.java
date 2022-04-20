package com.example.spring.designPattern.structural.decoratorPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-06-13:58
 */
public abstract class Drink {

    private String desc;

    private float price;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float costPrice();
}
