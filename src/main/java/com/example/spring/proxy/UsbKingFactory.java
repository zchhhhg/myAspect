package com.example.spring.proxy;

/**
 * @author zhoucheng
 * @description 目标类，目标对象，被代理对象，想做的事
 * @date 2022-01-10-17:25
 */
public class UsbKingFactory implements UsbSell {
    @Override
    public float sell(int amount) {
        // 目标方法
        return 85.0f;
    }
}
