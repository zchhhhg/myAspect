package com.example.spring.designPattern.method.VisitorPatten;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-08-11:13
 */
public class Woman extends Person {
    @Override
    public void accept(Action action) {
        action.getWomanResult();
    }
}
