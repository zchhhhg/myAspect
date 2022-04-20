package com.example.spring.designPattern.method.templateMethodPattern;

/**
 * @author zhoucheng
 * @description 模板方法模式
 * 抽象类中先实现一部分并在一个总的方法里规定执行顺序
 * 子类继承该抽象类实现剩下的方法并调用总方法
 * 钩子方法：方法内不做任何操作，子类可以视情况要不要覆盖它（暴露一个返回布尔值的方法，重写这个方法返回false，接口内部做处理如果为false则不处理XXX）
 * @date 2022-04-07-14:48
 */
public class Client {
}
