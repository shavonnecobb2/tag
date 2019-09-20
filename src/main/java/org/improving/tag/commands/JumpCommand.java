package org.improving.tag.commands;

import org.springframework.stereotype.Component;

@Component
public class JumpCommand extends BaseEmoteCommand {

    public JumpCommand() { super("jump", "You jumped around like a mad man."); }
}
