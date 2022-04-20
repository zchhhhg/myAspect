package com.example.spring.designPattern.method.memoPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoucheng
 * @description 守护者对象 负责保存多个备忘录对象 利用集合进行管理
 * @date 2022-04-20-13:45
 */
public class CareTaker {

    private List<Memento> mementos;

    public CareTaker() {
        this.mementos= new ArrayList<Memento>();
    }

    public void addMemento(Memento memento){
        mementos.add(memento);
    }

    public Memento getMemento(int index){
        return mementos.get(index);
    }

}
