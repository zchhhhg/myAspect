package com.example.spring.designPattern.creational.factoryPattern;

/**
 * @author zhoucheng
 * @description 简单工厂模式
 * @date 2022-03-31-13:27
 */
public class SimpleFactory {

    private Pizza pizza;

    private static SimpleFactory simpleFactory;

    public void getPizza(String pizzaType) {
        System.out.println("使用简单工厂模式完成pizza预定");
        if(pizzaType.equals("cheese")){
            pizza = new cheesePizza();
        }else if(pizzaType.equals("greek")){
            pizza = new GreekPizza();
        }else {
            System.out.println("暂不支持预定此类pizza");
        }
        if(pizza!=null){
            pizza.setPizzaName(pizzaType);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
    }

    public static SimpleFactory getFactory(){
        if(simpleFactory==null){
            simpleFactory = new SimpleFactory();
        }
        return simpleFactory;
    }
}
