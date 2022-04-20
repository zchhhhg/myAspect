package com.example.spring.designPattern.creational.factoryPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-03-31-14:11
 */
public class BJSimpleFactory implements AbstarctFactory {

    private Pizza pizza;

    private static BJSimpleFactory simpleFactory;

    public static BJSimpleFactory getFactory(){
        if(simpleFactory==null){
            simpleFactory = new BJSimpleFactory();
        }
        return simpleFactory;
    }
    @Override
    public void getPizza(String pizzaType) {
        System.out.println("使用抽象工厂模式完成北京pizza预定");
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
}
