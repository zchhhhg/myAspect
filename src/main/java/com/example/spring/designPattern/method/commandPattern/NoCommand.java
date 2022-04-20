package com.example.spring.designPattern.method.commandPattern;

/**
 * @author zhoucheng
 * @description 初始化，不执行任何操作
 * 这同样是一种设计模式 可以省去对空的判断
 * @date 2022-04-08-9:40
 */
public class NoCommand implements Command {

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
