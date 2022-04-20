package com.example.spring.designPattern.structural.bridgePattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-06-10:09
 */
public class Phone {
    private  Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    public void open(){
        brand.open();
    }

    public void call() {
        brand.call();
    }

}
