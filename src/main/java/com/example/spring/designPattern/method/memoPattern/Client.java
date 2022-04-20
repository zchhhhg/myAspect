package com.example.spring.designPattern.method.memoPattern;

/**
 * @author zhoucheng
 * @description 备忘录 数据存档并恢复
 * @date 2022-04-20-13:43
 */
public class Client {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Originator originator = new Originator();
        originator.setState("目前状态是1");
        careTaker.addMemento(originator.saveStateMemento());
        originator.saveStateMemento();
        originator.setState("目前状态是2");
        careTaker.addMemento(originator.saveStateMemento());
        originator.saveStateMemento();
        System.out.println(originator.getState());
        originator.getStateFromMemento(careTaker.getMemento(0));
        System.out.println(originator.getState());
    }
}
