package com.example.spring.designPattern.method.commandPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-08-9:21
 */
public interface Command {
    public void execute();
    public void undo();
}
