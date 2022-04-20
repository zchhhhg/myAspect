package com.example.spring.designPattern.method.VisitorPatten;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-08-11:08
 */
public abstract class Person {
    // 提供一个方法，让访问者可以访问
    public abstract void accept(Action action);
}
