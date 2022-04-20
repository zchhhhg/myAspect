package com.example.spring.designPattern.structural.proxyPattern.staticProxy;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-07-13:59
 */
public class UsbSellFactory implements UsbSell {
    @Override
    public void sell() {
        System.out.println("源头工厂一个USB卖5元");
    }
}
