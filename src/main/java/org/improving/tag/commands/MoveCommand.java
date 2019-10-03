package org.improving.tag.commands;

import org.improving.tag.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class MoveCommand extends BaseAliasedCommand {
    private InputOutput io;

    public MoveCommand(InputOutput io) {
        super(io, "move", "m");
        this.io = io;
    }

    @Override
    public String getCommandPart(String input) {
        var parts = input.split(" ");
        if (parts.length == 1) throw new UnsupportedOperationException();
        return parts[0];
    }

    @Override
    public String getErrorMessage() {
        return "Oh no! That route is unavailable!";
    }

    @Override
    public void childExecute(String input, Game game) {
        input = input.trim();
        var parts = input.split(" ");
        var parameters = new ArrayList<String>(Arrays.asList(parts));
        parameters.remove(0);
        var destination = String.join(" ", parameters);


        if (game.getPlayer().getLocation().getAdversary() != null) {
            io.displayText("Hey you! You shall not pass!");
            return;
        }


        Exit exit = null;
        for (var e : game.getPlayer().getLocation().getExits()) {
            if (e.getName().equalsIgnoreCase(destination)) {
                exit = e;
            } else {
                for (var a : e.getAliases()) {
                    if (a.equalsIgnoreCase(destination)) {
                        exit = e;
                        break;
                    }
                }
            }
            if (exit != null) break;
        }
        if (exit == null) throw new UnsupportedOperationException();

        game.getPlayer().setLocation(exit.getDestination());
        if (game.getPlayer().getLocation().getName().equalsIgnoreCase("The Volcano of Death")) {
            io.displayText("Welcome to the Volcano of DEATH - you are now DEAD. GOODBYE.");
            throw new GameExitException();
        } else {
            io.displayText("You travel " + exit.getName() + ".");
        }
    }
}
