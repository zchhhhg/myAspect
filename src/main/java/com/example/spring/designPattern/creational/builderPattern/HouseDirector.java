package com.example.spring.designPattern.creational.builderPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-01-11:16
 */
public class HouseDirector {
    private HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // 如何处理业务处理流程，交给此指挥者
    public House buildHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.buildRoofs();
        return houseBuilder.getHouse();
    }
}
