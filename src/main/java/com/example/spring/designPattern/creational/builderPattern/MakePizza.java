package com.example.spring.designPattern.creational.builderPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-03-31-13:34
 */
public abstract class MakePizza {


    public abstract void prepare();

    public abstract void bake();

    public abstract void cut();

    public abstract void box();

    public void makePizza(){
        prepare();
        bake();
        cut();
        box();
    };
}
