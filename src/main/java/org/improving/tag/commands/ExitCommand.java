package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.GameExitException;
import org.improving.tag.InputOutput;
import org.improving.tag.SaveGameFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class ExitCommand extends BaseAliasedCommand {
    private final SaveGameFactory saveGame;

    public ExitCommand(InputOutput io, SaveGameFactory saveGame) {
        super(io, "exit", "e");
        this.saveGame = saveGame;
    }

    @Override
    public void childExecute(String input, Game game) {
            saveGame.save(game);
            io.displayText("See you later dude!");
            throw new GameExitException();
           }

        }




