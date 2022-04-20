package com.example.spring.designPattern.method.commandPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-08-9:34
 */
public class LightOffCommand implements Command{
    private LightReceiver receiver;

    public LightOffCommand(LightReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.off();
    }

    @Override
    public void undo() {
        receiver.on();
    }
}
