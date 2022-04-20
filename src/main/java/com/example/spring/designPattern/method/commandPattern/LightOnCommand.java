package com.example.spring.designPattern.method.commandPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-08-9:24
 */
public class LightOnCommand implements Command {

    private LightReceiver light;

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
