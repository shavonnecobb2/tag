package org.improving.tag.commands;

public abstract class BaseEmoteCommand implements Command {
    private String cmdText;
    private String cmdResponse;

// inserted constructors for Class
    public BaseEmoteCommand(String cmdText, String cmdResponse) {
        this.cmdText = cmdText;
        this.cmdResponse = cmdResponse;
    }

// inserted method for Class
    @Override
    public boolean isValid(String input) {
        return input.equals(cmdText);
    }
    @Override
    public void execute(String input) {
        System.out.println(cmdResponse);
    }
}
