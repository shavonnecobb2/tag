package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.TreasureChest;
import org.improving.tag.items.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class OpenCommand extends BaseAliasedCommand {
    private InputOutput io;


    public OpenCommand(InputOutput io) {
        super(io, "open", "o");
        this.io = io;
    }


    @Override
    public String getErrorMessage() {
        return "..Open what??";
    }

    @Override
    public void childExecute(String input, Game game) {
        Item item = game.getPlayer().getLocation().openTreasureChest();
        io.displayText("You just found " + item + " - which has been added to your inventory!!!");
        game.getPlayer().getInventory().addItem(item);
    }
}
