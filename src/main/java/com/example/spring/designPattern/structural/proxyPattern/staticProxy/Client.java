package com.example.spring.designPattern.structural.proxyPattern.staticProxy;

/**
 * @author zhoucheng
 * @description 静态代理
 * 可以在不修改目标对象功能的前提下，通过代理对象对目标功能进行扩展
 * 但因为要与目标对象实现一样的接口，所以或产生较多的代理类，一切接口增加方法，目标对象与代理对象都需要维护
 * @date 2022-04-07-14:02
 */
public class Client {
    public static void main(String[] args) {
        UsbSellFactory factory = new UsbSellFactory();
        ProxyUsbSell proxy = new ProxyUsbSell(factory);
        proxy.sell();
    }
}
