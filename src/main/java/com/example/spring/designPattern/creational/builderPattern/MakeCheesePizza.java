package com.example.spring.designPattern.creational.builderPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-03-31-13:28
 */
public class MakeCheesePizza extends MakePizza {

    @Override
    public void prepare() {
        System.out.println("开始准备奶酪pizza材料");
    }

    @Override
    public void bake() {
        System.out.println("烘焙奶酪pizza");
    }

    @Override
    public void cut() {
        System.out.println("切块奶酪pizza");
    }

    @Override
    public void box() {
        System.out.println("打包奶酪pizza");
    }
}
