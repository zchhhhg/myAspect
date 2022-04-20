package com.example.spring.designPattern.method.mediatorPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-20-10:03
 */
public abstract class Mediator {
    // 将资源注册到中介者 比如智能家电里的各种电器就属于中介者拥有的资源
    public abstract void register(Colleague colleague);
    // 具体的操作
    public abstract void sendMessage();
}
