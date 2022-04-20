package com.example.spring.designPattern.creational.builderPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-01-11:12
 */
public class HouseLowerBuilder extends HouseBuilder  {
    @Override
    public void buildBasic() {
        System.out.println("平房打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("平房砌墙");
    }

    @Override
    public void buildRoofs() {
        System.out.println("平房封顶");
    }
}
