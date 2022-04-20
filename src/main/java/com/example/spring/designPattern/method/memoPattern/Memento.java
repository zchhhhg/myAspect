package com.example.spring.designPattern.method.memoPattern;

/**
 * @author zhoucheng
 * @description 备忘录对象 负责保存好记录
 * @date 2022-04-20-13:45
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
