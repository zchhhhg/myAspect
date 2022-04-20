package com.example.spring.designPattern.method.commandPattern;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author zhoucheng
 * @description 命令模式
 * 将发起请求的对象与执行请求的对象解耦，发起方不必知道具体的接受者对象及具体实现形式
 * 但可能会导致系统中的具体命令类过多增加系统复杂度
 * @date 2022-04-08-9:51
 */
public class Client {
    public static void main(String[] args) {
        RemoteController controller = new RemoteController();
        LightReceiver lightReceiver = new LightReceiver();
        controller.setCommand(1, new LightOnCommand(lightReceiver),new LightOffCommand(lightReceiver));
        controller.offCommand(1);
        controller.undoCommand();
    }
}
