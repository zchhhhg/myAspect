package com.example.spring.designPattern.creational.builderPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-01-11:08
 */
public abstract class HouseBuilder {
    private House house = new House();

    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void buildRoofs();

    public House getHouse(){
        return house;
    }
}
