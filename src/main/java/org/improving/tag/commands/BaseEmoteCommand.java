package org.improving.tag.commands;

import org.improving.tag.InputOutput;

public abstract class BaseEmoteCommand implements Command {
    private String cmdText;
    private String cmdResponse;
    private InputOutput io;

// constructors
    public BaseEmoteCommand(String cmdText, String cmdResponse, InputOutput io) {
        this.cmdText = cmdText;
        this.cmdResponse = cmdResponse;
        this.io = io;
    }

// methods
    @Override
    public boolean isValid(String input) {
        return input.trim().equalsIgnoreCase(cmdText);
    }

    @Override
    public void execute(String input) {
        io.displayText(cmdResponse);
    }
}
