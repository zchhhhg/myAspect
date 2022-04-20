package com.example.spring.designPattern.creational.builderPattern;

import com.example.spring.designPattern.creational.factoryPattern.BJSimpleFactory;
import com.example.spring.designPattern.creational.factoryPattern.SimpleFactory;

/**
 * @author zhoucheng
 * @description 建造者模式
 * 传统方式通俗易懂，但是耦合度相对较高
 * 建造者模式四种角色 产品角色，抽象建造者，具体建造者，指挥者
 * @date 2022-03-31-13:49
 */
public class OrderPizza {
    public static void main(String[] args) {
        testBuilderPattern();
    }

    public static void testTraditionalWay(){
        MakeCheesePizza cheesePizza = new MakeCheesePizza();
        cheesePizza.makePizza();
    }

    public static void testBuilderPattern(){
        HouseDirector houseDirector = new HouseDirector(new HouseLowerBuilder());
        houseDirector.buildHouse();
    }
}
