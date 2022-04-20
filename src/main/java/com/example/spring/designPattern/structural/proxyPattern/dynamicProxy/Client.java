package com.example.spring.designPattern.structural.proxyPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zhoucheng
 * @description JDK动态代理 目标对象需要实现接口
 * cglib代理 目标对象不需要实现接口 底层是通过字节码处理框架ASM来转换字节码并生成新的类
 * @date 2022-01-10-17:35
 */
public class Client {
    public static void main(String[] args) {
        // 1、创建目标对象，使用Proxy
        UsbSell factory = new UsbKingFactory();
        // 2、创建InvocationHandler对象
        InvocationHandler handler = new MySellHander(factory);
        // 3、创建代理对象 固定此写法
        UsbSell proxyInstance = (UsbSell)Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(), handler);
        // 4、通过代理执行方法
        float amount = proxyInstance.sell(85);
        System.out.println(amount);
    }
}
