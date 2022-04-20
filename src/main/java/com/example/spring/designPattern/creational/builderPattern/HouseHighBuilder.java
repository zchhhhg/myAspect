package com.example.spring.designPattern.creational.builderPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-01-11:14
 */
public class HouseHighBuilder extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("高楼打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砌墙");
    }

    @Override
    public void buildRoofs() {
        System.out.println("高楼封顶");
    }
}
