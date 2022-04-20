package com.example.spring.designPattern.method.commandPattern;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-08-9:41
 */
public class RemoteController {

    private Command[] onCommands;

    private Command[] offCommands;

    private Command undoCommand;

    public RemoteController() {
        this.onCommands = new Command[5];
        this.offCommands = new Command[5];
        for (int i = 0;i<5;i++){
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
        undoCommand = new NoCommand();
    }

    public void setCommand(int no, Command onCommand,Command offCommand){
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    public void onCommand(int no){
        onCommands[no].execute();
        undoCommand = onCommands[no];
    }

    public void offCommand(int no){
        offCommands[no].execute();
        undoCommand = offCommands[no];
    }

    public void undoCommand(){
        undoCommand.undo();
    }
}
