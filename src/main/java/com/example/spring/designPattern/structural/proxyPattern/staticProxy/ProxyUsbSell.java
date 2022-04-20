package com.example.spring.designPattern.structural.proxyPattern.staticProxy;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-07-14:00
 */
public class ProxyUsbSell implements UsbSell{

    private UsbSellFactory usbSellFactory;

    public ProxyUsbSell(UsbSellFactory usbSellFactory) {
        this.usbSellFactory = usbSellFactory;
    }

    @Override
    public void sell() {
        System.out.println("代理商从源头工厂进货");
        usbSellFactory.sell();
        System.out.println("代理商每个USB加价20元");
    }
}
