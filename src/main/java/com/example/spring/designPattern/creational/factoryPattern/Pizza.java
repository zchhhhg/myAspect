package com.example.spring.designPattern.creational.factoryPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-03-31-13:34
 */
public abstract class Pizza {
    private String pizzaName;

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public abstract void prepare();

    public void bake(){
        System.out.println(pizzaName+"开始烘烤");
    }

    public void cut(){
        System.out.println(pizzaName+"开始切盘");
    }

    public void box(){
        System.out.println(pizzaName+"开始打包");
    }
}
