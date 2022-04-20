package com.example.spring.designPattern.method.mediatorPattern;

/**
 * @author zhoucheng
 * @description 中介者模式
 * 被管理的各同事之前互不影响 符合迪米特原则 最少知道
 * 中介者
 * @date 2022-04-20-9:22
 */
public class Client {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        Curtain curtain = new Curtain();
        Lamp lamp = new Lamp();
        mediator.register(curtain);
        mediator.register(lamp);
        mediator.sendMessage();
    }
}
