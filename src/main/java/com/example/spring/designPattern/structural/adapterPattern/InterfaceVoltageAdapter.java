package com.example.spring.designPattern.structural.adapterPattern;

/**
 * @author zhoucheng
 * @description 接口适配器模式（缺省适配器模式）
 * 创建一个抽象类实现目标接口的所有方法，当真正用到时就可以只实现想实现几个方法，而不用都实现
 * @date 2022-04-01-13:50
 */
public abstract class InterfaceVoltageAdapter implements Voltage5V {
}
