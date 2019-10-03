package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.Location;
import org.improving.tag.TreasureChest;
import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class OpenCommand extends BaseAliasedCommand {
    private InputOutput io;
    private TreasureChest treasureChest = TreasureChest.NO_TREASURE;
    private Location location;


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
        List treasureItem = game.getPlayer().getLocation().openTreasureChest();
            io.displayText("You just found a " + treasureItem + " - which has been added to your inventory!!!");
            game.getPlayer().getInventory().addAll(treasureItem);
        }
}
