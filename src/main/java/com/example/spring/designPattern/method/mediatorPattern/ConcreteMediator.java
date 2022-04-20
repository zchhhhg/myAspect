package com.example.spring.designPattern.method.mediatorPattern;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-20-10:05
 */
public class ConcreteMediator extends Mediator {

    private List<Colleague> colleList;

    public ConcreteMediator() {
        colleList = new LinkedList<Colleague>();
    }

    @Override
    public void register(Colleague colleague) {
        colleList.add(colleague);
    }

    @Override
    public void sendMessage() {
        for (int i = 0; i < colleList.size(); i++) {
            colleList.get(i).start();
        }
    }
}
