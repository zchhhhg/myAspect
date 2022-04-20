package com.example.spring.designPattern.method.memoPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-20-13:44
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void getStateFromMemento(Memento memento){
        this.state = memento.getState();
    }

    public Memento saveStateMemento(){
        return new Memento(this.state);
    }
}
