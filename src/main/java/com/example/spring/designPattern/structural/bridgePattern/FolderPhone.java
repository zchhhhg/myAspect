package com.example.spring.designPattern.structural.bridgePattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-06-10:22
 */
public class FolderPhone extends Phone {
    public FolderPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        System.out.println("折叠手机");
        super.open();
    }

    @Override
    public void call() {
        System.out.println("折叠手机");
        super.call();
    }
}
