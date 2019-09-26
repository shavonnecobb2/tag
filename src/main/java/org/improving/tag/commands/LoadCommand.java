package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.SaveGameFactory;
import org.springframework.stereotype.Component;


@Component
public class LoadCommand implements Command{
    private InputOutput io;
    private SaveGameFactory saveGame;

    public LoadCommand(InputOutput io, SaveGameFactory saveGame) {
        this.io = io;
        this.saveGame = saveGame;
    }

    @Override
    public boolean isValid(String input, Game game) {
        input = input.trim();
        var parts = input.split(" ");
        if (parts.length ==2) {
            return parts[0].equalsIgnoreCase("load");
        }
        return false;
    }

    @Override
    public void execute(String input, Game game) {
        var enteredPath = input.split(" ")[1].trim();
        saveGame.load(enteredPath, game);
        io.displayText("You have returned to " + game.getPlayer().getLocation().getName() + ".");
    }
}

